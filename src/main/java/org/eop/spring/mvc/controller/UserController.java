package org.eop.spring.mvc.controller;

import java.util.List;

import javax.servlet.http.Part;

import org.eop.spring.mvc.bean.User;
import org.eop.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author lixinjie
 * @since 2017-08-19
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "user/add";
	}
	
	@PostMapping("/add")
	public String addUser(User user, BindingResult bresult, RedirectAttributes rattr) {
		Long id = userService.saveUser(user);
		user.setId(id);
		rattr.addFlashAttribute("operation", "add");
		rattr.addFlashAttribute("user", user);
		return "redirect:/user/list";
	}
	
	@GetMapping("/list")
	public String listUsers(Model model) {
		List<User> users = userService.listAllUsers();
		model.addAttribute("users", users);
		return "user/list";
	}
	
	@GetMapping("/edit/{id:\\d+}")
	public String editUser(@PathVariable("id")Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "user/edit";
	}
	
	@PutMapping("/edit")
	public String editUser(User user, BindingResult bresult, RedirectAttributes rattr) {
		userService.updateUser(user);
		rattr.addFlashAttribute("operation", "edit");
		rattr.addFlashAttribute("user", user);
		return "redirect:/user/list";
	}
	
	
	@GetMapping("/delete/{id:\\d+}")
	public String deleteUser(@PathVariable("id")Long id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user/delete";
	}
	
	@DeleteMapping("/delete")
	public String deleteUser(@RequestParam("id")Long id, RedirectAttributes rattr) {
		User user = userService.getUser(id);
		userService.removeUser(id);
		rattr.addFlashAttribute("operation", "delete");
		rattr.addFlashAttribute("user", user);
		return "redirect:/user/list";
	}
	
	@GetMapping("/file")
	public String uploadFile(Model model) {
		return "user/file";
	}
	
	@PostMapping("/file")
	public String uploadFile(@RequestParam("name") String name, @RequestParam("file") MultipartFile file, Model model) {
		if (!file.isEmpty()) {
			model.addAttribute("name", name + "-file-" + file.getOriginalFilename());
			model.addAttribute("size", file.getSize());
		}
		return "user/file";
	}
	
	@GetMapping("/file1")
	public String uploadFile1(Model model) {
		return "user/file1";
	}
	
	@PostMapping("/file1")
	public String uploadFile1(@RequestPart("name") String name, @RequestParam("file") Part file, Model model) {
		if (file != null) {
			model.addAttribute("name", name + "-file1-" + file.getSubmittedFileName());
			model.addAttribute("size", file.getSize());
		}
		return "user/file1";
	}
}
