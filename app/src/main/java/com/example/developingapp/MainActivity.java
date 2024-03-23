package com.example.developingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart(){
        super.onStart();
        EditText etPlannedDate = (EditText) findViewById(R.id.bornDate);
        setDate(etPlannedDate);
        confirmData();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

    //On execution
    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }



    public void setDate(EditText etPlannedDate){
        etPlannedDate.setOnClickListener(v -> {
            if (v.getId() == R.id.bornDate) {
                showDatePickerDialog(etPlannedDate);
            }
        });
    }

    public void confirmData(){
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ConfirmData.class);
            setExtras(i);
            startActivity(i);
        });
    }

    private void setExtras(Intent i){
        EditText name = (EditText) findViewById(R.id.name);
        EditText date = (EditText) findViewById(R.id.bornDate);
        EditText phone = (EditText) findViewById(R.id.phone);
        EditText email = (EditText) findViewById(R.id.email);
        EditText description = (EditText) findViewById(R.id.contactDescription);
        i.putExtra("name", name.getText().toString());
        i.putExtra("date", date.getText().toString());
        i.putExtra("phone", phone.getText().toString());
        i.putExtra("email", email.getText().toString());
        i.putExtra("description", description.getText().toString());
    }

    private void showDatePickerDialog(EditText etPlannedDate) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // +1 because January is zero
                final String selectedDate = dayOfMonth + " / " + (month+1) + " / " + year;
                etPlannedDate.setText(selectedDate);
            }
        });
        newFragment.show(this.getSupportFragmentManager(), "datePicker");
    }

}