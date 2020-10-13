package com.chayan_27.cricketscorer;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.plattysoft.leonids.ParticleSystem;

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
        ImageView imageView = (ImageView) findViewById(R.id.image1);
        ImageView imageView1=(ImageView) findViewById(R.id.image2);
        ImageView imageView2 = (ImageView) findViewById(R.id.image3);
        ImageView imageView3=(ImageView) findViewById(R.id.image4);
        ImageView imageView4 = (ImageView) findViewById(R.id.image5);
        ImageView imageView5=(ImageView) findViewById(R.id.image6);

        final float bottomOfScreen = getResources().getDisplayMetrics()
                .heightPixels - (imageView.getHeight() * 4);
        //bottomOfScreen is where you want to animate to
        /*animator(imageView,"translationX",-1000f,1000f,5000);
        animator(imageView,"translationY",-1000f,1000f,5000);*/
        animator(imageView1,"translationY",-1000f,bottomOfScreen,2000);
        animator(imageView1,"rotation",1000f,-1000f,5000);
        animator(imageView2,"translationY",-1000f,bottomOfScreen,3000);
        animator(imageView2,"rotation",1000f,-1000f,5000);

        animator(imageView3,"translationY",-1000f,bottomOfScreen,4000);
        animator(imageView3,"rotation",1000f,-1000f,5000);
        /*animator(imageView4,"translationY",-1000f,3000f,5000);
        animator(imageView4,"translationX",-300f,800f,5000);
        animator(imageView4,"rotation",-300f,800f,5000);*/


        /*ObjectAnimator animY = ObjectAnimator.ofFloat(imageView, "rotation", -1000f,1000f);
        animY.setDuration(5000);
        animY.setInterpolator(new AccelerateInterpolator());

        animY.setRepeatCount(200);
        animY.start();
        ObjectAnimator animY1 = ObjectAnimator.ofFloat(imageView, "translationY", bottomOfScreen,0f);
        animY1.setDuration(5000);
        animY1.setInterpolator(new AccelerateInterpolator());

        animY1.setRepeatCount(200);
        animY1.start();

        ObjectAnimator animX = ObjectAnimator.ofFloat(imageView1, "translationX", 1000f,-1000f);
        animX.setDuration(3000);
        animX.setInterpolator(new AccelerateInterpolator());

        animX.setRepeatCount(200);
        animX.start();
        ObjectAnimator animX1 = ObjectAnimator.ofFloat(imageView1, "rotation", 1000f,-1000f);
        animX1.setDuration(3000);
        animX1.setInterpolator(new AccelerateInterpolator());

        animX1.setRepeatCount(200);
        animX1.start();*/

      /*  imageView.animate()
                .translationY(bottomOfScreen)
                .rotation(90)
                .setInterpolator(new AccelerateInterpolator())
                .setInterpolator(new BounceInterpolator())
                .setDuration(2000)
        .setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animation.start();



            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        })
        ;*/
        /*new ParticleSystem(this, 80, R.drawable.ic_cricket_02, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 180, 180)
                .setRotationSpeed(144)

                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.image1), 8);

        new ParticleSystem(this, 80, R.drawable.ic_cricketball, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.image2), 8);*/
    }

    public void calculate(View view) {
        int runs1 = Integer.parseInt(runs.getText().toString());
        int balls1 = Integer.parseInt(balls.getText().toString());
        int six, four = 0, two, one, runsleftaftersix, ballsleftaftersix;
        List<String> list = new ArrayList<>();


            for(int i=6;i>=2;i-=2){
                int k=i;
                if(k==2){
                    k=k+1;
                }
                for(int j=k-2;j>=1;j-=2){
                    String result="";
                    six = runs1 / i;
                    runsleftaftersix = runs1 % i;
                    if(runsleftaftersix!=0){
                        result=   "Target Achievable in "+(1 + six)+" balls\n"+j+"'s(req) : " + 0 + "\n"+i+"'s(req) : " + (six+1);
                        list.add(result);

                    }
                    four =(int) Math.ceil((double)runsleftaftersix / j);

                    if ((four * j + six * i) >= runs1 && (four + six) <= balls1) {
                        result = "Target Achievable in "+(four + six)+" balls\n"+j+"'s(req) : " + four + "\n"+i+"'s(req) : " + six;

                    } else {
                        result = "Target not Achievable\n"+j+"'s(req) : " + four + " \n"+i+"'s(req) : " + six+"\nin "+(four+six)
                                +" balls but given balls are only "+balls1+" fell short of "+((four+six)-balls1)+" balls";

                    }
                    list.add(result);

                    if(j==2){
                        j=3;
                    }
                }
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.homepage,new ScoreVisibility(list)).addToBackStack(null).commit();

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

    public void animator(ImageView imageView,String propertyname,float left,float right,long duration){
        ObjectAnimator animY = ObjectAnimator.ofFloat(imageView, propertyname,left,right);
        animY.setDuration(duration);
        animY.setInterpolator(new AccelerateInterpolator());
        animY.setInterpolator(new BounceInterpolator());
        animY.setRepeatCount(200);
        animY.start();
    }
}