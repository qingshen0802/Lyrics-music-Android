package fr.isep.ii3510.assignment3musiclibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import fr.isep.ii3510.assignment3musiclibrary.models.Music;
import fr.isep.ii3510.assignment3musiclibrary.utils.Utilities;

public class AlbumActivity extends Activity {

    ArrayList<String> albums = new ArrayList<>();
    String bandName;
    ListView lvAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        lvAlbum = findViewById(R.id.albumlist);

        bandName = Utilities.selectedBandName;
        sortAlbums(bandName);
        sortList();
    }

    private void sortAlbums(String bandName) {
        String tempAlbumName = "";
        for (Music music : Utilities.musicList) {
            if (bandName.equals(music.getBandName())) {
                if (!tempAlbumName.equals(music.getAlbumName())) {
                    tempAlbumName = music.getAlbumName();
                    albums.add(music.getAlbumName());
                }
            }
        }
    }

    private void sortList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, albums);
        lvAlbum.setAdapter(adapter);

        lvAlbum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  itemValue    = (String) lvAlbum.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), SongActivity.class);
                Utilities.selectedAlbumName = itemValue;
                startActivity(intent);
            }
        });
    }
}
