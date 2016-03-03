package com.imaginea.dto;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;

/**
 * Created by pranavs on 3/3/2016.
 */
public class ReportDataSource {

    public JRDataSource getDateSource() {

        EmployeeBeanList employeeBeanList = new EmployeeBeanList();
        ArrayList<Employee> dataList = employeeBeanList.getEmployeeBeanList();

        JRDataSource dataSource =
                new JRBeanCollectionDataSource(dataList);

        return dataSource;
    }
}
