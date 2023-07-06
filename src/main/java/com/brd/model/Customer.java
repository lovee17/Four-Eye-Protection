package com.brd.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "customerLove170601")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 5343446405778012637L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerID;

	@Id
	@Column(name = "Customer_code")
	private String customerCode;


	@NotEmpty
	@Column(length=30)
	@Size(min=3,max=30)
	private String customerName;


	@NotEmpty
	@Size(min=3,max=100)
	@Column(length=100)
	private String customerAddress1;


	@Column(length=100)
	private String customerAddress2;



	@NotEmpty
	@Size(min=6,max=6)
	@Column(length=6)
	@Pattern(regexp="(^$|[0-9]{6})")
	private String customerPinCode;

	@NotEmpty
	@Email
	private String emailAddress;


	@NotEmpty
	@Size(min=10,max=10)
	@Column(length=10)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String contactNumber;


	@Column(length = 100)
	private String primaryContactPerson;


	private String recordStatus;


	private String flag;


	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column(length = 30)
	private  String createdBy;

	@Temporal(TemporalType.DATE)
	private Date modifiedDate;

	@Column(length = 30)
	private  String modifiedBy;

	@Temporal(TemporalType.DATE)
	private Date authorizedDate;

	@Column(length = 30)
	private  String authorizedBy;


	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress1() {
		return customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public String getCustomerAddress2() {
		return customerAddress2;
	}

	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	public String getCustomerPinCode() {
		return customerPinCode;
	}

	public void setCustomerPinCode(String customerPinCode) {
		this.customerPinCode = customerPinCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPrimaryContactPerson() {
		return primaryContactPerson;
	}

	public void setPrimaryContactPerson(String primaryContactPerson) {
		this.primaryContactPerson = primaryContactPerson;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getAuthorizedDate() {
		return authorizedDate;
	}

	public void setAuthorizedDate(Date authorizedDate) {
		this.authorizedDate = authorizedDate;
	}

	public String getAuthorizedBy() {
		return authorizedBy;
	}

	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	public Customer(){}
	public Customer(String customerCode, String customerName, String customerAddress1, String customerAddress2, String customerPinCode, String emailAddress, String primaryContactPerson, String recordStatus, String flag, Date createDate, String createdBy) {
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.customerAddress1 = customerAddress1;
		this.customerAddress2 = customerAddress2;
		this.customerPinCode = customerPinCode;
		this.emailAddress = emailAddress;
		this.primaryContactPerson = primaryContactPerson;
		this.recordStatus = recordStatus;
		this.flag = flag;
		this.createDate = createDate;
		this.createdBy = createdBy;
	}


	@Override
	public String toString() {
		return "Customer{" +
				"customerID=" + customerID +
				", customerCode='" + customerCode + '\'' +
				", customerName='" + customerName + '\'' +
				", customerAddress1='" + customerAddress1 + '\'' +
				", customerAddress2='" + customerAddress2 + '\'' +
				", customerPinCode='" + customerPinCode + '\'' +
				", emailAddress='" + emailAddress + '\'' +
				", contactNumber=" + contactNumber +
				", primaryContactPerson='" + primaryContactPerson + '\'' +
				", recordStatus=" + recordStatus +
				", flag=" + flag +
				", createDate=" + createDate +
				", createdBy='" + createdBy + '\'' +
				", modifiedDate=" + modifiedDate +
				", modifiedBy='" + modifiedBy + '\'' +
				", authorizedDate=" + authorizedDate +
				", authorizedBy='" + authorizedBy + '\'' +
				'}';

	}

}
