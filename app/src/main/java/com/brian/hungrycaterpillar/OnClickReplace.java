package com.brian.hungrycaterpillar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.ImageButton;


class OnClickReplace implements View.OnClickListener {

    private Context c;
    private ImageButton button;
    private int newImage;
    private boolean sound = false;
    private int start;
    private int soundResource;
    private boolean edible;
    long lastClickTime;

    /**
     * C
     * @param c Given Context
     * @param button The ImageButton
     * @param newImage The new image location that will replace the current ImageButton
     * @param edible True if its an edible, false otherwise
     * @param sound True if the button has a sound, false otherwise
     * @param soundResource Sound location to play
     */
    OnClickReplace(Context c, ImageButton button, int newImage, boolean edible, boolean sound, int soundResource, long lastClickTime){
        this.button = button;
        this.newImage = newImage;
        this.c = c;
        this.sound = sound;
        this.soundResource = soundResource;
        this.edible = edible;
        this.lastClickTime = lastClickTime;
        //Starting x position
        start = Math.round(button.getX());
    }

    @Override
    public void onClick(View v) {
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000){
            return;
        }

        lastClickTime = SystemClock.elapsedRealtime();
        /*
        If the button sound is (true), play sound file.  Animate object.
        * */
        if (sound) {
        MediaPlayer mp = MediaPlayer.create(c, soundResource);
        mp.start();
        }

        //Animate button to oscillate between the starting position
        ValueAnimator animator = ValueAnimator.ofFloat(start-15,start+15);
        animator.setDuration(600);
        animator.setInterpolator(new CycleInterpolator(3));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                button.setTranslationX(((Float) animation.getAnimatedValue()) + 30);
            }
        });

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                button.setImageResource(newImage);
                //Can change other parameters here if the Button is an edible, sound, etc.
                if (edible){
                    sound = false;
                }
            }
        });
        animator.start();
    }
}