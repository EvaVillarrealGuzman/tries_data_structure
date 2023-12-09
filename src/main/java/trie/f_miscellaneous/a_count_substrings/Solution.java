package trie.f_miscellaneous.a_count_substrings;

class Solution {
    public static void main(String[] args) {
        int  resultTest1 = countDistinctSubStr("aabb");
        System.out.println(resultTest1);
    }

    // generate all substrings
    // by iterating in a nested loop
    static int countDistinctSubStr(String str)
    {
        Trie trie = new Trie();
        int strLen = str.length();
        if (strLen == 0)
            return 0;

        int distinctSubStrCount = 0;
        for (int i = 0; i < strLen; i++)
        {
            for (int j = i; j < strLen; j++)
            {
                //increment the distinct count
                distinctSubStrCount += trie.insertAndCount(str, i, j + 1);
            }
        }

        return distinctSubStrCount;
    }
}