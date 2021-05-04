/*

  Question Link - https://leetcode.com/problems/design-underground-system
  
  Approach 1:
  
  Two hashmaps
  1. Using two hashmap 
    a. one to store passenger checkin data
    b. second to store average data.
    
  White Paper Code
  class UndergroundSystem {

	Map<Long, Pair<String, Integer>> passengerMap;
	Map<String, Pair<Long, Long>> averageMap;

    public UndergroundSystem() {
        this.passengerMap = new HashMap<>();
        this.averageMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        passengerMap.put(id, new Pair<String, Integer>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> timePair = passengerMap.remove(id);
        String pathName = timePair.getKey() + "." + stationName;
        Integer travelTime = t - timePair.getValue();

        Pair<Long, Long> oldPair = averageMap.get(pathName);
        Pair<Long, Long> newPair;
        if(oldPair != null) {
        	int numerator = oldPair.getKey() + (t - timePair.getValue());
        	int denomination = oldPair.getValu() + 1;
        	newPair = new Pair<>(numerator, denominator);
        }
        else {
        	newPair = new Pair<>(travelTime, 1);
        }
        averageMap.put(pathName, newPair);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String pathName = startStation + "." + endStation;
       	Pair<Long, Long> averagePair = averageMap.get(pathName);
       	return averagePair.getValue()/averagePair.getKey();
    }
    
}

Mistakes
1. silly mistake while calculating average.
*/

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    Map<Integer, Pair<String, Integer>> passengerMap;
    Map<String, Pair<Integer, Integer>> averageMap;

    public UndergroundSystem() {
        this.passengerMap = new HashMap<>();
        this.averageMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        passengerMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> timePair = passengerMap.remove(id);
        String pathName = timePair.getKey() + "." + stationName;
        Integer travelTime = t - timePair.getValue();

        Pair<Integer, Integer> oldPair = averageMap.get(pathName);
        Pair<Integer, Integer> newPair;
        if(oldPair != null) {
            int numerator = oldPair.getKey() + (t - timePair.getValue());
            int denominator = oldPair.getValue() + 1;
            newPair = new Pair<>(numerator, denominator);
        }
        else {
            newPair = new Pair<>(travelTime, 1);
        }
        averageMap.put(pathName, newPair);
    }

    public double getAverageTime(String startStation, String endStation) {
        String pathName = startStation + "." + endStation;
        Pair<Integer, Integer> averagePair = averageMap.get(pathName);
        return (double) averagePair.getKey()/averagePair.getValue();
    }
}

