package VascoPanigi;


import VascoPanigi.dao.CatalogueDAO;
import VascoPanigi.dao.LoanDAO;
import VascoPanigi.dao.UserDAO;
import VascoPanigi.entities.*;
import VascoPanigi.enums.Periodicity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

//         Loan loan2 = new Loan(ad.findById(UUID.fromString("2e833e3c-560e-49b9-a189-3ae8230f4733")), cd.findById(UUID.fromString("2c5886b1-001d-4927-94d3-15204220fc79")), LocalDate.of(2024, 2, 10));
//         Loan loan3 = new Loan(ad.findById(UUID.fromString("2e833e3c-560e-49b9-a189-3ae8230f4733")), cd.findById(UUID.fromString("5ce564b1-b94a-40c3-b201-96329faa47fd")), LocalDate.of(2020, 9, 30));
//         Loan loan4 = new Loan(ad.findById(UUID.fromString("655665e2-9851-4252-897f-b5d8ebf54d9d")), cd.findById(UUID.fromString("9318b803-ad22-4921-84d1-075b3eb96198")), LocalDate.of(2015, 6, 15));
//         Loan loan5 = new Loan(ad.findById(UUID.fromString("655665e2-9851-4252-897f-b5d8ebf54d9d")), cd.findById(UUID.fromString("884ae96f-412d-4ff6-b5d9-03fe6697fd04")), LocalDate.of(2024, 5, 7));
//         Loan loan2 = new Loan("2e833e3c-560e-49b9-a189-3ae8230f4733", "2c5886b1-001d-4927-94d3-15204220fc79", LocalDate.of(2024, 6, 15));

//        ld.save(loan2);
//        ld.save(loan3);
//        ld.save(loan4);
//        ld.save(loan5);


//        ld.updateLoanEndingDate(UUID.fromString("654cd7e7-bec5-42c6-9223-fb41fc6590b4"), LocalDate.of(2025, 3, 10));

            cd.findByIdAndDelete(UUID.fromString("fed79374-b3cb-4c74-a1db-423a2d2749c5"));


    }
}