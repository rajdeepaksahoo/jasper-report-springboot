package com.jasper.report.reports;

import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmployeeReport {
    private DataSource dataSource;
    public void generateReport() throws SQLException, JRException {
        Map<String, Object> parameters = new HashMap<>();
        // Add parameters if your query needs them
        parameters.put("paramName", "abc");
        String jasperPath ="/Users/rajdeepaksahoo/IdeaProjects/Spring Boot/Jasper Reports/Jasper-Report 1/src/main/resources/employee.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperPath);
        // Assuming you have a dataSource bean configured for your DB
        Connection conn = dataSource.getConnection();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/rajdeepaksahoo/IdeaProjects/Spring Boot/Jasper Reports/Jasper-Report 1/src/main/resources/employee.pdf");
    }
}
