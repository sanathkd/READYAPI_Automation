package fileName

import java.util.*;
import java.text.SimpleDateFormat;

class CommonLibrary {
	
	public static String compareMap(Map<String,String> Ex_Map , Map<String,String> Ac_Map){
//	public static void main(String[] args) {
		
//		Map<String,String> Ex_Map = [LogCode:'57234',message:'adaaadad',method:'Crate',tppId:'1'];
//		Map<String,String> Ac_Map = [method:'Create',message:'adaadadad',tppId:'12',LogCode:'5723'];
		Ex_Map.sort();
		Ac_Map.sort();
		
		def res = ""
		for  (key in Ex_Map.keySet()){
			
			if (Ex_Map.get(key).toString().trim().toUpperCase() != Ac_Map.get(key).toString().trim().toUpperCase())
				res = res + "\n" +key + " : Expected = "+ Ex_Map.get(key) + "| Actual = " + Ac_Map.get(key)
		}
		
		return res
		
	}
	
	public static String getNorwayTime(String format) {

		def d = new Date()
		def sdf = new SimpleDateFormat (format)
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"))		
		return sdf.format(d).toString()
	}
	
	public static String getNextTime(String hurMin) {

		Integer.parseInt(hurMin.substring(2))
		def min = Integer.parseInt(hurMin.substring(2))
		def hur = Integer.parseInt(hurMin.substring(0,2))

		def res = ''
		Date now = new Date();
		int yer =  now.getYear() + 1900;
		int mnt = now.getMonth()
		int dte =  now.getDate()

		for(int i= -1 ; i<=2 ; i++) {
			Date d = new Date(yer,mnt,dte,hur,min + i ,00)
			def sdf = new java.text.SimpleDateFormat ("HHmm")
			res = res + "|" + sdf.format(d).toString()

		}
		return  res.substring(1)


	}
	
}
