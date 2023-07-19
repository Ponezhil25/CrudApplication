package com.example.TaskCrudApp.Repository;

import com.example.TaskCrudApp.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel,Long> {


}
