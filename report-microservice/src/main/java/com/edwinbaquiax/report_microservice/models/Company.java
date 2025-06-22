package com.edwinbaquiax.report_microservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data //getters setters
public class Company {

    private long id;
    private String name;
    private String founder;
    private String logo;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")//formateo de fecha
    private LocalDate foundationDate;
    private Collection<WebSite> webSites;

}
