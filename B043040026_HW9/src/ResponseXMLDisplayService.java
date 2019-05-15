public class ResponseXMLDisplayService extends DisplayService{

	@Override
	public XMLParser getParser() {
		/* Fill your code here */
		return new ResponseXMLParser();
	}

}
