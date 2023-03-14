package Demo.ReflectDemo;

import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;

public class Case {
    public String CaseId;
    public String  ApiId;
    public String Desc;
    public String Params;
    public String ExpectedResponseData;
    public String ActualResponseData;

    public String getExpectedResponseData() {
        return ExpectedResponseData;
    }

    public void setExpectedResponseData(String expectedResponseData) {
        ExpectedResponseData = expectedResponseData;
    }

    public String getActualResponseData() {
        return ActualResponseData;
    }

    public void setActualResponseData(String actualResponseData) {
        ActualResponseData = actualResponseData;
    }

    public String getCaseId() {
        return CaseId;
    }

    public void setCaseId(String caseId) {
        CaseId = caseId;
    }

    public String getApiId() {
        return ApiId;
    }

    public void setApiId(String apiId) {
        ApiId = apiId;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String params) {
        Params = params;
    }
   @Override
   public String toString(){
        return "CaseId="+CaseId+",ApiId="+ApiId+",Desc="+Desc+",Params="+Params+"ExpectedResponseData="+ExpectedResponseData+"ActualResponseData="+ActualResponseData;
   }

}
