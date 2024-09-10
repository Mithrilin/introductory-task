package tech.fivedhub.userservice.mapper;

import org.mapstruct.Mapper;
import tech.fivedhub.userservice.dto.UserDto;
import tech.fivedhub.userservice.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);
}
