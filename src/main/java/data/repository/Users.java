package data.repository;

import data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User, Long> {
}
