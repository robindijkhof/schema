package com.example.demo;

import com.example.demo.model.Data;

public class Imperative {
    public void run(StepperState state) {
        Data data = state.data;



        if (data.getTemperature() > 20) {
            if(state.loggingEnabled) {
                System.out.println("Stap warmer dan 20");
            }

            if (data.getTemperature() > 40) {

                if(state.loggingEnabled){
                    System.out.println("Stap warmer dan 40");
                }
                doKorteBroekAan(state);

            } else if (data.isWorkDay()) {
                if(state.loggingEnabled) {
                    System.out.println("Stap werkdag");
                }

                if(data.isWorkDay()){

                    if(state.loggingEnabled) {
                        System.out.println("Stap is al vrij");
                    }
                    if(data.isAlreadyOff()){
                        doKorteBroekAan(state);
                    }else{
                        if(state.loggingEnabled) {
                            System.out.println("Stap thuiswerken");
                        }
                        if(data.isWorkingFromHome()){
                            doKorteBroekAan(state);
                        }else{
                            doLangeBroekAan(state);
                        }
                    }
                }
                else{
                    doKorteBroekAan(state);
                }

            }else {
                doKorteBroekAan(state);
            }

        }else{
            doLangeBroekAan(state);
        }

        if(state.isLoggingEnabled()){
            System.out.println("Log broek soort aan");
        }
        System.out.println("Vandaag doen we mooi de " + state.getData().getBroeksoort() + " aan");
        System.out.println("Data: " + state.getData().toString());
        System.out.println();


    }

    public static void doKorteBroekAan(StepperState state){
        state.data.setBroeksoort("Korte broek");

        if(state.loggingEnabled){
            System.out.println("Stap: korte broek aan");
        }
    }

    public static void doLangeBroekAan(StepperState state){
        state.data.setBroeksoort("Lange broek");

        if(state.loggingEnabled){
            System.out.println("Stap: lange broek aan");
        }
    }
}
