package com.edwinbaquiax.companies_microservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Data //getters setters
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//uuid
    private long id;
    private String name;
    private String founder;
    private String logo;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")//formateo de fecha
    private LocalDate foundationDate;
    //De uno a muchos
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "id_company",referencedColumnName = "id")//referencia inversa
    private Collection<WebSite> webSites;

}
