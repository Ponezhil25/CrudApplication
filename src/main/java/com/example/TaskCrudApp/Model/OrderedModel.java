package com.example.TaskCrudApp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class OrderedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderedId;
    private long orderedValues;
    private String orderedDate;
    private String orderedItemType;
    @ManyToOne
    @JoinColumn(name = "customer")
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private CustomerModel customerDetails;
}
