package fileName

import java.sql.Driver

import groovy.sql.Sql;

class FetchProperties {

	public static def CUSTOMERID;
	public static def USERID;
	public static def ACCOUNTNUMBER;
	public static def CURRENCY;
	public static def COUNTRY;
	public static def MARKETTYPE;
	public static def CHANNEL;
	public static def BANKORGID;

	public static def DBString ;
	public static def EnvIP ;

	public static boolean loadAccountDetails(String connString, String sqlQuery) {
		//	public static boolean main(String[] args) {

		def driver ;
		def conn;
		def resultSet;
		def sql;
		def resultsFlag	= false
		// connString = "jdbc:oracle:thin:pendata/pen@//10.246.89.97:1530/pen_g_functional"
		// sqlQuery = "select V.USERID as CUSTOMERID,V.ACCOUNTNUMBER, V.CURRENCYCODE as CURRENCY , V.MARKETTYPE,V.CHANNEL from V_AUTH_USERINFO V where  V.MARKETTYPE = 'PM' and V.CHANNEL = 'INT'  and  BANKORGID  = '4201' and V.CURRENCYCODE = 'NOK' and length(V.USERID)='11' and ROWNUM=1"
		try {
			driver = Class.forName('oracle.jdbc.OracleDriver').newInstance() as Driver

			println " 1st-->"
			conn = driver.connect(connString , new Properties())
			sql = new Sql(conn)
			resultSet = sql.rows(sqlQuery)
			println "results-->" + resultSet

			CUSTOMERID= resultSet.CUSTOMERID.toString().replaceAll("[^a-zA-Z0-9]+","")
			ACCOUNTNUMBER=  resultSet.ACCOUNTNUMBER.toString().replaceAll("[^a-zA-Z0-9]+","")
			CURRENCY=  resultSet.CURRENCY.toString().replaceAll("[^a-zA-Z0-9]+","")

			USERID = CUSTOMERID.substring(5) as int
			USERID = USERID.toString().replaceAll("[^a-zA-Z0-9]+","")

			resultsFlag = true

		}catch(Exception e) {
			e.printStackTrace()
			throw new Exception("Error while fetching account data")
		}finally {
			conn.close()
			println "DB connection closed!!" + conn.closed
			return resultsFlag
		}

	}

	public static void getEnvProperties(String ActiveEnv) {
		DBString = ""
		EnvIP = ""
		switch(ActiveEnv.toUpperCase()) {
			case "G-D4 FUNCTIONAL":
				DBString = "jdbc:oracle:thin:pendata/pen@//10.246.89.97:1530/pen_g_functional"
				EnvIP = "10.246.89.107:23621"
				break
			case "G-D5 SPRINT":
				DBString = "jdbc:oracle:thin:pwhdata/pwh@//10.246.89.97:1530/pwh_g_d5"
				EnvIP = "10.246.89.107:22561"
				break
			case "G-D6 SPRINT":
				DBString = "jdbc:oracle:thin:pwhdata/pwh@10.246.89.97:1530/pwh_g_d6"
				EnvIP = "10.246.89.108:22641"
				break
			case "G-D2 SPRINT":
				DBString = "jdbc:oracle:thin:pendata/pen@10.246.89.97:1530/pen_g_sprint"
				EnvIP = "10.246.89.106:24901"
				break

			default :
				DBString = "jdbc:oracle:thin:pendata/pen@//10.246.89.97:1530/pen_g_functional"
				EnvIP = "10.246.89.107:23621"
				println "default"
		}

	}


}

