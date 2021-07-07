//CreateNewProject

class CreateNewProject {
    public static void create( projectName , context){
        def path = new com.eviware.soapui.support.GroovyUtils(context).projectPath;
        def getProject = context.testCase.testSuite.project.workspace.getProjectByName (projectName);
        if (getProject == null){ addNewProject(projectName, path, context); }
        getProject = context.testCase.testSuite.project.workspace.getProjectByName (projectName);
        if (getProject != null){ addTestSuite(projectName, java.util.UUID.randomUUID().toString().substring(0,10) ,context); }
        println "-------------------------------------------------";
    }
    public static void addNewProject(projectName, path, context){
        File projectFile = new File(path+"/ReadyAPI_Projects/"+projectName+".xml");
        def getNewProject = context.testCase.testSuite.project.workspace.createProject(projectName,projectFile);
        println ("NEW PROJECT IS CREATED WITH NAME: "+getNewProject.getName()+" and the location is: "+getNewProject.getPath());
    }
    public static void addTestSuite(projectName, suiteName, context){
        def getProject = context.testCase.testSuite.project.workspace.getProjectByName (projectName);
        def testSuite = addTestSuitesToProject(getProject, suiteName);
        def testCase = addTestCaseToSuite(testSuite, suiteName);
        def testStep = addTestStepToCase(testCase, suiteName);
        println ( "New Test Suite: "+ testSuite.getName()+" , New Test Case: "+testCase.getName()+" and New Test Step Name: "+testStep.getName());
    }
    public static addTestSuitesToProject(getProject, name){ return (getProject.addNewTestSuite( "TS_"+name) ); }
    public static addTestCaseToSuite(testSuite, name){ return (testSuite.addNewTestCase( "TC_"+name) ); }
    public static addTestStepToCase(testCase, name){ return (testCase.addTestStep( "groovy", "Step_"+name) ); }
}