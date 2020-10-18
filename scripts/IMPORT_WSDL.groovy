import com.eviware.soapui.impl.WsdlInterfaceFactory

class IMPORT_WSDL {

    public static importWsdl( projectName , wsdl , testRunner )  {
        def project = testRunner.testCase.testSuite.project
        def workspace = project.workspace
        
        def setProject = workspace.getProjectByName(projectName);
        
        if ( setProject != null )    {
            if (wsdl != null)    {
                println "Adding Service "+wsdl
                WsdlInterfaceFactory.importWsdl( setProject , wsdl , true);
            }
        }
    }
}