package tech.fivedhub.companyservice.controller;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.fivedhub.companyservice.dto.CompanyDto;
import tech.fivedhub.companyservice.service.CompanyService;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/companies")
@Validated
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{companyId}")
    public CompanyDto getCompanyById(@PathVariable @Positive Long companyId) {
        log.debug("Requesting company with ID {}.", companyId);
        return companyService.getCompanyById(companyId);
    }
}
