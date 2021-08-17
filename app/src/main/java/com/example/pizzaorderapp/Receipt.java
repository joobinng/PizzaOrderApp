package com.example.pizzaorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Receipt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        PizzaModel pizza = null;
        Intent gettingIntent = getIntent();

        //Setting text inputs into strings from previous page
        String namefinal = gettingIntent.getStringExtra("fullname");
        String phonefinal = gettingIntent.getStringExtra("fullphone");
        String emailfinal = gettingIntent.getStringExtra("fullemail");
        String addressfinal = gettingIntent.getStringExtra("fulladdress");
        String totalfinal = gettingIntent.getStringExtra("fulltotal1");
        String sizefinal = gettingIntent.getStringExtra("fullsize");
        //String toppingfinal = pizza.getItem(0);

        TextView nameview = findViewById(R.id.name2);
        TextView phoneview = findViewById(R.id.phone2);
        TextView emailview = findViewById(R.id.email2);
        TextView addressview = findViewById(R.id.address2);
        TextView totalview = findViewById(R.id.totals);
        TextView sizeview = findViewById(R.id.size2);
        TextView toppingview = findViewById(R.id.toppings2);

        nameview.setText(namefinal);
        phoneview.setText(phonefinal);
        emailview.setText(emailfinal);
        addressview.setText(addressfinal);
        totalview.setText(totalfinal);
        sizeview.setText(sizefinal);
        //toppingview.setText(toppingfinal);
    }
}