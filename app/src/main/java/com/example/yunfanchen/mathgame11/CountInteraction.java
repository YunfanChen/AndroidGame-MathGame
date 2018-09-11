package com.example.yunfanchen.mathgame11;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.view.View.VISIBLE;

public class CountInteraction extends AppCompatActivity {
    private SoundPool soundPool;
    private int soundID1,soundID2,soundID3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<ImageButton> list = new ArrayList<ImageButton>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_interaction_layout);

        String s = getIntent().getStringExtra("score");
        int s2 = Integer.valueOf(s).intValue()+5;
        Button score = (Button)findViewById(R.id.score);
        score.setText(s2+"");

        if(s2==0){
            Intent intent = new Intent(CountInteraction.this,SoundPlayer4Count.class);
            startService(intent);
        }
        else;

        initSound();
        //Hide tab bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        //button5: let user back to the Main page.
        ImageButton button5 = (ImageButton) findViewById(R.id.button5);
        View v1 = findViewById(R.id.button5);
        v1.getBackground().setAlpha(0);

        final ImageButton musicon = (ImageButton)findViewById(R.id.musicon);
        final ImageButton musicoff = (ImageButton)findViewById(R.id.musicoff);

        musicon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                musicoff.setVisibility(View.VISIBLE);
                musicoff.setClickable(true);
                musicon.setVisibility(View.INVISIBLE);
                musicon.setClickable(false);
                Intent intent = new Intent(CountInteraction.this,SoundPlayer4Count.class);
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
                Intent intent = new Intent(CountInteraction.this,SoundPlayer4Count.class);
                startService(intent);
            }
        });


        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CountInteraction.this,SoundPlayer4Count.class);
                stopService(intent);
                Intent intent2 = new Intent(CountInteraction.this,CountActivity.class);
                startActivity(intent2);

            }
        });
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        ImageButton e1=(ImageButton)findViewById(R.id.e1);
        ImageButton e2=(ImageButton)findViewById(R.id.e2);
        ImageButton e3=(ImageButton)findViewById(R.id.e3);
        ImageButton e4=(ImageButton)findViewById(R.id.e4);
        ImageButton e5=(ImageButton)findViewById(R.id.e5);
        ImageButton e6=(ImageButton)findViewById(R.id.e6);
        ImageButton e7=(ImageButton)findViewById(R.id.e7);
        ImageButton e8=(ImageButton)findViewById(R.id.e8);
        ImageButton e9=(ImageButton)findViewById(R.id.e9);
        ImageButton e10=(ImageButton)findViewById(R.id.e10);
        ImageButton e11=(ImageButton)findViewById(R.id.e11);
        ImageButton e12=(ImageButton)findViewById(R.id.e12);
        final Button result1=(Button)findViewById(R.id.result1);
        final Button result2=(Button)findViewById(R.id.result2);
        final Button result3=(Button)findViewById(R.id.result3);
        final Button result4=(Button)findViewById(R.id.result4);

        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);
        list.add(e7);
        list.add(e8);
        list.add(e9);
        list.add(e10);
        list.add(e11);
        list.add(e12);

        int randomOutNum = Math.abs(new Random().nextInt())%12;
        int totalNum = 12;

        for(int i = 0; i < randomOutNum;i++){
            int removeNum = Math.abs(new Random().nextInt())%list.size();
            list.get(removeNum).setVisibility(View.GONE);
            list.remove(removeNum);
            totalNum--;
        }
        final int rightNum = totalNum;

        int[] result = new int[4];
        result[0] = totalNum;
        result[1] = -1;
        result[2] = -1;
        result[3] = -1;
        int count = 1;
        while(count <= 3) {
            int num = Math.abs(new Random().nextInt())%12;
            boolean flag = true;
            for (int j = 0; j <= 3; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        shuffle(result,new Random());

        String r1 = Integer.toString(result[0]);
        String r2 = Integer.toString(result[1]);
        String r3 = Integer.toString(result[2]);
        String r4 = Integer.toString(result[3]);

        result1.setText(r1);
        result2.setText(r2);
        result3.setText(r3);
        result4.setText(r4);

        if(s2==50){

            ImageButton award = (ImageButton)findViewById(R.id.award50);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==100){
            ImageButton award = (ImageButton)findViewById(R.id.award100);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==200){
            ImageButton award = (ImageButton)findViewById(R.id.award200);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==300){
            ImageButton award = (ImageButton)findViewById(R.id.award300);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==400){
            ImageButton award = (ImageButton)findViewById(R.id.award400);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==500){
            ImageButton award = (ImageButton)findViewById(R.id.award500);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==600){
            ImageButton award = (ImageButton)findViewById(R.id.award600);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==700){
            ImageButton award = (ImageButton)findViewById(R.id.award700);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==800){
            ImageButton award = (ImageButton)findViewById(R.id.award800);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==900){
            ImageButton award = (ImageButton)findViewById(R.id.award900);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==1000){
            ImageButton award = (ImageButton)findViewById(R.id.award1000);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==1500){
            ImageButton award = (ImageButton)findViewById(R.id.award1500);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else if(s2==2000){
            ImageButton award = (ImageButton)findViewById(R.id.award2000);
            award.startAnimation(shake);
            shake.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    result1.setVisibility(View.INVISIBLE);
                    result2.setVisibility(View.INVISIBLE);
                    result3.setVisibility(View.INVISIBLE);
                    result4.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);
                    result4.setVisibility(View.VISIBLE);
                    congSound();
                }
            });
        }
        else;


        result1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(result1.getText()==Integer.toString(rightNum)){
                    ImageButton r1 =(ImageButton)findViewById(R.id.r1);
                    r1.setVisibility(View.VISIBLE);
                    result1.setEnabled(false);
                    result2.setEnabled(false);
                    result3.setEnabled(false);
                    result4.setEnabled(false);
                    wellSound();
                    Button next =(Button)findViewById(R.id.next);
                    next.setVisibility(View.VISIBLE);
                    next.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Button score = (Button)findViewById(R.id.score);
                            int s2 = Integer.valueOf(score.getText().toString()).intValue();
                            finish();
                            Intent intent = new Intent(getBaseContext(), CountInteraction.class);
                            intent.putExtra("score", String.valueOf(s2));
                            startActivity(intent);

                        }
                    });

                }else{
                    final ImageButton w1 =(ImageButton)findViewById(R.id.w1);
                    w1.setVisibility(View.VISIBLE);
                    result1.setEnabled(false);
                    result2.setEnabled(false);
                    result3.setEnabled(false);
                    result4.setEnabled(false);
                    againSound();
                    final Button again = (Button)findViewById(R.id.tryAgain);
                    again.setVisibility(View.VISIBLE);
                    again.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            result1.setEnabled(true);
                            result2.setEnabled(true);
                            result3.setEnabled(true);
                            result4.setEnabled(true);
                            w1.setVisibility(View.INVISIBLE);
                            again.setVisibility(View.INVISIBLE);

                        }
                    });
                }




            }
        });
        result2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(result2.getText()==Integer.toString(rightNum)){
                    ImageButton r2 =(ImageButton)findViewById(R.id.r2);
                    r2.setVisibility(View.VISIBLE);
                    result1.setEnabled(false);
                    result2.setEnabled(false);
                    result3.setEnabled(false);
                    result4.setEnabled(false);
                    wellSound();
                    Button next =(Button)findViewById(R.id.next);
                    next.setVisibility(View.VISIBLE);
                    next.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Button score = (Button)findViewById(R.id.score);
                            int s2 = Integer.valueOf(score.getText().toString()).intValue();
                            finish();
                            Intent intent = new Intent(getBaseContext(), CountInteraction.class);
                            intent.putExtra("score", String.valueOf(s2));
                            startActivity(intent);

                        }
                    });

                }else{
                    final ImageButton w2 =(ImageButton)findViewById(R.id.w2);
                    w2.setVisibility(View.VISIBLE);
                    result1.setEnabled(false);
                    result2.setEnabled(false);
                    result3.setEnabled(false);
                    result4.setEnabled(false);
                    againSound();
                    final Button again = (Button)findViewById(R.id.tryAgain);
                    again.setVisibility(View.VISIBLE);
                    again.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            result1.setEnabled(true);
                            result2.setEnabled(true);
                            result3.setEnabled(true);
                            result4.setEnabled(true);
                            w2.setVisibility(View.INVISIBLE);
                            again.setVisibility(View.INVISIBLE);

                        }
                    });
                }

            }
        });
        result3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(result3.getText()==Integer.toString(rightNum)){
                    ImageButton r3 =(ImageButton)findViewById(R.id.r3);
                    r3.setVisibility(View.VISIBLE);
                    result1.setEnabled(false);
                    result2.setEnabled(false);
                    result3.setEnabled(false);
                    result4.setEnabled(false);
                    wellSound();
                    Button next =(Button)findViewById(R.id.next);
                    next.setVisibility(View.VISIBLE);
                    next.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Button score = (Button)findViewById(R.id.score);
                            int s2 = Integer.valueOf(score.getText().toString()).intValue();
                            finish();
                            Intent intent = new Intent(getBaseContext(), CountInteraction.class);
                            intent.putExtra("score", String.valueOf(s2));
                            startActivity(intent);

                        }
                    });
                }else{
                    final ImageButton w3 =(ImageButton)findViewById(R.id.w3);
                    w3.setVisibility(View.VISIBLE);
                    result1.setEnabled(false);
                    result2.setEnabled(false);
                    result3.setEnabled(false);
                    result4.setEnabled(false);
                    againSound();
                    final Button again = (Button)findViewById(R.id.tryAgain);
                    again.setVisibility(View.VISIBLE);
                    again.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            result1.setEnabled(true);
                            result2.setEnabled(true);
                            result3.setEnabled(true);
                            result4.setEnabled(true);
                            w3.setVisibility(View.INVISIBLE);
                            again.setVisibility(View.INVISIBLE);

                        }
                    });
                }

            }
        });
        result4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(result4.getText()==Integer.toString(rightNum)){
                    ImageButton r4 =(ImageButton)findViewById(R.id.r4);
                    r4.setVisibility(View.VISIBLE);
                    result1.setEnabled(false);
                    result2.setEnabled(false);
                    result3.setEnabled(false);
                    result4.setEnabled(false);
                    wellSound();
                    Button next =(Button)findViewById(R.id.next);
                    next.setVisibility(View.VISIBLE);
                    next.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Button score = (Button)findViewById(R.id.score);
                            int s2 = Integer.valueOf(score.getText().toString()).intValue();
                            finish();
                            Intent intent = new Intent(getBaseContext(), CountInteraction.class);
                            intent.putExtra("score", String.valueOf(s2));
                            startActivity(intent);

                        }
                    });
                }else{
                    final ImageButton w4 =(ImageButton)findViewById(R.id.w4);
                    w4.setVisibility(View.VISIBLE);
                    result1.setEnabled(false);
                    result2.setEnabled(false);
                    result3.setEnabled(false);
                    result4.setEnabled(false);

                    final Button again = (Button)findViewById(R.id.tryAgain);
                    again.setVisibility(View.VISIBLE);
                    again.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            result1.setEnabled(true);
                            result2.setEnabled(true);
                            result3.setEnabled(true);
                            result4.setEnabled(true);
                            w4.setVisibility(View.INVISIBLE);
                            again.setVisibility(View.INVISIBLE);
                            againSound();

                        }
                    });
                }

            }
        });



    }
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID1 = soundPool.load(this, R.raw.well_done, 1);
        soundID2 = soundPool.load(this, R.raw.try_again, 1);
        soundID3 = soundPool.load(this, R.raw.cong, 1);
    }
    private void wellSound() {
        soundPool.play(
                soundID1,
                1.0f,
                1.0f,
                0,
                0,
                1
        );
    }
    private void againSound() {
        soundPool.play(
                soundID2,
                1.0f,
                1.0f,
                0,
                0,
                1
        );
    }
    private void congSound() {
        soundPool.play(
                soundID3,
                1.0f,
                1.0f,
                0,
                0,
                1
        );
    }

    // using the random get the random number
    public static  void  shuffle(int[] array, Random random){

        for(int i = array.length; i >= 1; i--){

            swap(array,i-1,random.nextInt(i));
        }
    }

    // the two number swap  in the array
    public static void swap(int[] array, int i , int j){

        int temp = array[i];

        array[i] = array[j];

        array[j] = temp;


    }

}
