package trie.e_search_engine.c_search_history_based_auto_complete;

public class Pair {
    int key;
    String value;
    //Constructor of the class
    public Pair(int key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public int getKey()
    {
        return this.key;
    }

    public String getValue()
    {
        return this.value;
    }
}
