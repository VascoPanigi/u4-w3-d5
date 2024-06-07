package VascoPanigi.entities;

import VascoPanigi.enums.Periodicity;

import java.util.Random;
import jakarta.persistence.*;


@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Catalogue {

    @Column(name = "magazine_periodicity")
    @Enumerated(EnumType.STRING)
    protected Periodicity periodicity;

    public Magazine() {
    }

    public Magazine(int totalPages, int publicationYear, String title, Periodicity periodicity) {
        super(totalPages, publicationYear, title);
        this.periodicity = periodicity;
    }

    public static Periodicity generatePeriodicity() {
        Random random = new Random();
        Periodicity[] periocityValues = Periodicity.values();
        return periocityValues[random.nextInt(periocityValues.length)];
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                ", totalPages=" + totalPages +
                ", publicationYear=" + publication_year +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
