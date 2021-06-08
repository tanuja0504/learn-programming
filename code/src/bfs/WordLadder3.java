package bfs;

import java.util.*;

public class WordLadder3 {
    //https://leetcode.com/problems/word-ladder-ii/discuss/1207696/Java-or-BFS%2BDFS-or-Simple-explanations-with-examples-or-Faster-than-80
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList); //for O(1) lookup
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord))
            return result;

        Map<String, Set<String>> map = new HashMap<>(); //has to be Set & not list
        bfs(beginWord, endWord, dict, map);

        List<String> list = new ArrayList<>();
        list.add(beginWord); //adding begin word in the list to start with...

        dfs(map, beginWord, endWord, result, list); //backtrack
        return result;
    }

    private static void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Set<String>> map) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        boolean isFinish = false;

        while (!q.isEmpty()) {
            int size = q.size();

            Iterator<String> itr = q.iterator();
            while (itr.hasNext()) { //IMP: To avoid looping
                dict.remove(itr.next());
            }

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                char[] chs = word.toCharArray(); //for replacing char
                for (int j = 0; j < word.length(); j++) {
                    char old = chs[j]; //hold old char

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chs[j] == c) continue; //if same char then continue
                        chs[j] = c; //for each jth pos replace char a-z and find match for potential candidate...
                        String newWord = String.valueOf(chs);

                        if (dict.contains(newWord)) {
                            if (newWord.equals(endWord))
                                isFinish = true; //to stop next level iteration
                            else
                                q.offer(newWord);
                            map.putIfAbsent(word, new HashSet<>());
                            map.get(word).add(newWord);
                        }
                    }
                    chs[j] = old; //replace back old char
                }
            }

            if (isFinish)
                return; //already got all combination of shortest path...
        }
    }

    private static void dfs(Map<String, Set<String>> map, String beginWord, String endWord, List<List<String>> result, List<String> list) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (map.get(beginWord) == null) return;

        for (String word : map.get(beginWord)) {
            list.add(word);
            dfs(map, word, endWord, result, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {

        String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};
        String beginWord = "hit";
        String endWord = "cog";
        String words1[] = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        String beginWord1 = "qa";
        String endWord1 = "sq";
        String beginWord3 = "cet";
        String endWord3 = "ism";
        String words3[] = {"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"};
        List<String> wordList = new ArrayList<>();
        for (String w : words3) {
            wordList.add(w);
        }
        System.out.println(findLadders(beginWord3, endWord3, wordList));
    }
}
