package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.model.Employe;
import com.employee.service.EmployeeServiceClass;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServiceClass employeeService;

	@RequestMapping("/")
	public String home(Model model) {

		return "index";
	}

	@GetMapping("/Employe_login")
	public String Employe_logn() {
		return "Employe_login";
	}

	@GetMapping("/home")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// cretae model attribute to bind form data
		Employe employee = new Employe();
		// here "employee" <- Thymeleaf template will access this empty employee object
		// for binding form data
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employe employee) {
		// save Employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/home";

	}

	@GetMapping("/showFOrmForUpdate/{id}")
	public void showFOrmForUpdate(@PathVariable(value = "id") long id, Model model) {
		Employe emp = employeeService.getEmployeeById(id);
		model.addAttribute("employee", emp);
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeBysId(@PathVariable(value = "id") long id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/home";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;
		Page<Employe> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employe> listEmployees = page.getContent();
		model.addAttribute("currPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("listEmployees", listEmployees);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		return "home";

//	@GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable("pageNo") int pageNo, Model model) {
//        int pageSize = 5; // Example page size
//        Page<Employe> page = employeeService.findPaginated(pageNo, pageSize);
//        model.addAttribute("listusers", page.getContent());
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//        model.addAttribute("currPage", pageNo);
//        return "index";
//    }

	}
}
