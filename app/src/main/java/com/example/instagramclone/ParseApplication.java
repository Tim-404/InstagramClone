package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("XPzQVmrabNurjS2eRPRt0TJjP01wh4itCqSJsgJC")
                .clientKey("CfOYIZrGeyGWwlNqd15eYZ4Ha2pHjSXylWuJcJGc")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
