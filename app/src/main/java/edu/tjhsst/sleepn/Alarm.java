package edu.tjhsst.sleepn;

/**
 * Created by 2019bhumleke on 5/18/2018.
 */

public class Alarm {
    private int mIntentId;
    private String myTime;
    private String mAlarmName;

    public Alarm(String alarmTime, String alarmName, int intentId)
    {
        myTime=alarmTime;
        mIntentId=intentId;
        mAlarmName = alarmName;
    }

    public int getIntentId() {
        return mIntentId;
    }

    public void setIntentId(int intentId) {
        mIntentId = intentId;
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
