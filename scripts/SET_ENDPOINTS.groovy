import com.eviware.soapui.impl.WsdlInterfaceFactory

class SET_ENDPOINTS {
    public static void set( url , context )    {
        def project   = context.testCase.testSuite.project;
        def getEnv    = project.getActiveEnvironmentName();
        if ( getEnv != null && getEnv != "Default environment" )    {
            set( getEnv , url , context );
        }
    }
    
    public static void set( env , url , context )        {
        println "\nRequest recieved to set wsdl for test env "+env+" with URL: "+url
        def project  = context.testCase.testSuite.project;
        def apiCount = project.getInterfaceCount();
        def getEnv   = project.getEnvironmentByName(env);
        if ( getEnv != null && getEnv != "Default environment" )    {
            for ( int i = 0; i < apiCount ; i++ )    {
                def wsdlInterface = project.getInterfaceAt( i ).getName();
                setForWsdl ( env , url , wsdlInterface , context )
            }
        }
    }
    
    public static void setForWsdl ( url , wsdl , context )    {
        def project  = context.testCase.testSuite.project;
        def getEnv   = project.getActiveEnvironmentName();
        if ( getEnv != null && getEnv != "Default environment" ) {
            setForWsdl ( getEnv , url , wsdl , context );
        }
    }
    
    public static void setForWsdl ( env , url , wsdl , context )    {
        println "**-Request recieved to set single WSDL: "+wsdl+" with url: "+url
        def project  = context.testCase.testSuite.project;
        def getEnv   = project.getEnvironmentByName(env);
        def apiCount = project.getInterfaceCount();
        if ( getEnv != null && getEnv != "Default environment" )    {
            for ( int i = 0; i < apiCount ; i++ )    {
                def wsdlInterface = project.getInterfaceAt( i ).getName();
                if (wsdlInterface.equals(wsdl) && url != null)    {
                    def wsdlService   = getEnv.getService(wsdlInterface, com.eviware.soapui.config.ServiceConfig.Type.Enum.forString("SOAP"));
                    def urlConf       = wsdlService.getEndpoint().getConfig();
                    if ( urlConf != null ) {
                        urlConf.setStringValue( url );
                        println "**-Success.!! Endpoint is set for "+wsdl+" in test env "+env+"\n";
                    }
                }
            }
        }
    }
}