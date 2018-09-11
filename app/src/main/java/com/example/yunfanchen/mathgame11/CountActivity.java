package com.example.yunfanchen.mathgame11;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by yunfanchen on 25/2/2018.
 * This is count game.
 */
public class CountActivity extends AppCompatActivity {
    //button8: for the counter, the number will be shown on it.
    private Button button8;
    public int T = 0;//counter number
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.count_layout);
        //start background music for counting game.
        Intent intent = new Intent(CountActivity.this,SoundPlayer4Water.class);
        startService(intent);

        //Hide tab bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        //button5: let user back to the Main page.
        ImageButton button5 = (ImageButton) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CountActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        final ImageButton musicon = (ImageButton)findViewById(R.id.musicon);
        final ImageButton musicoff = (ImageButton)findViewById(R.id.musicoff);
        final ImageButton turnoff = (ImageButton)findViewById(R.id.turn_off);
        final ImageButton turnon = (ImageButton)findViewById(R.id.turn_on);

        musicon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                musicoff.setVisibility(View.VISIBLE);
                musicoff.setClickable(true);
                musicon.setVisibility(View.INVISIBLE);
                musicon.setClickable(false);
                turnoff.setVisibility(View.INVISIBLE);
                turnon.setVisibility(View.VISIBLE);
                Intent intent = new Intent(CountActivity.this,SoundPlayer4Water.class);
                stopService(intent);
            }
        });

        musicoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                musicoff.setVisibility(View.INVISIBLE);
                musicoff.setClickable(false);
                musicon.setVisibility(View.VISIBLE);
                musicon.setClickable(true);
                turnoff.setVisibility(View.VISIBLE);
                turnon.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(CountActivity.this,SoundPlayer4Water.class);
                startService(intent);
            }
        });



        //button5 background transparent
        View v1 = findViewById(R.id.button5);
        v1.getBackground().setAlpha(0);
        ImageButton e0 = (ImageButton) findViewById(R.id.button6);
        TranslateAnimation animation=new TranslateAnimation(-400,1000,650,650);
        animation.setRepeatCount(19);
        animation.setDuration(6000);
        e0.setAnimation(animation);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e1 = (ImageButton) findViewById(R.id.e_1);
                e1.setVisibility(View.VISIBLE);

            }

        }, 6000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e2 = (ImageButton) findViewById(R.id.e_2);
                e2.setVisibility(View.VISIBLE);

            }

        }, 12000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e3 = (ImageButton) findViewById(R.id.e_3);
                e3.setVisibility(View.VISIBLE);

            }

        }, 18000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e4 = (ImageButton) findViewById(R.id.e_4);
                e4.setVisibility(View.VISIBLE);

            }

        }, 24000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e5 = (ImageButton) findViewById(R.id.e_5);
                e5.setVisibility(View.VISIBLE);

            }

        }, 30000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e6 = (ImageButton) findViewById(R.id.e_6);
                e6.setVisibility(View.VISIBLE);

            }

        }, 36000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e7 = (ImageButton) findViewById(R.id.e_7);
                e7.setVisibility(View.VISIBLE);

            }

        }, 42000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e8 = (ImageButton) findViewById(R.id.e_8);
                e8.setVisibility(View.VISIBLE);

            }

        }, 48000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e9 = (ImageButton) findViewById(R.id.e_9);
                e9.setVisibility(View.VISIBLE);

            }

        }, 54000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e10 = (ImageButton) findViewById(R.id.e_10);
                e10.setVisibility(View.VISIBLE);

            }

        }, 60000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e12 = (ImageButton) findViewById(R.id.e_12);
                e12.setVisibility(View.VISIBLE);

            }

        }, 66000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e13 = (ImageButton) findViewById(R.id.e_13);
                e13.setVisibility(View.VISIBLE);

            }

        }, 72000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e14 = (ImageButton) findViewById(R.id.e_14);
                e14.setVisibility(View.VISIBLE);

            }

        }, 78000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e15 = (ImageButton) findViewById(R.id.e_15);
                e15.setVisibility(View.VISIBLE);

            }

        }, 84000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e16 = (ImageButton) findViewById(R.id.e_16);
                e16.setVisibility(View.VISIBLE);

            }

        }, 90000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e17 = (ImageButton) findViewById(R.id.e_17);
                e17.setVisibility(View.VISIBLE);

            }

        }, 96000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e18 = (ImageButton) findViewById(R.id.e_18);
                e18.setVisibility(View.VISIBLE);

            }

        }, 102000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e19 = (ImageButton) findViewById(R.id.e_19);
                e19.setVisibility(View.VISIBLE);

            }

        }, 108000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e20 = (ImageButton) findViewById(R.id.e_20);
                e20.setVisibility(View.VISIBLE);

            }

        }, 114000);
        new Handler().postDelayed(new Runnable(){

            public void run() {

                ImageButton e11 = (ImageButton) findViewById(R.id.e_11);
                e11.setVisibility(View.VISIBLE);

            }

        }, 120000);


        button8 = (Button)findViewById(R.id.button8);//button8: for the counter, the number will be shown on it.
        View v3 = findViewById(R.id.button8);
        v3.getBackground().setAlpha(0);//background transparent

        new Thread(new MyCountDownTimer()).start();//start a timer(delay is 6sec)

        ImageButton buttonQuestion = (ImageButton) findViewById(R.id.buttonMonkey);//Question button:make a question about counting
            View v4 = findViewById(R.id.buttonMonkey);
        v4.getBackground().setAlpha(0);//background transparent

        ImageButton countques = (ImageButton) findViewById(R.id.countBQ1);//A question image
        View v5 = findViewById(R.id.countBQ1);
        v5.getBackground().setAlpha(0);//background transparent



        buttonQuestion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(CountActivity.this, CountInteraction.class);
                intent.putExtra("score", "-5");
                startActivity(intent);
            }
        });

    }

    /**
     * Let the music stop when exit this page.
     */
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Intent intent = new Intent(CountActivity.this,SoundPlayer4Water.class);
        stopService(intent);
        super.onStop();
    }

    /**
     * A timer.
     */
    class MyCountDownTimer implements Runnable{

        @Override
        public void run() {


            while (T <= 20) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        button8.setClickable(false);
                        button8.setText(T+"");
                    }
                });
                try {
                    Thread.sleep(6000); //delay is 6sec. counter add 1 every 6 sec.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                T++;//counter add 1.
            }


        }
    }


}
