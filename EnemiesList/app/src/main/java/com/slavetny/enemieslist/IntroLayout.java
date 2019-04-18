package com.slavetny.enemieslist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

import androidx.fragment.app.Fragment;

public class IntroLayout extends AppIntro {

    private boolean firstStart = true;
    private String PREFS = "sharedPrefs";
    private String BOOL = "firstStart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation ( ActivityInfo. SCREEN_ORIENTATION_PORTRAIT );

        setColorDoneText(Color.BLACK);
        setIndicatorColor(Color.BLACK, Color.GRAY);

        loadData();

        if(firstStart) {
            SliderPage sliderPage = new SliderPage();
            sliderPage.setTitle("Pocket enemies list");
            sliderPage.setDescription("Your own list of enemies in your pocket");
            sliderPage.setTitleColor(Color.BLACK);
            sliderPage.setDescColor(Color.BLACK);
            sliderPage.setImageDrawable(R.drawable.ic_lamp);
            sliderPage.setBgColor(Color.WHITE);
            addSlide(AppIntroFragment.newInstance(sliderPage));

            SliderPage sliderPage2 = new SliderPage();
            sliderPage2.setTitle("Edit and supplement");
            sliderPage2.setDescription("Edit and supplement your list of enemies anytime, anywhere");
            sliderPage2.setTitleColor(Color.BLACK);
            sliderPage2.setDescColor(Color.BLACK);
            sliderPage2.setImageDrawable(R.drawable.ic_edit);
            sliderPage2.setBgColor(Color.WHITE);
            addSlide(AppIntroFragment.newInstance(sliderPage2));

            SliderPage sliderPage3 = new SliderPage();
            sliderPage3.setTitle("Safety first");
            sliderPage3.setDescription("Protect your list of enemies from prying eyes");
            sliderPage3.setTitleColor(Color.BLACK);
            sliderPage3.setDescColor(Color.BLACK);
            sliderPage3.setImageDrawable(R.drawable.ic_lock);
            sliderPage3.setBgColor(Color.WHITE);
            addSlide(AppIntroFragment.newInstance(sliderPage3));

            SliderPage sliderPage4 = new SliderPage();
            sliderPage4.setTitle("Export to PDF");
            sliderPage4.setDescription("Save your list of enemies in PDF format");
            sliderPage4.setTitleColor(Color.BLACK);
            sliderPage4.setDescColor(Color.BLACK);
            sliderPage4.setImageDrawable(R.drawable.ic_document);
            sliderPage4.setBgColor(Color.WHITE);
            addSlide(AppIntroFragment.newInstance(sliderPage4));

            SliderPage sliderPage5 = new SliderPage();
            sliderPage5.setTitle("Rate your enemies");
            sliderPage5.setDescription("Rate your enemy on a scale of 1 to 5 stars");
            sliderPage5.setTitleColor(Color.BLACK);
            sliderPage5.setDescColor(Color.BLACK);
            sliderPage5.setImageDrawable(R.drawable.ic_rate);
            sliderPage5.setBgColor(Color.WHITE);
            addSlide(AppIntroFragment.newInstance(sliderPage5));
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        loadData();
    }

    @Override
    public void onDonePressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        firstStart = false;
        saveData();
        this.finish();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(BOOL, true);
        editor.apply();
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        firstStart = sharedPreferences.getBoolean(BOOL, true);
    }
}
