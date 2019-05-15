public class FeedbackXMLDisplayService extends DisplayService{

	@Override
	public XMLParser getParser() {
		/* Fill your code here */
		return new FeedbackXML();
	}

}