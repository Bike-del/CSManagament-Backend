package com.Sachin.CustomerManagement.Controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRJpaDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/report")
public class ReportController {

        @Autowired
        private DataSource dataSource;

        @GetMapping("/{customerId}")
        public ResponseEntity<?> generateReport(@PathVariable Integer customerId) throws IOException, JRException, SQLException {

            var inputStream =  new ClassPathResource("reports/customerorder.jrxml").getInputStream();

           JasperReport jasperReport =  JasperCompileManager.compileReport(inputStream);

//            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);

            Map<String,Object> parameters = new HashMap<>();
            parameters.put("customerId",customerId);

            Connection connection = dataSource.getConnection();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

            connection.close();

            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=customer_report.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(bytes);


        }



}
