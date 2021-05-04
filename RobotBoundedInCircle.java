/*

  Question Link - https://leetcode.com/problems/robot-bounded-in-circle/
  
  Approach 1:
  1. Keep track of the coordinate.
  2. Keep track of the direction of robot.
  3. Iterate through the commands
    a. For G - find moved coordinate with current dirction.
    b. For R,L - find new direction with currnt direction.
  4. It coordinate is at start point or it is not facing north robot is round bounded.
  
  White Paper Code
  
  public boolean isRobotBounded(String instructions) {
    int[] currentPoint = {0, 0};
    String direction = "U";
    for(char command : instructions.toCharArray()) {
      if(command == 'G') {
        currentPoint = move(currentPoint, direction);
      }
      else {
        direction = changeDirection(direction, command);
      }
    }
    return currentPoint[0] == 0 && currentPoint[1] == 0
  }

  private int move(int[] point, String direction) {
    switch(direction) {
      case "D":
        return new int[] {point[0] - 1, point[1]};
        break;
      case "U":
        return new int[] {point[0] + 1, point[1]};
        break;
      case "L":
        return new int[] {point[0], point[1] - 1};
        break;
      case "R":
        return new int[] {point[0], point[1] + 1};
        break;
    }
    throw new Exception();
  }

  private String changeDirection(String oldDirection, char command) {
    if(command == 'L') {
      switch(oldDirection) {
        case "D":
          return "R";
          break;
        case "U":
          return "U";
          break;
        case "L":
          return "D";
          break;
        case "R":
          return "U";
          break;
      }
    }
    else if(command == 'R') {
      switch(oldDirection) {
        case "D":
          return "L";
          break;
        case "U":
          return "R";
          break;
        case "L":
          return "U";
          break;
        case "R":
          return "D"
          break;
      }
    }
    throw new Exception();
  }
  
  Mistakes
  1. Dint think of using direction and point, lost thought in half way.
  2. Dint think of dirction to close the cycle.
*/

import java.util.*;

class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
      int[] currentPoint = {0, 0};
      String direction = "U";
      for(char command : instructions.toCharArray()) {
        if(command == 'G') {
            currentPoint = move(currentPoint, direction);
        }
        else {
            direction = changeDirection(direction, command);
        }
      }
    
      return (currentPoint[0] == 0 && currentPoint[1] == 0) || !direction.equals("U"); 
    }

    private int[] move(int[] point, String direction) {
        switch(direction) {
            case "D":
                return new int[] {point[0] - 1, point[1]};
                
            case "U":
                return new int[] {point[0] + 1, point[1]};
                
            case "L":
                return new int[] {point[0], point[1] - 1};
                
            case "R":
                return new int[] {point[0], point[1] + 1};
                
        }
        throw new RuntimeException();
    }

    private String changeDirection(String oldDirection, char command) {
        if(command == 'L') {
            switch(oldDirection) {
                case "D":
                    return "R";
                
                case "U":
                    return "L";
                    
                case "L":
                    return "D";
                    
                case "R":
                    return "U";
                    
            }
        }
        else if(command == 'R') {
            switch(oldDirection) {
                case "D":
                    return "L";
                    
                case "U":
                    return "R";
                    
                case "L":
                    return "U";
                    
                case "R":
                    return "D";
                    
            }
        }
        throw new RuntimeException();
    }
}
