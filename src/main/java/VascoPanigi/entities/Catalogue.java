package VascoPanigi.entities;

import jakarta.persistence.*;

import java.util.Random;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type")
public abstract class Catalogue {

    @Id
    @GeneratedValue
    protected UUID isbn;


    protected String title;
    protected int publicationYear;
    protected int totalPages;

    public Catalogue(){
    }


    public Catalogue(int totalPages, int publicationYear, String title) {
        this.totalPages = totalPages;
        this.publicationYear = publicationYear;
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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }


}
