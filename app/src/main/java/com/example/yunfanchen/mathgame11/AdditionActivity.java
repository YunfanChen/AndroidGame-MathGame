package com.example.yunfanchen.mathgame11;

import android.content.Intent;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Random;

import static com.example.yunfanchen.mathgame11.CountInteraction.shuffle;

public class AdditionActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int soundID1,soundID2,soundID3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<ImageButton> list = new ArrayList<ImageButton>();
        ArrayList<ImageButton> list2 = new ArrayList<ImageButton>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        initSound();
        String s = getIntent().getStringExtra("score");
        int s2 = Integer.valueOf(s).intValue()+5;
        Button score = (Button)findViewById(R.id.score);
        score.setText(s2+"");

        if(s2==0){
            Intent intent = new Intent(AdditionActivity.this,SoundPlayer4Fish.class);
            startService(intent);
        }
        else;

        ImageButton button5 = (ImageButton) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(AdditionActivity.this,SoundPlayer4Fish.class);
                stopService(intent);
                Intent intent2 = new Intent(AdditionActivity.this,MainActivity.class);
                startActivity(intent2);
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
                Intent intent = new Intent(AdditionActivity.this,SoundPlayer4Fish.class);
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
                Intent intent = new Intent(AdditionActivity.this,SoundPlayer4Fish.class);
                startService(intent);
            }
        });

        ImageButton f1=(ImageButton)findViewById(R.id.f1);
        ImageButton f2=(ImageButton)findViewById(R.id.f2);
        ImageButton f3=(ImageButton)findViewById(R.id.f3);
        ImageButton f4=(ImageButton)findViewById(R.id.f4);
        ImageButton f5=(ImageButton)findViewById(R.id.f5);
        ImageButton f6=(ImageButton)findViewById(R.id.f6);
        ImageButton f7=(ImageButton)findViewById(R.id.f7);
        ImageButton f8=(ImageButton)findViewById(R.id.f8);
        ImageButton f9=(ImageButton)findViewById(R.id.f9);
        ImageButton f10=(ImageButton)findViewById(R.id.f10);
        ImageButton ff1=(ImageButton)findViewById(R.id.ff1);
        ImageButton ff2=(ImageButton)findViewById(R.id.ff2);
        ImageButton ff3=(ImageButton)findViewById(R.id.ff3);
        ImageButton ff4=(ImageButton)findViewById(R.id.ff4);
        ImageButton ff5=(ImageButton)findViewById(R.id.ff5);
        ImageButton ff6=(ImageButton)findViewById(R.id.ff6);
        ImageButton ff7=(ImageButton)findViewById(R.id.ff7);
        ImageButton ff8=(ImageButton)findViewById(R.id.ff8);
        ImageButton ff9=(ImageButton)findViewById(R.id.ff9);
        ImageButton ff10=(ImageButton)findViewById(R.id.ff10);

        final Button result1=(Button)findViewById(R.id.plus_result1);
        final Button result2=(Button)findViewById(R.id.plus_result2);
        final Button result3=(Button)findViewById(R.id.plus_result3);
        final Button result4=(Button)findViewById(R.id.plus_result4);

        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        list.add(f5);
        list.add(f6);
        list.add(f7);
        list.add(f8);
        list.add(f9);
        list.add(f10);
        list2.add(ff1);
        list2.add(ff2);
        list2.add(ff3);
        list2.add(ff4);
        list2.add(ff5);
        list2.add(ff6);
        list2.add(ff7);
        list2.add(ff8);
        list2.add(ff9);
        list2.add(ff10);

        int randomOutNum = (Math.abs(new Random().nextInt())%9)+1;
        int totalNum = 10;

        for(int i = 0; i < randomOutNum;i++){
            int removeNum = Math.abs(new Random().nextInt())%list.size();
            list.get(removeNum).setVisibility(View.INVISIBLE);
            list.remove(removeNum);
            totalNum--;
        }
        int firstNum = totalNum;

        randomOutNum = (Math.abs(new Random().nextInt())%9)+1;
        totalNum = 10;

        for(int i = 0; i < randomOutNum;i++){
            int removeNum = Math.abs(new Random().nextInt())%list2.size();
            list2.get(removeNum).setVisibility(View.INVISIBLE);
            list2.remove(removeNum);
            totalNum--;
        }
        int secondNum = totalNum;

        final int rightNum = firstNum + secondNum;

        int[] result = new int[4];
        result[0] = rightNum;
        result[1] = -1;
        result[2] = -1;
        result[3] = -1;
        int count = 1;
        while(count <= 3) {
            int num = (Math.abs(new Random().nextInt())%19)+1;
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

        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
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
                            Intent intent = new Intent(getBaseContext(), AdditionActivity.class);
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
                            Intent intent = new Intent(getBaseContext(), AdditionActivity.class);
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
                            Intent intent = new Intent(getBaseContext(), AdditionActivity.class);
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
                            Intent intent = new Intent(getBaseContext(), AdditionActivity.class);
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
                            w4.setVisibility(View.INVISIBLE);
                            again.setVisibility(View.INVISIBLE);

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
}
