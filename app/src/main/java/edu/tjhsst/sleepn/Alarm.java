package edu.tjhsst.sleepn;

import android.app.PendingIntent;
import android.content.Intent;

/**
 * Created by 2019bhumleke on 5/18/2018.
 */

public class Alarm implements Comparable<Alarm>{
    private PendingIntent mPendingIntent;
    private String myTime;
    private String mAlarmName;
    private boolean mActive;
    private boolean isAM;
    private int myHours;
    private int myMinutes;

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
        myHours=Integer.parseInt(myTime.substring(0,myTime.indexOf(':')));
        myMinutes=Integer.parseInt(myTime.substring(myTime.indexOf(':')+1,myTime.indexOf(' ')));
        if(myTime.contains("AM"))
        {
            isAM=true;
        }
        else {
            isAM=false;
            myHours+=12;
        }
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
    public int compareTo(Alarm a)
    {

        if(myHours>a.myHours)
        {
            return 1;
        }
        else if(myHours<a.myHours)
        {
            return -1;
        }

        else{
            if(myMinutes>a.myMinutes)
            {
                return 1;
            }
           else if(myMinutes<a.myMinutes)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
}
