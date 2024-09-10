package tech.fivedhub.userservice.mapper;

import org.mapstruct.Mapper;
import tech.fivedhub.userservice.dto.UserDto;
import tech.fivedhub.userservice.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    List<UserDto> userListToUserDtoList(List<User> users);
}
