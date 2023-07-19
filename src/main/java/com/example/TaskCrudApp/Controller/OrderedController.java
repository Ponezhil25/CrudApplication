package com.example.TaskCrudApp.Controller;

import com.example.TaskCrudApp.Model.CustomerModel;
import com.example.TaskCrudApp.Model.InstituteModel;
import com.example.TaskCrudApp.Model.OrderedModel;
import com.example.TaskCrudApp.Repository.OrderedRepository;
import com.example.TaskCrudApp.ServicesImplimentation.OrderedService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("order")
public class OrderedController {
    @Autowired
    OrderedService orderedService;


//    @GetMapping
    public  List<OrderedModel> getOrderedValues(){
        System.out.println("i am controller");
        return orderedService.getAllOrderedDetails();
        }
        @GetMapping
        public ResponseEntity<List<CustomerModel>> getCustomerOrderedVeg(){
            List<CustomerModel> customerOrderedVeg=orderedService.getCustomerOrderedVeg();
            return ResponseEntity.ok(customerOrderedVeg);
        }


}
