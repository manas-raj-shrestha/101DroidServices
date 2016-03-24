package com.droid.manasshrestha.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Multiplication using intent service
 */
public class MultiplicationIntentService extends IntentService {

    public static final String PARAMS_IN = "multiplication_number";

    private static final String TAG = MultiplicationIntentService.class.getSimpleName();

    public MultiplicationIntentService() {
        super("Multiplication Intent Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        startMultiplication(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "Destroy");
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
                Log.d(TAG, String.valueOf((i * o)));
            }

        }
    }
}
