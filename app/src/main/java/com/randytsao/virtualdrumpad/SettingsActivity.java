/**
 * SettingsActivity.java
 *
 *  The Settings activity is displayed when the user clicks on the "Settings"
 *  item in the toolbar. As of now, only the ability for the user to change the
 *  pad of each color is functional.
 *
 */

package com.randytsao.virtualdrumpad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import android.view.View;
import android.graphics.Color;

import java.util.ArrayList;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    List<String>            colorList;             // list containing our selection of colors
    ArrayAdapter<String>    listAdapter;

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

    // strToColor()
    // This function takes in an input string corresponding to a color and returns the
    // Android integer code
    public int strToColor(String colorStr) {
        int colorVal = 0;

        switch (colorStr) {
            case "Gray":
                colorVal = Color.LTGRAY; break;
            case "Blue":
                colorVal = Color.BLUE; break;
            case "Red":
                colorVal = Color.RED; break;
            case "Yellow":
                colorVal = Color.YELLOW; break;
            case "Black":
                colorVal = Color.BLACK; break;
            case "White":
                colorVal = Color.WHITE; break;
            default:
                colorVal = Color.LTGRAY;
        }

        return colorVal;
    }

    // onApplyButtonClicked
    // Handler for when "APPLY" button is clicked, will set pad colors to whatever is specified
    // in the spinners above the button
    public void onApplyButtonClicked(View view) {
        String selection;
        int newColor;

        // TODO: use listener to detect changes in spinners rather than updating every spinner

        // Check pad one's spinner and update it
        selection = MainDrumPadActivity.padOne.colorSpinner.getSelectedItem().toString();
        newColor = this.strToColor(selection);
        MainDrumPadActivity.padOne.setColor(newColor);

        // Check pad two's spinner and update it
        selection = MainDrumPadActivity.padTwo.colorSpinner.getSelectedItem().toString();
        newColor = this.strToColor(selection);
        MainDrumPadActivity.padTwo.setColor(newColor);

        // Check pad three's spinner and update it
        selection = MainDrumPadActivity.padThree.colorSpinner.getSelectedItem().toString();
        newColor = this.strToColor(selection);
        MainDrumPadActivity.padThree.setColor(newColor);

        // Check pad four's spinner and update it
        selection = MainDrumPadActivity.padFour.colorSpinner.getSelectedItem().toString();
        newColor = this.strToColor(selection);
        MainDrumPadActivity.padFour.setColor(newColor);

        // Check pad five's spinner and update it
        selection = MainDrumPadActivity.padFive.colorSpinner.getSelectedItem().toString();
        newColor = this.strToColor(selection);
        MainDrumPadActivity.padFive.setColor(newColor);

        // Check pad six's spinner and update it
        selection = MainDrumPadActivity.padSix.colorSpinner.getSelectedItem().toString();
        newColor = this.strToColor(selection);
        MainDrumPadActivity.padSix.setColor(newColor);
    }
}
