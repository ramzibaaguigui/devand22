package com.devfest.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.devfest.R;

public class MainActivity extends AppCompatActivity {
    private int currentIndex = 0;
    private static final int WINDOW_COUNT = 3;

    private LinearLayout bulletContainer;
    private LinearLayout bulletActiveContainer;
    private Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
    }

    private void assignViews() {
        bulletContainer = findViewById(R.id.container_selector_bullets);
        bulletActiveContainer = findViewById(R.id.container_selector_bullets_selected);
        nextButton = findViewById(R.id.button_login);
    }

    private int[] getImagesIds() {
        int[] ids = new int[bulletContainer.getChildCount()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = bulletContainer.getChildAt(i).getId();
        }
        return ids;
    }

    private int[] getActiveBulletsIds() {
        int[] ids = new int[bulletActiveContainer.getChildCount()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = bulletActiveContainer.getChildAt(i).getId();
        }
        return ids;
    }

    private void nextWindow() {
        currentIndex++;
        if (currentIndex == WINDOW_COUNT) {
            nextActivity();
            finish();
        } else {
            enable(currentIndex);
        }
    }

    private void enable(int index) {
        for (int i = 0; i< bulletActiveContainer.getChildCount(); i++) {
            findViewById(getActiveBulletsIds()[i]).setVisibility(index == i? View.VISIBLE : View.INVISIBLE);
        }
    }

    private void nextActivity() {

    }

}