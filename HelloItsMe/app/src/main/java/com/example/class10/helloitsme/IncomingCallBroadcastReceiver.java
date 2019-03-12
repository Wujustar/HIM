package com.example.class10.helloitsme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.util.Log;

public class IncomingCallBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = "PHONE STATE";
    private static String lastState;


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("phase", "onRecive");

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (state.equals(lastState)) {
            return;
        } else {
            lastState = state;
        }

        if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
            String incommingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            final String phone_number = PhoneNumberUtils.formatNumber(incommingNumber);

            Intent serviceIntent = new Intent(context, CallingService.class);
            serviceIntent.putExtra(CallingService.EXTRA_CALL_NUMBER, phone_number);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ContextCompat.startForegroundService(context, serviceIntent);
            }else{
                context.startService(serviceIntent);
            }

        }
    }
}
