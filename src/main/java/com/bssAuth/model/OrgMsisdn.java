package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the org_msisdns database table.
 * 
 */
@Entity
@Table(name="org_msisdns")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrgMsisdn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name="create_date")	
	private Date createDate;

	@Column(name="is_admin")
	private String isAdmin;

	private String msisdn;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name="update_date")	
	private Date updateDate;

	//bi-directional many-to-one association to Organisation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="org_id")
	private Organisation organisation;

	public OrgMsisdn() {
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

	public String getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	@Override
	public String toString() {
		return "OrgMsisdn [id=" + id + ", createDate=" + createDate + ", isAdmin=" + isAdmin + ", msisdn=" + msisdn
				+ ", updateDate=" + updateDate + ", organisation=" + organisation + "]";
	}

}