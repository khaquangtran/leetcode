class Node {
    Node[] links = new Node[26];

    public Node() {}

    public boolean contains(char character) {
        int charIndex = character - 'a';
        return this.links[charIndex] != null;
    }

    public void put(char character) {
        int charIndex = character - 'a';
        this.links[charIndex] = new Node();
    }

    public Node next(char character) {
        int charIndex = character - 'a';
        return this.links[charIndex];
    }
}

class Trie {
    Node rootNode = new Node();

    public void insertWord(String word) {
        Node currentNode = rootNode;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (currentNode.contains(c)) continue;

            currentNode.put(c);
            currentNode = currentNode.next(c);
        }
    }

    public boolean startsWith(String prefix) {
        Node currentNode = rootNode;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!currentNode.contains(c)) return false;

            currentNode = currentNode.next(c);
        }

        return true;
    }
}


public class Main {
    private boolean isPrefixAndSuffix(String word, String targetWord) {
        if (targetWord.length() < word.length()) return false;

        int low = 0, high = word.length() - 1, high2 = targetWord.length() - 1;

        while (low < word.length() && high >= 0) {
            if (targetWord.charAt(low) != word.charAt(low) || targetWord.charAt(high2) != word.charAt(high)) return false;

            low++;
            high--;
            high2--;
        }

        return true;
    }

    private int bruteForce(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];

            for (int j = i + 1; j < words.length; j++) {
                String comparedWord = words[j];

                if (isPrefixAndSuffix(currentWord, comparedWord)) {
                    count++;
                }
            }
        }

        return count;
    }

    private int prefixTrie(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            Trie prefixTrie = new Trie();
            Trie suffixTrie = new Trie();

            String reversedWord = new StringBuilder(words[i]).reverse().toString();

            prefixTrie.insertWord(words[i]);
            suffixTrie.insertWord(reversedWord);

            for (int j = 0; j < i; j++) {
                if (words[j].length() > words[i].length()) continue;

                String reversedComparedWord = new StringBuilder(words[j]).reverse().toString();

                if (prefixTrie.startsWith(words[j]) && suffixTrie.startsWith(reversedComparedWord)) count++;
            }
        }

        return count;
    }

    public int countPrefixSuffixPairs(String[] words) {
        // return bruteForce(words);
        return prefixTrie(words);
    }

    public static void main(String[] args) {
        Main main = new Main();

        String[] words = {"a","aba","ababa","aa"};

        System.out.println(main.countPrefixSuffixPairs(words));
    }
}