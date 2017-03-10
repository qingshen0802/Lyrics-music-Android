package fr.isep.ii3510.assignment3musiclibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.isep.ii3510.assignment3musiclibrary.models.Music;
import fr.isep.ii3510.assignment3musiclibrary.utils.CSVFile;
import fr.isep.ii3510.assignment3musiclibrary.utils.Utilities;

public class BandActivity extends Activity {

    ArrayList<String> bands = new ArrayList<>();
    ListView lvMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band);
        lvMusic = findViewById(R.id.bandlist);
        List musicList = loadCSV();
        sortMusicList(musicList);
        sortList();
    }

    private List loadCSV() {
        InputStream inputStream = getResources().openRawResource(R.raw.library);
        CSVFile csvFile = new CSVFile(inputStream);
        List musicList = csvFile.read();
        return musicList;
    }

    private void sortMusicList(List<String[]> musicList) {
        Utilities.musicList = new ArrayList<>();
        String tempBandName = "";
        for (String[] row : musicList) {
            Music music = new Music(row);
            Utilities.musicList.add(music);
            if (!tempBandName.equals(music.getBandName())) {
                tempBandName = music.getBandName();
                bands.add(music.getBandName());
            }
        }
    }

    private void sortList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, bands);
        lvMusic.setAdapter(adapter);

        lvMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  itemValue    = (String) lvMusic.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), AlbumActivity.class);
                Utilities.selectedBandName = itemValue;
                startActivity(intent);
            }
        });
    }
}
