package tech.fivedhub.userservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.fivedhub.userservice.dto.UserDto;
import tech.fivedhub.userservice.exception.NotFoundException;
import tech.fivedhub.userservice.mapper.UserMapper;
import tech.fivedhub.userservice.model.User;
import tech.fivedhub.userservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            log.error("User with ID {} missing from DB.", userId);
            throw new NotFoundException(String.format("User with ID %d missing from DB.", userId));
        }

        User user =  optionalUser.get();
        UserDto userDto = userMapper.userToUserDto(user);
        log.debug("User with ID {} returned.", userId);
        return userDto;
    }

    @Override
    public UserDto getUserByLastName(String lastName) {
        Optional<User> optionalUser = userRepository.findByLastName(lastName);

        if (optionalUser.isEmpty()) {
            log.error("User with Last Name {} missing from DB.", lastName);
            throw new NotFoundException(String.format("User with Last Name %s missing from DB.", lastName));
        }

        User user =  optionalUser.get();
        UserDto userDto = userMapper.userToUserDto(user);
        log.debug("User with Last Name {} returned.", lastName);
        return userDto;
    }

    @Override
    public List<UserDto> getUsersByIds(List<Long> ids) {
        List<User> users = userRepository.findByIdIn(ids);

        if (users.isEmpty()) {
            log.info("There were no users with the specified ids.");
            return new ArrayList<>();
        }

        List<UserDto> userDtos = userMapper.userListToUserDtoList(users);
        log.debug("The list of users of size {} has been returned.", users.size());
        return userDtos;
    }
}
