/**
 *  MainDrumPadActivity
 *
 *
 */

package com.randytsao.virtualdrumpad;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.AudioManager;
import android.widget.Button;

import android.database.sqlite.*;

public class MainDrumPadActivity extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;

    private VirtualPadDrumPad padOne;
    private VirtualPadDrumPad padTwo;
    private VirtualPadDrumPad padThree;
    private VirtualPadDrumPad padFour;
    private VirtualPadDrumPad padFive;
    private VirtualPadDrumPad padSix;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        // Set title of our app
        setTitle("Virtual Drum Pad");

        // Initialize our buttons
        buttonOne = (Button)findViewById(R.id.padOne);
        buttonTwo = (Button)findViewById(R.id.padTwo);
        buttonThree = (Button)findViewById(R.id.padThree);
        buttonFour = (Button)findViewById(R.id.padFour);
        buttonFive = (Button)findViewById(R.id.padFive);
        buttonSix = (Button)findViewById(R.id.padSix);

        // Assign buttons to virtual drum pads
        padOne = new VirtualPadDrumPad(buttonOne);
        padTwo = new VirtualPadDrumPad(buttonTwo);
        padThree = new VirtualPadDrumPad(buttonThree);
        padFour = new VirtualPadDrumPad(buttonFour);
        padFive = new VirtualPadDrumPad(buttonFive);
        padSix = new VirtualPadDrumPad(buttonSix);

        // TEMP: test .wav file playback on hardcoded samples
        padOne.padSample = MediaPlayer.create(this, R.raw.clap_808);
        padTwo.padSample = MediaPlayer.create(this, R.raw.kick_acoustic01);

        padOne.setSample(R.raw.clap_808);
        padTwo.setSample(R.raw.kick_acoustic01);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // onPadOneClick
    public void onPadOneClick(View view) {
        padOne.playSample();
    }

    // onPadTwoClick
    public void onPadTwoClick(View view) {
        padTwo.playSample();
    }

    // onPadThreeClick
    public void onPadThreeClick(View view) {

    }

    // onPadFourClick
    public void onPadFourClick(View view) {

    }

    // onPadFiveClick
    public void onPadFiveClick(View view) {

    }

    // onPadSixClick
    public void onPadSixClick(View view) {

    }

}
