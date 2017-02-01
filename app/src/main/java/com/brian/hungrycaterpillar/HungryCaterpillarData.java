package com.brian.hungrycaterpillar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * HungryCaterpillarData contains the data regarding the HungryCaterpillar Story.
 *
 * Current implementation hardcoded data values to match emualtor: Nexus 5
 */
class HungryCaterpillarData {

    private Page[] pagearray;
    int numberOfPages =13;

    HungryCaterpillarData(Context c, int sx, int sy, int leftPadding, long lastClickTime) {

        pagearray = new Page[numberOfPages];

        ///////// BACKGROUND  DRAWABLES

        //MOON + BRANCH
        Drawable moon = ContextCompat.getDrawable(c, R.drawable.moon);
        Drawable branch = ContextCompat.getDrawable(c, R.drawable.branch);
        Drawable sun = ContextCompat.getDrawable(c, R.drawable.sun);
        Drawable grassbackground = ContextCompat.getDrawable(c, R.drawable.grassbackground);
        Drawable nightbackground = ContextCompat.getDrawable(c, R.drawable.nightbackground);

        DrawableContainer sunc = new DrawableContainer(sun, 3*sx/5, 0, 3*sx/5+sun.getIntrinsicWidth()/2,sun.getIntrinsicHeight()/2);
        DrawableContainer branchc = new DrawableContainer(branch, 0, sy / 3, sx, sy);
        DrawableContainer moonc = new DrawableContainer(moon, 3 * sx / 5, 0, 3 * sx / 5 + moon.getIntrinsicWidth()/2, moon.getIntrinsicHeight()/2);
        DrawableContainer grassb = new DrawableContainer(grassbackground, 0, 0, sx, sy);
        DrawableContainer nightb = new DrawableContainer(nightbackground, 0, 0, sx, sy);

        //Sun and background
        ArrayList<DrawableContainer> sunlist = new ArrayList<>(Arrays.asList(grassb, sunc));
        //Branch + moon + night background
        ArrayList<DrawableContainer> dlist1 = new ArrayList<>(Arrays.asList(nightb, moonc, branchc));
        //Branch + moon + grass background
        ArrayList<DrawableContainer> dlist2 = new ArrayList<>(Arrays.asList(grassb, sunc, branchc));


        //Page 1

        ImageButton egg = new ImageButton(c);
        new SetupAnimatedButton(c, egg, R.drawable.egg, R.drawable.egg, 300, 100, 100, false, false, 0, lastClickTime);
        Page p1 = new Page();
        p1.ibuttons = new ImageButton[]{egg};
        p1.text = c.getString(R.string.p1);
        p1.createcanvasView(c, leftPadding, Color.WHITE, dlist1);


        //Page 2
        ImageButton egg2 = new ImageButton(c);
        new SetupAnimatedButton(c, egg2, R.drawable.egg, R.drawable.caterpillar, 300, 100, 100, false, false, 0, lastClickTime);
        Page p2 = new Page();
        p2.ibuttons = new ImageButton[]{egg2};
        p2.text = c.getString(R.string.p2);
        p2.createcanvasView(c, leftPadding, Color.BLACK, dlist2);


        //Page 3
        ImageButton apple3 = new ImageButton(c);
        ImageButton caterpillar3 = new ImageButton(c);
        new SetupAnimatedButton(c, caterpillar3, R.drawable.caterpillar, R.drawable.caterpillar,
                300, 350, 100, false, false, 0, lastClickTime);
        new SetupAnimatedButton(c, apple3, R.drawable.apple, R.drawable.applecore,
                500, 100, 100,true, true, R.raw.bite, lastClickTime);
        Page p3 = new Page();
        p3.text = c.getString(R.string.p3);
        p3.ibuttons = new ImageButton[]{apple3, caterpillar3};
        p3.createcanvasView(c, leftPadding, Color.BLACK, sunlist);


        //Page 4
        ImageButton caterpillar4 = new ImageButton(c);
        ImageButton pear = new ImageButton(c);
        ImageButton pear2 = new ImageButton(c);
        new SetupAnimatedButton(c, caterpillar4, R.drawable.caterpillar, R.drawable.caterpillar, 5, 350, 100, false, false, 0, lastClickTime);
        new SetupAnimatedButton(c, pear, R.drawable.pear, R.drawable.peareaten, 300, 100, 100, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, pear2, R.drawable.pear, R.drawable.peareaten, 600, 100, 100, true, true, R.raw.bite, lastClickTime);
        Page p4 =new Page();
        p4.ibuttons = new ImageButton[]{caterpillar4, pear, pear2};
        p4.text = c.getString(R.string.p4);
        p4.createcanvasView(c, leftPadding, Color.BLACK, sunlist);


        //Page 5
        ImageButton caterpillar5 = new ImageButton(c);
        ImageButton plum = new ImageButton(c);
        ImageButton plum2 = new ImageButton(c);
        ImageButton plum3 = new ImageButton(c);
        new SetupAnimatedButton(c, caterpillar5, R.drawable.caterpillar, R.drawable.caterpillar, 5, 350, 100, false, false, 0, lastClickTime);
        new SetupAnimatedButton(c, plum, R.drawable.plum, R.drawable.seed, 300, 100, 100, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, plum2, R.drawable.plum, R.drawable.seed, 600, 100, 100, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, plum3, R.drawable.plum, R.drawable.seed, 900, 100, 100, true, true, R.raw.bite, lastClickTime);
        Page p5 =new Page();
        p5.ibuttons = new ImageButton[]{caterpillar5, plum, plum2, plum3};
        p5.text = c.getString(R.string.p5);
        p5.createcanvasView(c, leftPadding, Color.BLACK, sunlist);


        //Page 6
        ImageButton caterpillar6 = new ImageButton(c);
        ImageButton strawberry = new ImageButton(c);
        ImageButton strawberry2 = new ImageButton(c);
        ImageButton strawberry3 = new ImageButton(c);
        ImageButton strawberry4 = new ImageButton(c);
        new SetupAnimatedButton(c, caterpillar6, R.drawable.caterpillar, R.drawable.caterpillar, 5, 350, 100, false, false, 0, lastClickTime);
        new SetupAnimatedButton(c, strawberry, R.drawable.strawberry, R.drawable.strawberryeaten, 300, 150, 100, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, strawberry2, R.drawable.strawberry, R.drawable.strawberryeaten, 600, 150, 100, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, strawberry3, R.drawable.strawberry, R.drawable.strawberryeaten, 900, 150, 100, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, strawberry4, R.drawable.strawberry, R.drawable.strawberryeaten, 1200, 150, 100, true, true, R.raw.bite, lastClickTime);
        Page p6 =new Page();
        p6.ibuttons = new ImageButton[]{caterpillar6, strawberry, strawberry2, strawberry3,strawberry4};
        p6.text = c.getString(R.string.p6);
        p6.createcanvasView(c, leftPadding, Color.BLACK, sunlist);


        //Page 7
        ImageButton caterpillar7 = new ImageButton(c);
        ImageButton orange = new ImageButton(c);
        ImageButton orange2 = new ImageButton(c);
        ImageButton orange3 = new ImageButton(c);
        ImageButton orange4 = new ImageButton(c);
        ImageButton orange5 = new ImageButton(c);
        new SetupAnimatedButton(c, caterpillar7, R.drawable.caterpillar, R.drawable.caterpillar, 5, 350, 100, false, false, 0, lastClickTime);
        new SetupAnimatedButton(c, orange, R.drawable.orange, R.drawable.orangerind, 300, 150, 90, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, orange2, R.drawable.orange, R.drawable.orangerind, 500, 150, 90, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, orange3, R.drawable.orange, R.drawable.orangerind, 700, 150, 90, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, orange4, R.drawable.orange, R.drawable.orangerind, 900, 150, 90, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, orange5, R.drawable.orange, R.drawable.orangerind, 1100, 150, 90, true, true, R.raw.bite, lastClickTime);
        Page p7 =new Page();
        p7.ibuttons = new ImageButton[]{caterpillar7, orange, orange2, orange3,orange4, orange5};
        p7.text = c.getString(R.string.p7);
        p7.createcanvasView(c, leftPadding, Color.BLACK, sunlist);


        //Page 8
        ImageButton cake = new ImageButton(c);
        ImageButton icecream = new ImageButton(c);
        ImageButton pickle = new ImageButton(c);
        ImageButton cheese = new ImageButton(c);
        ImageButton salami = new ImageButton(c);
        ImageButton lollipop = new ImageButton(c);
        ImageButton pie = new ImageButton(c);
        ImageButton sausage = new ImageButton(c);
        ImageButton cupcake = new ImageButton(c);
        ImageButton watermelon = new ImageButton(c);
        new SetupAnimatedButton(c, cake, R.drawable.cake, R.drawable.cakeeaten, 300, 0, 70, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, icecream, R.drawable.icecream, R.drawable.icecreameaten, 600, 0, 70, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, pickle, R.drawable.pickle, R.drawable.pickleeaten, 900, 0, 70, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, watermelon, R.drawable.watermelon, R.drawable.watermeloneaten, 1200, 0, 70, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, cheese, R.drawable.cheese, R.drawable.cheeseeaten, 0, 200, 70, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, salami, R.drawable.salami, R.drawable.salamieaten, 250, 200, 70, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, lollipop, R.drawable.lollipop, R.drawable.lollipopeaten, 500, 200, 70, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, pie, R.drawable.pie, R.drawable.pieeaten, 750, 200, 70, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, sausage, R.drawable.sausage, R.drawable.sausageeaten, 1000, 200, 70, true, true, R.raw.bite, lastClickTime);
        new SetupAnimatedButton(c, cupcake, R.drawable.cupcake, R.drawable.cupcakeeaten, 1300, 200, 70, true, true, R.raw.bite, lastClickTime);
        Page p8 =new Page();
        p8.ibuttons = new ImageButton[]{cake, icecream, pickle, cheese, salami, lollipop, pie, sausage, cupcake, watermelon};
        p8.text = c.getString(R.string.p8);
        p8.createcanvasView(c, leftPadding, Color.BLACK, sunlist);


        //Page 9
        ImageButton caterpillar9 = new ImageButton(c);
        ImageButton leaf = new ImageButton(c);
        new SetupAnimatedButton(c, caterpillar9, R.drawable.caterpillar, R.drawable.caterpillar, 200, 350, 100, false, false, 0, lastClickTime);
        new SetupAnimatedButton(c, leaf, R.drawable.leaf, R.drawable.leafeaten, 600, 75, 200, true, true, R.raw.bite, lastClickTime);
        Page p9 =new Page();
        p9.ibuttons = new ImageButton[]{caterpillar9,leaf};
        p9.text = c.getString(R.string.p9);
        p9.createcanvasView(c, leftPadding, Color.BLACK, sunlist);


        //Page 10
        ImageButton caterpillar10 = new ImageButton(c);
        new SetupAnimatedButton(c, caterpillar10, R.drawable.caterpillar, R.drawable.caterpillar, 5, 75, 400, false, false, 0, lastClickTime);
        Page p10 =new Page();
        p10.ibuttons = new ImageButton[]{caterpillar10};
        p10.text = c.getString(R.string.p10);
        p10.createcanvasView(c, leftPadding, Color.BLACK, sunlist);


        //Page 11
        ImageButton coccoon = new ImageButton(c);
        new SetupAnimatedButton(c, coccoon, R.drawable.coccoon, R.drawable.coccoon, 200, -100, 300, false, false, 0, lastClickTime);
        Page p11 =new Page();
        p11.ibuttons = new ImageButton[]{coccoon};
        p11.text = c.getString(R.string.p11);
        p11.createcanvasView(c, leftPadding, Color.BLACK, dlist2);


        // Page 12
        ImageButton coccoon12 = new ImageButton(c);
        new SetupAnimatedButton(c, coccoon12, R.drawable.coccoon, R.drawable.coccoonemerge, 200, -50, 300, false, false, 0, lastClickTime);
        Page p12 =new Page();
        p12.ibuttons = new ImageButton[]{coccoon12};
        p12.text = c.getString(R.string.p12);
        p12.createcanvasView(c, leftPadding, Color.BLACK, dlist2);


        ///Page 13
        ImageButton butterfly = new ImageButton(c);
        new SetupAnimatedButton(c, butterfly, R.drawable.butterfly, R.drawable.butterfly, 400, 0, 300, false, false, 0, lastClickTime);
        Page p13 =new Page();
        p13.ibuttons = new ImageButton[]{butterfly};
        p13.text = c.getString(R.string.p13);
        p13.createcanvasView(c, leftPadding, Color.BLACK, dlist2);


        //Add Pages to array
        pagearray[0] = p1;
        pagearray[1] = p2;
        pagearray[2] = p3;
        pagearray[3] = p4;
        pagearray[4] = p5;
        pagearray[5] = p6;
        pagearray[6] = p7;
        pagearray[7] = p8;
        pagearray[8] = p9;
        pagearray[9] = p10;
        pagearray[10] = p11;
        pagearray[11] = p12;
        pagearray[12] = p13;
    }

    Page[] getPagearray() {
        return pagearray;
    }

}
