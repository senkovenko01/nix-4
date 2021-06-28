package ua.com.alevel.model.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("income")
public class IncomeCategory extends Category {

    @Column(name = "income_name")
    private String incomeName;

    public String getIncomeName() {
        return incomeName;
    }

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    @Override
    public String toString() {
        return "IncomeCategory{" +
                "incomeName='" + incomeName + '\'' +
                '}';
    }
}
