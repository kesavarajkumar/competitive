import java.util.*;

/*
  Question Link : https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts
  
  Approach 1:
  1. Sort the cuts and find max diffrence between them
  2. compare them with end's
  3. find max area for both width and height
  4. calculate area
  
  White Paper Code
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxW = Integer.MIN_VALUE;
        int prevCut = 0;
        for(int vCut : verticalCuts) {
            maxW = Math.max(maxW, vCut - prevCut);
            prevCut = vCut;
        }
        maxW = Math.max(maxW, w - prevCut);
        
        int maxH = Integer.MIN_VALUE;
        prevCut = 0;
        for(int hCut : horizontalCuts) {
            maxH = Math.max(maxH, hCut - prevCut);
            prevCut = hCut;
        }
        maxH = Math.max(maxH, h - prevCut);
        
        return (maxW * maxH) % 100000007;
    }
    
    Mistakes
    1. Dint handle long range exceed case.
*/

class MaxAreaCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxW = Integer.MIN_VALUE;
        int prevCut = 0;
        for(int vCut : verticalCuts) {
            maxW = Math.max(maxW, vCut - prevCut);
            prevCut = vCut;
        }
        maxW = Math.max(maxW, w - prevCut);
        
        int maxH = Integer.MIN_VALUE;
        prevCut = 0;
        for(int hCut : horizontalCuts) {
            maxH = Math.max(maxH, hCut - prevCut);
            prevCut = hCut;
        }
        maxH = Math.max(maxH, h - prevCut);
        
        long ans = 1L * maxH * maxW;
        
        return  (int) (ans % 1000000007);
    }
}
