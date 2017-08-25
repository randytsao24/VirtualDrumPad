/**
 * VirtualPadDrumPad.java
 *
 *  This file contains the class declaration for VirtualPadDrumPad. Each VirtualPadDrumPad
 *  in the app has a particular button and audio sample assigned to it.
 *
 */

package com.randytsao.virtualdrumpad;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.content.Context;

import android.widget.Button;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.AudioAttributes;
import android.widget.Spinner;
import android.graphics.Color;
import android.graphics.PorterDuff;

public class VirtualPadDrumPad {
    Button          padButton;          // button that this pad is assigned to
    Spinner         colorSpinner;       // Spinner that this pad is assigned to
    Context         mainContext;        // interface to main activity
    int             padIndexStr;           // index that pad is assigned to

    DrumSample      sample;
    MediaPlayer     padSample;          // sample that the pad is assigned to
    String          sampleName;         // sample name in String format
    int             sampleRawId;        // integer ID from res/raw

    // VirtualPadDrumPad()
    // Constructor for VirtualDrumPad
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VirtualPadDrumPad(int index, Context c, Button b) {
        MediaPlayer padSample;

        // Assign index
        padIndexStr = index;

        // Get context for main activity
        mainContext = c;

        // Assign button
        padButton = b;

        // Instantiate basic MediaPlayer object for padSample
        padSample = MediaPlayer.create(c, R.raw.kick_acoustic01);
        sample = new DrumSample(this, padSample, R.raw.kick_acoustic01);
    }

    // setSample()
    // Sets sample to pad's sample ID
    public void setSample(int requestedId) {
        // Change assigned sample to requested sample
        sample.setSample(requestedId);
    }

    // setPadText()
    // Sets button's text to specified string
    public void setPadText(String newText) {
        padButton.setText(newText);
    }

    // setColor()
    // Sets background color of pad to specified color associated with input string
    public void setColor(int colorVal) {
        padButton.getBackground().setColorFilter(colorVal, PorterDuff.Mode.SRC_OVER);

        // Change text color to white if color is blue or black
        if (colorVal == Color.BLUE || colorVal == Color.BLACK)
            padButton.setTextColor(Color.WHITE);
         else
            padButton.setTextColor(Color.BLACK);
    }

    // playSample()
    // Play assigned sample, called when a short pad click is detected
    public void playSample() {

        // Check if sample is still playing, reset to beginning if so
        if (sample.samplePlayer.isPlaying()) {
            sample.samplePlayer.seekTo(0);
        } else
            sample.samplePlayer.start();
    }
}
