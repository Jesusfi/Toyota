package com.example.jesusizquierdo.toyota;

import android.*;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jesusizquierdo.toyota.classes.Messages;
import com.example.jesusizquierdo.toyota.rvadapters.ChatRvAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {
    private static String SENT = "SMS_SENT";
    private static String DELIVERED = "SMS_DELIVERED";
    private static int MAX_SMS_MESSAGE_LENGTH = 160;
    private static Chat instance;
    RecyclerView recyclerView;
    ArrayList<Messages> messages;
    ChatRvAdapter chatRvAdapter;
    @Override
    protected void onStart() {
        super.onStart();
        instance = this;
    }
    public void getSms(String sms){
        messages.add(new Messages("BOT", sms));
        chatRvAdapter.notifyDataSetChanged();

    }
    public static Chat getInstance(){
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        final EditText editText = (EditText) findViewById(R.id.et);
        final Button send = (Button) findViewById(R.id.send);
        recyclerView = (RecyclerView) findViewById(R.id.sms_chat);
        messages= new ArrayList<>();
        chatRvAdapter = new ChatRvAdapter(Chat.this,messages);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(chatRvAdapter);

        requestSmsPermission();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String message = editText.getText().toString().trim();
                sendSMS("7046122387",message);
///jsut making sure it is saved on git
                if(user.getDisplayName() != null){
                    messages.add(new Messages(user.getDisplayName(),message));
                    chatRvAdapter.notifyDataSetChanged();
                }else{
                    messages.add(new Messages(user.getEmail(),message));
                    chatRvAdapter.notifyDataSetChanged();
                }

            }
        });
    }
    public void sendSMS(String phoneNumber, String message){
        PendingIntent piSent = PendingIntent.getBroadcast(getApplicationContext(),
                0, new Intent(SENT), 0);
        PendingIntent piDelivered = PendingIntent.getBroadcast(getApplicationContext(),
                0, new Intent(DELIVERED), 0);
        SmsManager smsManager = SmsManager.getDefault();
        int length = message.length();

        if (length > MAX_SMS_MESSAGE_LENGTH) {
            ArrayList<String> messagelist = smsManager.divideMessage(message);
            smsManager.sendMultipartTextMessage(phoneNumber, null,
                    messagelist, null, null);
        } else {
            smsManager.sendTextMessage(phoneNumber, null, message,
                    piSent, piDelivered);
        }
    }
    private void requestSmsPermission() {
        String permission = android.Manifest.permission.READ_SMS;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        if (grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(Chat.this,"permission granted", Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(Chat.this,"permission not granted", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
