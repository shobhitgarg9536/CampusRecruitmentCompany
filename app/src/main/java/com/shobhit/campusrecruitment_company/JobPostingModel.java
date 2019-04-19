package com.shobhit.campusrecruitment_company;

public class JobPostingModel {

    public JobPostingModel(){}

    public JobPostingModel(String companyId, String companyName, String vacancyName, String noOfVacancy, String dateOfInterview) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.vacancyName = vacancyName;
        NoOfVacancy = noOfVacancy;
        DateOfInterview = dateOfInterview;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public String getNoOfVacancy() {
        return NoOfVacancy;
    }

    public void setNoOfVacancy(String noOfVacancy) {
        NoOfVacancy = noOfVacancy;
    }

    public String getDateOfInterview() {
        return DateOfInterview;
    }

    public void setDateOfInterview(String dateOfInterview) {
        DateOfInterview = dateOfInterview;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    private String companyId, companyName, vacancyName, NoOfVacancy, DateOfInterview;
}
