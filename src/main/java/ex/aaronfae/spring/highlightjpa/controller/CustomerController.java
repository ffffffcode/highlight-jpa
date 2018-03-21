package ex.aaronfae.spring.highlightjpa.controller;

import ex.aaronfae.spring.highlightjpa.dao.CustomerRepository;
import ex.aaronfae.spring.highlightjpa.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/add")
    @ResponseBody
    public String addNewUser(@RequestParam String firstName
            , @RequestParam String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customerRepository.save(customer);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/findByLastName")
    public @ResponseBody
    List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
