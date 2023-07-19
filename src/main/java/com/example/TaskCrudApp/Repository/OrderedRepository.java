package com.example.TaskCrudApp.Repository;

import com.example.TaskCrudApp.Model.InstituteModel;
import com.example.TaskCrudApp.Model.OrderedModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedRepository extends JpaRepository<OrderedModel,Long> {
    List<OrderedModel> findByorderedItemType(String values);
}
