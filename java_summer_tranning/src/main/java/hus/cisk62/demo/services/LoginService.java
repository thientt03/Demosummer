package hus.cisk62.demo.services;

import hus.cisk62.demo.entities.EmployeeEntity;
import hus.cisk62.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean checkLogin(String account , String password){
        EmployeeEntity employeeEntity  = employeeRepository.findByAccount(account);
        if(employeeEntity == null){
            return false;
        }

        if(employeeEntity.getPassword().equals(password) == false){
            return false;
        }

        return true;
    }

}
