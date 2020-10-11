package ncl.demo.postgres;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import com.google.gson.*;  //converts java objects to JSON

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/bulkcreate")
    public String bulkCreate(){   //method for debug

        customerRepository.saveAll(Arrays.asList(
                new Customer("Mark", "Hanrahan1"),
                new Customer("Mark", "Hanrahan2"),
                new Customer("Mark", "Hanrahan3"),
                new Customer("Mark", "Hanrahan4"),
                new Customer("Mark", "Hanrahan5")
        ));
    return "Customers Created";
    }
    @GetMapping("/add")
    public String addUser(@RequestParam(value = "firstname") String firstname, @RequestParam(value = "lastname") String lastname){  //create a user entry in DB
        customerRepository.save(new Customer(firstname,lastname));
        return "Customer Added";
    }

    @GetMapping("/fetchAll")    //pull all data from Customer table (debug)
    public String fetchAll(){
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);  //add found customers to return ArrayList because finall()->JPARepos returns Iterable<>
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(customers);
        return gson.toJson(customers);
    }
    @PostMapping("/create")
    public String create(@RequestBody Customer customer){
        customerRepository.save(new Customer(customer.getFirstName(),customer.getLastName()));
        return "Customer Created(1)";
    }
}
