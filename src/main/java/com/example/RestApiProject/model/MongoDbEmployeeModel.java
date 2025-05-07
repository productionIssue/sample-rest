package com.example.RestApiProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Employee")
public class MongoDbEmployeeModel {
    @Id
    private String id;
    private String name;
    private String company;

    public MongoDbEmployeeModel(String id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
