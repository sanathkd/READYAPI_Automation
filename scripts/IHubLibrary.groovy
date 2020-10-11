import java.text.DecimalFormat;

class IHubLibrary{

	public static Map<String,String> map = ['daily':'Daglig','weekly':'Uke','biweekly':'14.dag','semimonthly':'2 g mnd','monthly':'Måned','bimonthly':'2. mnd','quarterly':'Kvartal','tertially':'Tertial','semiannually':'Halvår','yearly':'Årlig']
	
	public static String validatePeriodicIHubText(amount,ccyCode,creditAccount,firstDueDate,recurrenceType,log){


		def amountStr = getAmountString(amount.toString())
		
		if(ccyCode.toUpperCase() !=  "NOK")
			ccyCode = ccyCode.toUpperCase()
		else 
			ccyCode = ""


			if (creditAccount.size() >11)
				creditAccount = 'UTLAND'

			Date d = Date.parse('yyyy-MM-dd',firstDueDate)
			def sdf = new java.text.SimpleDateFormat ("ddMMyy")
			def newDueDate = sdf.format(d).toString()

			def newrecurrenceType = map.get(recurrenceType.toLowerCase())

			if(ccyCode == "") 
				return [amountStr ,creditAccount,"Forf:" +newDueDate, newrecurrenceType].join(" ")
			else
				return [amountStr ,ccyCode,creditAccount,"Forf:" +newDueDate, newrecurrenceType].join(" ")
			
			
	}

	public static def validateBalanceIHubText(accountNumber,creditAccountNumber,firstDueDate,recurrenceType,limitType,log){

		def hentOrOver = 'Hent'
		if(limitType.toString().equalsIgnoreCase('ABOVE')){
			accountNumber = creditAccountNumber
			hentOrOver = "Overfør"
		}

		if (accountNumber.size() >11)
					accountNumber = 'UTLAND'

		Date d = Date.parse('yyyy-MM-dd',firstDueDate)
		def sdf = new java.text.SimpleDateFormat ("ddMMyy")
		def newDueDate = sdf.format(d).toString()

		def newrecurrenceType = map.get(recurrenceType.toLowerCase())					

		return[accountNumber ,"Forf:" +newDueDate, newrecurrenceType, hentOrOver].join(" ")
		
	}

	public static def getAmountString(amount){
		Double amountDouble  = Double.parseDouble(amount)
		DecimalFormat decimalFormat = new DecimalFormat("#");
		decimalFormat.setGroupingUsed(true);
		decimalFormat.setGroupingSize(3);

		String amountStr = decimalFormat.format(amountDouble).toString().replace(',', '.')
		if (amountStr.size() >9)
			return "Se PCL"
		else
			return amountStr
	}
}
