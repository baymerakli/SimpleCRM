package com.ozg.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ozg.spring.dao.CustomerDAOImpl;
import com.ozg.spring.model.Customer;
import com.ozg.spring.service.CustomerService;

@Controller
@SessionAttributes("customer")
public class CustomerController {

    private CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

    @Autowired(required = true)
    @Qualifier(value = "customerService")
    public void setCustomerService(CustomerService ps) {
	this.customerService = ps;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(Model model) {
	model.addAttribute("customer", new Customer());
	model.addAttribute("listCustomers", this.customerService.listCustomers());
	return "customer";
    }

    // For add and update customer both
    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public String addCustomer(Customer c) {
	logger.info("Add Customer:" + c);
	if (c.getId() == 0) {
	    // new customer, add it
	    this.customerService.addCustomer(c);
	} else {
	    // existing customer, call update
	    this.customerService.updateCustomer(c);
	}

	return "redirect:/customers";

    }

    @RequestMapping("/remove/{id}")
    public String removeCustomer(@PathVariable("id") int id) {

	this.customerService.removeCustomer(id);
	return "redirect:/customers";
    }

    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model) {
	Customer c = this.customerService.getCustomerById(id);
	logger.info("Edit Customer:" + c);
	model.addAttribute("customer", c);
	model.addAttribute("listCustomers", this.customerService.listCustomers());
	return "customer";
    }

}
