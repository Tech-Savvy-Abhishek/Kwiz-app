package com.abhishek.kwizx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginScreen extends AppCompatActivity {
    TextInputLayout  layout_password, layout_username;
    TextView textViewSignUp;
    ProgressDialog progressDialog;
    CardView cardView;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        Hooks();

        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        String check_box=preferences.getString("remember","NULL");
        if(!check_box.equals("NULL"))
        {
            RegistarScreen.username_public=check_box;
            Intent i=new Intent(LoginScreen.this,MainActivity.class);
            startActivity(i);
            finish();
        }


    }


    public void loginToAccount(View view)
    {

        String username=layout_username.getEditText().getText().toString();
        String password=layout_password.getEditText().getText().toString();

        if(!username.isEmpty())
        {
            layout_username.setError(null);
            layout_username.setErrorEnabled(false);
            if(!password.isEmpty())
            {
                layout_password.setError(null);
                layout_password.setErrorEnabled(false);

                progressDialog.setMessage("Logging in Please Wait...");
                progressDialog.setTitle("Log in");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                cardView.setCardBackgroundColor(getResources().getColor(R.color.green));

                final String usernameData=layout_username.getEditText().getText().toString();
                final String passwordData=layout_password.getEditText().getText().toString();
                FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                DatabaseReference databaseReference=firebaseDatabase.getReference("appusers");



                Query check_username=databaseReference.orderByChild("usename").equalTo(usernameData);
                check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.exists())
                        {
                            layout_username.setError(null);
                            layout_username.setErrorEnabled(false);
                            String passwordCheck=snapshot.child(usernameData).child("password").getValue(String.class);
                            if(passwordCheck.equals(passwordData))
                            {
                                layout_password.setError(null);
                                layout_password.setErrorEnabled(false);
                                Toast.makeText(LoginScreen.this, "Logged in successfully", Toast.LENGTH_SHORT).show();


                                progressDialog.dismiss();


                                //ra
                                RegistarScreen. username_public=username;

                                check();

                                Intent i=new Intent(LoginScreen.this,MainActivity.class);
                                startActivity(i);
                                finish();
                            }
                            else
                            {
                                progressDialog.dismiss();
                                cardView.setCardBackgroundColor(getResources().getColor(R.color.secondary_quizx));

                                layout_password.setError("Wrong password");
                            }
                        }
                        else
                        {
                            cardView.setCardBackgroundColor(getResources().getColor(R.color.secondary_quizx));
                            progressDialog.dismiss();

                            layout_username.setError("User doesn't exist");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
            else
            {
                layout_password.setError("Please enter the password");
            }
        }
        else
        {
            layout_username.setError("Username can't be blank");
        }
    }

    public void goToRegisterScreen(View view)
    {
        textViewSignUp.setTextColor(getResources().getColor(R.color.black));
        Intent i=new Intent(this,RegistarScreen.class);
        startActivity(i);
        finish();

    }

    public void Hooks()
    {
        textViewSignUp=findViewById(R.id.textViewSignUp);
        textViewSignUp.setTextColor(getResources().getColor(R.color.secondary_quizx));
        layout_password=findViewById(R.id.layout_password);
        layout_username=findViewById(R.id.layout_username);
        progressDialog=new ProgressDialog(this);
        cardView=findViewById(R.id.cardView);
        checkBox=findViewById(R.id.checkBox1);
    }

    public void check()
    {

        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        if(checkBox.isChecked())
        {
            editor.putString("remember",RegistarScreen.username_public);
        }
        else
        {
            editor.putString("remember","NULL");
        }

        editor.apply();


    }
}