public class WordDictionary {
    public class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String val = "";
    }
    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node =  root;
        for( int i = 0 ; i < word.length() ; i++){
            if( node.children[word.charAt(i) - 'a'] == null){
                node.children[word.charAt(i) - 'a'] = new TrieNode();    
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.val = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return isMatch(word.toCharArray(), 0, root);    
    }
    public boolean isMatch(char[] ch, int k , TrieNode node){
        if( k == ch.length ) return !node.val.equals("");
        if( ch[k] != '.'){
            return node.children[ch[k] - 'a'] != null && isMatch(ch, k + 1, node.children[ch[k] - 'a']);
        } else{
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (isMatch(ch, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}