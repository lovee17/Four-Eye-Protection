package com.brd.controller;

import com.brd.dao.CustomerDao;
import com.brd.dao.CustomerMasterDao;
import com.brd.model.Customer;
import com.brd.model.CustomerMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/makerHome")
public class MakerController {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    CustomerMasterDao customerMasterDao;



    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());

        return "customerform";
    }


    @RequestMapping("/formsubmit")
    public ModelAndView processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {


        try{
            if (theBindingResult.hasErrors()) {

                return new ModelAndView("customerform");
            }

            else if(!customerMasterDao.loadCustomer(theCustomer.getCustomerCode()).isEmpty()){
                return new ModelAndView("error","custID",theCustomer.getCustomerCode());

            }
            else {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String username ;
                if (principal instanceof UserDetails) {
                     username = ((UserDetails)principal).getUsername();
                } else {
                     username = principal.toString();
                }

                theCustomer.setCreateDate(new Date());
                theCustomer.setCreatedBy(username);
                theCustomer.setRecordStatus("N");
                customerDao.createCustomer(theCustomer);
                ModelAndView modelAndView = new ModelAndView("display");
                modelAndView.addObject("customer", theCustomer);
                return modelAndView;
            }

        }
        catch (DataIntegrityViolationException e){
            return new ModelAndView("error","custID",theCustomer.getCustomerCode());
        }
    }


    @RequestMapping("/saveForm")
    public ModelAndView saveForm() {
        List<Customer> customers;
        List<CustomerMaster> customerMasters;
        customers = customerDao.getAllCustomer();
        customerMasters = customerMasterDao.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("makerview");
        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("customerMasterList", customerMasters);
        return modelAndView;
    }


    @RequestMapping("/doNotSaveForm")
    private ModelAndView doNotSaveForm(@RequestParam("code") String code) {
        customerDao.deleteCustomer(code);
        ModelAndView modelAndView = new ModelAndView("customerform");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }


    @RequestMapping("/maker")
    public ModelAndView viewData() {

        List<Customer> customers;
        List<CustomerMaster> customerMasters;
        customers = customerDao.getAllCustomer();
        customerMasters = customerMasterDao.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("makerview");
        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("customerMasterList", customerMasters);
        return modelAndView;
    }


    @RequestMapping("/linkview")
    public ModelAndView viewLink(@RequestParam("code") String code, @RequestParam(value = "status", required = false) String status) {

        Customer customer;
        if (status.equals("N") || status.equals("M") || status.equals("D") || status.equals("NR") || status.equals("MR") || status.equals("DR")) {
            customer = customerDao.getById(code);
        } else {

            CustomerMaster customerMaster = customerMasterDao.getById(code);
            customer = customerDao.dto(customerMaster);
        }

        ModelAndView modelAndView = new ModelAndView("customerFullView");
        modelAndView.addObject("item", customer);
        return modelAndView;
    }


    @RequestMapping("/delete")
    public ModelAndView approve(@RequestParam("code") String code, @RequestParam(value = "status", required = false) String status) {


        List<Customer> customers;
        List<CustomerMaster> customerMasters;
        Customer customer;
        CustomerMaster customerMaster;


        if (status.equals("N") || status.equals("M") || status.equals("D") || status.equals("NR") || status.equals("MR")) {
            customerDao.deleteCustomer(code);

        } else {
            customerMaster = customerMasterDao.getById(code);
            customer = customerDao.dto(customerMaster);
            customer.setRecordStatus("D");
            customerDao.createCustomer(customer);
        }


        customers = customerDao.getAllCustomer();
        customerMasters = customerMasterDao.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("makerview");
        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("customerMasterList", customerMasters);
        return modelAndView;

    }

    @RequestMapping("/modify")
    public String modify(@RequestParam("code") String code, @RequestParam(value = "status", required = false) String status, Model model) {
        model.addAttribute("userCode", code);

        Customer customer;
        if (status.equals("N") || status.equals("M") || status.equals("NR")) {
            customer = customerDao.getById(code);

        } else {

            CustomerMaster customerMaster = customerMasterDao.getById(code);
            customer = customerDao.dto(customerMaster);
            customer.setRecordStatus("M");
        }

        model.addAttribute("customer12", customer);
        return "modifyCustomer";
    }


    @RequestMapping("/modifyForm")
    public ModelAndView modifyForm(@Valid @ModelAttribute("customer12") Customer customer1, BindingResult bindingResult) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username ;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        customer1.setModifiedDate(new Date());
        customer1.setModifiedBy(username);
        if (customer1.getRecordStatus().equals("NR")) {
            customerDao.modifyNR(customer1);
        } else if (customer1.getRecordStatus().equals("MR")) {
            customerDao.modify(customer1);

        } else if (customer1.getRecordStatus().equals("N")) {
            customerDao.add(customer1);

        } else {

            customerDao.modify(customer1);
        }

        List<Customer> customers;
        List<CustomerMaster> customerMasters;
        customers = customerDao.getAllCustomer();
        customerMasters = customerMasterDao.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("makerview");
        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("customerMasterList", customerMasters);
        return modelAndView;
    }

}