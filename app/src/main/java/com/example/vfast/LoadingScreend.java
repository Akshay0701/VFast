package com.example.vfast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingScreend extends AppCompatActivity {


    ProgressBar progressBar;
    TextView textView;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screend);
        getSupportActionBar().hide();
        //color switch
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean true1=false;
        if (prefs.getBoolean("NIGHT_MODE",true1)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        img=findViewById(R.id.img);
        img.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.fdlogo));
        progressBar=findViewById(R.id.progress_bar);
        textView=findViewById(R.id.text_view);
     //   LottieAnimationView slideImageView=(LottieAnimationView)findViewById(R.id.img);
      //  slideImageView.setSpeed(0.6f);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressBarAnimation();

    }
    private void progressBarAnimation() {
        ProgressBarAnimation progressBarAnimation=new ProgressBarAnimation(this,progressBar,textView,0f,100f);
        progressBarAnimation.setDuration(6000);
        progressBar.setAnimation(progressBarAnimation);
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }


}
