package com.randytsao.virtualdrumpad;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.content.Context;

/**
 * Created by randytsao on 8/25/17.
 */

public class DrumSample {

    VirtualPadDrumPad   parentPad;
    MediaPlayer         samplePlayer;
    int                 sampleRawId;
    String              sampleName;

    // DrumSample()
    public DrumSample (VirtualPadDrumPad pad, MediaPlayer p, int i) {
        parentPad = pad;
        samplePlayer = p;
        sampleRawId = i;
        sampleName = getSampleName(parentPad.mainContext, sampleRawId);
    }

    // setSample()
    // Configures sample settings to requested raw .wav file
    public void setSample(int requestedId) {
        sampleRawId = requestedId;
        samplePlayer = MediaPlayer.create(parentPad.mainContext, sampleRawId);
        sampleName = getSampleName(parentPad.mainContext, sampleRawId);
    }

    // getSampleName()
    // Returns string containing sample name based upon raw resource integer ID
    public static String getSampleName(Context c, int id) {
        String name, tempStr;
        int start, end;

        // Update sample button description text
        tempStr = c.getString(id);
        start = tempStr.lastIndexOf("/");
        end = tempStr.lastIndexOf(".");
        name = tempStr.substring(start + 1, end);

        return name;
    }
}
