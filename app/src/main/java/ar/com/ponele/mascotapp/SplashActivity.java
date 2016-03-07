package ar.com.ponele.mascotapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import ar.com.ponele.mascotapp.dto.util.AlertMessage;
import ar.com.ponele.mascotapp.task.CheckTask;
import ar.com.ponele.mascotapp.task.ConnectionCheckTask;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar pbProgress;
    private List<CheckTask> checks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        checks = new ArrayList<>();
        checks.add(new ConnectionCheckTask(this));

        this.pbProgress = (ProgressBar) findViewById(R.id.pbProgress);
        this.pbProgress.setMax(checks.size());
    }

    @Override
    protected void onStart() {
        super.onStart();

        final SplashActivity self = this;
        new AsyncTask<CheckTask, Integer, AlertMessage>() {

            @Override
            protected void onProgressUpdate(Integer... values) {
                self.pbProgress.incrementProgressBy(values[0]);
            }

            @Override
            protected void onCancelled(AlertMessage alert) {
                new AlertDialog.Builder(self)
                        .setTitle(alert.getTitleId())
                        .setMessage(alert.getMessageId())
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                self.finish();
                            }
                        }).create().show();
            }

            @Override
            protected AlertMessage doInBackground(CheckTask... tasks) {
                AlertMessage message = null;
                for(CheckTask task: tasks) {
                    if (task.isValid()) {
                        this.publishProgress(1);
                    } else {
                        message = task.getAlertMessage();
                        this.cancel(true);
                    }
                }

                return message;
            }

            @Override
            protected void onPostExecute(AlertMessage aVoid) {
                final Intent intent = new Intent(self, MainActivity.class);
                startActivity(intent);
                self.finish();
                super.onPostExecute(aVoid);
            }
        }.execute(this.checks.toArray(new CheckTask[this.checks.size()]));

    }

}
