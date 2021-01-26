import java.util.*;
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

class Trie{
    TrieNode root;
    int findCount = 0;
    Queue <TrieNode> q = new LinkedList<TrieNode>();
    Trie(){
        this.root = new TrieNode('*');
    }
    
    void add(String s){
        s = s.toLowerCase();
        TrieNode curr = this.root;
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if(curr.children[a-97] == null)
            curr.children[a-97] = new TrieNode(a);
            
            curr = curr.children[a-97];
        }
        curr.end = true; 
    }
    
    void explore_children(TrieNode c){
        for(TrieNode child : c.children){
            if(child!=null && !child.visited){
                this.q.add(child);
                child.visited = true;
                explore_children(child);
            }
    }
    }
    
    int find(String s){
        this.findCount = 0;
        s = s.toLowerCase();
        TrieNode curr = this.root;
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if(curr.children[a-97] == null)
            break;
            
            curr = curr.children[a-97];
        }      
        explore_children(curr);
        while(!this.q.isEmpty()){
            TrieNode n = this.q.poll();
            if(n.end == true)
            this.findCount++;
        }
        return this.findCount;
    }
}