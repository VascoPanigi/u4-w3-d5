package VascoPanigi;


import VascoPanigi.dao.CatalogueDAO;
import VascoPanigi.dao.LoanDAO;
import VascoPanigi.dao.UserDAO;
import VascoPanigi.entities.*;
import VascoPanigi.enums.Periodicity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d5");

    public static void main(String[] args) {
//        System.out.println("YIPPIEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE :DDDDDDDDD");
        EntityManager em = emf.createEntityManager();
        CatalogueDAO cd = new CatalogueDAO(em);
        UserDAO ad = new UserDAO(em);
        LoanDAO ld = new LoanDAO(em);

//        Magazine magazine1 = new Magazine(Magazine.generateTotalPages(), Magazine.generateYear(), "first magazine", Periodicity.MONTHLY);
//        Book book3 = new Book(Book.generateTotalPages(), Book.generateYear(), "first book", "crime", "author2");
//
//        cd.save(magazine1);
//        cd.save(book3);

//        User jerry = new User("Scotti", LocalDate.of(1960, 5, 13), "Jerry");
//        User gabibbo = new User("Ao", LocalDate.of(1980, 2, 10), "Gabibbo");
//        ad.save(jerry);
//        ad.save(gabibbo);

//         Loan loan8 = new Loan(ad.findById(UUID.fromString("fb9ec68f-39c6-4ad1-ae87-72230f53c86d")), cd.findById(UUID.fromString("9312288c-7ac8-4924-b4e8-921f48d34cad")), LocalDate.of(2024, 4, 10));
//         Loan loan3 = new Loan(ad.findById(UUID.fromString("2e833e3c-560e-49b9-a189-3ae8230f4733")), cd.findById(UUID.fromString("5ce564b1-b94a-40c3-b201-96329faa47fd")), LocalDate.of(2020, 9, 30));

//        ld.save(loan4);
//        ld.save(loan5);

//----------------------WORKING METHODS-------------------------------
        
//        ld.updateLoanEndingDate(UUID.fromString("654cd7e7-bec5-42c6-9223-fb41fc6590b4"), LocalDate.of(2025, 3, 10));
//        cd.findByName("book").forEach(System.out::println);
//        cd.findByYear(1989).forEach(System.out::println);
//        cd.findByAuthor("author").forEach(System.out::println);
//        ld.findCurrentlyLent().forEach(System.out::println);
//        cd.findByUserCardNumber(UUID.fromString("2e833e3c-560e-49b9-a189-3ae8230f4733")).forEach(System.out::println);
//        ld.findExpiredLoans().forEach(System.out::println);
    }
}