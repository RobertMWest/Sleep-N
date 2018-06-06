package edu.tjhsst.sleepn;

import android.app.PendingIntent;
import android.content.Intent;

/**
 * Created by 2019bhumleke on 5/18/2018.
 */

public class Alarm {
    private PendingIntent mPendingIntent;
    private String myTime;
    private String mAlarmName;
    private boolean mActive;

    public Alarm(String alarmTime, String alarmName, PendingIntent intent)
    {
        if(intent != null)
        {
            mActive = true;
        }
        else
        {
            mActive = false;
        }

        myTime=alarmTime;
        mPendingIntent=intent;
        mAlarmName = alarmName;
    }

    public boolean isActive() {
        return mActive;
    }

    public String getTime()
    {
        return myTime;
    }

    public void setTime(String t)
    {
        myTime=t;
    }

    public String getAlarmName() {
        return mAlarmName;
    }

    public void setAlarmName(String alarmName) {
        mAlarmName = alarmName;
    }
}
