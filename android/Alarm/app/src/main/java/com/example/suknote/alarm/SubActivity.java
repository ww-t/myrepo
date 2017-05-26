package com.example.suknote.alarm;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by suknote on 2015-06-11.
 */
public class SubActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button button=(Button)findViewById(R.id.button3);

        RingtoneManager ringtoneManager=new RingtoneManager(this);
        Uri uri=ringtoneManager.getRingtoneUri(RingtoneManager.TYPE_ALARM);
        final Ringtone ringtone=ringtoneManager.getRingtone(this,uri);

        ringtone.play();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ringtone.stop();
                finish();
            }
        });
    }
}
