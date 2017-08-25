/**
 *  MainDrumPadActivity
 *
 *  by Randy Tsao (randytsao24@gmail.com)
 *
 *  This is the main activity for the VirtualDrumPad application.
 *
 */

package com.randytsao.virtualdrumpad;

import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.graphics.Color;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.ImageView;

import android.database.sqlite.*;
import android.util.Log;
import java.util.ArrayList;
import java.lang.reflect.Field;

public class MainDrumPadActivity extends AppCompatActivity {

    // Originally wanted to use structures to hold multiple buttons/pads, decided against it
    // for clarity's sake, also don't want to have ability to hold less/more buttons and pads

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;

    public static VirtualPadDrumPad padOne;
    public static VirtualPadDrumPad padTwo;
    public static VirtualPadDrumPad padThree;
    public static VirtualPadDrumPad padFour;
    public static VirtualPadDrumPad padFive;
    public static VirtualPadDrumPad padSix;

    Toast toast;

    String[] sampleStrList;

    MenuItem sampleMenuSelectionItem;
    PopupMenu sampleMenu;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        padOne = new VirtualPadDrumPad("ONE", this, buttonOne);
        padTwo = new VirtualPadDrumPad("TWO", this, buttonTwo);
        padThree = new VirtualPadDrumPad("THREE", this, buttonThree);
        padFour = new VirtualPadDrumPad("FOUR", this, buttonFour);
        padFive = new VirtualPadDrumPad("FIVE", this, buttonFive);
        padSix = new VirtualPadDrumPad("SIX", this, buttonSix);

        // Initialize and set pads to existing samples
        // TODO: Set pads to last saved configuration
        padOne.setSample(R.raw.clap_808);
        padTwo.setSample(R.raw.kick_acoustic01);
        padThree.setSample(R.raw.hihat_acoustic01);
        padFour.setSample(R.raw.crash_acoustic);
        padFive.setSample(R.raw.openhat_acoustic01);
        padSix.setSample(R.raw.perc_tribal);

        // Initialize colors of pads to light gray
        // TODO: Set pad colors to saved configuration
        padOne.setColor(Color.GRAY);
        padTwo.setColor(Color.LTGRAY);
        padThree.setColor(Color.LTGRAY);
        padFour.setColor(Color.RED);
        padFive.setColor(Color.LTGRAY);
        padSix.setColor(Color.LTGRAY);

        toast = new Toast(getApplicationContext());

        // Set up sample list menu
        sampleStrList = getSampleList();
        initSampleMenu(buttonOne);

        // Initialize long click functionality on buttons, want to display menu of samples to
        // choose for user in event of a long click on a pad
        buttonOne.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                initSampleMenu(buttonOne);

                sampleMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        sampleMenuSelectionItem = menuItem;
                        int itemId = menuItem.getOrder();
                        String text = menuItem.toString();

                        // Update button text with new sample selection
                        buttonOne.setText("ONE\n\n" + "(" + text + ")");

                        return true;
                    }
                });

                sampleMenu.show();
                return true;
            }
        });

        buttonTwo.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                initSampleMenu(buttonTwo);

                sampleMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        sampleMenuSelectionItem = menuItem;
                        int itemId = menuItem.getOrder();
                        String text = menuItem.toString();

                        // Update button text with new sample selection
                        buttonTwo.setText("TWO\n\n" + "(" + text + ")");

                        return true;
                    }
                });

                sampleMenu.show();
                return true;
            }
        });

        buttonSix.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                initSampleMenu(buttonSix);

                sampleMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        sampleMenuSelectionItem = menuItem;
                        int itemId = menuItem.getOrder();
                        String text = menuItem.toString();

                        // Update button text with new sample selection
                        buttonSix.setText("SIX\n\n" + "(" + text + ")");

                        return true;
                    }
                });

                sampleMenu.show();
                return true;
            }
        });

        /*for (int i = 0; i < sampleStrList.length; i++) {
            Log.d("Sample name: ", sampleStrList[i]);
        } */
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

        // Check what menu item was selected
        switch (id) {
            // Switch to settings menu when "Settings" item is clicked
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                break;
            // Switch to configuration list when item is clicked
            case R.id.action_load_config:
                break;
            // Switch to configuration saving activity when item is clicked
            case R.id.action_save_config:
                break;
            default:
        }
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

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

    // getSampleList()
    // This function creates a list of Strings composed of the samples contained in res/raw.
    public String[] getSampleList() {
        Field[] rawFields = R.raw.class.getFields();
        Field tempField;

        String[] sampleList = new String[rawFields.length];

        sampleList[0] = "SAMPLE LIST";

        // Store fields from res/raw into our list of samples
        for (int i = 1; i < rawFields.length; i++) {
            tempField = rawFields[i];
            sampleList[i] = tempField.getName();
        }

        return sampleList;
    }

    // initSampleMenu()
    // This function adds all of the names of the samples into a list to be displayed to the user
    // whenever a pad configuration is requested
    public void initSampleMenu(View view) {
        sampleMenu = new PopupMenu(this, view);

        for (int i = 0; i < sampleStrList.length; i++) {
            sampleMenu.getMenu().add(sampleStrList[i]);
        }
    }
}
