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
public class AspectTemporary {

    private static final Logger logger = LogManager.getLogger(AspectTemporary.class);

    @After("execution(* com.brd.dao.CustomerDao.*(..))")
    public void createCustomer(JoinPoint joinPoint) {
        if(joinPoint.getSignature().getName().contains("create"))
        logger.info("Customer inserted in Temporary Table");

    }

    @After("execution(* com.brd.dao.CustomerDao.modify(..))")
    public void updateCustomer(JoinPoint joinPoint) {
        logger.info("Customer updated in Temporary Table");
    }


    @After("execution(* com.brd.dao.CustomerDao.add(..))")
    public void updateCustomer1(JoinPoint joinPoint) {
        logger.info("Customer updated in Temporary Table");
    }


    @After("execution(* com.brd.dao.CustomerDao.modifyNR(..))")
    public void updateCustomer2(JoinPoint joinPoint) {
        logger.info("Customer updated in Temporary Table");
    }

    @After("execution(* com.brd.dao.CustomerDao.deleteCustomer(..))")
    public void deleteCustomer(JoinPoint joinPoint) {
        logger.info("Customer deleted from Temporary Table");
    }

    @AfterReturning("execution(* com.brd.dao.CustomerDao.getById(..))")
    public void getCustomerById(JoinPoint joinPoint) {
        logger.info("Customer found in Temporary Table");
    }

}

