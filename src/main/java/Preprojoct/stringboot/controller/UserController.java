package Preprojoct.stringboot.controller;

import Preprojoct.stringboot.model.User;
import Preprojoct.stringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @PostMapping(value = "/add")
    public String addUser(@RequestParam String name, @RequestParam String surname, @RequestParam String email) {
        User user = new User(name, surname, email);
        userService.add(user);
        return "redirect:/";
    }


    @PostMapping(value = "/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String surname, @RequestParam String email) {
        User user = new User(name, surname, email);
        user.setId(id);
        userService.update(user);
        return "redirect:/";
    }


    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
