package PAF.practice_1.Model;

import java.time.LocalDate;

public class Expense {
    private int id;
    private int user_id;
    private String category;
    private double amount;
    private String description;
    private LocalDate purchase_date;


    //Getters and Setters
    public int getId() {     return id; }
    public void setId(int id) {    this.id = id; }
    public int getUser_id() {   return user_id; }
    public void setUser_id(int user_id) {   this.user_id = user_id;  }
    public String getCategory() {   return category;  }
    public void setCategory(String category) {    this.category = category; }
    public double getAmount() {    return amount; }
    public void setAmount(double amount) {    this.amount = amount; }
    public String getDescription() {    return description;  }
    public void setDescription(String description) {   this.description = description; }
    public LocalDate getPurchase_date() {   return purchase_date; }
    public void setPurchase_date(LocalDate purchase_date) {    this.purchase_date = purchase_date;  }
    
}
