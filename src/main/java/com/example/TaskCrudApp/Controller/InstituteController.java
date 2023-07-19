package com.example.TaskCrudApp.Controller;

import com.example.TaskCrudApp.Model.InstituteModel;
import com.example.TaskCrudApp.Repository.InstituteRepository;
import com.example.TaskCrudApp.Services.InstituteService;
import com.example.TaskCrudApp.exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/institute")
public class InstituteController {

    /**
     * for access the repository methods
     */
    @Autowired
    public InstituteService instituteService;
    @Autowired
    public InstituteRepository instituteRepository;

    public InstituteController(InstituteService instituteService){
        //whenever an instance of CommonController is created, an InstituteService object must be provided as an argument.
        super();
        this.instituteService=instituteService;
    }

    /**method operation is adding the institute details and save into db*/

    @PostMapping("/add-institute")
    public ResponseEntity<?> addInstituteDetails(@RequestBody InstituteModel instituteModel){

        InstituteModel existingName=  instituteRepository.findByinstituteName(instituteModel.getInstituteName());

        if (existingName != null){
            return  new ResponseEntity<>("Already exists ",HttpStatus.INTERNAL_SERVER_ERROR);

        }else{
            return new ResponseEntity<>(instituteService.saveInstituteDetails(instituteModel),HttpStatus.CREATED);
        }


    }

/**    method operation is getting institute details*/

    @GetMapping
    public List<InstituteModel> getAllInstituteDetails(){
        return instituteService.getAllInstituteDetails();
    }

    /**method operation is editing institute details*/
    @PutMapping("edit-institute/{id}")
    public ResponseEntity <InstituteModel> updateInstituteDetails(@PathVariable("id")long id,@RequestBody InstituteModel instituteModel){
        return new ResponseEntity<InstituteModel>(instituteService.updateInstituteDetails(instituteModel,id),HttpStatus.OK);
    }
    /**method operation is delete institute*/

    @DeleteMapping("delete-institute/{id}")
    public ResponseEntity deleteInstituteDetails(@PathVariable("id")long id,InstituteModel instituteModel){
        return new ResponseEntity(instituteService.deleteInstituteDetails(instituteModel,id),HttpStatus.OK);
    }

    /**this method is for deleting the institute details by selected checkbox*/
    @DeleteMapping("delete-institute-checkbox/{ids}")
    public ResponseEntity<?> deleteStudents(@PathVariable @RequestBody String ids) {
        List<Long> listIds = Arrays.stream(ids.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        for (Long id:listIds) {

          InstituteModel instituteStudentData= instituteService.getBothById(id);
          try {
              if (instituteStudentData.getStudentModels().isEmpty()) {
                  instituteService.deleteInstituteWithCheckBox(id);
              } else {
                  System.out.println("Students are holding institute details");
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("student present in this database");
              }
          }catch (Exception e){
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sorry, student exists in the database");
          }
        }
        return null;
    }
}

