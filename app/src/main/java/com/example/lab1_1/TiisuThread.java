package com.example.lab1_1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class TiisuThread extends Thread implements Runnable {

    Activity mActivity;
    Handler mHandler;

    TiisuThread(Activity mActivity, Handler mHandler) {
        this.mActivity = ((MainActivity) mActivity);
        this.mHandler = mHandler;
    }


    public void run() {

        try {
            while(!Thread.interrupted()) {
                LocalDateTime timeAtm = LocalDateTime.now();
                DateTimeFormatter timeAtmForm = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = timeAtm.format(timeAtmForm);

                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("key", formattedDate + " Tiisu we want more! \n");
                message.setData(bundle);
                mHandler.sendMessage(message);
                sleep(5000);
            }
        }
        catch(Exception ex) {
            Log.d("mita", ex.toString());
        }
    }
}

