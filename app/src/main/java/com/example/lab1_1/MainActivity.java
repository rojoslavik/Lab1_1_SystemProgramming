package com.example.lab1_1;

import android.app.Activity;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static TiisuThread thread;
    TextView tiisuText;
    public boolean started = false;
    private static final String MSG_KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Start).setOnClickListener(this);
        findViewById(R.id.Stop).setOnClickListener(this);
        tiisuText = findViewById(R.id.threadView);


    }

    public void printText(String text) {
        tiisuText.setText(tiisuText.getText() + "\r" + text);
    }

   private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = (Bundle) msg.getData();
            String string = bundle.getString(MSG_KEY);
            printText(string);
        }
    };

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Start) {
            if(started == false) {
                started = true;
                thread = new TiisuThread(this, mHandler);
                thread.start();
            }
        }
        else if (v.getId() == R.id.Stop) {
            if(started == true) {
                thread.interrupt();
                started = false;
            }
        }
    }
}

