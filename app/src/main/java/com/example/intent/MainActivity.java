package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(Intent.ACTION_SYNC);
        Button btnSync = findViewById(R.id.sync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date timeNow = new Date();
                DateFormat timeFormat = new SimpleDateFormat("H:mm", Locale.getDefault());
                String time = timeFormat.format(timeNow);
                int hour = Integer.parseInt(time.split(":", 2)[0]);
                if (hour >= 6 & hour < 14) {
                    intent.setData(Uri.parse("http://morning"));
                }
                if (hour == 14) {
                    intent.setData(Uri.parse("http://afternoon"));
                }
                if (hour >= 15 || hour < 6) {
                    intent.setData(Uri.parse("http://evening"));
                }
                startActivity(intent);
            }
        });
    }
}