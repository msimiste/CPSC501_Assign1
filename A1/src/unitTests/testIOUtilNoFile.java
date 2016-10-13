package unitTests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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

}