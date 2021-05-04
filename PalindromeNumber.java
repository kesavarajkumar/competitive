/*
  Question Link : https://leetcode.com/problems/palindrome-number
  
  Approach 1:
  1. Convert into string
  2. Use two pointers to traverse front, back and compare.
  
  Approach 2:
  1. If negative return false.
  2. Reverse the integer using math.
  3. check if reversed integer is equal to input.
  
  White Paper Code
  public boolean isPalindrome(int x) {
    if(x < 0) {
      return false;
    }

    int reversedX = reverseInteger(x);
    return x == reversedX;
  }

  private int reverseInteger(int number) {
    int reversedNumber = 0;
    while(number > 0) {
      reversedNumber = (reversedNumber * 10) + number % 10;
      number /= 10;
    }
    return reversedNumber;
  }
  
  Mistakes
  1. Was hesitating after writing the solution for numbers that exceed the range of intger. But that doesnt count as palindrome hence need not handle it specially.
*/

import java.util.*;

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int reversedX = reverseInteger(x);
        return x == reversedX;
    }

    private int reverseInteger(int number) {
        int reversedNumber = 0;
        while(number > 0) {
            reversedNumber = (reversedNumber * 10) + number % 10;
            number /= 10;
        }
        return reversedNumber;
    }
}
