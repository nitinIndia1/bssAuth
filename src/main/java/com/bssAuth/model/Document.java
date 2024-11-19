package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the documents database table.
 * 
 */
@Entity
@Table(name="documents")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	public Document() {
	}



	public Document(int documentId, String documentUrl, String document1Type, String document2Type, String document2Url,
			String document3Type, String document3Url) {
		this.documentId = documentId;
		this.documentUrl = documentUrl;
		this.document1Type = document1Type;
		this.document2Type = document2Type;
		this.document2Url = document2Url;
		this.document3Type = document3Type;
		this.document3Url = document3Url;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="document_id")
	private int documentId;

	@Column(name="document_url")
	private String documentUrl;
	@JsonIgnore
	@Lob
	@Column(name="document1_type")
	private String document1Type;
	@JsonIgnore
	@Lob
	@Column(name="document2_type")
	private String document2Type;

	@Column(name="document2_url")
	private String document2Url;

	@JsonIgnore
	@Lob
	@Column(name="document3_type")
	private String document3Type;

	@Column(name="document3_url")
	private String document3Url;

	@JsonIgnore
	@Lob
	@Column(name="document4_type")
	private String document4Type;

	@Column(name="document4_url")
	private String document4Url;

	@JsonIgnore
	@Lob
	@Column(name="document5_type")
	private String document5Type;

	@Column(name="document5_url")
	private String document5Url;

		

	
	
	
	
	
	
	
	
	@JsonIgnore
	@Lob
	@Column(name="document6_type")
	private String document6Type;

	@Column(name="document6_url")
	private String document6Url;

		

	@JsonIgnore
	@Lob
	@Column(name="document7_type")
	private String document7Type;

	@Column(name="document7_url")
	private String document7Url;

		

	
	@JsonIgnore
	@Lob
	@Column(name="document8_type")
	private String document8Type;

	@Column(name="document8_url")
	private String document8Url;

		

	
	
	
	
	@JsonIgnore
	@Lob
	@Column(name="document9_type")
	private String document9Type;

	@Column(name="document9_url")
	private String document9Url;

		

	
	
	
	@JsonIgnore
	
	@Lob
	@Column(name="document10_type")
	private String document10Type;

	@Column(name="document10_url")
	private String document10Url;

		

	
	
	
	@JsonIgnore
	
	@Lob
	@Column(name="document11_type")
	private String document11Type;

	@Column(name="document11_url")
	private String document11Url;

		

	
	
	
	
	@JsonIgnore
	@Lob
	@Column(name="document12_type")
	private String document12Type;

	@Column(name="document12_url")
	private String document12Url;

		

	
	
	
	
	@JsonIgnore
	@Lob
	@Column(name="document13_type")
	private String document13Type;

	@Column(name="document13_url")
	private String document13Url;

		

	
	
	@JsonIgnore
	@Lob
	@Column(name="document14_type")
	private String document14Type;

	@Column(name="document14_url")
	private String document14Url;

		
	
	@JsonIgnore
	@Lob
	@Column(name="document15_type")
	private String document15Type;

	@Column(name="document15_url")
	private String document15Url;

		
		
	
	@JsonIgnore
	@Lob
	@Column(name="document16_type")
	private String document16Type;

	@Column(name="document16_url")
	private String document16Url;

		
		
	
	
	@JsonIgnore
	@Lob
	@Column(name="document17_type")
	private String document17Type;

	@Column(name="document17_url")
	private String document17Url;

		
	@JsonIgnore
	@Lob
	@Column(name="document18_type")
	private String document18Type;

	@Column(name="document18_url")
	private String document18Url;

		
			
	@JsonIgnore
	@Lob
	@Column(name="document19_type")
	private String document19Type;

	@Column(name="document19_url")
	private String document19Url;

		
	@JsonIgnore
	@Lob
	@Column(name="document20_type")
	private String document20Type;

	@Column(name="document20_url")
	private String document20Url;

	public int getDocumentId() {
		return documentId;
	}



	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}



	public String getDocumentUrl() {
		return documentUrl;
	}



	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}



	public String getDocument2Url() {
		return document2Url;
	}



	public void setDocument2Url(String document2Url) {
		this.document2Url = document2Url;
	}



	public String getDocument3Url() {
		return document3Url;
	}



	public void setDocument3Url(String document3Url) {
		this.document3Url = document3Url;
	}



	public String getDocument4Url() {
		return document4Url;
	}



	public void setDocument4Url(String document4Url) {
		this.document4Url = document4Url;
	}



	public String getDocument5Url() {
		return document5Url;
	}



	public void setDocument5Url(String document5Url) {
		this.document5Url = document5Url;
	}



	public String getDocument6Url() {
		return document6Url;
	}



	public void setDocument6Url(String document6Url) {
		this.document6Url = document6Url;
	}



	public String getDocument7Url() {
		return document7Url;
	}



	public void setDocument7Url(String document7Url) {
		this.document7Url = document7Url;
	}



	public String getDocument8Url() {
		return document8Url;
	}



	public void setDocument8Url(String document8Url) {
		this.document8Url = document8Url;
	}



	public String getDocument9Url() {
		return document9Url;
	}



	public void setDocument9Url(String document9Url) {
		this.document9Url = document9Url;
	}



	public String getDocument10Url() {
		return document10Url;
	}



	public void setDocument10Url(String document10Url) {
		this.document10Url = document10Url;
	}



	public String getDocument11Url() {
		return document11Url;
	}



	public void setDocument11Url(String document11Url) {
		this.document11Url = document11Url;
	}



	public String getDocument12Url() {
		return document12Url;
	}



	public void setDocument12Url(String document12Url) {
		this.document12Url = document12Url;
	}



	public String getDocument13Url() {
		return document13Url;
	}



	public void setDocument13Url(String document13Url) {
		this.document13Url = document13Url;
	}



	public String getDocument14Url() {
		return document14Url;
	}



	public void setDocument14Url(String document14Url) {
		this.document14Url = document14Url;
	}



	public String getDocument15Url() {
		return document15Url;
	}



	public void setDocument15Url(String document15Url) {
		this.document15Url = document15Url;
	}



	public String getDocument16Url() {
		return document16Url;
	}



	public void setDocument16Url(String document16Url) {
		this.document16Url = document16Url;
	}



	public String getDocument17Url() {
		return document17Url;
	}



	public void setDocument17Url(String document17Url) {
		this.document17Url = document17Url;
	}



	public String getDocument18Url() {
		return document18Url;
	}



	public void setDocument18Url(String document18Url) {
		this.document18Url = document18Url;
	}



	public String getDocument19Url() {
		return document19Url;
	}



	public void setDocument19Url(String document19Url) {
		this.document19Url = document19Url;
	}



	public String getDocument20Url() {
		return document20Url;
	}



	public void setDocument20Url(String document20Url) {
		this.document20Url = document20Url;
	}



	public void setDocument1Type(String document1Type) {
		this.document1Type = document1Type;
	}



	public void setDocument2Type(String document2Type) {
		this.document2Type = document2Type;
	}



	public void setDocument3Type(String document3Type) {
		this.document3Type = document3Type;
	}



	public void setDocument4Type(String document4Type) {
		this.document4Type = document4Type;
	}



	public void setDocument5Type(String document5Type) {
		this.document5Type = document5Type;
	}



	public void setDocument6Type(String document6Type) {
		this.document6Type = document6Type;
	}



	public void setDocument7Type(String document7Type) {
		this.document7Type = document7Type;
	}



	public void setDocument8Type(String document8Type) {
		this.document8Type = document8Type;
	}



	public void setDocument9Type(String document9Type) {
		this.document9Type = document9Type;
	}



	public void setDocument10Type(String document10Type) {
		this.document10Type = document10Type;
	}



	public void setDocument11Type(String document11Type) {
		this.document11Type = document11Type;
	}



	public void setDocument12Type(String document12Type) {
		this.document12Type = document12Type;
	}



	public void setDocument13Type(String document13Type) {
		this.document13Type = document13Type;
	}



	public void setDocument14Type(String document14Type) {
		this.document14Type = document14Type;
	}



	public void setDocument15Type(String document15Type) {
		this.document15Type = document15Type;
	}



	public void setDocument16Type(String document16Type) {
		this.document16Type = document16Type;
	}



	public void setDocument17Type(String document17Type) {
		this.document17Type = document17Type;
	}



	public void setDocument18Type(String document18Type) {
		this.document18Type = document18Type;
	}



	public void setDocument19Type(String document19Type) {
		this.document19Type = document19Type;
	}



	public void setDocument20Type(String document20Type) {
		this.document20Type = document20Type;
	}



	public String getDocument1Type() {
		return document1Type;
	}



	public String getDocument2Type() {
		return document2Type;
	}



	public String getDocument3Type() {
		return document3Type;
	}



	public String getDocument4Type() {
		return document4Type;
	}



	public String getDocument5Type() {
		return document5Type;
	}



	public String getDocument6Type() {
		return document6Type;
	}



	public String getDocument7Type() {
		return document7Type;
	}



	public String getDocument8Type() {
		return document8Type;
	}



	public String getDocument9Type() {
		return document9Type;
	}



	public String getDocument10Type() {
		return document10Type;
	}



	public String getDocument11Type() {
		return document11Type;
	}



	public String getDocument12Type() {
		return document12Type;
	}



	public String getDocument13Type() {
		return document13Type;
	}



	public String getDocument14Type() {
		return document14Type;
	}



	public String getDocument15Type() {
		return document15Type;
	}



	public String getDocument16Type() {
		return document16Type;
	}



	public String getDocument17Type() {
		return document17Type;
	}



	public String getDocument18Type() {
		return document18Type;
	}



	public String getDocument19Type() {
		return document19Type;
	}



	public String getDocument20Type() {
		return document20Type;
	}

		
			
		
	
	
	


}