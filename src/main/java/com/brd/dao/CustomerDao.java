package com.brd.dao;

import com.brd.model.Customer;
import com.brd.model.CustomerMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomerDao {


    @Autowired
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate hibernateTemplate) {
        this.template = hibernateTemplate;
    }


    @Transactional(readOnly = false)
    public void createCustomer(Customer customer) {
            template.save(customer);

    }


    @Transactional(readOnly = false)
    public void deleteCustomer(String customerCode) {
        Customer customer =template.get(Customer.class,customerCode);
        assert customer != null;
        template.delete(customer);
    }

    @Transactional(readOnly = false)
    public Customer getById(String customerCode) {
        return template.get(Customer.class,customerCode);
    }


    @Transactional(readOnly = false)
    public List<Customer> getAllCustomer() {
        return template.loadAll(Customer.class);
    }


    @Transactional(readOnly = false)
    public void modify(Customer customer) {
        customer.setRecordStatus("M");
        template.merge(customer);

    }


    @Transactional(readOnly = false)
    public void add(Customer customer) {
        template.merge(customer);
    }


    @Transactional(readOnly = false)
    public void modifyNR(Customer customer) {
        customer.setRecordStatus("N");
        template.merge(customer);
    }



    public Customer dto(CustomerMaster customerMaster){

        Customer customer = new Customer();
        customer.setCustomerCode(customerMaster.getCustomerCode());
        customer.setCustomerAddress1(customerMaster.getCustomerAddress1());
        customer.setCustomerAddress2(customerMaster.getCustomerAddress2());
        customer.setCustomerPinCode(customerMaster.getCustomerPinCode());
        customer.setCustomerName(customerMaster.getCustomerName());
        customer.setContactNumber(customerMaster.getContactNumber());
        customer.setCreateDate(customerMaster.getCreateDate());
        customer.setCreatedBy(customerMaster.getCreatedBy());
        customer.setModifiedDate(customerMaster.getModifiedDate());
        customer.setModifiedBy(customerMaster.getModifiedBy());
        customer.setFlag(customerMaster.getFlag());
        customer.setRecordStatus(customerMaster.getRecordStatus());
        customer.setPrimaryContactPerson(customerMaster.getPrimaryContactPerson());
        customer.setEmailAddress(customerMaster.getEmailAddress());

        return customer;
    }

}