package login.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import login.app.entity.UserForm;

public interface UserRepository extends JpaRepository<UserForm, Long> {
	@Query(value = "SELECT * FROM user_tb", nativeQuery = true)
	List<UserForm> findAllUser();

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM user_tb WHERE name=?1", nativeQuery = true)
	UserForm findByname(String name);

}
