package com.example.yunfanchen.mathgame11;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yunfanchen on 25/2/2018.
 * Let graphics can move, zoom in, zoom out, rotate
 */
public class TouchView extends View {

    private float downX;
    private float downY;
    private float firstX;
    private float firstY;
    private OnClickListener listener;
    private boolean clickable = true;
    private float whRatio;
    private int minWidth;
    private int maxWidth;
    private int minHeight;
    private int maxHeight;

    public TouchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(Context context) {
        super(context);
    }


    @Override
    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    private float lastDis;
    private float coreX;
    private float coreY;
    private boolean doubleMove = false;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);


        if(minWidth == 0){
            //Calculate the aspect ratio
            whRatio = getWidth()*1f/getHeight();
            //The minimum width is the default width of 1/2
            // The minimum width is one-half of the default width
            minWidth = getWidth()/2;
            ViewGroup parent = (ViewGroup) getParent();
            maxWidth = parent.getWidth();//Set the maximum width is the width of the parent view

            minHeight = getHeight()/2;
            maxHeight = (int) (maxWidth / whRatio);
        }
    }

    View copyView;
    float lastRota;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstX = downX = event.getRawX();
                firstY = downY = event.getRawY();
                //Get the view of the center coordinates
                coreX = getWidth()/2+getX();
                coreY = getHeight()/2+getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //Get the number of finger touch points
                int pointerCount = event.getPointerCount();
                //Double touch event
                if(pointerCount >= 2){
                    doubleMove = true;//Finger gesture touch status
                    float distance = getSlideDis(event);
                    float spaceRotation = getRotation(event);
                    //Copy the same copyView cover to the original view
                    if(copyView == null){
                        copyView = new View(getContext());
                        copyView.setX(getX());
                        copyView.setY(getY());
                        copyView.setRotation(getRotation());
                        copyView.setBackground(getBackground());
                        copyView.setLayoutParams(new ViewGroup.LayoutParams(getWidth(), getHeight()));
                        ViewGroup parent = (ViewGroup) getParent();
                        parent.addView(copyView);
                        //Hide the original view
                        setAlpha(0);
                    }else{
                        //Zoom in and out of logic
                        int slide = (int) (lastDis - distance);
                        int slide2 = (int) (slide/whRatio);
                        ViewGroup.LayoutParams layoutParams = getLayoutParams();
                        layoutParams.width = (layoutParams.width - slide);
                        layoutParams.height = layoutParams.height - slide2;

                        if(layoutParams.width > maxWidth || layoutParams.height > maxHeight){//Judge the maximum length and width
                            layoutParams.width = maxWidth;
                            layoutParams.height = maxHeight;
                        }else if(layoutParams.width < minWidth || layoutParams.height < minHeight){
                            layoutParams.width = minWidth;
                            layoutParams.height = minHeight;
                        }

                        //When the view width changes, we want the center of this view remains the same, so you want to reset the coordinates of the x and y axes
                        setLayoutParams(layoutParams);
                        float x = coreX - getWidth() / 2;
                        float y = coreY - getHeight() / 2;
                        setX(x);
                        setY(y);
                        copyView.setX(x);
                        copyView.setY(y);

                        //The length and width of the copyView into the same size as the original view, this is to keep the visual consistency of each gesture zoom
                        ViewGroup.LayoutParams layoutParams1 = copyView.getLayoutParams();
                        layoutParams1.width = layoutParams.width;
                        layoutParams1.height = layoutParams.height;
                        copyView.setLayoutParams(layoutParams1);

                        if(lastRota != 0){
                            float f = lastRota-spaceRotation;
                            copyView.setRotation(copyView.getRotation()-f);
                        }
                    }
                    //Record this two-finger rotation degree
                    lastRota = spaceRotation;
                    //Record the distance between two fingers
                    lastDis = distance;
                }else if(!doubleMove && pointerCount == 1){//Single point move event
                    float moveX = event.getRawX();
                    float moveY = event.getRawY();
                    //According to the last coordinates, calculate the distance this finger moves
                    float slideX = moveX - downX;
                    float slideY = moveY - downY;
                    //Set view coordinates
                    setX(getX()+slideX);
                    setY(getY()+slideY);
                    //Record the coordinates of the view after moving
                    downX = moveX;
                    downY = moveY;
                }
                break;
            case MotionEvent.ACTION_UP:
                //When the fingers raised, copy parameters on the home copyView assignment back
                if(copyView != null){
                    setAlpha(1);
                    setRotation(copyView.getRotation());
                    ViewGroup parent = (ViewGroup) getParent();
                    parent.removeView(copyView);
                }

                //Initialize all parameter information
                lastRota = 0;
                copyView = null;
                doubleMove = false;
                lastDis = 0;


                float upX = event.getRawX();
                float upY = event.getRawY();
                if (Math.abs(upX - firstX) < 10 && Math.abs(upY - firstY) < 10 && clickable) {
                    if (listener != null) listener.onClick(this);//Trigger click
                }
                break;
        }
        return true;
    }

    /**
     * Get the rotation angle between the fingers
     */
    private float getRotation(MotionEvent event) {

        double deltaX = event.getX(0) - event.getX(1);
        double deltaY = event.getY(0) - event.getY(1);
        double radians = Math.atan2(deltaY, deltaX);
        return (float) Math.toDegrees(radians);
    }

    /**
     * Get the distance between your fingers
     */
    private float getSlideDis(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }
}
