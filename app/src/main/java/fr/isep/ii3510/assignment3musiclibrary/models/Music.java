package fr.isep.ii3510.assignment3musiclibrary.models;

public class Music {
    String bandName, albumName, songName;

    public Music() {
        bandName = "";
        albumName = "";
        songName = "";
    }

    public Music(String[] music) {
        bandName = music[0];
        albumName = music[1];
        songName = music[2];
    }

    public String getBandName() {
        return bandName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getSongName() {
        return songName;
    }
}
