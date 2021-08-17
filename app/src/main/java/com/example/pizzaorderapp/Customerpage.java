package com.example.pizzaorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Customerpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerpage);

        //Creating button method to link to next page (receipt)
        Button custoButton = (Button) findViewById(R.id.next2);
        custoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReceipt();
            }
        });

        //Loading pizza total price from previous page
        Intent gettingIntent = getIntent();
        String price = gettingIntent.getStringExtra("fulltotal");
        String size = gettingIntent.getStringExtra("radioGroup");

        TextView totalpriceview = findViewById(R.id.total1);
        TextView thesize = findViewById(R.id.size);

        totalpriceview.setText(price);
        thesize.setText(size);
    }

    //Method to set User inputs into Strings
    //putExtra to send to Receipt page
    public void openReceipt(){
        Intent intent = new Intent(this, Receipt.class);

        //Setting EditText inputs into a string
        EditText name = (EditText) findViewById(R.id.name);
        String fullname = name.getText().toString();

        EditText phone = (EditText) findViewById(R.id.phone);
        String fullphone = phone.getText().toString();

        EditText email = (EditText) findViewById(R.id.email);
        String fullemail = email.getText().toString();

        EditText address = (EditText) findViewById(R.id.address);
        String fulladdress = address.getText().toString();

        //Passing total price from previous page
        TextView total = (TextView) findViewById(R.id.total1);
        String fulltotal1 = total.getText().toString();

        TextView size = (TextView) findViewById(R.id.size);
        String fullsize = size.getText().toString();

        //Pushing data to receipt page
        intent.putExtra("fullname", fullname);
        intent.putExtra("fullphone", fullphone);
        intent.putExtra("fullemail", fullemail);
        intent.putExtra("fulladdress", fulladdress);
        intent.putExtra("fulltotal1", fulltotal1);
        intent.putExtra("fullsize", fullsize);

        startActivity(intent);
    }
}