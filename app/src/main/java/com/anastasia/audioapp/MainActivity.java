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
    Button stop;

    MediaPlayer mediaPlayer;
    int song = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        stop = findViewById(R.id.stop);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(R.raw.eminemwithoutme);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(R.raw.oshinokoidol);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(R.raw.thechainsmokersparis);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(R.raw.sadesmoothoperator);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(R.raw.kflayhighenough);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMusic();
            }
        });
    }

    private void playMusic(int currentSong) {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(MainActivity.this, currentSong);
        song = currentSong;
        mediaPlayer.start();
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
        song = 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
