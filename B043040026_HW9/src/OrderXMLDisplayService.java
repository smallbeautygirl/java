public class OrderXMLDisplayService extends DisplayService{

	@Override
	public XMLParser getParser() {
		/* Fill your code here */
		return new OrderXMLParser();
	}

}
