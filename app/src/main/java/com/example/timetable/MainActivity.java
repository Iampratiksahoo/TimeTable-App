package com.example.timetable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView answerListView;

    public void generateAnswer(int currentNumber)
    {
        ArrayList<Integer> answerArrayList = new ArrayList<Integer>();
        for(int j=1; j<=10;j++)
        {
            answerArrayList.add(j * currentNumber);
        }
        ArrayAdapter<Integer> answerArrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,answerArrayList);
        answerListView.setAdapter(answerArrayAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar numberSeekBar = (SeekBar)findViewById(R.id.numberSeekBar);
        answerListView = (ListView)findViewById(R.id.answerListView);




        numberSeekBar.setMin(1);
        numberSeekBar.setMax(20);
        numberSeekBar.setProgress(10);

        generateAnswer(10);



        numberSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //Log.i("Pointer At ",Integer.toString(progress));
                generateAnswer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });





    }
}