package com.example.suknote.alarm;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static android.widget.Toast.*;


public class MainActivity extends ActionBarActivity {

    Button ok,cancel;
    Spinner spinner;
    DatePicker dp;
    TimePicker tp;
    RadioButton dr,tr;
    AlarmManager am;
    GregorianCalendar ccal,scal;
    TimeZone tz;
    String[] tzlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok=(Button)findViewById(R.id.button);
        cancel=(Button)findViewById(R.id.button2);
        dp=(DatePicker)findViewById(R.id.datePicker);
        tp=(TimePicker)findViewById(R.id.timePicker);
        spinner=(Spinner)findViewById(R.id.spinner);
        dr=(RadioButton)findViewById(R.id.radioButton);
        tr=(RadioButton)findViewById(R.id.radioButton2);

        am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        ccal=new GregorianCalendar();
        scal=new GregorianCalendar();

        tzlist=tz.getAvailableIDs();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tzlist);
        spinner.setAdapter(adapter);
        spinner.setPrompt("타임존");

        dp.init(ccal.get(Calendar.YEAR),ccal.get(Calendar.MONTH),ccal.get(Calendar.DATE),null);
        tp.setCurrentHour(ccal.get(Calendar.HOUR_OF_DAY));
        tp.setCurrentMinute(ccal.get(Calendar.MINUTE));

        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.setVisibility(View.VISIBLE);
                tp.setVisibility(View.INVISIBLE);
            }
        });

        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.setVisibility(View.INVISIBLE);
                tp.setVisibility(View.VISIBLE);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tz=TimeZone.getTimeZone(spinner.getSelectedItem().toString());
                scal.setTimeZone(tz);
                scal.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(), tp.getCurrentHour(), tp.getCurrentMinute());
                am.set(AlarmManager.RTC_WAKEUP,scal.getTimeInMillis(),pendingIntent());
                Toast.makeText(getApplicationContext(),"알람 설정",Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.cancel(pendingIntent());
                Toast.makeText(getApplicationContext(),"알람 취소",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public PendingIntent pendingIntent(){
        Intent intent=new Intent(MainActivity.this,SubActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, intent, 0);

        return pendingIntent;
    }
}
