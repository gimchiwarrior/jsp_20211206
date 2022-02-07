package org.spring.my.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{
	@Autowired
	private String saveDir;
	@Override
	public String upload(MultipartFile file) {
		// TODO Auto-generated method stub
		String oriFileName = file.getOriginalFilename();
		
		if(oriFileName.equals("")) {
			return "";
		}
		
		String filename = System.currentTimeMillis()+ "_" + oriFileName;
		File filePath = new File(saveDir,filename);
		try {
			file.transferTo(filePath);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return filename;
	}

}
