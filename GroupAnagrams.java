/*
  Question Link : https://leetcode.com/problems/group-anagrams/
  
  Approach :
  1. Have a map as sorted string as key and list of strings as value
  2. iterate the strings
  3. Sort them and check if already present in map if so add to list else create new entry
  4. return values as list
  
  White pape code
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramGroup = new HashMap();
    for(String string : strs) {
      String sortedString = getSortedString(string);
      List<String> groupList = anagramGroup.get(sortedString);
      if(groupList == null) {
        anagramGroup.put(sortedString, new ArrayList<>(string));
      }
      else {
        groupList.add(string);
      }
    }

	  return new ArrayList<>(groupList.values());
  }

  private String getSortedString(String string) {
    Character[] strArr = string.toCharArray();
    Arrays.sort(strArr);
    return new String(strArr);
  }
*/

import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroup = new HashMap();
        for(String string : strs) {
            String sortedString = getSortedString(string);
            List<String> groupList = anagramGroup.get(sortedString);
            if(groupList == null) {
                anagramGroup.put(sortedString, new ArrayList<>(Arrays.asList(string)));
            }
            else {
                groupList.add(string);
            }
        }

        return new ArrayList<>(anagramGroup.values());
    }

    private String getSortedString(String string) {
        char[] strArr = string.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }
}
