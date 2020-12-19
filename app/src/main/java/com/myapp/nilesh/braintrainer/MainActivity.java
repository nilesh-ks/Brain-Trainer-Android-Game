package com.myapp.nilesh.braintrainer;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView[] textViewArray;
    int box;
    TextView textView8, textView9, textView10, textView11, textView12, textView13;
    TextView textView7;
    Random r = new Random();
Button button;
TextView textView6;

    static int right, total;
   Boolean active=true;
    public void sum() {
        int i1 = r.nextInt(99 - 1) + 1;
        int i2 = r.nextInt(99 - 1) + 1;
        textView8.setText(i1 + "  +  " + i2);
        int result = i1 + i2;
        box = r.nextInt(3 - 0) + 0;
        int textViewCount = 4;
        List<Integer> list=new ArrayList<Integer>();

        list.add(1);
        list.add(2);

        textViewArray = new TextView[textViewCount];
        textViewArray[0] = textView10;
        textViewArray[1] = textView11;
        textViewArray[2] = textView12;
        textViewArray[3] = textView13;


        for (int j = 0; j < textViewCount; j++) {
            if (textViewArray[j] == textViewArray[box]) {
                textViewArray[box].setText(Integer.toString(result));
            } else {
                int x = r.nextInt(180 - 1) + 1;
                textViewArray[j].setText(Integer.toString(x));
            }


        }
    }



    public void reset(View view)
    {
        total=0;
        right=0;
        textView6.setText("30s");
        textView7.setText("0/0");
        sum();
        textView9.setVisibility(view.GONE);
        button.setVisibility(View.GONE);
        countDownTimer.start();
    }
CountDownTimer countDownTimer=new CountDownTimer(30000,1000) {
    @Override
    public void onTick(long millisUntilFinished) {
        active=true;
        textView6.setText(millisUntilFinished/1000+"s");
    }

    @Override
    public void onFinish() {
active=false;
        textView9.setText("Done!");
        textView9.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
    }
}.start();







    public void click(View view) {

if(active) {
    total++;
    TextView text = (TextView) view;
    int tap = Integer.parseInt(text.getTag().toString());
    if (textViewArray[tap] == (textViewArray[box])) {
        textView9.setText("Correct:)");
        textView9.setVisibility(view.VISIBLE);
        right++;
    }
    else
    {
        textView9.setText("Wrong:(");
        textView9.setVisibility(view.VISIBLE);

    }

    textView7.setText(right + "/" + total);
    sum();
}



}






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        button=(Button)findViewById(R.id.button);
        total=0;
        right=0;
        textView6.setText("30s");
        textView7.setText("0/0");
        sum();
        textView9.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        countDownTimer.start();


sum();


}
}


