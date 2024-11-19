package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the customer_details database table.
 * 
 */
@Entity
@Table(name="employee_organisation_msisdn")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeOrganisationMsisdn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	public EmployeeOrganisationMsisdn() {}


	public EmployeeOrganisationMsisdn(int id, Employee employee, Organisation organisation, String msisdn,
			String status, Date createDate, Date updateDate) {
		this.id = id;
		this.employee = employee;
		this.organisation = organisation;
		this.msisdn = msisdn;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_id")
	private Employee employee;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="org_id")
	private Organisation organisation;

	
	private String msisdn;
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="create_date")	
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="update_date")
	private Date updateDate;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Organisation getOrganisation() {
		return organisation;
	}


	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}


	public String getMsisdn() {
		return msisdn;
	}


	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Override
	public String toString() {
		return "EmployeeOrganisationMsisdn [id=" + id + ", employee=" + employee + ", organisation=" + organisation
				+ ", msisdn=" + msisdn + ", status=" + status + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}



	
	

}