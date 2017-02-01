package com.brian.hungrycaterpillar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;


/**
 * End class is for the last page.
 */
public class End extends AppCompatActivity implements GestureDetector.OnGestureListener {

    int currentPage;
    Counter c = Counter.getInstance();
    private GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int currentLayout = R.layout.end;
        setContentView(currentLayout);

        //Button to to restart application and exit
        final ImageButton restart = (ImageButton) findViewById(R.id.restart);
        final ImageButton exit = (ImageButton) findViewById(R.id.exit);

        currentPage = c.getCurrentCount();
        detector = new GestureDetectorCompat(this, this);

        //Restart (Go to MainActivity)
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });

        //Set button to exit the application
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });
    }

    //

    //Return to the previous page
    private void prevPage() {
        Intent intent = new Intent(this, PageActivity.class);
        startActivity(intent);
    }

    //Start the at the beginning MainActivity
    private void restart() {
        c.setCurrentCount(0);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Exit the application
    private void exit(){
        ExitActivity.exitApplication(this);
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
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if ((e2.getX()- e1.getX()) > 200) {
            prevPage();
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}

