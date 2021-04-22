package com.koushik.CRM.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koushik.CRM.entity.Customer;
import com.koushik.CRM.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		// true means it will trim it to null if only white space available
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@RequestMapping("/saveCustomer")
	public String saveCustomer(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			customerService.saveCustomers(customer);
			return "redirect:/customer/list";
		}

	}
	
	@RequestMapping("/updateCustomer")
	public String update(
			@RequestParam("customerId") int theId,
			Model model) {
		Customer customer = customerService.getCustomer(theId);
		model.addAttribute("customer-update",customer);
		return "customer-update";
	}
	
	@RequestMapping("/deleteCustomer")
	public String delete(
			@RequestParam("customerId") int theId,
			Model model) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/search")
	public String delete(
			@RequestParam("searchCustomer") String name,
			Model model) {
		System.out.println("Customer name: "+name);
		List<Customer> customer = customerService.getCustomerByName(name);
		model.addAttribute("result",customer);
		return "result";
	}
}
