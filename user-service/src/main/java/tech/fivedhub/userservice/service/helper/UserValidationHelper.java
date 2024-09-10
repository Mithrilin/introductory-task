package tech.fivedhub.userservice.service.helper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.fivedhub.userservice.exception.NotFoundException;
import tech.fivedhub.userservice.model.User;
import tech.fivedhub.userservice.repository.UserRepository;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserValidationHelper {

    private final UserRepository userRepository;


}
