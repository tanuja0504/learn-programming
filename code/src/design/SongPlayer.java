package design;

import java.util.*;


class SongItem {
    String song;
    int count;

    SongItem(String s1) {
        song = s1;
        count = 0;
    }

}

class SongItemComparator implements Comparator<SongItem> {

    public int compare(SongItem o1, SongItem o2) {
        return Integer.compare(o1.count, o2.count);
    }
}

public class SongPlayer {
    Map<String, TreeSet<SongItem>> playList;

    SongPlayer() {
        playList = new HashMap<>();
        SongItem song1 = new SongItem("TestA1");
        SongItem song2 = new SongItem("TestA2");
        SongItem song3 = new SongItem("TestA3");
        SongItem song4 = new SongItem("TestA4");
        SongItem song5 = new SongItem("TestB1");
        SongItem song6 = new SongItem("TestB2");
        SongItem song7 = new SongItem("TestB3");
        SongItem song8 = new SongItem("TestB4");
        playList.put("A", new TreeSet<>(new SongItemComparator()));
        playList.get("A").add(song1);
        playList.get("A").add(song2);
        playList.get("A").add(song3);
        playList.get("A").add(song4);

        playList.put("B", new TreeSet<>(new SongItemComparator()));
        playList.get("B").add(song5);
        playList.get("B").add(song6);
        playList.get("B").add(song7);
        playList.get("B").add(song8);
    }

    public String playSong(String artist, String song) {
        TreeSet<SongItem> s = playList.get(artist);
        for (SongItem s1 : s) {
            if (s1.song.equals(song)) {
                s1.count++;
                break;
            }
        }


        playList.put(artist, s);

        for (SongItem s1 : s) {
            System.out.println(s1.song + " " + s1.count);
        }

        return song;
    }

    public String getTopSong(String artist) {
        return playList.get(artist).last().song;
    }

    public static void main(String[] args) {
        SongPlayer obj = new SongPlayer();

        obj.playSong("A", "TestA2");
        obj.playSong("A", "TestA2");
        obj.playSong("A", "TestA2");

        System.out.println("Top Song" + obj.getTopSong("A"));
    }
}
