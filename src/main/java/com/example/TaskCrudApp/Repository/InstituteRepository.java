package com.example.TaskCrudApp.Repository;

import com.example.TaskCrudApp.Model.InstituteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface InstituteRepository extends JpaRepository<InstituteModel,Long> {
    InstituteModel findByinstituteName(String name);

}
