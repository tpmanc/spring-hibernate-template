package controllers;

import helpers.PasswordHelper;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.UserService;

import java.util.HashMap;

@Controller
public class IndexController {
    @Autowired
    public UserService userService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(
            @RequestParam(value="categoryId", required=false, defaultValue = "0") int categoryId,
            Model model
    ) {
        model.addAttribute("title", "Index page");
        return "index/index";
    }

    @RequestMapping(value = {"/sign-in"}, method = RequestMethod.GET)
    public String login(
            Model model
    ) {
        model.addAttribute("title", "Sign In");
        return "index/sign-in";
    }

    @RequestMapping(value = {"/sign-up/handler"}, method = RequestMethod.POST)
    public String signUpHandler(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String passwordRepeat
    ) {
        HashMap<String, String> errors = new HashMap<>();
        if (!password.equals(passwordRepeat)) {
            errors.put("password", "Passwords should be same");
        }
        User user = userService.getByEmail(email);
        if (user != null) {
            errors.put("email", "Already used");
        }

        user = new User();
        user.setEmail(email);
        user.setPasswordHash(PasswordHelper.generatePasswordHash(password));
        user.setDisabled(false);
        userService.create(user);

        return "redirect:/sign-in";
    }
}
