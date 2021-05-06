/*

  Question Link : https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
  
  Approach 1:
  1. have a map to store reminders and count
  2. iterate the times
    a. check if 60 - mod is present in map and increment the count;
    b. add n % 60 into the map
    
  White Paper Code
  public int numPairsDivisibleBy60(int[] times) {
    Map<Integer, Integer> reminderVsCount = new HashMap<>();
    int result = 0;
    for(int time : times) {
      int mod60 = time % 60;
      int reminderCount = reminderVsCount.getOrDefault(60 - mod60, 0);
      result += reminderCount;
      reminderVsCount.put(mod60, reminderVsCount.getOrDefault(mod60, 0) + 1);
    } 
      return result;
  }
  
  Mistakes 
  1. Missed handling when n is 60.
 
*/

import java.util.*;

public int numPairsDivisibleBy60(int[] times) {
      Map<Integer, Integer> reminderVsCount = new HashMap<>();
      int result = 0;
      for(int time : times) {
          int mod60 = time % 60;
          int reminderCount = reminderVsCount.getOrDefault(mod60 == 0 ? 0 : 60 - mod60, 0);
          result += reminderCount;
          reminderVsCount.put(mod60, reminderVsCount.getOrDefault(mod60, 0) + 1);
      } 
      return result;
}
