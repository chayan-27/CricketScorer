package com.chayan_27.cricketscorer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText runs;
    EditText balls;
    Button cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runs = (EditText) findViewById(R.id.runs);
        balls = (EditText) findViewById(R.id.balls);
        cal = (Button) findViewById(R.id.cal);
    }

    public void calculate(View view) {
        int runs1 = Integer.parseInt(runs.getText().toString());
        int balls1 = Integer.parseInt(balls.getText().toString());
        int six, four = 0, two, one, runsleftaftersix, ballsleftaftersix;
        List<String> list = new ArrayList<>();
        if (runs1 >= balls1) {

            for(int i=6;i>=2;i-=2){
                int k=i;
                if(k==2){
                    k=k+1;
                }
                for(int j=k-2;j>=1;j-=2){
                    six = runs1 / i;
                    runsleftaftersix = runs1 % i;
                    four = runsleftaftersix / j;
                    String result="";
                    if ((four * j + six * i) >= runs1 && (four + six) <= balls1) {
                        result = "Target Achievable\n"+j+"'s(req) : " + four + "  "+i+"'s(req) : " + six;

                    } else {
                        result = "Target not Achievable\n"+j+"'s(req) : " + four + "  "+i+"'s(req) : " + six+" in "+(four+six)
                                +" balls but given balls are only "+balls1+" fell short of "+((four+six)-balls1)+" balls";

                    }
                    list.add(result);

                    if(j==2){
                        j=3;
                    }
                }
            }

            String res="";
            for(String string:list){
                res=res+string+"\n";
            }
           /* six = runs1 / 6;
            runsleftaftersix = runs1 % 6;
            ballsleftaftersix = balls1 - six;

            four = runsleftaftersix / 4 + 1;
            two = runsleftaftersix / 2 + 1;
            one = runsleftaftersix + 1;
            if (four == 0) {
                four = 1;
            }
            if (two == 0) {
                two = 1;
            }
            if (one == 0) {
                one = 1;
            }


            String result = "";
            if ((four * 4 + six * 6) >= runs1 && (four + six) <= balls1) {
                result = "Target Achievable\n4's(req) : " + four + "  6's(req) : " + six;
                list.add(result);
            } else {
                result = "Target not Achievable\n4's(req) : " + four + "  6's(req) : " + six;
                list.add(result);
            }

            if ((two * 2 + six * 6) >= runs1 && (two + six) <= balls1) {
                result = "Target Achievable\n2's(req) : " + two + "  6's(req) : " + six;
                list.add(result);
            } else {
                result = "Target not Achievable\n2's(req) : " + two + "  6's(req) : " + six;
                list.add(result);
            }

            if ((one  + six * 6) >= runs1 && (one + six) <= balls1) {
                result = "Target Achievable\n1's(req) : " + one + "  6's(req) : " + six;
                list.add(result);
            } else {
                result = "Target not Achievable\n1's(req) : " + one + "  6's(req) : " + six;
                list.add(result);
            }*/
        }
    }
}