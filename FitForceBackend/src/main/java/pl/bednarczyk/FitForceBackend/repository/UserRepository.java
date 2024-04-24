package pl.bednarczyk.FitForceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
