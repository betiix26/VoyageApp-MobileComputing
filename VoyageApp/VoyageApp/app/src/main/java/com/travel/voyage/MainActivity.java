package com.travel.voyage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.gson.Gson;
import com.travel.voyage.room.User;

//good one
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_TravelJournal);

        Gson gson = new Gson();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        DataManager.setLoggedInUser(gson.fromJson(preferences.getString(DataManager.LOGGED_IN_USER, ""),
                User.class), this);

        startActivity(DataManager.getLoggedInUser() != null ?
                new Intent(this, HomeActivity.class) : new Intent(this, LoginActivity.class)
        );
        finish();
    }

}