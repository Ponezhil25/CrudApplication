package com.example.TaskCrudApp.ServicesImplimentation;

import com.example.TaskCrudApp.Model.CustomerModel;
import com.example.TaskCrudApp.Model.InstituteModel;
import com.example.TaskCrudApp.Model.OrderedModel;
import com.example.TaskCrudApp.Repository.CustomerRepository;
import com.example.TaskCrudApp.Repository.OrderedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderedService {

    @Autowired
    private OrderedRepository orderedRepository;
    @Autowired
    private CustomerRepository customerRepository;
    public OrderedModel findOrderedValues(OrderedModel orderedModel,Long id){
        orderedRepository.findById(id);
        System.out.println(orderedModel.getOrderedValues());
        return orderedModel;
    }

    public List<OrderedModel> getAllOrderedDetails() {

        return orderedRepository.findAll();
    }
    public List<CustomerModel> getCustomerOrderedVeg() {
        List<OrderedModel> vegOrders = orderedRepository.findByorderedItemType("veg");
        Map<CustomerModel,Long> vegOrderedCountByCustomer=vegOrders.stream()
                .collect(Collectors.groupingBy(OrderedModel::getCustomerDetails,Collectors.counting()));
        return vegOrderedCountByCustomer.entrySet().stream().filter(entry->entry.getValue()>0)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
