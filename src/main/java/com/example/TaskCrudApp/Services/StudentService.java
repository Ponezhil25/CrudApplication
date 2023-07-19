package com.example.TaskCrudApp.Services;

import com.example.TaskCrudApp.Model.StudentModel;

import java.util.List;

public interface StudentService {
    StudentModel saveStudentDetails(StudentModel studentModel);
    List<StudentModel>getAllStudentDetails();
    StudentModel updateStudentDetails(StudentModel studentModel,long id);

    StudentModel deleteStudentDetails(StudentModel studentModel,long id);

    public void deleteWithCheckBox(Iterable<Long> ids);
}
