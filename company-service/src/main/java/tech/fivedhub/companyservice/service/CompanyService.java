package tech.fivedhub.companyservice.service;

import tech.fivedhub.companyservice.dto.CompanyDto;

public interface CompanyService {

    CompanyDto getCompanyById(Long companyId);
}
