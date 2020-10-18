import com.eviware.soapui.impl.WsdlInterfaceFactory

class UPDATE_DEFINITION {

    public static updateDefinition( projectName , wsdl , testRunner )  {
        def project = testRunner.testCase.testSuite.project
        def workspace = project.workspace
        
        def setProject = workspace.getProjectByName(projectName);
        
        if ( setProject != null )    {
            if (wsdl != null)    {
                println ("Updating Service "+wsdl);
                WsdlInterface.updateDefinition( wsdl , true);
            }
        }
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
}