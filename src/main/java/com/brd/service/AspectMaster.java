package com.brd.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;


@Aspect
@Service
public class AspectMaster {


    Logger logger = LogManager.getLogger(AspectMaster.class);

    @After("execution(* com.brd.dao.CustomerMasterDao.createCustomer(..))")
    public void createCustomer(JoinPoint joinPoint) {
        logger.info("Customer inserted in Master");
    }

    @After("execution(* com.brd.dao.CustomerMasterDao.deleteCustomer(..))")
    public void deleteCustomer(JoinPoint joinPoint) {
        logger.info("Customer deleted from Master");
    }

    @AfterReturning("execution(* com.brd.dao.CustomerMasterDao.getById(..))")
    public void getCustomerById(JoinPoint joinPoint) {
        logger.info("Customer found in Master");
    }


}
