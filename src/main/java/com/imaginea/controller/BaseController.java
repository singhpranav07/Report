package com.imaginea.controller;

import com.imaginea.dto.ReportDataSource;
import net.sf.jasperreports.engine.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


/**
 * Created by pranavs on 3/2/2016.
 */
@Controller
public class BaseController {
    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

    /*
      This is just for the testing purpose
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome");
        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

    /*
      This is just for the testing purpose
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Welcome " + name);
        return VIEW_INDEX;

    }

    /*
       Method to fetch jasper report content in pdf format.
     */
    @RequestMapping(value = "/EmployeeDetails/", method = RequestMethod.GET)
    public String EmployeeDetails( ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        model.addAttribute("message", "Report Generation request ");
        try {
            /*
               Jasper report template i.e jrxml is compiled to jasper.
               Report is filled by JasperFillManager by passing Data Source.
             */

            String path = request.getSession().getServletContext().getRealPath("\\WEB-INF\\jasperreports\\Employee_Details.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(path);

            ReportDataSource reportDataSource = new ReportDataSource();
            // JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), new JREmptyDataSource());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), reportDataSource.getDateSource());
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;filename=Employee.pdf");
            response.getOutputStream().write(pdfBytes);

            response.getOutputStream().flush();
            response.getOutputStream().close();
            response.flushBuffer();

        } catch (JRException ex) {
            logger.error(ex.getMessage(), ex.getCause());
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex.getCause());
        }
        return VIEW_INDEX;
    }

}
