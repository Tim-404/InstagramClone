package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("XPzQVmrabNurjS2eRPRt0TJjP01wh4itCqSJsgJC")
                .clientKey("CfOYIZrGeyGWwlNqd15eYZ4Ha2pHjSXylWuJcJGc")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
