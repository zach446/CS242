package Working_With_Exceptions;

//Class to store and retrieve a URL. At the moment, 
//it will compile, but we will develop this class
//to throw and catch exceptions.
public class SimpleURL {
	
	private String urlname; // private data for URL name
	
	// Constructor
	public SimpleURL() {
		urlname = "";
	}
	
	// storeURL() method
	public void storeURL( String urlname ) {			
		this.urlname = urlname;
	}
	
	// getURL method
	public String getURL() {
		return this.urlname; 
	}
	
	// main method
	public static void main ( String[] args ) {
		// Create a new SimpleURL object
		SimpleURL simpleURL = new SimpleURL();
		
		// Provide it a URL to store
		simpleURL.storeURL( "http://www.clarkson.edu" );
		
		// Print out the stored URL
		System.out.println( simpleURL.getURL() );
		
	}
}

