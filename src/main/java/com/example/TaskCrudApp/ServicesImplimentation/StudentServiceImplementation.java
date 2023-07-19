package com.example.TaskCrudApp.ServicesImplimentation;

import com.example.TaskCrudApp.Exceptions.ResourceNotFoundException;
import com.example.TaskCrudApp.Model.InstituteModel;
import com.example.TaskCrudApp.Model.StudentModel;
import com.example.TaskCrudApp.Repository.InstituteRepository;
import com.example.TaskCrudApp.Repository.StudentRepository;
import com.example.TaskCrudApp.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImplementation implements StudentService {
    /**this class is the logicis for the Students Details*/

    private StudentRepository studentRepository;
    @Autowired
    private InstituteRepository instituteRepository;
    public StudentServiceImplementation(StudentRepository studentRepository){
        super();
        this.studentRepository=studentRepository;
    }
//bidirectional
    /**method operation is getting the data from the user and save into the db*/
    @Override
    public StudentModel saveStudentDetails(StudentModel studentModel) {
        InstituteModel instituteModel=  instituteRepository.findByinstituteName(studentModel.getStudentInstituteName());
        studentModel.setInstituteModel(instituteModel);
        return studentRepository.save(studentModel);
    }
    /**method operation is getting the data from the db */
    @Override
    public List<StudentModel> getAllStudentDetails() {
        return studentRepository.findAll();
    }
    /**method operation is editing the existing data*/
    @Override
    public StudentModel updateStudentDetails(StudentModel studentModel, long id) {
        StudentModel existingStudent=studentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("StudentId"+id));
        existingStudent.setStudentName(studentModel.getStudentName());
        existingStudent.setStudentAddress(studentModel.getStudentAddress());
        existingStudent.setStudentInstituteName(studentModel.getStudentInstituteName());
        existingStudent.setCourse(studentModel.getCourse());
        studentRepository.save(existingStudent);
        return existingStudent;
    }
/** method operation is deleting the student details*/
    @Override
    public StudentModel deleteStudentDetails(StudentModel studentModel, long id) {
        return null;
    }
    /** method operation is deleting the student details with check box*/
    @Override
    public void deleteWithCheckBox(Iterable<Long> ids) {
        studentRepository.deleteAllByIdInBatch(ids);
    }
}
