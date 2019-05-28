package com.electro.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;
    @Column
    private String description;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY'T'HH:mm")
//    @JsonSerialize(using = DateSerializer.class)
//    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "Europe/Minsk")
    private Date applicationDate;

    public Application(String name, String phone, String description){
        this.name = name;
        this.phone = phone;
        this.description = description;
    }
}
