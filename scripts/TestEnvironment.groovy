import com.eviware.soapui.impl.WsdlInterfaceFactory

class TestEnvironment {
    public static void addEndPoints( context )        {
        def project = context.testCase.testSuite.project;
        int envCount = project.getEnvironmentCount();
        for ( int i = 0; i <envCount ; i++ )    {
            def env = project.getEnvironmentAt( i ).getName();
            add( env , context );
        }
    }
    public static void add( env , context )    {
        env = env.toLowerCase();
        def project   = context.testCase.testSuite.project;
        def getEnv    = project.getEnvironmentByName(env);
        def apiCount  = project.getInterfaceCount();
        def result    = DetectTestEnvironment.getDetailsOf( env );
        def validEnv  = result[ 0 ];
        def eos_ip    = result[ 1 ];
        def pwhConnectionString = result[ 4 ];

        if ( getEnv == null && validEnv != null )        {
            createNewTestEnvironment( env , apiCount , context );
            getEnv    = project.getEnvironmentByName( env );
        }
        if ( getEnv != null && validEnv != null )    {
            setEndPoint( env , eos_ip , apiCount , context );
            setJdbcConnection( env , pwhConnectionString , context );
        } else if ( validEnv == null )    {
            println "Test Environment is not defined in \"DetectTestEnvironment\" Groovy File"
        }
    }
    public static void createNewTestEnvironment( env , apiCount , context )    {
        def project = context.testCase.testSuite.project;
        project.addNewEnvironment( env );
        project.setActiveEnvironment( env );
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
        println " *** Created New Test Environment "+env+" *** "
    }
    public static void setEndPoint( env , eos_ip , apiCount , context )        {
        def project = context.testCase.testSuite.project;
        project.setActiveEnvironment( env );
        def getEnv    = project.getEnvironmentByName(env);
        def delimitor = "PortTypeSoap11";
        def envDbContainer= getEnv.getDatabaseConnectionContainer();
        for ( int i = 0; i < apiCount ; i++ )    {
            def wsdlInterface = project.getInterfaceAt( i ).getName();
            def wsdlService = getEnv.getService(wsdlInterface, com.eviware.soapui.config.ServiceConfig.Type.Enum.forString("SOAP"));
            if ( wsdlInterface.contains ( "PINS" ) || wsdlInterface.contains ( "PAYS" )  && wsdlService != null )     {
                def service = wsdlInterface.split(delimitor).toString();
                service = service.replaceAll( "[^a-zA-Z0-9_]","" );
                def setString = "http://"+eos_ip+"/pin/services/"+service+"?wsdl";
                def urlConf    = wsdlService.getEndpoint().getConfig();
                if ( urlConf != null ) {
                    urlConf.setStringValue( setString );
                }
            }
        }
        println "Setting Endpoints for "+env+" is successful, making it ACTIVE Environment";
    }

    public static void setJdbcConnection( env , pwhConnectionString , context )    {
        def project = context.testCase.testSuite.project;
        def prjDbContainer = project.getDatabaseConnectionContainer();
        def jdbcConnectionCount = project.databaseConnectionContainer.getResourceCount();
        if ( jdbcConnectionCount == 0 )    {
            println "No JDBC Strings Found at Project level, Adding JDBC Connection  "
            def connect = prjDbContainer.addResource( "PWHDATA" );
        }
        jdbcConnectionCount = prjDbContainer.getResourceCount();
        if ( jdbcConnectionCount != 0 )        {
            def jdbcTemplateName = prjDbContainer.getResourceAt( 0 ).getName();
            def jdbcTemplateDriver = prjDbContainer.getResourceAt( 0 ).getDriver();
            addJdbcConnectionToEnvironment( env , pwhConnectionString , context );
        }
    }
    public static void addJdbcConnectionToEnvironment( env , pwhConnectionString , context )        {
        def project = context.testCase.testSuite.project;
        def getEnv = project.getEnvironmentByName( env );
        def envDbContainer= getEnv.getDatabaseConnectionContainer();
        def getEnvJdbcCount = envDbContainer.getResourceCount();
        def connection;
        if ( getEnvJdbcCount == 0 )        {
            println "Creating New JDBC connection row for env : "+env
            connection = envDbContainer.addResource( "PWHDATA" );
            connection.setDriver( "oracle.jdbc.driver.OracleDriver" );
            connection.setConnectionString(pwhConnectionString);
        }    else    {
            for ( int i = 0 ; i < getEnvJdbcCount ; i++ )    {
                connection = envDbContainer.getResourceAt( i )
                def jdbcName = connection.getName();
                if ( jdbcName.contains ( "PWHDATA" ) )    {
                    println "Found PWHDATA row, Updating the Connection String details "
                    connection.setDriver("oracle.jdbc.driver.OracleDriver");
                    connection.setConnectionString(pwhConnectionString);
                }    else    {
                    println "Creating new row for PWHDATA JDBC and Updating the Connection String"
                    connection = envDbContainer.addResource("PWHDATA");
                    connection.setDriver("oracle.jdbc.driver.OracleDriver");
                    connection.setConnectionString(pwhConnectionString);
                }
            }
        }
    }
    public static void removeAll( context )    {
        def project = context.testCase.testSuite.project;
        int envCount = project.getEnvironmentCount();
        for ( int i = 0; i < envCount ; i++ )    {
            def env = project.getEnvironmentAt( 0 ).getName();
            remove(env , context )
        }
    }
    public static void remove( env , context )    {
        def project = context.testCase.testSuite.project;
        int envCount = project.getEnvironmentCount();
        env = env.toLowerCase();
        def envToDelete = null;
        for ( int i = 0; i < envCount ; i++ )    {
            def checkEnv = project.getEnvironmentAt( i ).getName();
            if (checkEnv.equalsIgnoreCase(env) || env.contains(checkEnv) || checkEnv.contains(env)){
                if (checkEnv == env) {
                    envToDelete = env;
                    println (env+" equals "+checkEnv)
                }else if (env.contains(checkEnv)){
                    envToDelete = checkEnv;
                    println (env+" contains "+checkEnv)
                }else if (checkEnv.contains(env)){
                    envToDelete = checkEnv;
                    println (checkEnv+" contains "+env)
                }else if (env.endsWith(checkEnv)){
                    envToDelete = checkEnv;
                    println (env+" endsWith "+checkEnv)
                }else if (checkEnv.endsWith(env)){
                    envToDelete = checkEnv;
                    println (checkEnv+" endsWith "+env)
                }
            }
            if (envToDelete != null)    {
                env = envToDelete;
                println ("Delete Candidate: "+env);
                def envName = project.getEnvironmentByName(env)
                if (envName != null)    {
                    def activeEnv = project.getActiveEnvironment().getName();
                    if (activeEnv == env)    {
                        project.setActiveEnvironment('Default');
                        println "Changed Active Environment to DEFAULT"
                    }
                    project.removeEnvironmentByName(env);
                    println "Test Environment "+env+" is removed successfully"
                }
            }
        }
    }
    
    public static void importAll( projectName , testRunner )
    {
        importWsdl( projectName, "authoriz" , testRunner );
        importWsdl( projectName, "standingorder" , testRunner );
        importWsdl( projectName, "statusupdate" , testRunner );
        importWsdl( projectName, "predefinedcreditor" , testRunner );
        importWsdl( projectName, "search" , testRunner );
        importWsdl( projectName, "paymentcreate" , testRunner );
        importWsdl( projectName, "util" , testRunner );
    }
    
    public static void importWsdl( String projectName , String wsdl , testRunner )
    {
        def project = testRunner.testCase.testSuite.project
        def workspace = project.workspace
        def setProject = workspace.getProjectByName(projectName);
        if ( setProject != null )    {
            def wsdlName = findWsdlName(wsdl);
            if ( wsdlName != null )    {
                def wsdlExists = verifyExistance( setProject , wsdlName );
                if (wsdlExists)    {
                    def wsdlUrl = findWsdlUrl( wsdlName );
                    if (wsdlUrl != null)    {
                        println "Adding Service "+wsdlName
                        WsdlInterfaceFactory.importWsdl( setProject , wsdlUrl , false);
                    }
                }
            }
        }
    }
    
    public static String findWsdlUrl( String wsdlName )
    {
        def url = null;
        if ( wsdlName.contains ("PINSPayment") || wsdlName.contains ("PAYSPayment") || wsdlName.contains ("PINSStandingOrder"))    {
            url = "http://10.246.89.106:22411/pin/services/"+wsdlName+"?wsdl";
        }
        return url;
    }
    
    public static boolean verifyExistance( setProject , wsdlName)
    {
        def delimitor = "PortTypeSoap11";
        def apiCount = setProject.getInterfaceCount();
        for ( int i = 0; i < apiCount ; i++ )    {
            def wsdlInterface = setProject.getInterfaceAt( i ).getName();
            def service = wsdlInterface.split(delimitor).toString();
            service = service.replaceAll( "[^a-zA-Z0-9_]","" );
            if ( service.contains ( wsdlName ) ) {
                println ("WSDL Exists: $wsdlName")
                return false;
            }
        }
        return true;
    }
    
    public static String findWsdlName( String wsdl )
    {
        wsdl = wsdl.toLowerCase();
        def wsdlName = null;
        if (wsdl.contains( "authoriz" ) )    {
            wsdlName = 'PAYSPaymentAuthorization_V1_2';
        }
        else if (wsdl.contains( "standingorder") )    {
            wsdlName = 'PINSStandingOrder_V2_0Service';
        }
        else if (wsdl.contains( "statusupdate") )    {
            wsdlName = 'PINSPaymentStatusUpdate_V1_5';
        }
        else if (wsdl.contains( "predefinedcreditor") )    {
            wsdlName = 'PINSPaymentPredefinedCreditor_V1_1';
        }
        else if (wsdl.contains( "search") )    {
            wsdlName = 'PINSPaymentSearch_V1_9';
        }
        else if (wsdl.contains( "paymentcreate") || wsdl.contains( "create") )    {
            wsdlName = 'PINSPayment_V1_9';
        }
        else if (wsdl.contains( "forecastsearch") || wsdl.contains( "forecast") )    {
            wsdlName = 'PINSPaymentAccountForecastSearch_V1_1';
        }
        else if (wsdl.contains( "util") )    {
            wsdlName = 'PINSPaymentUtil_V1_2';
        }
        return wsdlName;
    }
}