package com.abhishek.kwizx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseCategoryQuizScreen extends AppCompatActivity {

    public static final String key="com.abhishek.kwizx";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category_quiz_screen);
    }


    public  void backToDashboard(View view)
    {
        Intent i=new Intent(ChooseCategoryQuizScreen.this,MainActivity.class);
        startActivity(i);
        finish();

    }

    public void aptQuiz(View view)
    {
        Intent i=new Intent(ChooseCategoryQuizScreen.this, QuizMCQScreen.class);
        i.putExtra(key,1);
        startActivity(i);
        finish();

    }

    public void phyQuiz(View view)
    {
        Intent i=new Intent(ChooseCategoryQuizScreen.this, QuizMCQScreen.class);
        i.putExtra(key,2);
        startActivity(i);
        finish();

    }

    public void chemQuiz(View view)
    {
        Intent i=new Intent(ChooseCategoryQuizScreen.this, QuizMCQScreen.class);
        i.putExtra(key,3);
        startActivity(i);
        finish();

    }

    public void bioQuiz(View view)
    {
        Intent i=new Intent(ChooseCategoryQuizScreen.this, QuizMCQScreen.class);
        i.putExtra(key,4);
        startActivity(i);
        finish();

    }

    public void geoQuiz(View view)
    {
        Intent i=new Intent(ChooseCategoryQuizScreen.this, QuizMCQScreen.class);
        i.putExtra(key,5);
        startActivity(i);
        finish();

    }


}