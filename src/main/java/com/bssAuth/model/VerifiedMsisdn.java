package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the verified_msisdn database table.
 * 
 */
@Entity
@Table(name="verified_msisdn")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VerifiedMsisdn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="create_date")	
	private Date createDate;

	@Column(name="msisdn")	
	private String msisdn;

	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="update_date")	
	private Date updateDate;

	//bi-directional many-to-one association to SimDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sim_detail_id")
	private SimDetail simDetail;

	public VerifiedMsisdn() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public SimDetail getSimDetail() {
		return this.simDetail;
	}

	public void setSimDetail(SimDetail simDetail) {
		this.simDetail = simDetail;
	}

}