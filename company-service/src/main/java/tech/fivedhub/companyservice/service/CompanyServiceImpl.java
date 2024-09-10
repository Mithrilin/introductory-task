package tech.fivedhub.companyservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.fivedhub.companyservice.client.UserClient;
import tech.fivedhub.companyservice.dto.CompanyDto;
import tech.fivedhub.companyservice.dto.UserDto;
import tech.fivedhub.companyservice.exception.NotFoundException;
import tech.fivedhub.companyservice.mapper.CompanyMapper;
import tech.fivedhub.companyservice.model.Company;
import tech.fivedhub.companyservice.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyMapper companyMapper;

    private final UserClient userClient;

    @Override
    public CompanyDto getCompanyById(Long companyId) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);

        if (optionalCompany.isEmpty()) {
            log.error("Company with ID {} missing from DB.", companyId);
            throw new NotFoundException(String.format("Company with ID %d missing from DB.", companyId));
        }

        Company company = optionalCompany.get();
        List<UserDto> employeesList = userClient.getEmployeesList(company.getEmployees());
        CompanyDto companyDto = companyMapper.companyToCompanyDto(company, employeesList);
        log.debug("Company with ID {} returned.", companyId);
        return companyDto;
    }

    @Override
    public CompanyDto getCompanyByName(String name) {
        Optional<Company> optionalCompany = companyRepository.findByName(name);

        if (optionalCompany.isEmpty()) {
            log.error("Company with name {} missing from DB.", name);
            throw new NotFoundException(String.format("Company with name %s missing from DB.", name));
        }

        Company company = optionalCompany.get();
        List<UserDto> employeesList = userClient.getEmployeesList(company.getEmployees());
        CompanyDto companyDto = companyMapper.companyToCompanyDto(company, employeesList);
        log.debug("Company with name {} returned.", name);
        return companyDto;
    }
}
