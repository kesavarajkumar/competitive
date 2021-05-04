/*
  Question Link - https://leetcode.com/problems/happy-number
  
  Approach 1:
  1. Create a set to maintain all sumOfSquares
  2. Add given number in the set.
  3. Recursively
    a. check if number is 1 -> return true
    b. compute sum of squares
    c. check number already present in set
      I) return false
    d. add number in set
    e. Go to step a.
    
  White Paper Code
  
  public boolean isHappy(int n) {
   Set<Integer> sumSquareSet = new HashSet<>();
   sumSquareSet.add(n);
   return helper(n, sumSquareSet);
}

private boolean helper(int n, Set<Integer> sumSquareSet) {
	if(n == 1) {
		return true;
	}

	int sumOfSqaures = getSumOfSqaures(n);
	if(sumSquareSet.contains(sumOfSqaures)) {
		return false;
	}
	sumSquareSet.add(sumOfSqaures);
	return helper(sumOfSqaures, sumSquareSet);
}

private int getSumOfSqaures(int n) {
	int newNumber = 0;
	while(n > 0) {
		newNumber += Math.pow(n % 10, 2);
		n /= 2;
	}
	return newNumber;
  
  Mistakes
  1. Typo mistake in the method getSumOfSquares.
  
  Approach 2: - Without extra space
  1. have 2 pointers slow, fast
  2. Using floydds cycle detection algorithm we can identify it.
  
  White Paper Code
  private void sumOfSquare(int n) {
	int sumOfSquare = 0;
	while(n > 0) {
		sumOfSquare += Math.pow(n % 10, 2);
		n /= 10;
	}
	return sumOfSquare;
}

public boolean isHappy(int n) {
   int slow = sumOfSquare(n);
   int fast = sumOfSquare(slow);
   while(fast != 1 && slow != fast) {
      slow = sumOfSquare(slow);
      fast = sumOfSquare(fast);
   }
   return fast == 1;
}

Mistake
1. Dint think of this approach
}
*/

import java.util.*

class HappyNumber {
    private int sumOfSquare(int n) {
        int sumOfSquare = 0;
        while(n > 0) {
            int d = n % 10;
            sumOfSquare += d * d;
            n /= 10;
        }
        return sumOfSquare;
    }

    public boolean isHappy(int n) {
       int slow = n;
       int fast = sumOfSquare(n);
       while(fast != 1 && slow != fast) {
          slow = sumOfSquare(slow);
          fast = sumOfSquare(sumOfSquare(fast));
       }
       return fast == 1;
    }
}
