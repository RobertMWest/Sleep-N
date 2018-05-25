package edu.tjhsst.sleepn;

/**
 * Created by 2019bhumleke on 5/18/2018.
 */

public class Alarm {
    private boolean isActive=false;
    private int myTime;
    private String mAlarmName;

    public Alarm(int alarmTime, boolean alarmIsActive, String alarmName)
    {
        myTime=alarmTime;
        isActive=alarmIsActive;
        mAlarmName = alarmName;
    }

    public boolean getActive()
    {
        return isActive;
    }

    public int getTime()
    {
        return myTime;
    }

    public void setActive(boolean b)
    {
        isActive=b;
    }

    public void setTime(int t)
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
