package com.brian.hungrycaterpillar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class PageActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    int currentPage;
    int maxpage;
    int leftPadding;
    int sx;
    int sy;
    RelativeLayout buttonl;
    RelativeLayout canvasl;
    HungryCaterpillarData hungryCaterpillar;
    Counter c = Counter.getInstance();
    private GestureDetectorCompat detector;
    private long lastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);

        //Button and Canvas Layout
        buttonl = (RelativeLayout) findViewById(R.id.buttonLayout);
        canvasl = (RelativeLayout) findViewById(R.id.canvas);

        //Get Left Margin (NO LONGER BEING USED)
        ViewGroup.MarginLayoutParams vlp = (ViewGroup.MarginLayoutParams) buttonl.getLayoutParams();
        leftPadding = vlp.leftMargin;

        //Get Screen Width and Height
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        sx = displaymetrics.widthPixels;
        sy = displaymetrics.heightPixels;


        //Get the data information for the Hungry Caterpillar
        hungryCaterpillar = new HungryCaterpillarData(this, sx, sy, leftPadding, lastClickTime);

        //Set the number of pages count
        maxpage = hungryCaterpillar.numberOfPages-1;
        currentPage = c.getCurrentCount();

        //Add the page data to the layouts
        generatePageData(hungryCaterpillar.getPagearray()[currentPage]);

        detector = new GestureDetectorCompat(this, this);
    }


    /**
     * If the current page is at the end (maxpage), start End.class, otherwise increment the
     * currentPage count and recreate the activity with the new page.
     */
    public void nextPage() {
        if (currentPage == maxpage) {
            Intent intent = new Intent(this, End.class);
            startActivity(intent);
        } else {
            currentPage++;
            c.setCurrentCount(currentPage);
            recreate();
        }
    }

    /**
     * If the current page is at the first page of the story, start MainActivity.class,
     * otherwise decrement the currentPage count and recreate the activity with the new page.
     */

    public void prevPage() {
        if (currentPage == 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            currentPage--;
            c.setCurrentCount(currentPage);
            recreate();
        }
    }

    /**
     * Add the page's canvas to the canvas layout, and the buttons to the button layout.
     * @param page The given page
     */
    public void generatePageData(Page page) {
        page.addCanvasView(canvasl);
        page.addButtonViews(buttonl);

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
     * On right to left fling of a given threshold of pixels, call nextPage().
     * On a left to right fling of a given threshold of pixels, call prevPage().
     * If the fling does not exceed the threshold of pixels, return.
     */

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if ((e1.getX()- e2.getX()) > 200) {
            nextPage();
            return true;
        }
        else if ((e2.getX()- e1.getX()) > 200) {
            prevPage();
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
