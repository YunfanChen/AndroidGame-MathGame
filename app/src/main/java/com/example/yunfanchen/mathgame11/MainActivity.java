package com.example.yunfanchen.mathgame11;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
/**
 * Created by yunfanchen on 22/2/2018.
 * This is Main page with four buttons(four functions)
 */
public class MainActivity extends AppCompatActivity {
    Dialog dia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //Hide tab bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //Set four buttons background transparent
        View v1 = findViewById(R.id.button1);
        v1.getBackground().setAlpha(0);
        View v2 = findViewById(R.id.button2);
        v2.getBackground().setAlpha(0);
        View v3 = findViewById(R.id.button3);
        v3.getBackground().setAlpha(0);
        View v4 = findViewById(R.id.button4);
        v4.getBackground().setAlpha(0);
        //button1: go to count game
        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(MainActivity.this, CountActivity.class);
                startActivity(intent2);


            }
        });
        //button2: go to shapes game
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, ShapesActivity.class);
                startActivity(intent3);

            }
        });
        //button3: go to addition game
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AdditionActivity.class);
                intent.putExtra("score", "-5");
                startActivity(intent);

            }
        });
        //button4: go to subtraction game
        ImageButton button4 = (ImageButton) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SubtractionActivity.class);
                intent.putExtra("score", "-5");
                startActivity(intent);

            }
        });

        ImageButton help = (ImageButton) findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                dia = new Dialog(context, R.style.edit_AlertDialog_style);
                dia.setContentView(R.layout.activity_start_dialog);

                ImageView imageView = (ImageView) dia.findViewById(R.id.start_img);
                imageView.setBackgroundResource(R.mipmap.intro);
                dia.show();

                dia.setCanceledOnTouchOutside(true); // Sets whether this dialog is
                Window w = dia.getWindow();
                WindowManager.LayoutParams lp = w.getAttributes();
                lp.x = 0;
                lp.y = 40;
                dia.onWindowAttributesChanged(lp);

            }
        });

    }

}
