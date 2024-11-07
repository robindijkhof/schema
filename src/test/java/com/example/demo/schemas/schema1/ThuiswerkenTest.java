package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.model.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ThuiswerkenTest {



    @Test
    public void welThuiswerken() {
        Data data = new Data();
        data.setWorkingFromHome(true);

        StepperState state = new StepperState(false, data);

        var step = new Thuiswerken();
        assertTrue(step.doStep(state));
    }

    @Test
    public void nietThuiswerken() {
        Data data = new Data();
        data.setWorkingFromHome(false);

        StepperState state = new StepperState(false, data);

        var step = new Thuiswerken();
        assertFalse(step.doStep(state));
    }
}
