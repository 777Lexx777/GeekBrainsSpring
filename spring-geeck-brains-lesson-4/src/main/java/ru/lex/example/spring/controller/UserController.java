package ru.lex.example.spring.controller;//package ru.geekbrains.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.geekbrains.persist.User;
//import ru.geekbrains.persist.UserRepository;
//
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//
//    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    private UserRepository userRepository;
//
//    private User user;
//
//    public UserController(UserRepository userRepository, User user) {
//        this.userRepository = userRepository;
//        this.user = user;
//    }
//
//    @GetMapping
//    public String listPage(Model model) {
//        logger.info("List page requested");
//
//        model.addAttribute("users", userRepository.findAll());
//        return "user";
//    }
//
//    @GetMapping("/{id}")
//    public String editPage(@PathVariable("id") Long id, Model model) {
//        logger.info("Edit page for id {} requested", id);
//
//        model.addAttribute("user", userRepository.findById(id));
//        return "user_form";
//    }
//
//    @PostMapping("/update")
//    public String update(User user) {
//        logger.info("Update endpoint requested");
//
//        if (user.getId() != -1) {
//            logger.info("Updating user with id {}", user.getId());
//            userRepository.update(user);
//        } else {
//            logger.info("Creating new user");
//            userRepository.insert(user);
//        }
//        return "redirect:/user";
//    }
//
//    @GetMapping("/new")
//    public String newUsers( @ModelAttribute("newUser") User user){
//        // model.addAttribute("newUser", new User());//
//        return "new";
//    }
//
//    @PostMapping()
//        public String create(Model model,@ModelAttribute("newUser") User user) {
//        // TODO
//        logger.info("New user");
//
//        if (user.getId() != -1) {
//            logger.info("Updating user with id {}", user.getId());
//           // model.addAttribute(userRepository.saveUser(user));
//            userRepository.insert(user);
//        } else {
//            logger.info("A user with such id already exist");
//
//        }
//        return "redirect:/user";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String remove(@PathVariable("id") Long id) {
//        // TODO
//        userRepository.deleteUser(id);
//        return "redirect:/user";
//    }
//}
