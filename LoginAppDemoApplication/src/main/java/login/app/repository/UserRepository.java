package login.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import login.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT * FROM user_tb", nativeQuery = true)
	List<User> findAllUser();

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM user_tb WHERE name=?1", nativeQuery = true)
	List<User> findByname(String name);

}
