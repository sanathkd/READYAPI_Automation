//CREATE_NEW_PROJECT

class CREATE_NEW_PROJECT {
    public static void create ( String projectName , context)
    {
        def randomValue = java.util.UUID.randomUUID().toString().substring(0,13);
        def project = context.testCase.testSuite.project;
        def workspace = project.workspace;
        def projPath = new com.eviware.soapui.support.GroovyUtils(context).projectPath //gets the path of the project root
        def projectExists = null;
        projectExists = workspace.getProjectByName (projectName);
        println ("project Existance --> "+projectExists.getPath()+"___"+projectExists.getName())
        
        if (projectExists == null)
        {
            def newProject = workspace.createProject(projectName,new File(projPath+"/"+projectName+".xml")) ;
            projectName = newProject.getName();
            println ("NEW PROJECT IS CREATED WITH NAME: "+projectName);
            projectExists = workspace.getProjectByName (projectName);
        }
        if (projectExists != null)
        {
            def testSuite = project.addNewTestSuite( "Sample_TestSuite_"+randomValue );
            println ( "CREATED NEW TEST SUITE --> "+ testSuite.getName());
            def testCase = testSuite.addNewTestCase( "Sample_TestCase_"+randomValue );
            println ( "CREATED NEW TEST CASE ---> "+ testCase.getName());
            def testStep = testCase.addTestStep( "groovy", "Sample_GroovyStep_"+randomValue );
            println ( "CREATED NEW TEST STEP ---> "+ testStep.getName());
        }
    }
}