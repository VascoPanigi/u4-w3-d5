package VascoPanigi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue
    private UUID card_number;
    private String name;
    private String surname;
    private LocalDate birth_date;

}
