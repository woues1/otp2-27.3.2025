package org.example;

public class Calculator {

    public static double calculate(double distance, double fuelConsumption){
            //TODO: calculate the fuel consumption of the car for 100 km
            double res = (100 * fuelConsumption) / distance;
            return res;
    }

}
