package ar.com.ponele.mascotapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.widget.ProgressBar;

public class SplashActivity extends ActionBarActivity {

    private static final int SECONDS =3;
    private static final int DELAY =2;
    private static final int MILLIS = 1000;

    private ProgressBar pbProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        this.pbProgress = (ProgressBar) findViewById(R.id.pbProgress);
        this.pbProgress.setMax(SECONDS - DELAY);
        this.startAnimation();
    }

    private void startAnimation() {
        new CountDownTimer(SECONDS * MILLIS, MILLIS) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = SplashActivity.this.getProgress(millisUntilFinished);
                pbProgress.setProgress(progress);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }

    private int getProgress(long ms) {
        return (int)((SECONDS * MILLIS)-ms)/MILLIS;
    }
}
