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

    //Erstellen eines Mediaplayer, damit die Musik abgespielt werden kann
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

        //onclick-listener fuer wenn jemand auf den button clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Übergeben der playMusic() Methode damit die Audio abgespielt werden kann
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

    //Methode damit die Musik abgespielt wird über Mediaplayer
    private void playMusic(int currentSong) {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                //stopt die Musik und den Mediaplayer
                mediaPlayer.stop();
            }
            //wenn die musik nicht länger gespielt werden soll wird die methode aufgerufen
            //bsp: wenn eine andere Audio abgespielt werden soll
            mediaPlayer.release();
        }
        // Erstellt einen neuen MediaPlayer mit dem ausgewählten Lied
        mediaPlayer = MediaPlayer.create(MainActivity.this, currentSong);
        // Setze das aktuelle Lied
        song = currentSong;
        //startet die wiedergabe
        mediaPlayer.start();
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            // Falls ein MediaPlayer existiert und gerade spielt, wird er gestoppt und wird er frei gegeben
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            // Setzt den MediaPlayer auf null, um anzuzeigen, dass er nicht existiert
            mediaPlayer.release();
            mediaPlayer = null;
        }
        //um anzuzeigen wenn kein lied gespielt wird
        song = 0;
    }
    // Überschreibt die onDestroy-Methode, um sicherzustellen, dass der MediaPlayer freigegeben wird, wenn die Aktivität zerstört wird
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
