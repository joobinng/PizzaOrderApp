package com.example.pizzaorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Setting variables
    PizzaModel pizza;
    TextView total;
    private double total_price;

    TextView pepperoni;
    TextView chicken;
    TextView olive;
    TextView mushroom;
    TextView green_pepper;
    TextView extra_cheese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating pizza object and total
        pizza = new PizzaModel();
        total = findViewById(R.id.total);

        //Creating method for button click
        Button button = (Button) findViewById(R.id.next1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomerpage();
            }
        });
        /*if(savedInstanceState != null) {
            total_price = savedInstanceState.getDouble("saveState");
            total.setText(String.valueOf(total_price));
        }*/
    }

    /*@Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("saveState", radioClicked());
    }*/

    //Method for determining price when radio button is clicked
    public void radioClicked(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()){
            case R.id.rb1:
                if (checked)
                    pizza.setPizza_prices(8);
                break;
            case R.id.rb2:
                if (checked)
                    pizza.setPizza_prices(10);
                break;
            case R.id.rb3:
                if (checked)
                    pizza.setPizza_prices(12);
                break;
        }
        total.setText("Total Price: " + String.format("%.2f", pizza.getPizza_prices()) + "$");
    }

    //Method for determining topping price added onto pizza
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch ((view.getId())){
            case R.id.cb1:
                if(checked) {
                    pizza.setPepperoni(0.50);
                    pizza.addItem("Pepperoni");
                }else{
                    pizza.setPepperoni(0);
                    pizza.removeItem("Pepperoni");}
                break;
            case R.id.cb2:
                if(checked) {
                    pizza.setChicken(0.50);
                    pizza.addItem("Chicken");
                }else{
                    pizza.setChicken(0);
                    pizza.removeItem("Chicken");}
                break;
            case R.id.cb3:
                if(checked) {
                    pizza.setOlive(0.50);
                    pizza.addItem("Olive");
                }else{
                    pizza.setOlive(0);
                    pizza.removeItem("Olive");}
                break;
            case R.id.cb4:
                if(checked) {
                    pizza.setMushroom(0.50);
                    pizza.addItem("Mushroom");
                }else{
                    pizza.setMushroom(0);
                    pizza.removeItem("Mushroom");}
                break;
            case R.id.cb5:
                if(checked) {
                    pizza.setGreen_pepper(0.50);
                    pizza.addItem("Green Pepper");
                }else{
                    pizza.setGreen_pepper(0);
                    pizza.removeItem("Green Pepper");}
                break;
            case R.id.cb6:
                if(checked) {
                    pizza.setExtra_cheese(0.50);
                    pizza.addItem("Extra Cheese");
                }else{
                    pizza.setExtra_cheese(0);
                    pizza.removeItem("Extra Cheese");}
                break;
        }
        total.setText("Total Price: " + String.format("%.2f", calculate_total()) + "$");

    }



    //Method for calculating total price of pizza with toppings added on
    private double calculate_total(){
        total_price = pizza.getPizza_prices() + pizza.getPepperoni() + pizza.getChicken() + pizza.getOlive() + pizza.getMushroom()
                + pizza.getGreen_pepper() + pizza.getExtra_cheese();
        return total_price;
    }

    //Method for opening Customer information page
    public void openCustomerpage(){
        Intent intent = new Intent(this, Customerpage.class);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        String selectedRadioValue = ((RadioButton)findViewById(rg.getCheckedRadioButtonId() )).getText().toString();

        //CheckBox cb = (CheckBox) findViewById(R.id.cb1);
        //String chbx1 = ((Boolean)findViewById(cb.isChecked() )).getText().toString();

        //putExtra sent total to customer page
        total = (TextView) findViewById(R.id.total);
        String fulltotal = total.getText().toString();

        //pizza = (TextView) findViewById(R.id.toppings);
        //String fulltoppings = pizza.getItem().toString();

        intent.putExtra("radioGroup", selectedRadioValue);
        intent.putExtra("fulltotal", fulltotal);

        startActivity(intent);
    }
}