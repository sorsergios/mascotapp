package ar.com.ponele.mascotapp.app;

import android.app.Application;

import com.firebase.client.Firebase;

public class Mascotapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
