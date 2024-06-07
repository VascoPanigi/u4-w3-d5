package VascoPanigi.entities;

import jakarta.persistence.*;

import java.util.Random;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type")

@NamedQueries({
        @NamedQuery(name = "findByName", query = "SELECT i FROM Catalogue i WHERE i.title LIKE :title"),
        @NamedQuery(name = "findByYear", query = "SELECT i FROM Catalogue i WHERE i.publication_year = :publication_year"),
        @NamedQuery(name = "findByAuthor", query = "SELECT i FROM Catalogue i WHERE i.author LIKE :author"),
        @NamedQuery(name = "findByUserCardNumber", query = "SELECT i FROM Catalogue i JOIN i.loan l WHERE l.user.card_number = :card_number")

})
public abstract class Catalogue {

    @Id
    @GeneratedValue
    protected UUID isbn;

    protected String title;

    protected int publication_year;
    protected int totalPages;

    // bidirectional mapping daje

    @OneToOne(mappedBy = "catalogue")
    private Loan loan;

    public Catalogue(){
    }

    public Catalogue(int totalPages, int publicationYear, String title) {
        this.totalPages = totalPages;
        this.publication_year = publicationYear;
        this.title = title;
    }

    public static int generateYear() {
        Random random = new Random();
        return random.nextInt(1950, 2024);
    }

    public static int generateTotalPages() {
        Random random = new Random();
        return random.nextInt(1, 2000);
    }

    public UUID getIsbn() {
        return isbn;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

}
