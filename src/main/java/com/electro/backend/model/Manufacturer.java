package com.electro.backend.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String country;
    @Column
    private String description;

    public Manufacturer(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Manufacturer(String name, String country, String description) {
        this.name = name;
        this.country = country;
        this.description = description;
    }
}
