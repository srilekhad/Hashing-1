// We check if strings `s` and `t` are of equal length; otherwise, return false.
// Using two hash maps (`smap` and `tmap`), we map each character from `s` to `t` and vice versa to ensure a one-to-one correspondence. 
// If at any point the mapping doesn't match the previous mapping, we return false; otherwise, we return true after checking all characters.

// time complexity: O(n) 
// We traverse the strings once, doing constant-time work per character.
// space complexity: O(1) 
// Although we use hash maps, they store at most 26 character mappings, so space is constant.



class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        HashMap<Character, Character> smap = new HashMap<>();
        HashMap<Character, Character> tmap = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if(smap.containsKey(schar))
            { 
                if(smap.get(schar)!=tchar)
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