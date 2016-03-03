# Report

This is example to generate PDF report from jasper jrxml template.

Emplyoee_Details.jrxml : template for report
dto --> Employee, EmployeeBeanList, ReportDataSource: Data for fill up the report, we can take data from Database as well
BaseController  --> Controller having end point to fetch the pdf

Deploy the war file from target to tomcat Webapp folder.
To see the report, see the following URL, pdf will get downloaded

http://localhost:8080/Report/EmployeeDetails/
