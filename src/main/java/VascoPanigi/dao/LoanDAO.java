package VascoPanigi.dao;

import VascoPanigi.entities.Catalogue;
import VascoPanigi.entities.Loan;
import VascoPanigi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class LoanDAO {
    private final EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Loan loan) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println("The loan " + loan.getId() + " has been added. Yippie :D");
    }

    public Loan findById(UUID loanId) {
        Loan loan = em.find(Loan.class, loanId);
        if (loan == null) throw new NotFoundException(loanId);
        return loan;
    }

    public void findByIdAndDelete(UUID loanId) {
        Loan found = this.findById(loanId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The user " + found.getId() + " has been eliminated from our system!");
    }

    public void updateLoanEndingDate(UUID loanId, LocalDate newEndingDate) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Loan loan = em.find(Loan.class, loanId);
        if (loan == null) throw new NotFoundException(loanId);

        loan.setLoan_ending_date(newEndingDate);
        em.merge(loan);

        transaction.commit();
        System.out.println("The loan ending date for loan " + loan.getId() + " has been updated. :D");
    }

    public List<Loan> findCurrentlyLent() {
        TypedQuery<Loan> query = em.createNamedQuery("findCurrentlyLent", Loan.class);
        return query.getResultList();
    }

    public List<Loan> findExpiredLoans() {
        TypedQuery<Loan> query = em.createNamedQuery("findExpiredLoans", Loan.class);
        return query.getResultList();
    }

}
