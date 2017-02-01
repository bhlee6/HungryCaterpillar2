package com.brian.hungrycaterpillar;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import java.util.ArrayList;

class Page {

    ImageButton[] ibuttons;
    String text;
    private MyView canvasView;


    Page(){
        this.text = "";
        this.ibuttons = ibuttons;
    }

    void addButtonViews(RelativeLayout l) {
        for (ImageButton ibutton: ibuttons) {
            l.addView(ibutton);
        }
    }

    void addCanvasView(RelativeLayout l) {
        l.addView(this.canvasView);
    }

    void createcanvasView(Context c, int padding, int textColor, ArrayList<DrawableContainer> dlist) {
        this.canvasView = new MyView(c, padding, this.text, textColor, dlist);
    }
}
