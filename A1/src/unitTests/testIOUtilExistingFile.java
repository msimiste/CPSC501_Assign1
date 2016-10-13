package unitTests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import workingFiles.IOUtility;

public class testIOUtilExistingFIle {

	
	@Before public void setUp(){
		String catalogFilePath = "catalog.txt";
		File catalogFile = new File(catalogFilePath);
		
		try{
			catalogFile.createNewFile();
		}
		catch(Exception e){}
	}
	
	@After public void tearDown(){
		String catalogFilePath = "catalog.txt";
		File catalogFile = new File(catalogFilePath);
		
		try{
			catalogFile.delete();
		}
		catch(Exception e){}
	}	
	
	@Test
	public void testCheckLocalCache_WhenLocalFileExists() {
		
		String catalogFilePath = "catalog.txt";
		File catalogFile = new File(catalogFilePath);
		
		try{
			catalogFile.createNewFile();
		}
		catch(Exception e){}
		
		IOUtility ioUtil = new IOUtility();
		boolean cacheExists = true;
		
		cacheExists = ioUtil.checkLocalCache();
		
		assertEquals(cacheExists,true);
		
		try{
			catalogFile.delete();
		}
		catch(Exception e){}
		
	}

}