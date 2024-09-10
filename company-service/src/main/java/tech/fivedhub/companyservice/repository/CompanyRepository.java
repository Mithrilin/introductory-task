package tech.fivedhub.companyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.fivedhub.companyservice.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
