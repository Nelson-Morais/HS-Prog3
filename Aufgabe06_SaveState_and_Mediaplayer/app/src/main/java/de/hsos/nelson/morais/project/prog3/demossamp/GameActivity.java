package de.hsos.nelson.morais.project.prog3.demossamp;

import androidx.appcompat.app.AppCompatActivity;



import android.graphics.Bitmap;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;

import android.widget.ImageButton;
import android.widget.LinearLayout;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import java.util.Timer;
import java.util.TimerTask;



public class GameActivity extends AppCompatActivity {

    ImageButton soundButton, shareButton;
    MediaPlayer mediaPlayer;

    private GameView gameView;
    private Handler handler = new Handler();
    private final static long Interval = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //setContentView(gameView);


        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        mediaPlayer = MediaPlayer.create(this, R.raw.tetrix_soundtrack);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        gameView = new GameView(this);
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.gameview);
        layout1.addView(gameView);


        turnSound();
        shareFunktion();


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                    }
                });
            }
        }, 0, 17);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void turnSound() {
        soundButton = findViewById(R.id.soundButton);
        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    soundButton.setSelected(true);
                } else {
                    mediaPlayer.start();
                    soundButton.setSelected(false);
                }
            }
        });
    }

    private void shareFunktion() {
        shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                screenSnap();
            }
        });
    }

    private void screenSnap() {

        View windowView = getWindow().getDecorView().getRootView();
        windowView.setDrawingCacheEnabled(true);

        Bitmap bitmap = Bitmap.createBitmap(windowView.getDrawingCache());
        windowView.setDrawingCacheEnabled(false);



        String filename = Environment.getExternalStorageDirectory() + "/Download/"
                + Calendar.getInstance().getTime().toString() + ".jpg";


        File file = new File(filename);


        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
