package ua.com.alevel.model.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("expense")
public class ExpenseCategory extends Category {

    @Column(name = "expense_name")
    private String expenseName;

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    @Override
    public String toString() {
        return "ExpenseCategory{" +
                "expenseName='" + expenseName + '\'' +
                '}';
    }
}
