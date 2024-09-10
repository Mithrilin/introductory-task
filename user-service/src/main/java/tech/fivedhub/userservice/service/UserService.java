package tech.fivedhub.userservice.service;

import tech.fivedhub.userservice.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long userId);

    UserDto getUserByLastName(String lastName);

    List<UserDto> getUsersByIds(List<Long> ids);
}
