package ar.com.ponele.mascotapp.app;

import android.app.Application;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.firebase.client.Firebase;

public class Mascotapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
            getApplicationContext(),
            "ap-northeast-1:68807d1b-ec49-4282-abc8-81f7993a6329", // Identity Pool ID
            Regions.AP_NORTHEAST_1 // Region
        );
    }
}
