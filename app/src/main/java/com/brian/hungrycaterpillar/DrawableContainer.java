package com.brian.hungrycaterpillar;

import android.graphics.drawable.Drawable;

/**
 * DrawableContainer is a container for the drawable and its drawable bounds
 */
class DrawableContainer{
    int x1;
    int y1;
    int x2;
    int y2;
    Drawable d;

    /**
     * @param d Drawable
     * @param x1 Starting x
     * @param y1 Starting y
     * @param x2 Ending x
     * @param y2 Ending y
     */
    DrawableContainer(Drawable d, int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.d = d;
    }
}
