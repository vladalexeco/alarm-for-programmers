package ru.vladalexeco.alarmforprogrammers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;

import java.text.SimpleDateFormat;

import ru.vladalexeco.alarmforprogrammers.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        bind.timePicker.setIs24HourView(true);

        bind.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                int hour = 0;
                int minute = 0;

                if (isChecked) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        hour = bind.timePicker.getHour();
                        minute = bind.timePicker.getMinute();
                    } else {
                        hour = bind.timePicker.getChildCount();
                        minute = bind.timePicker.getCurrentMinute();
                    }
                    bind.textView1.setText(String.format("%d : %02d", hour, minute));
                } else {
                    bind.textView1.setText("Будильник выключен");
                }
            }
        });



    }
}