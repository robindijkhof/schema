package com.example.demo;


import com.example.demo.model.Data;
import com.example.demo.model.MockData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/test")
public class MyController {

    private final ProcesService procesService;

    @GetMapping
    public String steps(){
        procesService.runAllData();
        System.out.println();
        System.out.println();
        return "ok";
    }

    @GetMapping("/imp")
    public String steps2(){
        List<Data> mockDate = MockData.getMockData();
        for(Data d: mockDate){
            new Imperative().run(new StepperState(false, d));
        }
        System.out.println();
        System.out.println();
        return "ok-ish";
    }

}
