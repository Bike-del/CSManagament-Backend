package com.Sachin.CustomerManagement.Controller;

import com.Sachin.CustomerManagement.ApiResponse.ApiResponse;
import com.Sachin.CustomerManagement.Service.Customer.CustomerService;
import com.Sachin.CustomerManagement.VO.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(customerService.allCustomer(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable String name){
        return new ResponseEntity<>(customerService.getByCustomerName(name), HttpStatus.OK);
    }



    @GetMapping("/{Id}")
    public ResponseEntity<Customer> getById(@PathVariable long Id){
        return new ResponseEntity<>(customerService.getById(Id),HttpStatus.OK);
    }

    //pagination
    @GetMapping("/page/{no}")
    public ResponseEntity<List<Customer>> getCustomersByPage(@PathVariable long no){
        return new ResponseEntity<>(customerService.getByPageNo(no),HttpStatus.OK);
    }



    //post
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.Create(customer),HttpStatus.CREATED);
    }

    //put
    @PutMapping("/update/{Id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable long Id){
        return new ResponseEntity<>(customerService.update(customer,Id),HttpStatus.OK);
    }


    //delete
    @DeleteMapping("/delete/{Id}")
    public ApiResponse deleteCustomer(@PathVariable long Id){
        customerService.Delete(Id);
        return new ApiResponse("Deleted",true,null);

    }


}
