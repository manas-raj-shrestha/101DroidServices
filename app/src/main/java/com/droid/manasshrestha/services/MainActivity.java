package com.droid.manasshrestha.services;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MultiplicationResult {

    private final static String TAG = MainActivity.class.getSimpleName();
    RemoteService remoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        remoteService = new RemoteService(new Handler(), this);
    }

    public void startServiceWithoutCallbacks(View view) {
        Intent intent = new Intent(this, MultiplicationServiceWithoutReceiver.class);
        intent.putExtra(MultiplicationServiceWithReceiver.PARAMS_IN, 2);
        intent.putExtra(MultiplicationServiceWithReceiver.PARAMS_IN_RECEIVER, remoteService);
        startService(intent);
    }

    public void startServiceWithCallbacks(View view) {
        Intent intent = new Intent(this, MultiplicationServiceWithReceiver.class);
        intent.putExtra(MultiplicationServiceWithReceiver.PARAMS_IN, 2);
        intent.putExtra(MultiplicationServiceWithReceiver.PARAMS_IN_RECEIVER, remoteService);
        startService(intent);
    }

    public void startIntentService(View view){
        Intent intent = new Intent(this, MultiplicationIntentService.class);
        intent.putExtra(MultiplicationIntentService.PARAMS_IN, 2);
        startService(intent);
    }

    @Override
    public void getIntermediateResult(int result) {
        Log.d(TAG, String.valueOf(result));
    }
}
