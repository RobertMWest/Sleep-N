package edu.tjhsst.sleepn;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Alarm> mArrayList;
    private int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mArrayList = new ArrayList<Alarm>();
        for(int i=0;i<3;i++)
        {
            index=i;
            mArrayList.add(new Alarm(8,true, "Hi"));
        }

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);

//        mAddItem=(Button)findViewById(R.id.add_button);
//        mRemoveItem=(Button)findViewById(R.id.remove_button);
//
//        mAddItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addItem();
//                mRecyclerView.scrollToPosition(index);
//
//                //Log.i("","Add Button Clicked");
//
//            }
//
//
//        });
//
//        mRemoveItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                removeItem();
//                //Log.i("","Remove Button Clicked");
//
//            }








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AlarmCreator.class);
                startActivityForResult(i, 1);
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("data");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                System.out.println(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read value." + error.toException());
            }
        });

        FirebaseMessaging.getInstance().subscribeToTopic("FCPS");


        //FOR TESTING ONLY
        /*
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 10);

        //Create a new PendingIntent and add it to the AlarmManager
        Intent intent = new Intent(this, AlarmReceiverActivity.class);
        intent.putExtra("alarmName", "Time to get up!");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                UUID.randomUUID().hashCode(), intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager am =
                (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                pendingIntent);

        cal.add(Calendar.SECOND, 10);

        //Create a new PendingIntent and add it to the AlarmManager
        intent = new Intent(this, AlarmReceiverActivity.class);
        pendingIntent = PendingIntent.getActivity(this,
                UUID.randomUUID().hashCode(), intent, PendingIntent.FLAG_CANCEL_CURRENT);
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                pendingIntent);
         */
    }



}
