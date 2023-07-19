package com.example.TaskCrudApp.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    private String customerName;
    @OneToMany(mappedBy = "customerDetails",cascade = CascadeType.ALL)
    private List<OrderedModel> orderedListDetails;
}
