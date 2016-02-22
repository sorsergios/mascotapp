package ar.com.ponele.mascotapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FireBaseRest rest = FireBaseRest.getInstance();
//        String testLost = rest.getTestLost();
//
//        final TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setText(testLost);
    }
}
