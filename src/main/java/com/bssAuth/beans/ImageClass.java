package com.bssAuth.beans;
import java.io.Serializable;
import java.util.*;
import java.util.stream.*;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.function.*;
public class ImageClass implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonIgnore 
private MultipartFile customerImage;

public MultipartFile getCustomerImage() {
	return customerImage;
}

public void setCustomerImage(MultipartFile customerImage) {
	this.customerImage = customerImage;
}
 
 
 
 
}
