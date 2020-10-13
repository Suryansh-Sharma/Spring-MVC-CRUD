package np.com.roshanadhikary.controllers;

import np.com.roshanadhikary.domain.Customer;
import np.com.roshanadhikary.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/customer/{id}")
    public String getCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }

    @RequestMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.listCustomers());
        return "customers";
    }

//    GET request to /customer/new opens up the customerForm
    @RequestMapping("/customer/new")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

//    POST request to /customer persists the customer
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String addCustomer(Customer customer) {
        Customer savedCustomer = customerService.addOrUpdateCustomer(customer);
        return "redirect:/customer/" + savedCustomer.getId();
    }

    @RequestMapping("/customer/edit/{id}")
    public String updateCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customerForm";
    }
}
