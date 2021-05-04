/*
  Question Link : https://leetcode.com/problems/reorder-data-in-log-files
  Total Time Taken - 50 Minutes
  
  Approach 1 :
  1. Create two lists to maintain digit and letter logs spearately.
  2. Iterate the log and add in relevant list.
  3. Write a custom comparator to sort based on the question requirement.
  4. Sort the letter list with custom comparator.
  5. Merge letter and digit logs
  6. Return them as string array.
  
  Paper Code:
  public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
	List<String> letterLogs = new ArrayList<>();
	for(String log : logs) {
		if(isDigitLog(log)) {
			digitLogs.add(log);
		}
		else {
			letterLogs.add(log);
		}
	}
	Collections.sort(letterLogs, new CustomStringComparator());
	letterLogs.addAll(digitLogs);
	
	String[] result = new String[letterLogs.size()];
	int I = 0;
	for(String log : letterLogs) {
		result[I++] = log;
	}
	return result;
}

Private static boolean isDigitLog(String log) {
	String firstAfterIdentifier = log.split(“ ”)[1];
	if(firstAfterIdentifier.length() == 1 && firstAfterIdentifier.charAt(0) >= ‘0’ && firstAfterIdentifier.charAt(0) <= ‘9’ ) {
		return true;
	}
	return false;
}

Static class CustomStringComparator extends Comparable<String> {
	
	@Override
	public int compareTo(String s1, String s2) {
		String mergedS1 = getMergedLogString(s1);
		String mergedS2 = getMergedLogString(s2);
		return mergedS1.compareTo(mergedS2);
	}

	private static String getMergedLogString(String log) {
		String[] splitArr = log.split(“ “);
		String mergedString = “”;
		for(int I = 1; I < splitArr.length(); i++) {
			mergedString += splitArr[i];
		}
		mergedString += splitArr[0];
		return mergedString;
	}
}
  
  Mistakes In Paper Code:
  1. Assumed the digit log would be between 0 to 9 only and added length check.
  2. String comparator logic was misunderstood from the question. When both logs are same assumed we have to merge identifier and sort.
  3. During letter log sorting logic, i ignored the spaced but it also played a role in sorting.
  4. Every mistake was identified only with online test case. 
  5. Many submissions to this question.
  
*/

import java.util.*;

public class ReorderDataInLog {
  
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        for(String log : logs) {
            if(isDigitLog(log)) {
                digitLogs.add(log);
            }
            else {
                letterLogs.add(log);
            }
        }
        Collections.sort(letterLogs, new CustomStringComparator());
        letterLogs.addAll(digitLogs);

        String[] result = new String[letterLogs.size()];
        int i = 0;
        for(String log : letterLogs) {
            result[i++] = log;
        }
        return result;
    }

    private static boolean isDigitLog(String log) {
        String firstAfterIdentifier = log.split(" ", 2)[1];
        if(firstAfterIdentifier.charAt(0) >= '0' && firstAfterIdentifier.charAt(0) <= '9' ) {
            return true;
        }
        return false;
    }

    static class CustomStringComparator implements Comparator<String> {

        public int compare(String s1, String s2) {
            String[] s1LogData = splitIdentifiedAndLog(s1);
            String[] s2LogData = splitIdentifiedAndLog(s2);
            if(s1LogData[1].equals(s2LogData[1])) {
                return s1LogData[0].compareTo(s2LogData[0]);
            }
            return s1LogData[1].compareTo(s2LogData[1]);
        }

        private static String[] splitIdentifiedAndLog(String log) {
            String[] splitArr = log.split(" ", 2);
            String identifier = splitArr[0];
            String logWord = splitArr[1];
            return new String[] { identifier, logWord };
        }

    }
}
