import com.eviware.soapui.impl.WsdlInterfaceFactory

class IMPORT_WSDL {
    
    public static importWsdl( wsdl , testRunner )  {
        def projectName = testRunner.testCase.testSuite.project.getName();
        importWsdl( projectName , wsdl , testRunner )
    }

    public static importWsdl( projectName , wsdl , testRunner )  {
        def workspace = testRunner.testCase.testSuite.project.workspace
        def project   = workspace.getProjectByName(projectName);
        
        if ( project != null )    {
            if (wsdl != null)    {
                println "Adding Service "+wsdl+" in prject "+projectName
                WsdlInterfaceFactory.importWsdl( project , wsdl , true);
            }
        }
    }
}