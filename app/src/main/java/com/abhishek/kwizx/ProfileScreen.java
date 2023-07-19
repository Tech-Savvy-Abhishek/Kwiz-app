package com.abhishek.kwizx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileScreen extends AppCompatActivity {
TextView textViewUsername,textViewfullname;
DatabaseReference reference;
String email,fullname,password;
TextInputLayout input_textlayout_fullname,input_textlayout_email,input_textlayout_password;
CardView cardUpdateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        Hooks();

        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.secondary_quizx));

        textViewUsername.setText(RegistarScreen.username_public);
        reference=FirebaseDatabase.getInstance().getReference("appusers");

        getData();

    }

    private void getData() {

        reference.child(RegistarScreen.username_public).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
               if(task.isSuccessful())
               {
                  DataSnapshot dataSnapshot=task.getResult();
                  fullname=String.valueOf(dataSnapshot.child("fullname").getValue());
                   email=String.valueOf(dataSnapshot.child("email").getValue());
                   password=String.valueOf(dataSnapshot.child("password").getValue());


                   input_textlayout_fullname.getEditText().setText(fullname);
                   input_textlayout_email.getEditText().setText(email);
                   input_textlayout_password.getEditText().setText(password);
                   textViewfullname.setText(fullname);

               }
               else
               {
                   Toast.makeText(ProfileScreen.this, "Something went wrong", Toast.LENGTH_SHORT).show();
               }
            }
        });

    }

    private void Hooks() {
        textViewUsername=findViewById(R.id.textViewUsername);
        input_textlayout_fullname=findViewById(R.id.input_textlayout_fullname);
        input_textlayout_email=findViewById(R.id.input_textlayout_email);
        input_textlayout_password=findViewById(R.id.input_textlayout_password);
        textViewfullname=findViewById(R.id.textViewfullname);
        cardUpdateProfile=findViewById(R.id.card_updateProfile);
    }

    public  void updateProfile(View view)
    {
        cardUpdateProfile.setCardBackgroundColor(getResources().getColor(R.color.green));
        if(fullnameChange() || emailChange() || passwordChange())

        {

            Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            cardUpdateProfile.setCardBackgroundColor(getResources().getColor(R.color.secondary_quizx));
        }
        else
        {
            Toast.makeText(this, "No changes were made", Toast.LENGTH_SHORT).show();
            cardUpdateProfile.setCardBackgroundColor(getResources().getColor(R.color.secondary_quizx));
        }
    }

    private boolean passwordChange() {
        if(!password.equals(input_textlayout_password.getEditText().getText().toString()))
        {
            reference.child(RegistarScreen.username_public).child("password").setValue(input_textlayout_password.getEditText().getText().toString());
            return  true;
        }
        else
        {
            return false;
        }

    }

    private boolean emailChange() {
        if(!email.equals(input_textlayout_email.getEditText().getText().toString()))
        {
            reference.child(RegistarScreen.username_public).child("email").setValue(input_textlayout_email.getEditText().getText().toString());
            return  true;
        }
        else
        {
            return false;
        }

    }

    private boolean fullnameChange() {

        if(!fullname.equals(input_textlayout_fullname.getEditText().getText().toString()))
        {
            reference.child(RegistarScreen.username_public).child("fullname").setValue(input_textlayout_fullname.getEditText().getText().toString());
            textViewfullname.setText(input_textlayout_fullname.getEditText().getText().toString());
            return  true;
        }
        else
        {
            return false;
        }

    }

    public void backToMain(View view)
    {
        Intent i=new Intent(ProfileScreen.this, MainActivity.class);
        startActivity(i);
        finish();
    }


}