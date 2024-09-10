package tech.fivedhub.userservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.fivedhub.userservice.dto.UserDto;
import tech.fivedhub.userservice.mapper.UserMapper;
import tech.fivedhub.userservice.model.User;
import tech.fivedhub.userservice.service.helper.UserValidationHelper;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserValidationHelper userValidationHelper;

    private final UserMapper userMapper;

    @Override
    public UserDto getUserById(Long userId) {
        User user = userValidationHelper.isUserPresent(userId);
        UserDto userDto = userMapper.userToUserDto(user);
        log.info("Пользователь с ИД {} возвращен.", userId);
        return userDto;
    }
}
