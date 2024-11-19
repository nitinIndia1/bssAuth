package com.bssAuth.service;

import org.springframework.http.ResponseEntity;

import com.bssAuth.beans.IdRequest;
import com.bssAuth.beans.Image_;
import com.bssAuth.model.Image;

public interface ImageService {

	
	Image saveImage(Image_ image_);
	Image updateImageWithSelfie(Image image, Image_ image_);
	void deleteDuplicateCustomerImage(Image image);
	
}
