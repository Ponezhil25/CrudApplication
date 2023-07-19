package com.example.TaskCrudApp.Model;

import com.example.TaskCrudApp.Enums.CourseDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="studentDetails")
public class StudentModel {
    /**this class is entity for the Students*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String studentName;
    @Enumerated(EnumType.STRING)
    private CourseDetails course;  //need to use enum
    private String studentInstituteName;//need to use existing institute name
    private String studentAddress;
    @ManyToOne
    @JoinColumn(name="instituteId")
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private InstituteModel instituteModel;
}
