package kr.or.ddit.fileupload;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.ddit.fileUpload.FileUploadUtil;

public class FileUploadUtilTest {

	@Test
	public void getFilenameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"contentType.jpg\"";

		/***When***/
		String fileName = FileUploadUtil.getFilename(contentDisposition);

		/***Then***/
		assertEquals("contentType.jpg", fileName);
	}
}
