import com.eviware.soapui.impl.WsdlInterfaceFactory

class SET_JDBC {
    public static void set( connectionString , context )        {
        def project = context.testCase.testSuite.project;
        def projectName = project.getName();
        def getEnv = project.getActiveEnvironmentName();
        def connectionname = "JDBC-Connection";
        def connectionDriver = "oracle.jdbc.driver.OracleDriver";
        if ( getEnv != null && (!getEnv.equalsIgnoreCase("Default environment")) )    {
            set( projectName , getEnv , connectionname , connectionDriver , connectionString , context );
        } else println ("There are no Active Test Environments");
    }
    
    public static void set( env , connectionString , context )    {
        def project = context.testCase.testSuite.project;
        def projectName = project.getName();
        def getEnv  = project.getEnvironmentByName(env);
        def connectionname = "JDBC-Connection";
        def connectionDriver = "oracle.jdbc.driver.OracleDriver";
        if ( getEnv != null && (!(getEnv.getName()).equalsIgnoreCase("Default environment")) )    {
            set( projectName , getEnv.getName() , connectionname , connectionDriver , connectionString , context );
        } else println ("Test env '"+env+"' does not exist")
    }
    
    public static void set( projectName , env , connectionString , context )    {
        def workspace = context.testCase.testSuite.project.workspace;
        def project = workspace.getProjectByName(projectName);
        if (project != null)
        { 
            def getEnv = project.getEnvironmentByName(env);
            if (getEnv == null)	{
				getEnv = project.getActiveEnvironmentName();
			} else getEnv = getEnv.getName();
            def connectionname = "JDBC-Connection";
            def connectionDriver = "oracle.jdbc.driver.OracleDriver";
            if ( getEnv != null && (!getEnv.equalsIgnoreCase("Default environment")) )    {
                set( projectName , getEnv , connectionname , connectionDriver , connectionString , context );
            } else println ("Test env '"+env+"' does not exist")
        } else println ("Prioject '"+projectName+"' does not exists")
    }
    
    public static void addConnectionDetails ( dbContainer , connectionname , connectionDriver , connectionString , exists ){
        def connection = dbContainer.getResourceByName(connectionname);
        if (exists == false && connection == null)    {
            connection = dbContainer.addResource( connectionname );
        }
        connection.setDriver(connectionDriver);
        connection.setConnectionString(connectionString);
        println "Creating JDBC connection is Success"
    }
    
    public static void set( projectName , env , connectionname , connectionDriver , connectionString , context )    {
        println "Request received to configure JDBC connection for env '"+env+"' in the project "+projectName
        def workspace = context.testCase.testSuite.project.workspace;
        def project = workspace.getProjectByName(projectName);
        if (project != null)
        {
            println "Connection name  : "+connectionname
            println "Connection Driver: "+connectionDriver
            println "Connection String: "+connectionString
            def exists = false;
            def prjDbContainer = project.getDatabaseConnectionContainer();
            def jdbcConnectionCount = prjDbContainer.getResourceCount();
            if ( jdbcConnectionCount == 0 )    {
                println "No JDBC Connections Found at Project level, Adding JDBC Details for: "+connectionname;
                addConnectionDetails ( prjDbContainer , connectionname , connectionDriver , connectionString , false )
            }
            jdbcConnectionCount = prjDbContainer.getResourceCount();
            if ( jdbcConnectionCount != 0 )    {
                for ( int i = 0 ; i < jdbcConnectionCount ; i++ )    {
                    def jdbcName = prjDbContainer.getResourceAt( i ).getName();
                    if ( jdbcName == connectionname )    {
                        exists = true;
                    }
                }
                if ( exists == false )    {
                    addConnectionDetails ( prjDbContainer , connectionname , connectionDriver , connectionString , exists )
                }
                addJdbcToEnvironment( projectName , env , connectionname , connectionDriver , connectionString , context );
            }
        } else println ("Prioject '"+projectName+"' does not exists")
    }
    
    public static void addJdbcToEnvironment( projectName , env , connectionname , connectionDriver , connectionString , context )
    {
        def workspace = context.testCase.testSuite.project.workspace;
        def project = workspace.getProjectByName(projectName);
        def getEnv = project.getEnvironmentByName( env );
        def envDbContainer= getEnv.getDatabaseConnectionContainer();
        def getEnvJdbcCount = envDbContainer.getResourceCount();
        def connection;
        def exists = false;
        if ( getEnvJdbcCount == 0 )    {
            println "Creating New JDBC connection row for env : "+env+"\n"
            addConnectionDetails ( envDbContainer , connectionname , connectionDriver , connectionString , exists )
        }    else    {
            for ( int i = 0 ; i < getEnvJdbcCount ; i++ )    {
                connection = envDbContainer.getResourceAt( i )
                def jdbcName = connection.getName();
                if ( jdbcName.contains ( connectionname ) )    {
                    exists = true;
                }
            }
            addConnectionDetails ( envDbContainer , connectionname , connectionDriver , connectionString , exists)
        }
    }
}