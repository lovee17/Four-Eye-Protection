package com.brd.service;

import validationPkg.ValidationFunction;

import java.util.ArrayList;
import java.util.List;

public class Validations {


    Validations(){}

    public static boolean validFileTxt(String fileName){
        return (fileName.endsWith(".txt"));
    }



    public static boolean isValidCustomer(String[] customerData){

        if(customerData.length!=16) {

            return false;
        }

        return validCustomerCode(customerData[0]) && validCustomerName(customerData[1]) &&  validAddress1(customerData[2]) && validPinCode(customerData[4]) && validEmail(customerData[5]) && validRecordStatus(customerData[8]) && validActiveInactiveFlag(customerData[9])  ;

    }



    public static boolean validCustomerCode(String code){
        if(code==null || code.length()==0 ||code.length()>10) {

            return false;
        }

        else {

            return isAlphaNumeric(code);
        }
    }

    public static boolean validCustomerName(String name){
        if(name==null || name.length()==0 ||name.length()>30) {

            return false;
        }

        else {

            return isAlphaNumeric(name);
        }
    }


    public static boolean validAddress1(String address1){
        if(address1==null || address1.trim().length()==0 || address1.length()>100) {

            return false;
        }

        else {

            return isAlphaNumeric(address1);
        }
    }

    public static boolean validAddress2(String address2){

        return address2.length() <= 100;

    }

    public static boolean validPinCode(String pincode){

        if(pincode.length()!=6 || pincode.charAt(0)=='0')  {

            return false;
        }

    return pincode.trim().length() == 6;
    }


    public static  boolean validEmail(String email){

        if (email==null || email.equals("") ||email.length()>100) {

            return false;
        }

        return email.matches("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");

    }

    public static boolean validContactNumber(String contactNumber){

        if( contactNumber == null || contactNumber.equals("")) {

            return true;
        }

        if(contactNumber.length() != 10) {

            return false;
        }

        else {

            return contactNumber.matches("[6-9]\\d{9}");
        }

    }

    public static boolean validPrimaryContactPerson(String primaryContactPerson){

        if(primaryContactPerson==null || primaryContactPerson.length()>100 || primaryContactPerson.equals("")) {

            return false;
        }

        else {

            return isAlphaNumeric(primaryContactPerson);
        }
    }

    public static boolean validRecordStatus(String recordStatus){

        ValidationFunction validationFunction = new ValidationFunction();

        List<String> li = new ArrayList<>();
        li.add("N");
        li.add("M");
        li.add("D");
        li.add("A");
        li.add("R");
        li.add("NR");
        li.add("MR");

        if(recordStatus==null || recordStatus.length()>1 || recordStatus.equals("")) {

            return false;
        }


        return (validationFunction.domainValueValidation(recordStatus, li));

    }


    public static boolean validActiveInactiveFlag(String activeInactiveFlag){
        List<String> li = new ArrayList<>();
        li.add("Active");
        li.add("Inactive");
        ValidationFunction validationFunction = new ValidationFunction();

        if(activeInactiveFlag==null || activeInactiveFlag.length()>1 || activeInactiveFlag.equals("")) {

            return false;
        }

        return (validationFunction.domainValueValidation(activeInactiveFlag, li));

    }


    public static boolean validDate(String dateString){
        //19/AUG/2022

        if(dateString==null) {

            return false;
        }

        String[] tokens = dateString.split("/");
        boolean date = tokens[0].matches("([0-2]\\d||3[0-1])");
        boolean month = tokens[1].matches("Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec");
        boolean year = tokens[2].matches("[1|2][0|9]\\d\\d");
        return date && month && year;
    }



    public static boolean validCreateDate(String createDate){

        return validDate(createDate);
    }


    public static boolean validCreatedBy(String createdBy){
        if(createdBy==null) return false;
        if(createdBy.equals("")) return true;
        return isAlphaNumeric(createdBy);
    }

    public static boolean validModifiedDate(String modifiedDate){
        if( modifiedDate == null || modifiedDate.equals("") ) return true;
        return validDate(modifiedDate);
    }


    public static boolean validModifiedBy(String modifiedBy){
        if(modifiedBy==null || modifiedBy.equals("")) {

            return true;
        }

        return isAlphaNumeric(modifiedBy);
    }

    public static boolean validAuthorizedDate(String authorizedDate){
        if(authorizedDate==null || authorizedDate.equals("")) {

            return true;
        }

        return validDate(authorizedDate);
    }


    public static boolean validAuthorizedBy(String authorizedBy){

        if(authorizedBy==null || authorizedBy.equals("")) {

            return false;
        }

        return isAlphaNumeric(authorizedBy);
    }

    private static boolean isAlphaNumeric(String s) {

        return s.matches("[a-z A-Z0-9]+");
    }


}
