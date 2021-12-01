package login.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import login.app.entity.UserForm;
import login.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {

	@Autowired
	UserRepository userRepository;
	List<UserForm> UserList;

	@RequestMapping("/hello")
	private String init() {
		return "hello";
	}
}