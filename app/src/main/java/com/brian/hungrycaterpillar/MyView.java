package com.brian.hungrycaterpillar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.ScaleDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;

import java.util.ArrayList;

public class MyView extends View {
    int leftPadding;
    String text;
    ArrayList<DrawableContainer> dlist;
    TextPaint tpaint;
    Context context;
    int textColor;

    public MyView(Context context, int leftPadding, String text, int textColor, ArrayList<DrawableContainer> dlist) {
        super(context);
        this.leftPadding = leftPadding;
        this.text = text;
        this.dlist = dlist;
        this.context = context;
        this.textColor = textColor;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();


        //Draw the drawables from the Drawable Container Array list onto the canvas
        for (DrawableContainer c : this.dlist) {
            c.d = new ScaleDrawable(c.d, 0, x, y).getDrawable();
            assert c.d != null;
            c.d.setBounds(c.x1,c.y1, c.x2, c.y2);
            c.d.draw(canvas);
        }

        tpaint = new TextPaint();
        tpaint.setColor(textColor);
        tpaint.setTextSize(getResources().getDimension(R.dimen.myFontSize));
        tpaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        //Draw the page text onto the canvas
        int textWidth=canvas.getWidth()-this.leftPadding;
        StaticLayout textLayout=new StaticLayout(
                text,tpaint,textWidth, Layout.Alignment.ALIGN_CENTER,1.0f,0.0f,false);
        int textHeight=textLayout.getHeight();

        float newx=(getWidth()-textWidth)/2;
        float newy=(getHeight()-textHeight);

        canvas.save();
        canvas.translate(newx,newy);
        textLayout.draw(canvas);
        canvas.restore();
        }
    }
