package com.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.model.Employees;
import com.employee.service.EmployeeService;
import com.validator.EmployeeFormValidator;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;


@Controller
public class MainController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	 EmployeeFormValidator empvalidator;
	
	
	@RequestMapping("/")
	public String showHomePage() {
		 return "index";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employeeList(ModelAndView model1) throws IOException {
		List<Employees> employeeList = new ArrayList<Employees>();//employeeService.getAllEmployees();
		Employees employee = new Employees();
		List<Employees> employeeList2 = employeeService.getAllEmployees();
			ModelAndView model = new ModelAndView("employee");
		//model.addObject("employeeList", employeeList);
		model.addObject("employeeList", employeeList2);
		return model;

	}
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employees employee = new Employees();
		model.addObject("employee", employee);
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee( @ModelAttribute @Validated Employees employee,BindingResult result) {
		//Validation code
	    empvalidator.validate(employee, result);
		//System.out.println("About to save");
		if (result.hasErrors()){
			return new ModelAndView("redirect:/newEmployee");
		}
		else if(employee.getEmployeeID() == 0) { // if employee id is 0 then create new employee otherwise update
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
		return new ModelAndView("redirect:/employee");
	}
	
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeID = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeID);
		return new ModelAndView("redirect:/employee");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int employeeID = Integer.parseInt(request.getParameter("id"));
		Employees employee = employeeService.getEmployee(employeeID);
		ModelAndView model = new ModelAndView("edit_employee");
		model.addObject("employee", employee);
		return model;
	}
        
        @RequestMapping(value = "/jasper" , method = RequestMethod.GET)
public void generatePDFJasperChart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
 
	String sourceFileName = "C:\\Users\\Nelson Akpos\\Documents\\EmployeeReport.jasper";
	System.out.println(sourceFileName);
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("ReportTitle", "Nelson Demo");
	parameters.put("Author", "Prepared By Nelson Akpomuje");
	try {
		//System.out.println("Start compiling!!! ...");
		//JasperCompileManager.compileReportToFile(sourceFileName);
		//System.out.println("Done compiling!!! ...");
		sourceFileName = "C:\\Users\\Nelson Akpos\\Documents\\EmployeeReport.jasper";
                
		List<Employees> employeeList = employeeService.getAllEmployees();
		
	
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
				employeeList);
		JasperReport report = (JasperReport) JRLoader
				.loadObjectFromFile(sourceFileName);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report,
				parameters, beanColDataSource);
		if (jasperPrint != null) {
			byte[] pdfReport = JasperExportManager
					.exportReportToPdf(jasperPrint);
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Cache-Control", "private");
			response.setHeader("Pragma", "no-store");
			response.setContentLength(pdfReport.length);
			response.getOutputStream().write(pdfReport);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	} catch (JRException e) {
		e.printStackTrace();
	}//you are not 
}

}