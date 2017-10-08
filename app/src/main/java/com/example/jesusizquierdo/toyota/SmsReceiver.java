package com.example.jesusizquierdo.toyota;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;


/**
 * Created by Jesus Izquierdo on 10/8/2017.
 */

public class SmsReceiver extends BroadcastReceiver {
    private static final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private Intent mIntent;

    Chat chat = Chat.getInstance();


    @Override
    public void onReceive(Context context, Intent intent) {
        mIntent = intent;
        String action = intent.getAction();

        if (action.equals(ACTION_SMS_RECEIVED)) {
            String address = null, str = "";
            SmsMessage[] msgs = getMessagesFromIntent(mIntent);

            if (msgs != null) {
                for (int i = 0; i < msgs.length; i++) {
                    address = msgs[i].getOriginatingAddress();
                    str += msgs[i].getMessageBody().toString();
                    str += "\n";
                }
            }

            if (address != null) {
                // manage message and address ...
                if(address.contains("7046122387")){
                    chat.getSms(str);
                }

            }

        }
    }

    public static SmsMessage[] getMessagesFromIntent(Intent intent) {
        Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
        byte[][] pduObjs = new byte[messages.length][];

        for (int i = 0; i < messages.length; i++) {
            pduObjs[i] = (byte[]) messages[i];
        }

        byte[][] pdus = new byte[pduObjs.length][];
        int pduCount = pdus.length;
        SmsMessage[] msgs = new SmsMessage[pduCount];

        for (int i = 0; i < pduCount; i++) {
            pdus[i] = pduObjs[i];
            msgs[i] = SmsMessage.createFromPdu(pdus[i]);
        }

        return msgs;
    }
}
