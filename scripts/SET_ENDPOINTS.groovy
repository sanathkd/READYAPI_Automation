import com.eviware.soapui.impl.WsdlInterfaceFactory

class SET_ENDPOINTS {
    public static void set( url , context )    {
        def project = context.testCase.testSuite.project;
        def projectName = project.getName();
        def getEnv = project.getActiveEnvironmentName();
        if ( getEnv != null && (!getEnv.equalsIgnoreCase("Default environment")) )    {
            set( projectName , getEnv , url , context );
        } else println ("There are no Active Test Environments");
    }
    
    public static void set( env , url , context )        {
        def project = context.testCase.testSuite.project;
        def projectName = project.getName();
        def getEnv    = project.getEnvironmentByName(env);
        if ( getEnv != null && (!(getEnv.getName()).equalsIgnoreCase("Default environment")) )    {
            set( projectName , getEnv , url , context );
        } else println ("Test env '"+env+"' does not exist");
    }
    
    public static void set( projectName , env , url , context )        {
        println "Request recieved to set wsdl for test env "+env+" with URL: "+url
        def workspace = context.testCase.testSuite.project.workspace;
        def project = workspace.getProjectByName(projectName);
        if (project != null)
        {
            def apiCount = project.getInterfaceCount();
            def getEnv   = project.getEnvironmentByName(env);
            if (getEnv == null){
                getEnv = project.getActiveEnvironmentName();
            }else getEnv = getEnv.getName();
            if ( getEnv != null && (!getEnv.equalsIgnoreCase("Default environment")) )    {
                println "Considering test env '"+getEnv+"' for setting end points"
                for ( int i = 0; i < apiCount ; i++ )    {
                    def wsdlInterface = project.getInterfaceAt( i ).getName();
                    setForWsdl ( projectName , env , url , wsdlInterface , context )
                }
            } else println ("Test env '"+env+"' does not exist")
        } else println ("Prioject '"+projectName+"' does not exists")
    }
    
    public static void setForWsdl ( url , wsdl , context )    {
        def project = context.testCase.testSuite.project;
        def projectName = project.getName();
        def getEnv   = project.getActiveEnvironmentName();
        if ( getEnv != null && getEnv != "Default environment" ) {
            setForWsdl ( projectName , getEnv , url , wsdl , context );
        }
    }
    
    public static void setForWsdl ( env , url , wsdl , context )    {
        def project = context.testCase.testSuite.project;
        def projectName = project.getName();
        def getEnv   = project.getEnvironmentByName(env);
        if ( getEnv != null && getEnv != "Default environment" ) {
            setForWsdl ( projectName , getEnv.getName() , url , wsdl , context );
        }
    }
    
    public static void setForWsdl ( projectName , env , url , wsdl , context )    {
        println "**-Request recieved to set single WSDL: "+wsdl+" with url: "+url
        def workspace = context.testCase.testSuite.project.workspace;
        def project = workspace.getProjectByName(projectName);
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