package com.droid.manasshrestha.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Service for simple multiplication without receiver
 */
public class MultiplicationServiceWithoutReceiver extends Service{

    public static final String PARAMS_IN = "multiplication_number";
    public static final String PARAMS_IN_RECEIVER = "receiver_extra";
    public static final String PARAMS_OUT = "result_number";

    private static final String TAG = MultiplicationServiceWithoutReceiver.class.getSimpleName();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startMultiplication(intent);
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * Generate multiplication table up to 10 with 250 ms delay
     *
     * @param intent Received {@link Intent}
     */
    private void startMultiplication(Intent intent) {
        if (intent.hasExtra(PARAMS_IN)) {

            int i = intent.getIntExtra(PARAMS_IN, 1);

            for (int o = 1; o <= 10; o++) {
                Log.d(TAG,String.valueOf(i*o));
            }

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service Destroyed");
    }
}
