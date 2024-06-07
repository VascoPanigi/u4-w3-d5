package VascoPanigi.dao;


import VascoPanigi.entities.User;
import VascoPanigi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("The user " + user.getName() +  " " + user.getSurname() + " has been added. Yippie :D");
    }

    public User findById(UUID userId) {
        User user = em.find(User.class, userId);
        if (user == null) throw new NotFoundException(userId);
        return user;
    }

    public void findByIdAndDelete(UUID userId) {
        User found = this.findById(userId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The user " + found.getName() + " " + found.getSurname() +  " has been eliminated from our system!");
    }
}
