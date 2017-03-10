package fr.isep.ii3510.assignment3musiclibrary;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import fr.isep.ii3510.assignment3musiclibrary.models.Music;
import fr.isep.ii3510.assignment3musiclibrary.utils.Utilities;

public class SongActivity extends Activity {

    ArrayList<String> songs = new ArrayList<>();
    ListView lvSong;

    String bandName;
    String albumName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        lvSong = findViewById(R.id.songlist);

        albumName = Utilities.selectedAlbumName;
        bandName = Utilities.selectedBandName;

        sortSongs();
        sortList();
    }

    private void sortSongs() {
        for (Music music : Utilities.musicList) {
            if (albumName.equals(music.getAlbumName()) && bandName.equals(music.getBandName())) {
                songs.add(music.getSongName());
            }
        }
    }

    private void sortList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, songs);
        lvSong.setAdapter(adapter);
    }
}
