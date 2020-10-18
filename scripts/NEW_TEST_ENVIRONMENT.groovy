import com.eviware.soapui.impl.WsdlInterfaceFactory

class NEW_TEST_ENVIRONMENT {
    public static void add( env , context )    {
        def projectName   = context.testCase.testSuite.project.getName();
        add( env , projectName , context )
    }
    
    public static void add( env , projectName , context )    {
        env = env.toLowerCase();
        def workspace = context.testCase.testSuite.project.workspace
        def project = workspace.getProjectByName(projectName)
        println "Request Received to Create new test env with name " + env
        def getEnv    = isEnvExists ( env , project , context );
        def apiCount  = project.getInterfaceCount();

        if ( getEnv == null &&  project!= null )    {
            createNewTestEnvironment( env , apiCount , project , context );
            println "Success.! Test Environment is created with name "+env+" in Project "+projectName+" \n"
        } else println "Test Environment exists with Name "+getEnv+" in Project "+projectName+" \n"
    }

    public static void createNewTestEnvironment( env , apiCount , project , context )    {
        project.addNewEnvironment( env );
        project.setActiveEnvironment( env );
        println "Created New Test Environment and " + env + " is now Active "
        def activeEnv = project.getActiveEnvironment();
        for ( int i = 0; i < apiCount ; i++ )    {
            def wsdl = project.getInterfaceAt( i )
            URL url = new URL(wsdl.getDefinition())
            def urlDefinition = url.toString();
            def binding = project.getInterfaceAt( i ).getName().toString();
            def newService = activeEnv.addNewService( binding , com.eviware.soapui.config.ServiceConfig.Type.Enum.forString("SOAP") );
            def serviceConfig = newService.getConfig();
            def endpointConfig = serviceConfig.addNewEndpoint();
            endpointConfig.setStringValue( urlDefinition )
            newService.buildEndpoint( endpointConfig );
            def isCopied = true;
            activeEnv.populateService( newService , isCopied );
            activeEnv.release();
        }
    }

    public static String isEnvExists ( env , project , context )
    {
        env = env.toLowerCase();
        int envCount = project.getEnvironmentCount();
        def envName = null;

        for ( int i = 0; i < envCount ; i++ )    {
            def checkEnv = project.getEnvironmentAt( i ).getName();
            if (checkEnv.equalsIgnoreCase(env) || env.contains(checkEnv) || checkEnv.contains(env)){
                if (checkEnv == env) {
                    envName = env;
                    println (env+" equals "+checkEnv)
                }else if (env.contains(checkEnv)){
                    envName = checkEnv;
                    println (env+" contains "+checkEnv)
                }else if (checkEnv.contains(env)){
                    envName = checkEnv;
                    println (checkEnv+" contains "+env)
                }else if (env.endsWith(checkEnv)){
                    envName = checkEnv;
                    println (env+" endsWith "+checkEnv)
                }else if (checkEnv.endsWith(env)){
                    envName = checkEnv;
                    println (checkEnv+" endsWith "+env)
                }
                return envName
            }
        }
     }
    public static void remove( env , context )    { 
        def projectName   = context.testCase.testSuite.project.getName();
        remove( env , projectName , context );
    }

    public static void remove( env , projectName , context )    {
        println "Request Received to remove test env " + env
        def workspace = context.testCase.testSuite.project.workspace
        def project = workspace.getProjectByName(projectName)
        def getEnv    = isEnvExists ( env , project , context )
        if ( getEnv != null && project != null )    {
            def envName = project.getEnvironmentByName(getEnv)
            if (envName != null)    {
                def activeEnv = project.getActiveEnvironment().getName();
                if (activeEnv == getEnv)    {
                    project.setActiveEnvironment('Default');
                    println "Changed Active Environment to DEFAULT"
                }
                project.removeEnvironmentByName(getEnv);
                println "Success.! Test Environment "+getEnv+" is removed from Project "+projectName+"\n"
            }
        } else println "Test Environment does not exists with Name "+env+" in Project "+projectName+" \n";
    }
}