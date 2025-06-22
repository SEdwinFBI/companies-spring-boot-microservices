package com.edwinbaquiax.report_microservice.services;

public interface IReportService {

    String makeReport(String companyName);
    String saveReport(String nameReport);
    void deleteReport(String name);


}
