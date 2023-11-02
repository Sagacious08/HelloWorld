package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.ExcelService;

@RestController("/Git")
public class GitTestController {
	@Autowired
	private ExcelService excelService;
	
	@GetMapping("/getExcel")
	public void getExcel(HttpServletResponse response) {
	    try {
	        // Create a new Excel workbook and sheet using Apache POI
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Employee Data");

	        // Add data to the Excel sheet (replace this with your data)
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Employee ID");
	        headerRow.createCell(1).setCellValue("Name");
	        headerRow.createCell(2).setCellValue("Department");
	        
	        Employee e1=new Employee();
	        e1.setEmpCode("123");
	        e1.setDept("IT");
	        e1.setName("Sagar");
	        Employee e2=new Employee();
	        e2.setEmpCode("123");
	        e2.setDept("IT");
	        e2.setName("Sagar");
//	        Employee e3=new Employee();
//	        Employee e4=new Employee();
	        List<Employee> employeeList=new ArrayList<>();
	        employeeList.add(e1);
	        employeeList.add(e2);
//	        List<Employee> employeeList = excelService.getData();
	        int rowNum = 1;
	        for (Employee employee : employeeList) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(employee.getEmpCode());
	            row.createCell(1).setCellValue(employee.getName());
	            row.createCell(2).setCellValue(employee.getDept());
	        }

	        // Set the response content type for Excel file
	        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        response.setHeader("Content-Disposition", "attachment; filename=employee_data.xls");

	        // Write the Excel data to the response
	        workbook.write(response.getOutputStream());
	        workbook.close();
	    } catch (Exception e) {
	        // Handle any exceptions here
	        e.printStackTrace();
	    }
	}
	@GetMapping("home")
	public String home() {
		return "index";
		
	}

}
