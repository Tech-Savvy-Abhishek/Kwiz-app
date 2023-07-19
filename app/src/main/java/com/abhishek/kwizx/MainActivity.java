package com.abhishek.kwizx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
CardView profilecard,choosecard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hooks();

    }

    private void Hooks() {
        profilecard=findViewById(R.id.profilecard);
        choosecard=findViewById(R.id.chooseCategorycard);


    }

    public void openProfile(View view)
    {
        profilecard.setCardBackgroundColor(getResources().getColor(R.color.secondary_quizxlight));
        Intent i=new Intent(MainActivity.this,ProfileScreen.class);

        startActivity(i);
        finish();

    }

    public void chooseCategory(View view)
    {
        choosecard.setCardBackgroundColor(getResources().getColor(R.color.secondary_quizxlight));
        Intent i=new Intent(MainActivity.this,ChooseCategoryQuizScreen.class);

        startActivity(i);
        finish();

    }

    public  void logout(View view)
    {
        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("remember","NULL");
        editor.apply();


        Intent i=new Intent(MainActivity.this,LoginScreen.class);
        startActivity(i);
        finish();

    }
}