package tech.fivedhub.userservice.service;

import tech.fivedhub.userservice.dto.UserDto;

public interface UserService {

    UserDto getUserById(Long userId);
}
