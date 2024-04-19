package com.dilip.smsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;

public class SmsReceiver extends BroadcastReceiver {

    /**
     * This method is called when the BroadcastReceiver receives an SMS broadcast.
     *
     * @param context The Context of the application.
     * @param intent The Intent that contains the SMS data.
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        // Get the SMS data from the Intent
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return; // No data in the Intent, ignore
        }

        // Get the PDUs (Protocol Description Units) from the bundle
        Object[] smsObj = (Object[]) bundle.get("pdus");

        // Loop through each PDU (represents a single SMS message)
        for (Object obj : smsObj) {
            // Convert the PDU to a SmsMessage object
            SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);

            // Extract the sender number and message body
            String mobNO = message.getDisplayOriginatingAddress();
            String msg = message.getDisplayMessageBody();

            // Log the message details for debugging purposes
            Log.d("MsgDetails", "MobNo: " + mobNO + ", Msg: " + msg);

            // **Alternative 1: Send update intent to MainActivity**
            Intent updateIntent = new Intent(context, MainActivity.class);
            updateIntent.putExtra("mobNo", mobNO);
            updateIntent.putExtra("message", msg);
            context.sendBroadcast(updateIntent);

            // **Alternative 2: Use a custom Service to handle SMS and update UI**
            // need to create a Service class and handle the SMS processing and UI updates there.
            // This approach is better for complex tasks or if you need to perform actions in the background.

            // **This section is commented out as it's not related to receiving SMS**
            // // Create a new instance of MainActivity (not recommended)
            // // Call updateTextView method on the newly created instance (not thread-safe)
            // MainActivity mainActivity = new MainActivity();
            // mainActivity.updateTextView(mobNO, msg);

            // **Sending SMS from BroadcastReceiver is generally not recommended**
            // SmsManager smsManager = SmsManager.getDefault();
            // smsManager.sendTextMessage("+916352976450", null, "Hello", null, null);
        }
    }
}

