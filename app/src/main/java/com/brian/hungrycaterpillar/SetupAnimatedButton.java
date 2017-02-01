package com.brian.hungrycaterpillar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Sets up the basic functionality of an animated button
 */
class SetupAnimatedButton {

    SetupAnimatedButton(Context c, ImageButton button, int image, int replaceImage,
                               int x, int y, int width, boolean edible, boolean sound, int soundResource, long lastClickTime) {

        button.setImageResource(image);
        button.setX(x);
        button.setY(y);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);


        Drawable dimage = ContextCompat.getDrawable(c, image);
        int intrinsicwidth = Math.round(dimage.getIntrinsicWidth());
        int intrinsicheight = Math.round(dimage.getIntrinsicHeight());


        final float scale = c.getResources().getDisplayMetrics().density;
        int pixelswidth = Math.round((width * scale + 0.5f));

        int height = Math.round((intrinsicheight* pixelswidth)/ intrinsicwidth);

        params.width=pixelswidth;
        params.height=2*height;
        button.setLayoutParams(params);

        button.setBackgroundColor(Color.TRANSPARENT);
        button.setScaleType(ImageView.ScaleType.FIT_XY);
        button.setAdjustViewBounds(true);
        button.setOnClickListener(new OnClickReplace(c, button, replaceImage, edible, sound, soundResource, lastClickTime));
    }
}