package PAF.practice_1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import PAF.practice_1.Model.Expense;
import PAF.practice_1.Model.Users;
import PAF.practice_1.Repository.ExpenseRepository;

@Service
public class ExpenseService {
    @Autowired private ExpenseRepository expenseRepository;

    public List<Expense> getAll(Users user){
        return expenseRepository.getAllExpense(user);
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addExpense(Expense expense){
        expenseRepository.addExpense(expense);
    }

}
