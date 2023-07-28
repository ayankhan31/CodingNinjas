
class TrieNode{
    char data;
    boolean isTerminal;
    TrieNode children[];

    public TrieNode(char data){
        this.data=data;
        this.isTerminal=false;
        this.children = new TrieNode[26];
    }
}
public class Trie {

    private TrieNode root; //root of the trie.

    public Trie(){
        root = new TrieNode('\0');
    }

    private void addHelper(TrieNode root, String word){
        if(word.length()==0){
            root.isTerminal = true;
            return;
        }
        int childIndex = word.charAt(0)-'A';
        TrieNode child = root.children[childIndex];
        if(child==null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex]=child;
        }
        addHelper(child,word.substring(1));
    }
    public void add(String word){ //we should pass root in my function as well
        addHelper(root, word);
    }
    public boolean search(String word){
        return false;
    }
    public void remove(String word){
        removeHelper(root,word);
    }

    public void removeHelper(TrieNode root, String word){
        if(word.length()==0){
            root.isTerminal=false;
        }
        int childIndex = word.charAt(0)-'A';
        TrieNode child = root.children[childIndex];
        if(child==null){
            return;
        }
        removeHelper(child,word.substring(1));
    }

}
