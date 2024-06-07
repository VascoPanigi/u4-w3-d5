package VascoPanigi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID card_number;
    private String name;
    private String surname;
    private LocalDate birth_date;

    @OneToMany(mappedBy = "user")
    private List<Loan> loans;

    public User(){}

    public User(String surname, LocalDate birth_date, String name) {
        this.surname = surname;
        this.birth_date = birth_date;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public UUID getCard_number() {
        return card_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "birth_date=" + birth_date +
                ", surname='" + surname + '\'' +
                ", card_number=" + card_number +
                ", name='" + name + '\'' +
                '}';
    }
}
