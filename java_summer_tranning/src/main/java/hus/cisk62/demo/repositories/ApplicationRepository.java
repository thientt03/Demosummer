package hus.cisk62.demo.repositories;

import hus.cisk62.demo.entities.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApplicationRepository extends JpaRepository<ApplicationEntity,Integer> {
}