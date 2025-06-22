package com.edwinbaquiax.report_microservice.controllers;

import com.edwinbaquiax.report_microservice.services.IReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "report")
@AllArgsConstructor
public class ReportController {

    private final IReportService reportService;

    @GetMapping(path = "{name}")
    public ResponseEntity<Map<String,String>> getReport(@PathVariable String name) {
        var response = Map.of("Report",this.reportService.makeReport(name));

        return ResponseEntity.ok(response);
    }
}
