package com.example.TaskCrudApp.Services;

import com.example.TaskCrudApp.Model.InstituteModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InstituteService {
     InstituteModel saveInstituteDetails(InstituteModel instituteModel);
    List<InstituteModel>getAllInstituteDetails();
     InstituteModel updateInstituteDetails(InstituteModel instituteModel,long id);

    InstituteModel deleteInstituteDetails(InstituteModel instituteModel,long id);

    public void deleteInstituteWithCheckBox(Long ids);

    InstituteModel getBothById(Long instituteId);
}
