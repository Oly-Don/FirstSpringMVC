/**
  * Copyright 2018 bejson.com 
  */
package com.oly.hc.mock.insurance.pojo.send;

import com.oly.hc.mock.insurance.pojo.send.sub.PersonInfo;

import java.util.List;

/**
 * Auto-generated: 2018-06-11 17:30:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class OrderInfo {

    private String InsProductNo;
    private String PrintNo;
    //yyyy-MM-dd
    private String FlightDate;
    private String FlightNumber;
    private List<com.oly.hc.mock.insurance.pojo.send.sub.PersonInfo> PersonInfo;
    private String SerialNo;
    private String SignDataMd;
    public void setInsProductNo(String InsProductNo) {
         this.InsProductNo = InsProductNo;
     }
     public String getInsProductNo() {
         return InsProductNo;
     }

    public void setPrintNo(String PrintNo) {
         this.PrintNo = PrintNo;
     }
     public String getPrintNo() {
         return PrintNo;
     }

    public void setFlightDate(String FlightDate) {
         this.FlightDate = FlightDate;
     }
     public String getFlightDate() {
         return FlightDate;
     }

    public void setFlightNumber(String FlightNumber) {
         this.FlightNumber = FlightNumber;
     }
     public String getFlightNumber() {
         return FlightNumber;
     }

    public void setPersonInfo(List<PersonInfo> PersonInfo) {
        this.PersonInfo = PersonInfo;
    }
    public List<PersonInfo> getPersonInfo() {
        return PersonInfo;
    }

    public void setSerialNo(String SerialNo) {
         this.SerialNo = SerialNo;
     }
     public String getSerialNo() {
         return SerialNo;
     }

    public void setSignDataMd(String SignDataMd) {
         this.SignDataMd = SignDataMd;
     }
     public String getSignDataMd() {
         return SignDataMd;
     }

}