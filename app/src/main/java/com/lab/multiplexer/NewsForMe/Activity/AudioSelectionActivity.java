package com.lab.multiplexer.NewsForMe.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lab.multiplexer.NewsForMe.Activity.Adapter.SampleListAdapter;
import com.lab.multiplexer.NewsForMe.Activity.Model.Samples;
import com.lab.multiplexer.NewsForMe.R;


/**
 * A simple activity that allows the user to select a
 * chapter form "The Count of Monte Cristo" to play
 * (limited to chapters 1 - 4).
 */
public class AudioSelectionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView exampleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_selection_activity);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("FM Radio");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


         exampleList = (ListView) findViewById(R.id.selection_activity_list);
        exampleList.setAdapter(new SampleListAdapter(this, Samples.getAudioSamples()));
        exampleList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startAudioPlayerActivity(position);
    }

    private void startAudioPlayerActivity(int selectedIndex) {
        Intent intent = new Intent(this, AudioPlayerActivity.class);
        intent.putExtra(AudioPlayerActivity.EXTRA_INDEX, selectedIndex);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}