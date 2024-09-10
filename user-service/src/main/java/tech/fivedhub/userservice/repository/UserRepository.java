package tech.fivedhub.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.fivedhub.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
