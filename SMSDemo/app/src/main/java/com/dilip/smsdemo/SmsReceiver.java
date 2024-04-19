package com.dilip.smsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        Object[] smsObj = (Object[]) bundle.get("pdus");

        for (Object obj: smsObj) {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);

            String mobNO = message.getDisplayOriginatingAddress();
            String msg = message.getDisplayMessageBody();

            Log.d("MsgDetails", "MobNo: " + mobNO + ", Msg: " + msg);


//            MainActivity mainActivity = new MainActivity();
//            mainActivity.updateTextView(mobNO, msg);

            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage("+916352976450",null,"Hello", null, null);
        }

    }
}
