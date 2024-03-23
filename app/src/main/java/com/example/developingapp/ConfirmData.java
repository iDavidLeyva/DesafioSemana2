package com.example.developingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmdata);

    }

    @Override
    protected void onStart(){
        super.onStart();
        setSavedInfo();
        editData();
    }

    public void editData(){
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(v -> {
            this.finish();
        });
    }

    private void setSavedInfo( ){
        Bundle extras = getIntent().getExtras();
        TextView name = (TextView) findViewById(R.id.name);
        TextView date = (TextView) findViewById(R.id.bornDate);
        TextView phone = (TextView) findViewById(R.id.phone);
        TextView email = (TextView) findViewById(R.id.email);
        TextView description = (TextView) findViewById(R.id.contactDescription);
        name.setText(extras.getString("name"));
        date.setText(extras.getString("date"));
        phone.setText(extras.getString("phone"));
        email.setText(extras.getString("email"));
        description.setText(extras.getString("description"));
    }
}