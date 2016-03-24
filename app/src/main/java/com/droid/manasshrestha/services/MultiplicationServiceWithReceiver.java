package com.droid.manasshrestha.services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;

/**
 * Service to perform multiplication
 */
public class MultiplicationServiceWithReceiver extends Service {

    public static final String PARAMS_IN = "multiplication_number";
    public static final String PARAMS_IN_RECEIVER = "receiver_extra";
    public static final String PARAMS_OUT = "result_number";

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
        if (intent.hasExtra(PARAMS_IN) && intent.hasExtra(PARAMS_IN_RECEIVER)) {

            int i = intent.getIntExtra(PARAMS_IN, 1);
            ResultReceiver resultReceiver = intent.getParcelableExtra(PARAMS_IN_RECEIVER);

            for (int o = 1; o <= 10; o++) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(PARAMS_OUT, i * o);
                    resultReceiver.send(0X2,bundle);
            }

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service Destroyed");
    }
}
