package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0-X
    //1-O
    int act=1;
    String s="";
    int m=1, num=0;
    int[] gs={2,2,2,2,2,2,2,2,2};
    int[][] wp={{0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}};
    boolean gmActive= true;
    int a=1;



    public void begin1() {
        TextView textView = (TextView) findViewById(R.id.textView);
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        textView.startAnimation(fadeOut);
        fadeOut.setDuration(2000);
        fadeOut.setFillAfter(true);
    }


    public void tap(View view) {
        Button restart = (Button) findViewById(R.id.restart);
        if (a==1)
            restart.setVisibility(View.VISIBLE);
        Button exit = (Button) findViewById(R.id.exit);
        Button replay = (Button) findViewById(R.id.replay);
        ImageView img=(ImageView) view;
        int tp=Integer.parseInt(img.getTag().toString());
        if(!gmActive)
            gReset(view);
        if(gs[tp]==2 && a==1) {
            gs[tp]=act;
            if(act==0) {
                img.setImageResource(R.drawable.xx);
                act=1;
                s="O's Turn-Tap to Play";
                TextView status=findViewById(R.id.status);
                status.setText(s);
            }
            else {
                img.setImageResource(R.drawable.oo);
                act=0;
                s="X's Turn-Tap to Play";
                TextView status=findViewById(R.id.status);
                status.setText(s);
            }
            int flag=0;
            for(flag=0;flag<8;flag++) {
                if(gs[wp[flag][0]]==gs[wp[flag][1]] && gs[wp[flag][1]]==gs[wp[flag][2]] && gs[wp[flag][0]]!=2) {
                    String winner;
                    if(gs[wp[flag][0]]==0)
                        winner="X won!";
                    else
                        winner="O won!";
                    TextView winStatus=findViewById(R.id.winStatus);
                    winStatus.setText(winner);
                    s="";
                    TextView status=findViewById(R.id.status);
                    status.setText(s);
                    m=0;a=0;
                    restart.setVisibility(View.GONE);
                    replay.setVisibility(View.VISIBLE);
                    exit.setVisibility(View.VISIBLE);
                    if (flag==0) {
                        ImageView line3=(ImageView) findViewById(R.id.line3);
                        line3.setVisibility((View.VISIBLE));
                    }
                    else if(flag==1){
                        ImageView line1=(ImageView) findViewById(R.id.line1);
                        line1.setVisibility((View.VISIBLE));
                    }
                    else if(flag==2){
                        ImageView line2=(ImageView) findViewById(R.id.line2);
                        line2.setVisibility((View.VISIBLE));
                    }
                    else if(flag==3){
                        ImageView line5=(ImageView) findViewById(R.id.line5);
                        line5.setVisibility((View.VISIBLE));
                    }
                    else if(flag==4){
                        ImageView line4=(ImageView) findViewById(R.id.line4);
                        line4.setVisibility((View.VISIBLE));
                    }
                    else if(flag==5){
                        ImageView line6=(ImageView) findViewById(R.id.line6);
                        line6.setVisibility((View.VISIBLE));
                    }
                    else if(flag==6){
                        ImageView line7=(ImageView) findViewById(R.id.line7);
                        line7.setVisibility((View.VISIBLE));
                    }
                    else{
                        ImageView line8=(ImageView) findViewById(R.id.line8);
                        line8.setVisibility((View.VISIBLE));
                    }
                }
            }
            int count=0;int i;
            for( i=0;i<gs.length;i++) {
                if(gs[i]==0 || gs[i]==1)
                    count+=1;
            }
            if(count==9 && a!=0) {
                a=0;
                String w="Oops! It's Tie";
                TextView winStatus=findViewById(R.id.winStatus);
                winStatus.setText(w);s="";
                TextView status=findViewById(R.id.status);
                status.setText(s);
                restart.setVisibility(View.GONE);
                replay.setVisibility(View.VISIBLE);
                exit.setVisibility(View.VISIBLE);
            }
        }
        else if(a==0)
            Toast.makeText(this,"Replay To Continue",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Already There",Toast.LENGTH_SHORT).show();
    }

    public void exit(View v) {
        finish();
        System.exit(0);
    }


    public void gReset(View view) {
        a=1;
        Button exit = (Button) findViewById(R.id.exit);
        exit.setVisibility(View.GONE);
        Button replay = (Button) findViewById(R.id.replay);
        replay.setVisibility(View.GONE);
        Button restart = (Button) findViewById(R.id.restart);
        restart.setVisibility(View.GONE);
        ImageView line1 = (ImageView) findViewById(R.id.line1);
        line1.setVisibility(View.GONE);
        ImageView line2 = (ImageView) findViewById(R.id.line2);
        line2.setVisibility(View.GONE);
        ImageView line3 = (ImageView) findViewById(R.id.line3);
        line3.setVisibility(View.GONE);
        ImageView line4 = (ImageView) findViewById(R.id.line4);
        line4.setVisibility(View.GONE);
        ImageView line5 = (ImageView) findViewById(R.id.line5);
        line5.setVisibility(View.GONE);
        ImageView line6 = (ImageView) findViewById(R.id.line6);
        line6.setVisibility(View.GONE);
        ImageView line7 = (ImageView) findViewById(R.id.line8);
        line7.setVisibility(View.GONE);
        ImageView line8 = (ImageView) findViewById(R.id.line7);
        line8.setVisibility(View.GONE);
        gmActive=true;
        int i;m=1;
        for (i=0;i<gs.length;i++)
            gs[i]=2;
        s="O's Turn-Tap to Play"; act=1;
        TextView status=findViewById(R.id.status);
        status.setText(s);
        String winner="";
        TextView winStatus=findViewById(R.id.winStatus);
        winStatus.setText(winner);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button exit = (Button) findViewById(R.id.exit);
        exit.setVisibility(View.GONE);
        Button replay = (Button) findViewById(R.id.replay);
        replay.setVisibility(View.GONE);
        Button restart = (Button) findViewById(R.id.restart);
        restart.setVisibility(View.GONE);
        ImageView iView = (ImageView) findViewById(R.id.imageView);
        iView.setVisibility(View.GONE);
        TextView status=findViewById(R.id.status);
        status.setVisibility(View.GONE);
        ImageView line1 = (ImageView) findViewById(R.id.line1);
        line1.setVisibility(View.GONE);
        ImageView line2 = (ImageView) findViewById(R.id.line2);
        line2.setVisibility(View.GONE);
        ImageView line3 = (ImageView) findViewById(R.id.line3);
        line3.setVisibility(View.GONE);
        ImageView line4 = (ImageView) findViewById(R.id.line4);
        line4.setVisibility(View.GONE);
        ImageView line5 = (ImageView) findViewById(R.id.line5);
        line5.setVisibility(View.GONE);
        ImageView line6 = (ImageView) findViewById(R.id.line6);
        line6.setVisibility(View.GONE);
        ImageView line7 = (ImageView) findViewById(R.id.line8);
        line7.setVisibility(View.GONE);
        ImageView line8 = (ImageView) findViewById(R.id.line7);
        line8.setVisibility(View.GONE);
        s = "O's Turn-Tap to Play!";
        status.setText(s);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView iView = (ImageView) findViewById(R.id.imageView);
                TextView status=findViewById(R.id.status);
                AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
                iView.startAnimation(fadeIn);
                status.startAnimation(fadeIn);
                fadeIn.setDuration(500);
                fadeIn.setFillAfter(true);
                iView.setVisibility(View.VISIBLE);
                status.setVisibility(View.VISIBLE);
            }
        }, 2000);
        begin1();
        hey
    }
}