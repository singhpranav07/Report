# Report

This is example to generate PDF report from jasper jrxml template.

Emplyoee_Details.jrxml : template for report
dto --> Employee, EmployeeBeanList, ReportDataSource: Data ffor fill up the report, we can take data from Database as well
BaseController  --> Controller having end point to fetch the pdf

Deploy the .war file in target to tomact. 
To see the report, see the follwing URL, pdf will get downloaded

http://localhost:8080/Report/EmployeeDetails/
