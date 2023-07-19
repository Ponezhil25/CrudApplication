package com.example.TaskCrudApp.Repository;

import com.example.TaskCrudApp.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel,Long> {

}
