package unitTests;

import static org.junit.Assert.*;

import org.junit.*;

import workingFiles.Host;

public class TestHostMethods {

	Host host;

	@Before
	public void setUP() {
		host = new Host("people.ucalgary.ca:80/~mghaderi/test/a1.pdf");
	}
	
	@After
	public void tearDown(){
		host = null;
	}

	@Test
	public void testGetHostName() {
		String testHostname = "people.ucalgary.ca";
		assertEquals(testHostname, host.getHostName());
	}

	@Test
	public void testSetHostName() {
		String testHostname = "testing";
		host.setHostName(testHostname);
		assertEquals(testHostname, host.getHostName());
	}

	@Test
	public void testGetPort() {
		int testPort = 80;
		assertEquals(testPort, host.getPort());
	}

	@Test
	public void testSetPort() {
		int testPort = 9001;
		host.setPort(testPort);
		assertEquals(testPort, host.getPort());
	}

	@Test
	public void testGetPath() {
		String testPath = "/~mghaderi/test";
		assertEquals(testPath, host.getPath());
	}

	@Test
	public void testSetPath() {
		String testPath = "testing/this/path/out";
		host.setPath(testPath);
		assertEquals("testing/this/path/out", host.getPath());
	}

	@Test
	public void testGetFileName() {
		String fileName = "a1.pdf";
		assertEquals(fileName, host.getFileName());
	}

	@Test
	public void testSetFileName() {
		String fileName = "testingFile.txt";
		host.setFileName(fileName);
		assertEquals("testingFile.txt", host.getFileName());
	}

	@Test
	public void getConcatPath() {
		String concatPath = "/~mghaderi/test/a1.pdf";
		assertEquals(concatPath, host.getConcatPath());
	}

	@Test
	public void setConcatPath() {
		String concatPath = "this/is/a/test/path";
		host.setConcatPath(concatPath);
		assertEquals("this/is/a/test/path", host.getConcatPath());
	}

	@Test
	public void getUrl() {
		String testUrl = "people.ucalgary.ca/~mghaderi/test/a1.pdf";
		assertEquals(testUrl, host.getUrl());
	}

	@Test
	public void setUrl() {
		String url = "/ThisIsA/Test/Url";
		host.setUrl(url);
		assertEquals(url, host.getUrl());
	}

}
