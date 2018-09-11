package com.example.yunfanchen.mathgame11;


import java.io.IOException;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by yunfanchen on 27/2/2018.
 * Music for shapes game.
 */
public class SoundPlayer4Shapes extends Service {
    private MediaPlayer mp;

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        // Start playing music
        mp.start();
        // Music playback finished event processing
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                // Loop
                try {
                    mp.start();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // An error occurred while playing music
        mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            public boolean onError(MediaPlayer mp, int what, int extra) {
                // TODO Auto-generated method stub
                // Release resources
                try {
                    mp.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return false;
            }
        });

        super.onStart(intent, startId);
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        // Initialize music resources
        try {
            // Create a MediaPlayer object
            mp = new MediaPlayer();
            mp = MediaPlayer.create(SoundPlayer4Shapes.this, R.raw.shapes);
            mp.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        super.onCreate();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        // Stop playing music and freeing resources when the service is stopped
        mp.stop();
        mp.release();

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }



}