// We first check if the number of characters in `pattern` matches the number of words in string `s`; if not, we return false.
// Then, we use two hash maps to establish a one-to-one mapping from characters in `pattern` to words in `s` and vice versa. 
// If at any point the existing mapping doesn't match the current word or character, we return false; otherwise, we return true after verifying the full pattern.

// time complexity: O(n * k)
//where n is the number of words and k is the maximum length of a word (for equals and split)
// space complexity: O(n)
//for storing n entries in the two hash maps


class Solution {
    public boolean wordPattern(String pattern, String s) {

        if(pattern == null || pattern.length()==0 || s == null || s.length() == 0)
        {
            return false;
        }
        
        String[] words = s.split(" ");
        if(pattern.length()!=words.length)
        {
            return false;
        }

        HashMap<Character, String> smap = new HashMap<>();
        HashMap<String, Character> tmap = new HashMap<>();

       
        for(int i=0; i<pattern.length(); i++)
        {
            char schar = pattern.charAt(i);
            String tchar = words[i];
            if(smap.containsKey(schar))
            {
                if(!smap.get(schar).equals(tchar))
                {
                    return false;
                }
            } 
            else
            {
                smap.put(schar,tchar);
            }

            if(tmap.containsKey(tchar))
            {
                if(tmap.get(tchar)!=schar)
                {
                    return false;
                }
            } 
            else
            {
                tmap.put(tchar,schar);
            }
        }
        return true;
    }
}