package com.example.TaskCrudApp.ServicesImplimentation;

import com.example.TaskCrudApp.Exceptions.ResourceNotFoundException;
import com.example.TaskCrudApp.Model.InstituteModel;
import com.example.TaskCrudApp.Repository.InstituteRepository;
import com.example.TaskCrudApp.Services.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstituteServiceImplementation implements InstituteService {
    /**class is the logicis for the institute details  */
    private InstituteRepository instituteRepository;

    public InstituteServiceImplementation(InstituteRepository instituteRepository){
        super();
        this.instituteRepository=instituteRepository;
    }
    /**saving institute details*/
    @Override
    public InstituteModel saveInstituteDetails(InstituteModel instituteModel) {
        //InstituteModel byInstituteName=instituteRepository.findByInstituteName(instituteModel.getInstituteName());
        return instituteRepository.save(instituteModel);
    }
    /**method operation is get all details from institute table*/

    @Override
    public List<InstituteModel> getAllInstituteDetails() {

        return instituteRepository.findAll();
    }
/**method is update the institute*/
    @Override
    public InstituteModel updateInstituteDetails(InstituteModel instituteModel,long id) {
        InstituteModel existingInstitute=instituteRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("InstituteId"+id));
        existingInstitute.setInstituteName(instituteModel.getInstituteName());
        existingInstitute.setInstituteAddress(instituteModel.getInstituteAddress());
        instituteRepository.save(existingInstitute);
        return existingInstitute;
    }
    /**method operation is deleting institute details*/
    @Override
    public InstituteModel deleteInstituteDetails(InstituteModel instituteModel, long id) {
        InstituteModel delete=instituteRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Institute"+id));
        instituteRepository.deleteById(id);
        return delete;
    }
    /**method operation is deleting institute details by check box*/

    @Override
    public void deleteInstituteWithCheckBox(Long ids) {
        instituteRepository.deleteById(ids);
    }
    /**method is get both institute and students details*/
    @Override
    public InstituteModel getBothById(Long instituteId) {
        return instituteRepository.findById(instituteId).orElseThrow(()->
                new ResourceNotFoundException("no id is present"+instituteId));
    }
}
