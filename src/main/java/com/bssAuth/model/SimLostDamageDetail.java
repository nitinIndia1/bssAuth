package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the sim_lost_damage_detail database table.
 * 
 */
@Entity
@Table(name="sim_lost_damage_detail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SimLostDamageDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 664490758370890269L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="case_")
	private String case_;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="create_date")	
	private Date createDate;

	private String msisdn;

	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="update_date")	
	private Date updateDate;

	//bi-directional many-to-one association to Document
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doc_id")
	private Document document;

	//bi-directional many-to-one association to Image
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="img_id")
	private Image image;

	public SimLostDamageDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCase_() {
		return this.case_;
	}

	public void setCase_(String case_) {
		this.case_ = case_;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}