package com.bssAuth.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.DatatypeConverter;

//import jakarta.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bssAuth.beans.Image_;
import com.bssAuth.model.Image;
import com.bssAuth.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageRepository imgRepository;
	
	//private static String UPLOADED_FOLDER = "/opt/images/";
	
	private static String UPLOADED_FOLDER = "/home/apache-tomcat-8.5.85/webapps/ROOT/";
	
	//private static String UPLOADED_FOLDER = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\ROOT\\";
	
	//opt/apache-tomcat-8.5.85/webapps/ROOT
	
	@Override
	public Image saveImage(Image_ image_) {
		try {
			Image image = new Image();
			if(image_.getImgType()==null) {
				return	null;
			}
			if(image_.getImgType().equals("kyc")) {
				image.setKycPhotoBase64(image_.getBase64());
				
				String path =  saveImageInPath(image_);
				
				image.setKycPhotoUrl(path);
				
				Image imageSaved = imgRepository.saveAndFlush(image);
				if(imageSaved!=null) {
					return imageSaved;
				}
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return null;
	}
	@Override
	public Image updateImageWithSelfie(Image image, Image_ image_) {
		try {
			if(image_.getImgType()==null) {
				return	null;
			}
			if(image_.getImgType().equals("self")) {
				image.setOriginalPhotoBase64(image_.getBase64());
				
				String path =  saveImageInPath(image_);
				
				image.setOriginalPhotoUrl(path);
				
				Image imageSaved = imgRepository.saveAndFlush(image);
				if(imageSaved!=null) {
					return imageSaved;
				}
				
			}
			else if(image_.getImgType().equals("verified")) {
				image.setVerifiedPhotoBase64(image_.getBase64());
				String path = saveImageInPath(image_);
				image.setVerifiedPhotoUrl(path);
				Image imageSaved = imgRepository.saveAndFlush(image);
				if(imageSaved!=null) {
					return imageSaved;
				}
			}
			
			//thumb impression match API ? 
			else if(image_.getImgType().equals("thumb")) {
				image.setThumbImpression(image_.getBase64());
				String path = saveImageInPath(image_);
				image.setThumbImpressionUrl(path);
				Image imageSaved = imgRepository.saveAndFlush(image);
				if(imageSaved!=null) {
					return imageSaved;
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return null;
	}
	
	private String saveImageInPath(Image_ image_) {
        String path = null;
        if(image_.getBase64()==null || image_.getBase64().equalsIgnoreCase("null")) {
        	path="not able to save";
        }
		byte[] data = DatatypeConverter.parseBase64Binary(image_.getBase64());
        
        File file = new File(UPLOADED_FOLDER+image_.getToken()+File.separator);
        file.mkdir();
        
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file+File.separator+image_.getImgType()+".jpg"))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if(!file.exists()) {
        	path="not able to save";
        }
        else {
        	path = file.getAbsolutePath()+File.separator+image_.getImgType()+".jpg";
        	//path=path.replace("/home/apache-tomcat-8.5.85/webapps/ROOT/", "https://ekyc.chili.mu/");
        }
			return path;
	}
	@Override
	public void deleteDuplicateCustomerImage(Image image) {
		imgRepository.delete(image);
		
	}



	
}
