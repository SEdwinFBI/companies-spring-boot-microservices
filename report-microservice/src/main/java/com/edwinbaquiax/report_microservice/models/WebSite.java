package com.edwinbaquiax.report_microservice.models;

import lombok.Data;

import java.io.Serializable;


@Data
public class WebSite implements Serializable {


    private long id;
    private String name;
    private Category category;
    private String description;

}
