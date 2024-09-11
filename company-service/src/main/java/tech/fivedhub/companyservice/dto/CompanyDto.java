package tech.fivedhub.companyservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDto {

    private Long id;
    private String name;
    private Long budget;
    private List<UserDto> employees;
}
