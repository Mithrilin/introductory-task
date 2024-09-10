package tech.fivedhub.companyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.fivedhub.companyservice.model.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);
}
