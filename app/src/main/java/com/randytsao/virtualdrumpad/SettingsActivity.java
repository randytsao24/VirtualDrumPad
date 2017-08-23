package com.randytsao.virtualdrumpad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    List<String> colorList;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Set up list of colors
        colorList = new ArrayList<String>();
        colorList.add("Gray");
        colorList.add("Blue");
        colorList.add("Red");
        colorList.add("Yellow");
        colorList.add("Black");
        colorList.add("White");

        listAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item,
                colorList);
        listAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Obtain spinners and initialize choices
        MainDrumPadActivity.padOne.colorSpinner = (Spinner)findViewById(R.id.color_spinner1);
        MainDrumPadActivity.padOne.colorSpinner.setAdapter(listAdapter);

        MainDrumPadActivity.padTwo.colorSpinner = (Spinner)findViewById(R.id.color_spinner2);
        MainDrumPadActivity.padTwo.colorSpinner.setAdapter(listAdapter);

        MainDrumPadActivity.padThree.colorSpinner = (Spinner)findViewById(R.id.color_spinner3);
        MainDrumPadActivity.padThree.colorSpinner.setAdapter(listAdapter);

        MainDrumPadActivity.padFour.colorSpinner = (Spinner)findViewById(R.id.color_spinner4);
        MainDrumPadActivity.padFour.colorSpinner.setAdapter(listAdapter);

        MainDrumPadActivity.padFive.colorSpinner = (Spinner)findViewById(R.id.color_spinner5);
        MainDrumPadActivity.padFive.colorSpinner.setAdapter(listAdapter);

        MainDrumPadActivity.padSix.colorSpinner = (Spinner)findViewById(R.id.color_spinner6);
        MainDrumPadActivity.padSix.colorSpinner.setAdapter(listAdapter);
    }

    
}
