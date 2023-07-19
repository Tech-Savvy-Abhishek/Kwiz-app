package com.abhishek.kwizx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivity extends AppCompatActivity {
    CircularProgressBar circularProgressBar;
    TextView resultText;
    int correct,wrong;
    LinearLayout btn_share;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.secondary_quizx));


        correct=getIntent().getIntExtra("correct",0);
        wrong=getIntent().getIntExtra("wrong",0);

        circularProgressBar=findViewById(R.id.circularProgressBar);
        resultText=findViewById(R.id.result_text);
        btn_share=findViewById(R.id.btn_share);

        circularProgressBar.setProgress(correct);
        resultText.setText(correct+"/20");

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent shareIntent=new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT,"My application name");
                    String shareMessage="Hey,I've scored "+correct+" Out of 20\nI challenge you to beat my score in this awesome kwiz app";
                    shareMessage=shareMessage+"https://play.google.com/store/apps/details?id="+BuildConfig.APPLICATION_ID+"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                    startActivity(Intent.createChooser(shareIntent,"choose one"));
                }
                catch (Exception e)
                {

                }
            }
        });

    }


    public  void back(View view)
    {
            Intent i=new Intent(WonActivity.this,ChooseCategoryQuizScreen.class);
            startActivity(i);
            finish();
    }
}