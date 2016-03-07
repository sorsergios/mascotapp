package ar.com.ponele.mascotapp.task;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import ar.com.ponele.mascotapp.R;
import ar.com.ponele.mascotapp.dto.util.AlertMessage;

public class ConnectionCheckTask implements CheckTask {

    private final Activity activity;

    public ConnectionCheckTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean isValid() {
        final ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public AlertMessage getAlertMessage() {
        return new AlertMessage(R.string.connectionFailsTitle, R.string.connectionFails);
    }
}
