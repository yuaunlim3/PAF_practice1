package PAF.practice_1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import PAF.practice_1.Model.Expense;
import PAF.practice_1.Model.Users;
import PAF.practice_1.Service.ExpenseService;
import PAF.practice_1.Service.UsersService;

@Controller
@RequestMapping()
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/login")
    public String login(@RequestBody MultiValueMap<String, String> form, Model model) {
        String username = form.getFirst("username");
        Boolean checker = usersService.checkUser(username);

        if (!checker) {
            return "redirect:/create";
        }

        return "redirect:/homepage/" + username;

    }

    @GetMapping("/create")
    public String createPage() {
        return "createpage";
    }

    @PostMapping("/create")
    public String create(@RequestBody MultiValueMap<String, String> form, Model model) {
        String username = form.getFirst("username");
        String password = form.getFirst("password");
        String email = form.getFirst("email");

        Users user = new Users();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);

        Boolean checker = usersService.checkUser(username);

        // Check if user already exist
        if (checker) {
            return "createpage";
        }

        usersService.createUser(user);

        return "redirect:/homepage/" + user.getUsername();

    }

    // Login to the homepage
    @GetMapping("/homepage/{name}")
    public String Homepage(@PathVariable String name, Model model) {
        Users user = usersService.getUser(name);
        model.addAttribute("user", user);
        List<Expense> expenses = expenseService.getAll(user);
        model.addAttribute("expenses", expenses);
        return "homepage";
    }

    //Logout
    @GetMapping("/logout")
    public String logout(){
        return "redirect:/loginpage";
    }
}
