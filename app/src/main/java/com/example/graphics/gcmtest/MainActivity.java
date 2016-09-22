package com.example.graphics.gcmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;

public class MainActivity extends AppCompatActivity {

    private GcmNetworkManager mGcmNetworkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGcmNetworkManager = GcmNetworkManager.getInstance(this);

//        Task task = new OneoffTask.Builder()
//                .setService(GCMTaskService.class)
//                .setExecutionWindow(0, 30)
//                .setTag("Caller_id_videos")
//                .setUpdateCurrent(false)
//                .setRequiredNetwork(Task.NETWORK_STATE_CONNECTED)
//                .setRequiresCharging(false)
//                .build();

        Task periodicTask = new PeriodicTask.Builder()
                .setService(GCMTaskService.class)
                .setPeriod(5)
                .setFlex(1)
                .setTag("Caller_id_videos")
                .setPersisted(true)
                .build();


        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode == ConnectionResult.SUCCESS) {
            mGcmNetworkManager.schedule(periodicTask);
        } else {

            // TODO : Write alternate for scheduling a task.

        }
    }
}
