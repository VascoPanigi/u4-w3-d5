package VascoPanigi.dao;

import VascoPanigi.entities.Catalogue;
import VascoPanigi.entities.Loan;
import VascoPanigi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class CatalogueDAO {

    private final EntityManager em;

    public CatalogueDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Catalogue catalogue ) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogue);
        transaction.commit();
        System.out.println("The item: " + catalogue.getTitle() + ", has been added. Yippie :D");
    }

    public Catalogue findById(UUID itemId) {
        Catalogue catalogue  = em.find(Catalogue.class, itemId);
        if (catalogue == null) throw new NotFoundException(itemId);
        return catalogue;
    }

    public void findByIdAndDelete(UUID itemId) {
        Catalogue found = this.findById(itemId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The item: " + found.getTitle() + ", has been eliminated from our system!");
    }
}
