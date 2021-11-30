package login.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import login.app.entity.UserForm;
import login.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class LoginController {

	@Autowired
	UserRepository userRepository;
	List<UserForm> UserList;

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("UserForm", new UserForm());
		return "testLogin";
	}
	
	@PostMapping("/search")
	public String edit(@RequestParam(value = "name", required = false, defaultValue = "%")
	String name, Model model) {
		System.out.println(name);
//		UserList = userRepository.findByname(name);
//		model.addAttribute("UserList", UserList);
		
//		UserList = userRepository.findAllUser();
//		model.addAttribute("UserList", UserList);
		
		return "hello";
	}
}
