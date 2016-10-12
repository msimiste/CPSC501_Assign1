package workingFiles;

/**
 * A simple test driver
 * 
 * @author 	Majid Ghaderi
 * @version	1.0, Sep 22, 2015
 *
 */
public class Tester {
	
	public static void main(String[] args) {

		// include whatever URL you like
		// these are just some samples
		String[] url = {"people.ucalgary.ca/~mghaderi/test/test.html",
						"people.ucalgary.ca/~mghaderi/test/uc.gif",
						"people.ucalgary.ca:80/~mghaderi/test/a1.pdf", 
						/*"www.iconfinder.com/404notfound"*/ /*test for cache exception*/};
						//"users.eastlink.ca/~shimmyy/dowdypage/images/deck3.jpg"};
		
		// this is a very basic tester
		// the TAs will use more a comprehensive set of tests
		try {
			UrlCache cache = new UrlCache();
			
			for (int i = 0; i < url.length; i++)
			{	cache.getObject(url[i]);
				System.out.println("Last-Modified for " + url[i] + " is: " + cache.getLastModified(url[i]) + " milliseconds");
			}
			
			//System.out.println("Last-Modified for " + url[0] + " is: " + cache.getLastModified(url[0]));
			
			//System.out.println("Last-Modified for " + url[1] + " is: " + cache.getLastModified(url[1]));
		}
		catch (UrlCacheException e) {
			System.out.println("There was a problem: " + e.getMessage());
		}
		
	}	
}
