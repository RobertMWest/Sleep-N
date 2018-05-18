package edu.tjhsst.sleepn;

/**
 * Created by 2019bhumleke on 5/18/2018.
 */

public class Alarm {
    private boolean isActive=false;
    private int myTime;

    public Alarm(int alarmTime, boolean alarmIsActive)
    {
        myTime=alarmTime;
        isActive=alarmIsActive;
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
}
