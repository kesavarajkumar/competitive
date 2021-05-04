/*
  
  Question - https://leetcode.com/problems/add-binary
  
  Approach 1
  1. Use two pointers to traverse from the last.
  2. Binary addition is done and the carry for 2,3 is carried over.
  3. Sum is appended to StringBuilder
  4. Reverse of StringBuilder is returned as result.
  
  
  White Paper Code
  public String addBinary(String a, String b) {
    if(a.equals("0")) {
      return b;
    }
    if(b.equals("0")) {
      return a;
    }

    int p1 = a.length() - 1;
    int p2 = b.length() - 1;
    StringBuilder result = new StringBuilder();
    int carry = 0;
    while(p1 >= 0 || p2 >= 0) {
      int firstBit = p1 >= 0 ? a.charAt(p1) - '0' : 0;
      int secondBit = p2 >= 0 ? b.charAt(p2) - '0' : 0;
      int sum = carry + firstBit + secondBit;
      carry = sum == 3 ? 1 : sum == 2 ? 1 : 0;
      result.append(sum == 3 ? 1 : sum == 2 ? 0 : sum);
    }
    if(carry != 0) {
      result.append(carry);
    }
    return result.reverse().toString();
  }

  Mistakes Made
  1. Missed addition case for 1 + 1 + 1
  2. Missed decrementing the pointer.
  
*/

import java.util.*;

class AddBinaryString {
    public String addBinary(String a, String b) {
        if(a.equals("0")) {
            return b;
        }
        if(b.equals("0")) {
            return a;
        }

        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while(p1 >= 0 || p2 >= 0) {
            int firstBit = p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            int secondBit = p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            int sum = carry + firstBit + secondBit;
            carry = sum == 3 ? 1 : sum == 2 ? 1 : 0;
            result.append(sum == 3 ? 1 : sum == 2 ? 0 : sum);
        }
        if(carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
