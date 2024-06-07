package VascoPanigi.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //should it be unidirectional? starting from the LOAN I want to know which book has been lent
    // starting from Catalogue, do I want to know which item is associated with a particular loan? ofc we want that, otherwise our system would be blind

    @OneToOne
    @JoinColumn(name = "catalogue_id")
    private Catalogue catalogue;


    private LocalDate loan_start_date;
    private LocalDate loan_estimated_ending_date;
    private LocalDate loan_ending_date;

    public Loan(){}

    public Loan(User user, Catalogue catalogue, LocalDate loan_start_date) {
        this.user = user;
        this.catalogue = catalogue;
        this.loan_start_date = loan_start_date;
        this.loan_estimated_ending_date = loan_start_date.plusDays(30);
        this.loan_ending_date = null;
    }


    public UUID getId() {
        return id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public LocalDate getLoan_start_date() {
        return loan_start_date;
    }

    public void setLoan_start_date(LocalDate loan_start_date) {
        this.loan_start_date = loan_start_date;
    }

    public LocalDate getLoan_estimated_ending_date() {
        return loan_estimated_ending_date;
    }

    public void setLoan_estimated_ending_date(LocalDate loan_estimated_ending_date) {
        this.loan_estimated_ending_date = loan_estimated_ending_date;
    }

    public LocalDate getLoan_ending_date() {
        return loan_ending_date;
    }

    public void setLoan_ending_date(LocalDate loan_ending_date) {
        this.loan_ending_date = loan_ending_date;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", catalogue=" + catalogue +
                ", loan_start_date=" + loan_start_date +
                ", loan_estimated_ending_date=" + loan_estimated_ending_date +
                ", loan_ending_date=" + loan_ending_date +
                ", user=" + user +
                '}';
    }
}
