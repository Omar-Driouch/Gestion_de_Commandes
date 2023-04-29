package com.example.gestion_commandes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button addneworder;
    private Button orders;
    private Intent intent;
    private Intent intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addneworder = findViewById(R.id.AddNewOrders);
        orders = findViewById(R.id.orders);
        intent =   new Intent(this, AddNewOrder.class);
        addneworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent);


            }
        });








        intent2 =   new Intent(this,showdata.class);
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent2);


            }
        });



    }
}