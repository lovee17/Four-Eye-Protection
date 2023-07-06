package com.brd.controller;

import com.brd.dao.CustomerDao;
import com.brd.dao.CustomerMasterDao;
import com.brd.model.Customer;
import com.brd.model.CustomerMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/checkerHome")
public class CheckerController {


    @Autowired
    CustomerDao customerDao;

    @Autowired
    CustomerMasterDao customerMasterDao;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/checker")
    public ModelAndView checker(){
        List<Customer> customers;
        customers = customerDao.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("checkerview");
        modelAndView.addObject("customerList", customers);
        return modelAndView ;
    }


    @RequestMapping("/approve")
    public ModelAndView approve(@RequestParam("code") String code , @RequestParam(value = "status", required = false) String status ) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username ;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }


        Customer customer;
        CustomerMaster customerMaster;


        if(status.equals("N")) {
            customer = customerDao.getById(code);
            customer.setRecordStatus("A");
            customer.setFlag("Inactive");
            customer.setAuthorizedBy(username);
            customer.setAuthorizedDate(new Date());
            customerMaster = customerMasterDao.dto(customer);
            customerMasterDao.createCustomer(customerMaster);
            customerDao.deleteCustomer(code);
        }

        else if(status.equals("D")){
            customerDao.deleteCustomer(code);
            customerMasterDao.deleteCustomer(code);
        }

        else{
            customer = customerDao.getById(code);
            customer.setRecordStatus("A");
            customer.setFlag("Inactive");
            customer.setAuthorizedBy(username);
            customer.setAuthorizedDate(new Date());
            customerMaster = customerMasterDao.dto(customer);
            customerMasterDao.modify(customerMaster);
            customerDao.deleteCustomer(code);

        }


        List<Customer> customerTemps;
        customerTemps = customerDao.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("checkerview");
        modelAndView.addObject("customerList", customerTemps);
        return modelAndView;
    }


    @RequestMapping("/reject")
    public ModelAndView reject(@RequestParam("code") String code , @RequestParam(value = "status", required = false) String status) {


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username ;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }


        Customer customer;

        if(status.equals("N")) {
            customer = customerDao.getById(code);
            customer.setRecordStatus("NR");
            customerDao.add(customer);
        }


        else if(status.equals("D")) {
            customer = customerDao.getById(code);
            customer.setRecordStatus("DR");
            customerDao.add(customer);
        }

        else{

            customer = customerDao.getById(code);
            customer.setRecordStatus("MR");
            customerDao.add(customer);
        }

        List<Customer> customerTemps;
        customerTemps = customerDao.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("checkerview");
        modelAndView.addObject("customerList", customerTemps);
        return modelAndView;
    }

}
