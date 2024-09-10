package tech.fivedhub.userservice.controller;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.fivedhub.userservice.dto.UserDto;
import tech.fivedhub.userservice.service.UserService;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable @Positive Long userId) {
        log.debug("Requesting user with ID {}.", userId);
        return userService.getUserById(userId);
    }

    @GetMapping("/{lastName}")
    public UserDto getUserByLastname(@PathVariable String lastName) {
        log.debug("Requesting user with Last Name {}.", lastName);
        return userService.getUserByLastName(lastName);
    }

    @GetMapping
    public List<UserDto> getUsersByIds(@RequestParam List<Long> ids) {
        log.debug("Requesting users by ids.");
        return userService.getUsersByIds(ids);
    }
}
