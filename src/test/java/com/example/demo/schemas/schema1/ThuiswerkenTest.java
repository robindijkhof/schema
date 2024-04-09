package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.model.Data;
import com.example.demo.schemas.schema1.KorteBroekAan;
import com.example.demo.schemas.schema1.LangeBroekAan;
import com.example.demo.schemas.schema1.Thuiswerken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ThuiswerkenTest {

    private StepService stepService;

    @BeforeEach
    public void setup(){
        stepService = mock(StepService.class);
    }


    @Test
    public void welThuiswerken() {
        Data data = new Data();
        data.setWorkingFromHome(true);

        StepperState state = new StepperState(false, data);

        var step = new Thuiswerken();
        step.doStep(state, stepService);

        verify(stepService).getStepByName(KorteBroekAan.NAME);
    }

    @Test
    public void nietThuiswerken() {
        Data data = new Data();
        data.setWorkingFromHome(false);

        StepperState state = new StepperState(false, data);

        var step = new Thuiswerken();
        step.doStep(state, stepService);

        verify(stepService, times(0)).getStepByName(KorteBroekAan.NAME);
        verify(stepService, times(1)).getStepByName(LangeBroekAan.NAME);
    }
}
