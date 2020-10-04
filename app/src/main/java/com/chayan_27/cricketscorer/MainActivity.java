package com.chayan_27.cricketscorer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText runs;
    EditText balls;
    Button cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runs=(EditText)findViewById(R.id.runs);
        balls=(EditText)findViewById(R.id.balls);
        cal=(Button)findViewById(R.id.cal);
    }

    public void calculate(View view) {
        int runs1=Integer.parseInt(runs.getText().toString());
        int balls1=Integer.parseInt(balls.getText().toString());
        int six,four = 0,two,one,runsleftaftersix,ballsleftaftersix;
        if(runs1>=balls1){
            six=runs1/6;
             runsleftaftersix=runs1%6;
             ballsleftaftersix=balls1-six;

                 four=runsleftaftersix/4 + 1;
                 if(four==0){
                     four=1;
                 }


             String result="";
             if((four*4+six*6)>=runs1&& (four+six) <= balls1){
                 result="Target Achievable\n4's(req) : "+four+"  6's(req) : "+six;
             }else{
                 result="Target not Achievable\n4's(req) : "+four+"  6's(req) : "+six;
             }
        }
    }
}