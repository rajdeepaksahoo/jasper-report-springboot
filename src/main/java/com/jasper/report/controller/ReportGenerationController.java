package com.jasper.report.controller;

import com.jasper.report.reports.EmployeeReport;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@AllArgsConstructor
public class ReportGenerationController {
    private EmployeeReport report;
    @GetMapping
    public ResponseEntity<String> generateReport() throws JRException, SQLException {
        report.generateReport();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
