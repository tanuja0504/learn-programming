package bfs;

import java.util.*;

public class WordLadder2 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        Map<String, List<String>> dict = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        Set<String> visitedSet = new HashSet<>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();

        for (String s : wordList) {
            dict.put(s, new ArrayList<>());
            visited.put(s, false);
        }
        if (!dict.containsKey(beginWord)) {
            dict.put(beginWord, new ArrayList<>());
            visited.put(beginWord, false);
        }
        for (Map.Entry<String, List<String>> e : dict.entrySet()) {
            findNeighbor(e.getKey(), dict);
        }

        List<String> l = new ArrayList<>();
        l.add(beginWord);
        visitedSet.add(beginWord);
        helperBFS(beginWord, endWord, dict, distance);
        System.out.println(distance);
        helperDFS(beginWord, endWord, visitedSet, dict, result, l, distance);
        return result;
    }

    public static void helperBFS(String beginWord, String endWord, Map<String, List<String>> dict, Map<String, Integer> distance) {
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        distance.put(beginWord, 0);
        while (!q.isEmpty()) {
            level++;
            boolean flag = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s1 = q.poll();
                int curDistance = distance.get(s1);

                if (s1.equals(endWord)) {
                    flag = true;
                    break;
                }
                List<String> temp = dict.get(s1);
                for (String s : temp) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    q.offer(s);
                    if (!distance.containsKey(s)) {// Check if visited
                        distance.put(s, curDistance + 1);
                    }
                    visited.add(s);
                }
            }
            if (flag) {
                break;
            }
        }
        //return (flag==true)?level:0;
    }

    public static void helperDFS(String beginWord, String endWord, Set<String> visited, Map<String, List<String>> dict, List<List<String>> result, List<String> temp, Map<String, Integer> distance) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(temp));
            return;
        }

        List<String> l = dict.get(beginWord);
        for (int i = 0; i < l.size(); i++) {
            String w = l.get(i);
            if (visited.contains(w)) {
                continue;
            }
            System.out.println(w + " " + distance.get(w));
            if (distance.get(w) == distance.get(beginWord) + 1) {
                visited.add(w);
                temp.add(w);
                helperDFS(w, endWord, visited, dict, result, temp, distance);
                int size = temp.size() - 1;
                temp.remove(size);
                visited.remove(w);
            }
        }
    }

    public static void findNeighbor(String beginWord, Map<String, List<String>> dict) {

        for (int i = 0; i < beginWord.length(); i++) {
            char input[] = beginWord.toCharArray();
            char t1 = input[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == t1) {
                    continue;
                }
                input[i] = c;
                StringBuilder sb = new StringBuilder();
                for (char t : input) {
                    sb.append(t);
                }

                if (dict.containsKey(sb.toString())) {
                    dict.get(beginWord).add(new String(sb.toString()));
                }
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        String words1[] = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};

        String words2[] = {"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"};
        String words3[] = {"ion", "rev", "che", "ind", "lie", "wis", "oct", "ham", "jag", "ray", "nun", "ref", "wig", "jul", "ken", "mit", "eel", "paw", "per", "ola", "pat", "old", "maj", "ell", "irk", "ivy", "beg", "fan", "rap", "sun", "yak", "sat", "fit", "tom", "fin", "bug", "can", "hes", "col", "pep", "tug", "ump", "arc", "fee", "lee", "ohs", "eli", "nay", "raw", "lot", "mat", "egg", "cat", "pol", "fat", "joe", "pis", "dot", "jaw", "hat", "roe", "ada", "mac"};
        for (String w : words3) {
            wordList.add(w);
        }
        System.out.println(findLadders("cat", "fin", wordList));
    }
}