package com.ismailhakkiaydin.broadcastreceiverdinamik;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG=MainActivity.class.getSimpleName();

    private int dakika=1;

    TextView text;

    private MyFirstReceiver myFirstReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFirstReceiver=new MyFirstReceiver();
        text= (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter=new IntentFilter();
        //intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(myFirstReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myFirstReceiver);
    }

    public void registerReceiver(View view) {

        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);

        registerReceiver(myTimeTickReceiver, filter);

    }

    public void unRegisterReceiver(View view) {

        unregisterReceiver(myTimeTickReceiver);

    }



    private BroadcastReceiver myTimeTickReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {



            Toast.makeText(context, "myTimeTickReceiver Receiver!!!", Toast.LENGTH_LONG).show();

            int dakikaDegeri=dakika;

            text.setText(dakikaDegeri+ " dakika geçti");
            dakika++;

        }
    };


}