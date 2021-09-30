package ehcruz.model;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import java.math.BigDecimal;
import java.time.LocalDate;

@Record(maxLength = 75, minLength = 75)
public class Employee {

    @Field(at = 0, length = 25)
    private String fisrtName;

    @Field(at = 24, length = 10)
    private String lastName;

    @Field(at = 34, length = 15)
    private String position;

    @Field(at = 49, length = 8, handlerName = "localDateHandler")
    private LocalDate hireDate;

    @Field(at = 57, length = 15, type = BigDecimal.class, format = "#############.##", padding = 0, align = Align.RIGHT)
    private BigDecimal salary;

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
