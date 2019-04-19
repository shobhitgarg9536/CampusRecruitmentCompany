package com.shobhit.campusrecruitment_company;

public class NewJobPostingModel {

    public NewJobPostingModel(String companyId, String contactPerson, String vacancyName, String postName, String noOfVacancy, String dateOfInterview) {
        CompanyId = companyId;
        ContactPerson = contactPerson;
        VacancyName = vacancyName;
        PostName = postName;
        NoOfVacancy = noOfVacancy;
        DateOfInterview = dateOfInterview;
    }

    public String getContactPerson() {
        return ContactPerson;
    }

    public void setContactPerson(String contactPerson) {
        ContactPerson = contactPerson;
    }

    public String getVacancyName() {
        return VacancyName;
    }

    public void setVacancyName(String vacancyName) {
        VacancyName = vacancyName;
    }

    public String getPostName() {
        return PostName;
    }

    public void setPostName(String postName) {
        PostName = postName;
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
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }

    private String CompanyId, ContactPerson, VacancyName, PostName, NoOfVacancy, DateOfInterview;
}
