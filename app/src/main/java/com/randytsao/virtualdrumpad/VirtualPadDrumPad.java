/**
 * VirtualPadDrumPad.java
 *
 *  This file contains the class declaration for VirtualPadDrumPad. Each VirtualPadDrumPad
 *  in the app has a particular button and audio sample assigned to it.
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
import android.util.Log;

import android.widget.Button;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.AudioManager;
import android.media.AudioAttributes;
import android.widget.Spinner;

public class VirtualPadDrumPad {
    Button          padButton;          // button that this pad is assigned to
    Spinner         colorSpinner;       // Spinner that this pad is assigned to

    MediaPlayer     padSample;          // sample that the pad is assigned to
    int             sampleRawId;        // integer ID from res/raw
    int             color;

    AudioAttributes sampleAttributes;
    SoundPool       soundPool;

    boolean         isLoaded;

    // VirtualPadDrumPad()
    // Constructor - assigns button to pad
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VirtualPadDrumPad(Button b) {
        padButton = b;
    }

    // setSample()
    // set sample to pad's sample ID
    public void setSample(int requestedId) {
        sampleRawId = requestedId;
    }

    // setColor()
    // Sets background color of pad to specified color associated with input string
    public void setColor(String colorStr) {

    }

    // playSample()
    // Play assigned sample
    public void playSample() {

        // Check if sample is still playing, reset to beginning if so
        if (padSample.isPlaying()) {
            padSample.seekTo(0);
        } else
            padSample.start();
    }
}
