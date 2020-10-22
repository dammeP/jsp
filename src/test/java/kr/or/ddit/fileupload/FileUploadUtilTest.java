package kr.or.ddit.fileupload;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;

public class FileUploadUtilTest {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtilTest.class);

	@Test
	public void getFilenameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"contentType.jpg\"";

		/***When***/
		String fileName = FileUploadUtil.getFilename(contentDisposition);

		/***Then***/
		assertEquals("contentType.jpg", fileName);
	}
	
	@Test
	public void UUIDtest() {
		/***Given***/
		

		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}",uuid);
		
		/***Then***/
	}
	
	@Test
	public void getExtensionTest() {
		/***Given***/
		String filename = "sally";

		/***When***/
		String ext = FileUploadUtil.getExtenstion(filename);

		/***Then***/
		assertEquals("", ext);
	}
}
