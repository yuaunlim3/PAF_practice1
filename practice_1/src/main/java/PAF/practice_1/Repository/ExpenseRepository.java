package PAF.practice_1.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import PAF.practice_1.Model.Expense;
import PAF.practice_1.Model.Users;
import PAF.practice_1.Utils.SQL;

@Repository
public class ExpenseRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Expense> getAllExpense(Users user) {
        List<Expense> expenses = new LinkedList<>();
        SqlRowSet rw = template.queryForRowSet(SQL.getExpense, user.getId());
        while (rw.next()) {
            Expense expense = new Expense();
            expense.setId(rw.getInt("id"));
            expense.setUser_id(rw.getInt("user_id"));
            expense.setCategory(rw.getString("category"));
            LocalDate purchaseDate = rw.getDate("purchase_date").toLocalDate();
            expense.setPurchase_date(purchaseDate);
            expense.setAmount(rw.getDouble("amount"));
            expense.setDescription(rw.getString("description"));
            expenses.add(expense);
        }
        return expenses;
    }

    public void addExpense(Expense expense){
        template.update(SQL.addExpense,expense.getUser_id(),expense.getCategory(),expense.getAmount(),expense.getDescription(),expense.getPurchase_date());
    }

}
