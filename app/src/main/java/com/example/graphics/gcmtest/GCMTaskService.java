package com.example.graphics.gcmtest;

import android.util.Log;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;

/**
 * Created by graphics on 9/21/2016.
 */
public class GCMTaskService extends GcmTaskService {

    private static final String TAG = GCMTaskService.class.getName();

    @Override
    public int onRunTask(TaskParams taskParams) {
        Log.i(TAG, "onRunTask");
        switch (taskParams.getTag()) {
            case "Caller_id_videos":
                Log.i(TAG, "Caller_id_videos");

                // This is where you need to perform the background tasks.

                return GcmNetworkManager.RESULT_SUCCESS;
            default:
                return GcmNetworkManager.RESULT_FAILURE;
        }
    }
}
