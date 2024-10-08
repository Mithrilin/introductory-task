package tech.fivedhub.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.fivedhub.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLastName(String lastName);

    List<User> findByIdIn(List<Long> ids);
}
