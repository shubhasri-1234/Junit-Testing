package org.example;

import java.util.HashMap;
import java.util.Map;
public class PopulationSearch {
    public int getPopulation(String city) {
       Map<String,Integer> populationMap = null;
       int populationCount = 0;
       if(city.isEmpty()){
            throw new NullPointerException("Input shouldn't be empty");
       }
       populationMap = getPopulationCount();
       if(!populationMap.containsKey(city)){
            throw new NullPointerException("Invalid Input or City not present");
       } else {
            populationCount = populationMap.get(city);
       }       
        return populationCount;
    }

    public Map<String, Integer> getPopulationCount(){
       Map<String,Integer> populationMap = new HashMap<>();
       populationMap.put("Mumbai", 20000);
       populationMap.put("Bangalore", 40000);
       populationMap.put("Pune", 25000);
       populationMap.put("Jaipur", 35000);
       populationMap.put("Chennai", 45000);
       return populationMap;
    }
}
