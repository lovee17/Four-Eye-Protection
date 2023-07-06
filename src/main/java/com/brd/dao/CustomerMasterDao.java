package com.brd.dao;

import com.brd.model.Customer;
import com.brd.model.CustomerMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public class CustomerMasterDao {


    @Autowired
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate hibernateTemplate) {
        this.template = hibernateTemplate;
    }



    @Transactional(readOnly = false)
    public void createCustomer(CustomerMaster customerMaster) {
        template.save(customerMaster);

    }


    @Transactional(readOnly = false)
    public CustomerMaster getById(String customerCode) {
        return template.get(CustomerMaster.class,customerCode);
    }


    public CustomerMaster dto(Customer customer){

        CustomerMaster customerMaster = new CustomerMaster();
        customerMaster.setCustomerCode(customer.getCustomerCode());
        customerMaster.setCustomerAddress1(customer.getCustomerAddress1());
        customerMaster.setCustomerAddress2(customer.getCustomerAddress2());
        customerMaster.setCustomerPinCode(customer.getCustomerPinCode());
        customerMaster.setCustomerName(customer.getCustomerName());
        customerMaster.setContactNumber(customer.getContactNumber());
        customerMaster.setCreateDate(customer.getCreateDate());
        customerMaster.setCreatedBy(customer.getCreatedBy());
        customerMaster.setModifiedDate(customer.getModifiedDate());
        customerMaster.setModifiedBy(customer.getModifiedBy());
        customerMaster.setFlag(customer.getFlag());
        customerMaster.setRecordStatus(customer.getRecordStatus());
        customerMaster.setPrimaryContactPerson(customer.getPrimaryContactPerson());
        customerMaster.setEmailAddress(customer.getEmailAddress());

        return customerMaster;
    }



    @Transactional(readOnly = false)
    public List<CustomerMaster> getAllCustomer() {
        return template.loadAll(CustomerMaster.class);
    }

    @Transactional(readOnly = false)
    public String loadCustomer(String code){
        CustomerMaster s = template.get(CustomerMaster.class, code);
        if(s==null){
            return "";
        }
        return s.toString();
    }


    @Transactional(readOnly = false)
    public void modify(CustomerMaster customerMaster) {
        template.merge(customerMaster);
    }


    @Transactional(readOnly = false)
    public void deleteCustomer(String customerCode) {
        CustomerMaster customerMaster =template.get(CustomerMaster.class,customerCode);
        assert customerMaster != null;
        template.delete(customerMaster);
    }

}
