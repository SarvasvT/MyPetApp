package com.example.mypetapp;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SetReminder extends AppCompatActivity {

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    static final int ALARM_REQ_CODE = 100;

    Button setbt;
    Button cancelbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);

        setbt = (Button)findViewById(R.id.setbtn);
        cancelbt = (Button)findViewById(R.id.cancelbtn);

        setbt.setOnClickListener(this::onClick);
        cancelbt.setOnClickListener(this::onClick);

//        findViewById(R.id.setbtn).setOnClickListener((View.OnClickListener) this);
//        findViewById(R.id.cancelbtn).setOnClickListener(this);

    }

    public void onClick(View view) {
        EditText editText = findViewById(R.id.edittxt);
        TimePicker timePicker = findViewById(R.id.timepicker);


        //alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        //Intent intent = new Intent(SetReminder.this, AlarmReceiver.class);
        //int notificationId = 1;
        //intent.putExtra("notificationId", notificationId);
        //intent.putExtra("todo", editText.getText().toString());

        //alarmIntent = PendingIntent.getBroadcast(SetReminder.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        setbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SetReminder.this, MainActivity.class);
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);

                Intent iBroadcast = new Intent(SetReminder.this, MyReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(SetReminder.this,ALARM_REQ_CODE, iBroadcast, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis()-(60*1000),pendingIntent);
                Toast.makeText(SetReminder.this, "DONE!", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        /*switch (view.getId()) {
            case R.id.setbtn:
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);

                alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        calender.get +
                                60 * 1000, alarmIntent);

                Toast.makeText(this, "DONE!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;


            case R.id.cancelbtn:
                alarmMgr.cancel(alarmIntent);
                Toast.makeText(this, "CANCELED!", Toast.LENGTH_SHORT).show();
                break;

        }*/

    }
}