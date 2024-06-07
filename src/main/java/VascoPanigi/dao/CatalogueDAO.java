package VascoPanigi.dao;

import VascoPanigi.entities.Catalogue;
import VascoPanigi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

    public List<Catalogue> findByName(String title) {
        TypedQuery<Catalogue> query = em.createNamedQuery("findByName", Catalogue.class);
        query.setParameter("title", "%"+title+"%");
        return query.getResultList();
    }

    public List<Catalogue> findByYear(int publication_year) {
        TypedQuery<Catalogue> query = em.createNamedQuery("findByYear", Catalogue.class);
        query.setParameter("publication_year", publication_year);
        return query.getResultList();
    }

    public List<Catalogue> findByAuthor(String author) {
        TypedQuery<Catalogue> query = em.createNamedQuery("findByAuthor", Catalogue.class);
        query.setParameter("author", "%" + author + "%");
        return query.getResultList();
    }

    public List<Catalogue> findByUserCardNumber(UUID card_number) {
        TypedQuery<Catalogue> query = em.createNamedQuery("findByUserCardNumber", Catalogue.class);
        query.setParameter("card_number", card_number);
        return query.getResultList();
    }
}
