package edu.tjhsst.sleepn;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class AlarmCreator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_creator);

        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        

        //Create a new PendingIntent and add it to the AlarmManager


    }

    private void setAlarm(int Hour, int Minute) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, Hour);
        cal.set(Calendar.MINUTE, Minute);
        cal.set(Calendar.SECOND, 0);

        //in case of choosing a previous hour, then set alarm to next day
        if (cal.getTimeInMillis() < System.currentTimeMillis())
            cal.set(Calendar.HOUR_OF_DAY, Hour + 24);

        Intent intent = new Intent(this, AlarmReceiverActivity.class);
        intent.putExtra("alarmName", "Time to get up!");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                UUID.randomUUID().hashCode(), intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager am =
                (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                pendingIntent);

        cal.add(Calendar.SECOND, 10);
    }
}
