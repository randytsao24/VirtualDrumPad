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

    public static Button buttonOne;
    public static Button buttonTwo;
    public static Button buttonThree;
    public static Button buttonFour;
    public static Button buttonFive;
    public static Button buttonSix;

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

        // Configure toolbar
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

        // Set pads to existing samples
        padOne.padSample = MediaPlayer.create(this, R.raw.clap_808);
        padTwo.padSample = MediaPlayer.create(this, R.raw.kick_acoustic01);
        padThree.padSample = MediaPlayer.create(this, R.raw.hihat_acoustic01);
        padFour.padSample = MediaPlayer.create(this, R.raw.crash_acoustic);
        padFive.padSample = MediaPlayer.create(this, R.raw.openhat_acoustic01);
        padSix.padSample = MediaPlayer.create(this, R.raw.perc_tribal);



        padOne.setSample(R.raw.clap_808);
        padTwo.setSample(R.raw.kick_acoustic01);
        padThree.setSample(R.raw.hihat_acoustic01);
        padFour.setSample(R.raw.crash_acoustic);
        padFive.setSample(R.raw.openhat_acoustic01);
        padSix.setSample(R.raw.perc_tribal);
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

    // onSettingsClicked
    // Handler for Settings in toolbar being clicked.
    /*public void onSettingsClicked(View view) {

    }*/

    // onPadOneClick
    public void onPadOneClicked(View view) {
        padOne.playSample();
    }

    // onPadTwoClick
    public void onPadTwoClicked(View view) {
        padTwo.playSample();
    }

    // onPadThreeClick
    public void onPadThreeClicked(View view) {
        padThree.playSample();
    }

    // onPadFourClick
    public void onPadFourClicked(View view) {
        padFour.playSample();
    }

    // onPadFiveClick
    public void onPadFiveClicked(View view) {
        padFive.playSample();
    }

    // onPadSixClick
    public void onPadSixClicked(View view) {
        padSix.playSample();
    }

}
