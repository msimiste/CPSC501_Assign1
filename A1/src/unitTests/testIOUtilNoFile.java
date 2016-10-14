package unitTests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import workingFiles.IOUtility;

public class testIOUtilNoFile {

	@Before
	public void setUP() {
		String catalogFilePath = "catalog.txt";
		File catalogFile = new File(catalogFilePath);

		if (catalogFile.exists()) {
			try {
				catalogFile.delete();
			} catch (Exception e) {
			}
		}
	}
	
	@After
	public void tearDown(){
		
		String testFilePath = "testDir/testSubDir/TestFileName.txt"; 
		File testFile = new File(testFilePath);
		File parent = new File("testDir/testSubDir/");
		File grandParent = new File("testDir");
		
		if(testFile.exists()){
			testFile.delete();
			parent.delete();
			grandParent.delete();
		}
	}

	@Test
	public void testCheckLocalCache_WhenLocalFileDoesNotExist() {

		String catalogFilePath = "catalog.txt";
		File catalogFile = new File(catalogFilePath);

		try {
			catalogFile.createNewFile();
		} catch (Exception e) {
		}

		IOUtility ioUtil = new IOUtility();
		boolean cacheExists = true;

		cacheExists = ioUtil.checkLocalCache();

		assertEquals(cacheExists, true);

		try {
			catalogFile.delete();
		} catch (Exception e) {
		}
	}
	
	@Test	
	public void testMakeFileAndDir(){
		String testFileName = "TestFileName.txt";
		String testPath = "testDir/testSubDir/";
		
		IOUtility util = new IOUtility();
		
		File testFile = util.makeFileAndDir(testPath, testFileName);
		assertEquals(true,testFile.exists());
	}
}