// We convert each string to a character array, sort it, and use the sorted string as a key in a hash map to group anagrams. 
// If the key already exists, we add the original string to its corresponding list; otherwise, we create a new list. 
// Finally, we return all the grouped anagram lists as the map's values.

// Time complexity: O(N * K log K) 
// For each of the N strings, sorting takes O(K log K), where K is the maximum length of a string.

// Space complexity: O(N * K) 
// We store all strings in the hashmap grouped by sorted keys, where N is the number of strings and K is the average string length.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);
            if(map.containsKey(sorted))
            {
                 map.get(sorted).add(str);
            }
            else
            {
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(str);
            }
           
        }
        return new ArrayList<>(map.values());

    }
}