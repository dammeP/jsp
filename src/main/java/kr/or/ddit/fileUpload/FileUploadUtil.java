package kr.or.ddit.fileUpload;

import java.util.List;

public class FileUploadUtil {
	
	// form-data; name="img"; filename="sally.png"
	// filename="sally.png"; form-data; name="img";
	// ==> sally.png
	
	// FileUploadUtilTest
	public static String getFilename(String contentDisposition) {
		
		String fileName[] = contentDisposition.split("; ");
		for(String fileNames : fileName) {
			String fileNamesList[] = fileNames.split("=");
			if(fileNamesList[0].equals("filename")) {
				return fileNamesList[1].replaceAll("\"", "");		// 더블 쿼테이션 제거
			}
			
			
		}
		
		
		
		return "";
	}

}
