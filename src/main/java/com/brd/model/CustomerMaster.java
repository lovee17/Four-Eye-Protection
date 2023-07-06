package com.brd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "customerMasterLove170601")
public class CustomerMaster implements Serializable {

	private static final long serialVersionUID = 5343446409978012637L;


	private int customerID;

	@Id
	private String customerCode;


	private String customerName;


	private String customerAddress1;


	private String customerAddress2;


	private String customerPinCode;


	private String emailAddress;


	private String contactNumber;


	private String primaryContactPerson;

	private String recordStatus;

	private String flag;

	private Date createDate;

	private  String createdBy;

	private Date modifiedDate;


	private  String modifiedBy;


	private Date authorizedDate;


	private  String authorizedBy;


	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
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

	public void setRecordStatus(String  recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String  getFlag() {
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

	public CustomerMaster(){}
	public CustomerMaster(String customerCode, String customerName, String customerAddress1, String customerAddress2, String customerPinCode, String emailAddress, String primaryContactPerson, String recordStatus, String flag, Date createDate, String createdBy) {
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
