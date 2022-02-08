package org.spring.my.service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.spring.my.dao.ThumbnailDAO;
import org.spring.my.dto.Page;
import org.spring.my.dto.Thumbnail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThumbnailServiceImpl implements ThumbnailService{
	@Autowired
	String saveDir;
	@Autowired
	private ThumbnailDAO thumbnailDAO;
	
	@Override
	public String makeThumb(String filename) {
		// TODO Auto-generated method stub
		File oFile = new File(saveDir,filename);
		int index = filename.lastIndexOf(".");
		String ext = filename.substring(index + 1);
		String tFilename = "t-" + filename;
		File tFile = new File(saveDir,tFilename);
		
		int tWidth = 245;
		int tHeight = 245;
				
		try {
			BufferedImage oImage = ImageIO.read(oFile);
			int oWidth = oImage.getWidth();
			int oHeight = oImage.getHeight();
			int cWidth = oWidth;
			int cHeight = tHeight / tWidth * oWidth;
			int x = 0;
			int y = (oHeight - cHeight) / 2; 
			if(cHeight >= oHeight) {
				cWidth = tWidth / tHeight * oHeight;
				cHeight = oHeight;
				y = 0;
				x = (oWidth -cWidth) / 2;
			}
			oImage = oImage.getSubimage(x, y, cWidth, cHeight);
			
			BufferedImage tImage = new BufferedImage(tWidth,tHeight,BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = tImage.createGraphics();
			Image image = oImage.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
			graphic.drawImage(image, 0, 0, tWidth, tHeight, null);
			graphic.dispose();
			
			ImageIO.write(tImage, ext, tFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tFilename;
	}
	
	@Override
	public List<Thumbnail> selectList(Page page) {
		// TODO Auto-generated method stub
		return thumbnailDAO.selectList(page);
	}

}
