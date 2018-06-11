package com.oly.hc.mock.insurance.pojo;

import org.springframework.context.annotation.Bean;

/**
 * usege:
 * Created by oly on 2018/6/11.
 */
public class OrderResultInfo {

        private int ResultId;
        private String PolicyNo;
        private String ResultErrDesc;
        private String PrintNo;
        private String ApplyNo;
        private String DownUrl;
        public void setResultId(int ResultId) {
            this.ResultId = ResultId;
        }
        public int getResultId() {
            return ResultId;
        }

        public void setPolicyNo(String PolicyNo) {
            this.PolicyNo = PolicyNo;
        }
        public String getPolicyNo() {
            return PolicyNo;
        }

        public void setResultErrDesc(String ResultErrDesc) {
            this.ResultErrDesc = ResultErrDesc;
        }
        public String getResultErrDesc() {
            return ResultErrDesc;
        }

        public void setPrintNo(String PrintNo) {
            this.PrintNo = PrintNo;
        }
        public String getPrintNo() {
            return PrintNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }
        public String getApplyNo() {
            return ApplyNo;
        }

        public void setDownUrl(String DownUrl) {
            this.DownUrl = DownUrl;
        }
        public String getDownUrl() {
            return DownUrl;
        }

}
