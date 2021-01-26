class TrieNode{
    TrieNode children[];
    char data;
    boolean end;
    boolean visited;
    TrieNode(char data){
        this.children = new TrieNode[26];
        this.data = data;
    }
}
