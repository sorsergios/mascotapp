package ar.com.ponele.mascotapp.rest;

import com.firebase.client.Firebase;

import ar.com.ponele.mascotapp.utils.Constants;

public class FireBaseRest {

    private static FireBaseRest instance;
    private Firebase myFireBaseRef;

    private FireBaseRest() {
        this.myFireBaseRef = new Firebase(Constants.FIREBASE_URL);
    }

    public static synchronized FireBaseRest getInstance() {
        if (instance == null) {
            instance = new FireBaseRest();
        }
        return instance;
    }

    public String getTestLost() {
        return this.myFireBaseRef.child("losts").toString();
    }
}
