package com.example.RestApiProject.controller;

import com.example.RestApiProject.model.MongoDbEmployeeModel;
import com.example.RestApiProject.repository.MongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/db")
public class MasterController {
    @Autowired
    private MongoRepo mongoRepo;

    @GetMapping("fetch-employee")
    public List<MongoDbEmployeeModel> getAllEmployees() {
        return mongoRepo.findAll();
    }

    @GetMapping("get-employee-by-id/{id}")
    public Optional<MongoDbEmployeeModel> getUserById(@PathVariable String id) {
        return mongoRepo.findById(id);
    }

    @PostMapping("add-employee")
    public MongoDbEmployeeModel assNewEmployee(@RequestBody MongoDbEmployeeModel mongoDbEmployeeModel) {
        return mongoRepo.save(mongoDbEmployeeModel);
    }

    @PutMapping("update-employee/{id}")
    public MongoDbEmployeeModel updateUser(@PathVariable String id, @RequestBody MongoDbEmployeeModel mongoDbEmployeeModel) {
        MongoDbEmployeeModel fetchedMongoDbEmployeeModel = mongoRepo.findById(id).orElseThrow();
        fetchedMongoDbEmployeeModel.setName(mongoDbEmployeeModel.getName());
        fetchedMongoDbEmployeeModel.setCompany(mongoDbEmployeeModel.getCompany());
        return mongoRepo.save(fetchedMongoDbEmployeeModel);
    }

    @DeleteMapping("delete-employee/{id}")
    public void deleteUser(@PathVariable String id) {
        mongoRepo.deleteById(id);
    }
}
