class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    
}

class WordDictionary {
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
        
    }
    
    public boolean match(char[] charArray, int k, TrieNode node) {
        if (k == charArray.length) {
            return node.isWord;
        }
        if (charArray[k] == '.') {
            for (int i = 0; i < node.children.length; i ++) {
                if (node.children[i] != null && match(charArray, k + 1, node.children[i])) {
                    return true;
                }
            }
        }
        else {
            return node.children[charArray[k] - 'a'] != null && match(charArray, k + 1, node.children[charArray[k] - 'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
