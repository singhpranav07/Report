# Reporting Using Jasperreports Library

A sample application to fetch jasper report content in pdf format.

## Template for report
Emplyoee_Details.jrxml -- src/main/webapp/WEB-INF/jasperreports/

## DTO
- Employee
- EmployeeBeanList
- ReportDataSource: Data source to fill the report.

## Controller
BaseController -- Controller to get the report.

## Deployment
Deploy the war file present under /target.
### Server Used -- Tomcat

## Test URL
http://localhost:8080/Report/EmployeeDetails/

## Output
Sample report in pdf format
