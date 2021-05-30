package bfs;

import java.util.*;

public class WordLadder3 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        Map<String, List<String>> dictionary = new TreeMap<>();
        System.out.println(wordList.contains(beginWord));
        dictionary.put(beginWord, new ArrayList<>());
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        for (String s : wordList) {
            dictionary.put(s, new ArrayList<>());
        }
        for (Map.Entry<String, List<String>> e : dictionary.entrySet()) {
            getNeighbors(e.getKey(), wordList, dictionary);
        }
        int minDepth = getMinDepthBFS(beginWord, endWord, dictionary);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        getMinPathDFS(result, list, beginWord, endWord, minDepth, dictionary, new HashSet<>());
        return result;
    }

    public static void getNeighbors(String beginWord, List<String> wordList, Map<String, List<String>> dictionary) {
        for (int i = 0; i < beginWord.length(); i++) {
            char input[] = beginWord.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                input[i] = c;
                StringBuilder sb = new StringBuilder();
                for (char t : input) {
                    sb.append(t);
                }
                if (wordList.contains(sb.toString()) && !sb.toString().equals(beginWord)) {
                    dictionary.get(beginWord).add(sb.toString());
                }
            }
        }
    }

    public static int getMinDepthBFS(String beginWord, String endWord, Map<String, List<String>> dictionary) {
        if (beginWord.equals(endWord)) {
            return 0;
        }

        int depth = 0;
        Queue<String> depthQ = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        depthQ.add(beginWord);
        boolean found = false;
        while (!depthQ.isEmpty() && !found) {
            int size = depthQ.size();
            depth++;
            for (int i = 0; i < size; i++) {
                String s = depthQ.poll();
                if (s.equals(endWord)) {
                    found = true;
                    break;
                }
                if (!visited.contains(s)) {
                    List<String> neighbors = dictionary.get(s);
                    for (String t : neighbors) {
                        if (!visited.contains(t)) {
                            depthQ.add(t);

                        }
                    }
                    visited.add(s);
                }

            }
        }
        return depth;
    }

    public static void getMinPathDFS(List<List<String>> result, List<String> list, String beginWord, String endWord, int minDepth, Map<String, List<String>> dictionary, Set<String> visited) {

        if (list.size() > minDepth && !beginWord.equals(endWord)) {
            return;
        }

        if (list.size() <= minDepth && beginWord.equals(endWord)) {
            result.add(new ArrayList<>(list));
            return;
        }
        List<String> neighbors = dictionary.get(beginWord);
        for (String s : neighbors) {
            if (visited.contains(s)) {
                continue;
            }
            visited.add(s);
            list.add(s);
            getMinPathDFS(result, list, s, endWord, minDepth, dictionary, visited);
            int size = list.size() - 1;
            list.remove(size);
            visited.remove(s);
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
