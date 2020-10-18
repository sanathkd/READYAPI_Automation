//CREATE_NEW_PROJECT

class CREATE_NEW_PROJECT {
    public static void create ( String projectName , testRunner)
    {
        def project = testRunner.testCase.testSuite.project;
        def workspace = project.workspace;
        def porjectExists = null;
        porjectExists = workspace.getProjectByName (projectName);
        if (porjectExists != null)
        {
            def newProject = workspace.createProject(projectName,new File("C:/Users/Ei06593/OneDrive - EVRY/DOCUMENTS_SANATH/testSampleProject.xml")) ;
            projectName = newProject.getName();
            println ("NEW PROJECT IS CREATED WITH NAME: "+projectName);
        }
        project = workspace.getProjectByName(projectName);
        
        def testSuite = project.addNewTestSuite( "Sample_TestSuite" );
        def testCase = testSuite.addNewTestCase( "Sample_TestCase" );
        def testStep = testCase.addTestStep( "groovy", "Sample_GroovyStep" );
        
        println ( "CREATED NEW TEST SUITE :-"+ testSuite.getName() +" AND NEW TEST CASE :"+ testCase.getName() + " AND ONE NEW TEST STEP :"+ testStep.getName() );
    }
}