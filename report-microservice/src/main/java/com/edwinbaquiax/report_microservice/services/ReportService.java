package com.edwinbaquiax.report_microservice.services;

import com.edwinbaquiax.report_microservice.helpers.ReportHelper;
import com.edwinbaquiax.report_microservice.repositories.ICompaniesRepository;
import com.netflix.discovery.EurekaClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ReportService implements IReportService {

    private final ICompaniesRepository companiesRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(String companyName) {
        reportHelper.readTemplate();
        var company = this.companiesRepository.getByName(companyName)
                .orElseThrow(() -> new RuntimeException("No companies found with name: " + companyName));
        return company.getName();
    }

    @Override
    public String saveReport(String nameReport) {
        return "";
    }

    @Override
    public void deleteReport(String name) {

    }
}
