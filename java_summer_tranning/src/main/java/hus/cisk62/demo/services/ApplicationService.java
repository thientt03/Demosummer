package hus.cisk62.demo.services;

import hus.cisk62.demo.entities.ApplicationEntity;
import hus.cisk62.demo.entities.EmployeeEntity;
import hus.cisk62.demo.repositories.ApplicationRepository;
import hus.cisk62.demo.repositories.ApplicationRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Transactional
public class ApplicationService{
    @Autowired
    ApplicationRepositoryImp applicationRepositoryImp;
    @Autowired
    ApplicationRepository applicationRepository;
    public List<ApplicationEntity> findByElementID(int emp_id){
        return applicationRepositoryImp.findByElementID(emp_id);
    }

    public void displayApplication(Model model, int emp_id){
        model.addAttribute("applications", findByElementID(emp_id));
    }

//    public void save(ApplicationEntity applicationEntity) {
//
//    }

        public void save(ApplicationEntity applicationEntity) {
        applicationRepository.save(applicationEntity);
    }
}