import com.eviware.soapui.impl.WsdlInterfaceFactory

class REMOVE_WSDL {

    public static removeWsdl( projectName , wsdl , testRunner )  {
        def project = testRunner.testCase.testSuite.project
        def workspace = project.workspace
        
        def setProject = workspace.getProjectByName(projectName);
        
        if ( setProject != null )    {
            if (wsdl != null)    {
                println "Adding Service "+wsdl
                WsdlInterfaceFactory.removeWsdl( setProject , wsdl , true);
            }
        }
    }
}