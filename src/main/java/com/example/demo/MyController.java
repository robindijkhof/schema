package com.example.demo;


import com.example.demo.model.Data;
import com.example.demo.model.MockData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/test")
public class MyController {

    private final ProcesService procesService;
    private final VisualisationService visualisationService;

    @GetMapping
    public String steps(){
        procesService.runAllData();
        System.out.println();
        System.out.println();
        return "ok";
    }

    @GetMapping("/img")
    public ResponseEntity<String> img(){
      return ResponseEntity.ok(visualisationService.getSourceImage());

    }

}
