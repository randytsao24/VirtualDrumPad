/**
 * VirtualPadDrumPad.java
 *
 *  This file contains the class declaration for VirtualPadDrumPad. This class contains the
 *  necessary methods and members for assigning a particular sample to a button on the app.
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

public class VirtualPadDrumPad {
    Button          padButton;  // button that this pad is assigned to
    MediaPlayer     padSample; // sample that the pad is assigned to
    int             sampleRawId;

    AudioAttributes sampleAttributes;
    SoundPool       soundPool;

    boolean         isLoaded;

    // Constructor
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VirtualPadDrumPad(Button b) {
        isLoaded = false;

        padButton = b;

        // *.Builder() only applicable to APIs w/ version 21 or above
        if (Build.VERSION.SDK_INT >= 21) {
            // Initialize audio attributes for sound pool
            sampleAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(sampleAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        }

        //soundPool.setVolume();
    }

    // setSample()
    // set sample to pad's sample ID
    public void setSample(int requestedId) {
        sampleRawId = requestedId;

        // check whether or not soundPool load has completed or not
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                isLoaded = true;
            }
        });
    }

    // loadSample()
    // helper function to load a sample onto the pad's sound pool

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
