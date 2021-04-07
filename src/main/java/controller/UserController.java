package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import user.User;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    private ModelAndView allUsers(ModelAndView model) {
        List<User> users = userService.allUsers();
        model.setViewName("users");
        model.addObject("userList", users);

        return model;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    private ModelAndView addUser(ModelAndView model) {
        model.setViewName("createUser");

        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    private ModelAndView updateUser(User user, ModelAndView model) {
        model.setViewName("redirect:/users");
        userService.editUser(user);

        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    private ModelAndView deleteUser(int id, ModelAndView model) {
        model.setViewName("redirect:/users");
        User user = userService.getUserById(id);
        userService.deleteUser(user);

        return model;
    }

}
