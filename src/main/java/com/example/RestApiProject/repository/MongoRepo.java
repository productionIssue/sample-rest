package com.example.RestApiProject.repository;

import com.example.RestApiProject.model.MongoDbEmployeeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository<MongoDbEmployeeModel, String> {
}
