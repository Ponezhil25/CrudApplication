package com.example.TaskCrudApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="instituteDetails")
public class InstituteModel {
    /**this class is entity for the institute*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instituteId;
    private String instituteName;
    private String instituteAddress;

    @OneToMany(mappedBy="instituteModel",cascade = CascadeType.ALL)
    public List<StudentModel> studentModels;
}