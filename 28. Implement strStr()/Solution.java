// haystack abcdsda
// needle bcd
// res = 1

// O(n^2)
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int j = 0;
        while( j + needle.length() <= haystack.length() ){
            String sub = haystack.substring(j,j+needle.length());
            if(sub.equals(needle)) return j;
            j++;
        }
        return -1;
    }
}

// o(n*h)
public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
}