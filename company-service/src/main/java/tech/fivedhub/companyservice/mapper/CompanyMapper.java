package tech.fivedhub.companyservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.fivedhub.companyservice.dto.CompanyDto;
import tech.fivedhub.companyservice.dto.UserDto;
import tech.fivedhub.companyservice.model.Company;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mapping(source = "employeesList", target = "employees")
    CompanyDto companyToCompanyDto(Company company, List<UserDto> employeesList);
}
