package com.droid.manasshrestha.services;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;

/**
 * Created by ManasShrestha on 3/24/16.
 */
public class RemoteService extends ResultReceiver {

    private static final String TAG = RemoteService.class.getSimpleName();

    MultiplicationResult multiplicationResult;

    public RemoteService(Handler handler, MultiplicationResult multiplicationResult) {
        super(handler);
        this.multiplicationResult = multiplicationResult;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);

        multiplicationResult.getIntermediateResult(resultData.getInt(MultiplicationServiceWithReceiver.PARAMS_OUT));
    }

}
