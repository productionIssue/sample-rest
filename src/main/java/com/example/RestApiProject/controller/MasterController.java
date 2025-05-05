package com.example.RestApiProject.controller;

import com.example.RestApiProject.model.MasterModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MasterController {
    @GetMapping("/connection/{param}")
    public ResponseEntity<MasterModel> getConnection(@PathVariable String param) {
        MasterModel masterModel = new MasterModel(param);
        return ResponseEntity.ok(masterModel);
    }
}
