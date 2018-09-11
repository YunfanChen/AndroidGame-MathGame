package com.example.yunfanchen.mathgame11;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by yunfanchen on 25/2/2018.
 * This is shapes game.
 */
public class ShapesActivity extends AppCompatActivity {


    private static final String TAG = "MathGame";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shapes_layout);
        //start background music for shapes game.
        Intent intent = new Intent(ShapesActivity.this,SoundPlayer4Shapes.class);
        startService(intent);
        //Hide tab bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        //button7:let user back to the Main page.
        ImageButton button7 = (ImageButton) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ShapesActivity.this,MainActivity.class);
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
                Intent intent = new Intent(ShapesActivity.this,SoundPlayer4Shapes.class);
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
                Intent intent = new Intent(ShapesActivity.this,SoundPlayer4Shapes.class);
                startService(intent);
            }
        });


        //let buttons background transparent
        View v1 = findViewById(R.id.button7);
        v1.getBackground().setAlpha(0);
        View v2 = findViewById(R.id.triangleButton);
        v2.getBackground().setAlpha(0);
        View v3 = findViewById(R.id.rectangleButton);
        v3.getBackground().setAlpha(0);
        View v4 = findViewById(R.id.circleButton);
        v4.getBackground().setAlpha(0);
        View v5 = findViewById(R.id.pentagonButton);
        v5.getBackground().setAlpha(0);
        View v6 = findViewById(R.id.squareButton);
        v6.getBackground().setAlpha(0);
        View v7 = findViewById(R.id.heartButton);
        v7.getBackground().setAlpha(0);

        ImageButton camera = (ImageButton)findViewById(R.id.camera);
        camera.getBackground().setAlpha(0);
        camera.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                Bitmap bitmap = getScreenShot(rootView);
                saveBitmap(bitmap);
                AlertDialog.Builder builder  = new AlertDialog.Builder(ShapesActivity.this);
                builder.setTitle("MathGame" ) ;
                builder.setMessage("Saved the picture successfully!" ) ;
                builder.setPositiveButton("Cool" ,  null );
                builder.show();

            }
        });

    }

    public static Bitmap getScreenShot(View view) {
        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public void saveBitmap(Bitmap bitmap) {
        File imagePath = new File(Environment.getExternalStorageDirectory() + "/Pictures/screenshot" + System.currentTimeMillis() +".png");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
        Uri localUri = Uri.fromFile(imagePath);

        Intent localIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, localUri);

        sendBroadcast(localIntent);
    }

    /**
     * When user click triangleButton, add a new triangle in this page.
     * @param v
     */
    public void onClickTriangle(View v){
        closeAll();
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        ImageButton t1 =(ImageButton)findViewById(R.id.tip_triangle);
        t1.setVisibility(View.VISIBLE);
        TouchView dog =(TouchView)findViewById(R.id.shape_dog);
        dog.startAnimation(shake);

        TouchView touchView = new TouchView(this);
        touchView.setBackgroundResource(R.mipmap.bluetriangle);
        touchView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        ViewGroup vg = (ViewGroup) v.getParent();
        vg.addView(touchView);
    }

    /**
     * When user click rectangleButton, add a new Rectangle in this page.
     * @param v
     */
    public void onClickRectangle(View v){
        closeAll();
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        ImageButton t1 =(ImageButton)findViewById(R.id.tip_rectangle);
        t1.setVisibility(View.VISIBLE);
        TouchView dog =(TouchView)findViewById(R.id.shape_dog);
        dog.startAnimation(shake);

        TouchView touchView = new TouchView(this);
        touchView.setBackgroundResource(R.mipmap.pinkrectangle);
        touchView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        ViewGroup vg = (ViewGroup) v.getParent();
        vg.addView(touchView);
    }

    /**
     * When user click circleButton, add a new Circle in this page.
     * @param v
     */
    public void onClickCircle(View v){
        closeAll();
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        ImageButton t1 =(ImageButton)findViewById(R.id.tip_circle);
        t1.setVisibility(View.VISIBLE);
        TouchView dog =(TouchView)findViewById(R.id.shape_dog);
        dog.startAnimation(shake);

        TouchView touchView = new TouchView(this);
        touchView.setBackgroundResource(R.mipmap.redcircle);
        touchView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        ViewGroup vg = (ViewGroup) v.getParent();
        vg.addView(touchView);
    }

    /**
     * When user click pentagonButton, add a new Pentagon in this page.
     * @param v
     */
    public void onClickPentagon(View v){
        closeAll();
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        ImageButton t1 =(ImageButton)findViewById(R.id.tip_pentagon);
        t1.setVisibility(View.VISIBLE);
        TouchView dog =(TouchView)findViewById(R.id.shape_dog);
        dog.startAnimation(shake);

        TouchView touchView = new TouchView(this);
        touchView.setBackgroundResource(R.mipmap.greenpentagon);
        touchView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        ViewGroup vg = (ViewGroup) v.getParent();
        vg.addView(touchView);
    }

    /**
     * When user click squareButton, add a new Square in this page.
     * @param v
     */
    public void onClickSquare(View v){
        closeAll();
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        ImageButton t1 =(ImageButton)findViewById(R.id.tip_square);
        t1.setVisibility(View.VISIBLE);
        TouchView dog =(TouchView)findViewById(R.id.shape_dog);
        dog.startAnimation(shake);

        TouchView touchView = new TouchView(this);
        touchView.setBackgroundResource(R.mipmap.orangesquare);
        touchView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        ViewGroup vg = (ViewGroup) v.getParent();
        vg.addView(touchView);
    }

    /**
     * When user click heartButton, add a new Heart in this page.
     * @param v
     */
    public void onClickHeart(View v){
        closeAll();
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        ImageButton t1 =(ImageButton)findViewById(R.id.tip_heart);
        t1.setVisibility(View.VISIBLE);
        TouchView dog =(TouchView)findViewById(R.id.shape_dog);
        dog.startAnimation(shake);

        TouchView touchView = new TouchView(this);
        touchView.setBackgroundResource(R.mipmap.yellowheart);
        touchView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        ViewGroup vg = (ViewGroup) v.getParent();
        vg.addView(touchView);
    }

    /**
     * Let the music stop when exit this page.
     */
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Intent intent = new Intent(ShapesActivity.this,SoundPlayer4Shapes.class);
        stopService(intent);
        super.onStop();
    }

    public void closeAll(){
        ImageButton t1 =(ImageButton)findViewById(R.id.tip_triangle);
        ImageButton t2 =(ImageButton)findViewById(R.id.tip_heart);
        ImageButton t3 =(ImageButton)findViewById(R.id.tip_square);
        ImageButton t4 =(ImageButton)findViewById(R.id.tip_pentagon);
        ImageButton t5 =(ImageButton)findViewById(R.id.tip_circle);
        ImageButton t6 =(ImageButton)findViewById(R.id.tip_rectangle);
        t1.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);
        t3.setVisibility(View.INVISIBLE);
        t4.setVisibility(View.INVISIBLE);
        t5.setVisibility(View.INVISIBLE);
        t6.setVisibility(View.INVISIBLE);

    }

}
