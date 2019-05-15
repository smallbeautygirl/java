public class ErrorXMLDisplayService extends DisplayService{

	@Override
	public XMLParser getParser() {
		/* Fill your code here */
		return new ErrorXMLParser();
	}

}
