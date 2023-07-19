package com.example.TaskCrudApp.Controller;

import com.example.TaskCrudApp.Model.StudentModel;
import com.example.TaskCrudApp.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/student")
public class StudentController {
    /**class is the controller for the Students*/

    public StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    /**method operation is adding students details*/
    @PostMapping("add-student")
    public ResponseEntity< StudentModel> addStudentDetails(@RequestBody StudentModel studentModel){

        return new ResponseEntity<StudentModel>(studentService.saveStudentDetails(studentModel), HttpStatus.CREATED);
    }

    /**this method is getting student details*/
    @GetMapping("get-student")
    public List<StudentModel> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }


    /**this method is for editing the student details*/
    @PutMapping("edit-student/{id}")
    public ResponseEntity<StudentModel> updateStudentDetails(@PathVariable("id")long id,@RequestBody StudentModel studentModel){
        return new ResponseEntity<StudentModel>(studentService.updateStudentDetails(studentModel,id),HttpStatus.OK);

    }

    /**this method is deleting student details through check box*/
    @DeleteMapping("checkbox/{ids}")
    public void deleteStudents(@PathVariable @RequestBody String ids){
        List<Long>listIds= Arrays.stream(ids.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        studentService.deleteWithCheckBox(listIds);

    }
}
