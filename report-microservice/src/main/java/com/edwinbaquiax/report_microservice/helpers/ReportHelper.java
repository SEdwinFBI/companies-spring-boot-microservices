package com.edwinbaquiax.report_microservice.helpers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReportHelper {

    @Value("${report.template}")
    private String template;

    public String readTemplate(){
        System.out.println(template);
        return template;
    }
}
