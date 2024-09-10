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

    public User isUserPresent(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            log.error("User with ID {} missing from DB.", userId);
            throw new NotFoundException(String.format("ПUser with ID %d missing from DB.", userId));
        }

        return optionalUser.get();
    }
}
