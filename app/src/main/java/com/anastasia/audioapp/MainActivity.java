package com.anastasia.audioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    MediaPlayer mediaPlayer;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                playMusic();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 1;
                playMusic();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 2;
                playMusic();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 3;
                playMusic();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 4;
                playMusic();
            }
        });
        
    }

    private void playMusic() {
        if(i == 0){
            mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.EminemWithoutMe);
            mediaPlayer.start();}
        else if (i ==1){
            mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.OshinoKoIdol);
            mediaPlayer.start();
        } else if (i == 2) {
            mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.TheChainsmokersParis);
            mediaPlayer.start();
        } else if (i == 3) {
            mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.SadeSmoothOperator);
            mediaPlayer.start();
        } else {
            mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.KFlayHighEnough);
            mediaPlayer.start();
        }
    }
}