package com.brian.hungrycaterpillar;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int currentLayout = R.layout.activity_main;
        setContentView(currentLayout);

        //Detector for Gestures
        detector = new GestureDetectorCompat(this, this);
    }


    /**
     * Starts PageActivity
     */
    private void nextPage() {
        Intent intent = new Intent(this, PageActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    /**
     * On right to left fling of a given threshold of pixels, call nextPage()
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if ((e1.getX()- e2.getX()) > 200) {
            nextPage();
            return true;
        }
        else return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);

    }
}