package com.ulaygyi.ulgtimezone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spn=findViewById(R.id.spn);
        String[] timezoneArray = TimeZone.getAvailableIDs();
        ULGTimezone ulgAdapter=new ULGTimezone(this,timezoneArray);
        spn.setAdapter(ulgAdapter);
    }
}