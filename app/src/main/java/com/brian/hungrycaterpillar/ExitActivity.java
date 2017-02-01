package com.brian.hungrycaterpillar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



/**
 * ExitActivity class to handle exiting the Application
 */
public class ExitActivity extends AppCompatActivity {

    Counter c = Counter.getInstance();

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Set count to 0.
        c.setCurrentCount(0);

        if(android.os.Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        }
        else
            finish();
    }

    public static void exitApplication(Context context)
    {
        Intent intent = new Intent(context, ExitActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

        context.startActivity(intent);
    }
}