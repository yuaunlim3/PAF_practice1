package PAF.practice_1.Utils;

public class SQL {
    //Users
    public static final String checkUser = "SELECT count(*) from users where username = ?";
    public static final String createUser = "INSERT INTO users(username,password,email) VALUES(?,?,?)";
    public static final String checkPassword = "SELECT password from users where username = ?";
    public static final String getUser = "SELECT * from users where username = ?";

    //Expenses 
    public static final String addExpense = "INSERT INTO expenses(user_id,category,amount,description,purchase_date) VALUES(?,?,?,?,?)";
    public static final String getExpense = """
            SELECT 
                *
            FROM 
                expenses
            WHERE 
                user_id = ?;

            
            """;

}
