package com.example.lab1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TiisuThread thread = new TiisuThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button startButton = findViewById(R.id.Start);
        Button stopButton = findViewById(R.id.Stop);
        final TextView threadText = findViewById(R.id.threadView);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread = new TiisuThread();
                thread.start();

                threadText.setText();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.stopThread();

            }
        });
    }

}
