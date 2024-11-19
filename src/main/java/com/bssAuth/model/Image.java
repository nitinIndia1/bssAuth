package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name="images")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;


	public Image() {
	}

	
	public Image(int imagesId, String kycPhotoBase64, String kycPhotoUrl, String originalPhotoBase64,
			String originalPhotoUrl, String verifiedPhotoBase64, String verifiedPhotoUrl) {
		this.imagesId = imagesId;
		this.kycPhotoBase64 = kycPhotoBase64;
		this.kycPhotoUrl = kycPhotoUrl;
		this.originalPhotoBase64 = originalPhotoBase64;
		this.originalPhotoUrl = originalPhotoUrl;
		this.verifiedPhotoBase64 = verifiedPhotoBase64;
		this.verifiedPhotoUrl = verifiedPhotoUrl;
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="images_id")
	private int imagesId;
	@JsonIgnore
	@Lob
	@Column(name="kyc_photo_base64")
	private String kycPhotoBase64;

	@Column(name="kyc_photo_url")
	private String kycPhotoUrl;
	@JsonIgnore
	@Lob
	@Column(name="original_photo_base64")
	private String originalPhotoBase64;

	@Column(name="original_photo_url")
	private String originalPhotoUrl;
	@JsonIgnore
	@Lob
	@Column(name="verified_photo_base64")
	private String verifiedPhotoBase64;

	@Column(name="verified_photo_url")
	private String verifiedPhotoUrl;

	@JsonIgnore
	@Lob
	@Column(name = "thumb_impression")
	private String thumbImpression;

	
	@Column(name = "thumb_impression_url")
	private String thumbImpressionUrl;

	
	
	public int getImagesId() {
		return imagesId;
	}


	public void setImagesId(int imagesId) {
		this.imagesId = imagesId;
	}


	public String getKycPhotoUrl() {
		return kycPhotoUrl;
	}


	public void setKycPhotoUrl(String kycPhotoUrl) {
		this.kycPhotoUrl = kycPhotoUrl;
	}


	public String getOriginalPhotoUrl() {
		return originalPhotoUrl;
	}


	public void setOriginalPhotoUrl(String originalPhotoUrl) {
		this.originalPhotoUrl = originalPhotoUrl;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setKycPhotoBase64(String kycPhotoBase64) {
		this.kycPhotoBase64 = kycPhotoBase64;
	}


	public void setOriginalPhotoBase64(String originalPhotoBase64) {
		this.originalPhotoBase64 = originalPhotoBase64;
	}


	public void setVerifiedPhotoBase64(String verifiedPhotoBase64) {
		this.verifiedPhotoBase64 = verifiedPhotoBase64;
	}


	public void setVerifiedPhotoUrl(String verifiedPhotoUrl) {
		this.verifiedPhotoUrl = verifiedPhotoUrl;
	}


	public String getKycPhotoBase64() {
		return kycPhotoBase64;
	}


	public String getOriginalPhotoBase64() {
		return originalPhotoBase64;
	}


	public String getVerifiedPhotoBase64() {
		return verifiedPhotoBase64;
	}


	public String getVerifiedPhotoUrl() {
		return verifiedPhotoUrl;
	}


	public String getThumbImpression() {
		return thumbImpression;
	}


	public void setThumbImpression(String thumbImpression) {
		this.thumbImpression = thumbImpression;
	}


	public String getThumbImpressionUrl() {
		return thumbImpressionUrl;
	}


	public void setThumbImpressionUrl(String thumbImpressionUrl) {
		this.thumbImpressionUrl = thumbImpressionUrl;
	}


	
	
	

}