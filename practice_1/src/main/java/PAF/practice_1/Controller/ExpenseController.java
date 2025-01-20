package PAF.practice_1.Controller;

import java.time.LocalDate;

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
@RequestMapping("")
public class ExpenseController {
    @Autowired private UsersService usersService;
    @Autowired private ExpenseService expenseService;
    
    @GetMapping("/addExpense/{user}")
    public String addExpensePage(@PathVariable("user") String username, Model model){
        Users user = usersService.getUser(username);
        model.addAttribute("user", user);
        return "addexpense";
    }

    @PostMapping("success/{user}")
    public String addedExpense(@PathVariable("user")String username,@RequestBody MultiValueMap<String, String> form, Model model){
        Users user = usersService.getUser(username);
        model.addAttribute("user", user);

        Expense expense = new Expense();
        expense.setUser_id(user.getId());
        expense.setAmount(Double.parseDouble(form.getFirst("amount")));
        expense.setDescription(form.getFirst("description"));
        String dateString = form.getFirst("purchase_date");
        if (dateString != null && !dateString.isEmpty()) {
            LocalDate purchaseDate = LocalDate.parse(dateString);
            expense.setPurchase_date(purchaseDate);
        }

        expenseService.addExpense(expense);

        return "success";

    }


}
