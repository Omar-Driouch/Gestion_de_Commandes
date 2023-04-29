package com.example.gestion_commandes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class showdata extends AppCompatActivity {
    public static String titlee="Show Content";
    public   com.example.gestion_commandes.DatabaseHelper mydatabase;
    public static TextView Commandid,Commandname,CommandQuantity,CommandDate;
    public static String id,name,quantity,date;
    public static Button Next,Previois;
    public int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        Commandid = findViewById(R.id.CommandID0);
        Commandname = findViewById(R.id.commandname0);
        CommandQuantity = findViewById(R.id.quantity);

        mydatabase = new DatabaseHelper(this);
        Next = findViewById(R.id.nexttt);
        Previois = findViewById(R.id.previos);




        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> Mydata = mydatabase.getAllCommandes();

                if (position >= Mydata.size() - 1) {
                    position = 0;
                } else {
                    position++;
                }

                try {
                    String[] parts = Mydata.get(position).split(",");
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String quantite = parts[2].trim();

                    Commandid.setText(id);
                    Commandname.setText(name);
                    CommandQuantity.setText(quantite);
                } catch (Exception e) {
                    Toast.makeText(showdata.this, e.toString() + "  " + position, Toast.LENGTH_SHORT).show();
                }
            }

        });


        Previois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> Mydata = mydatabase.getAllCommandes();

                if (position == 0) {
                    position = Mydata.size() - 1;
                } else {
                    position--;
                }

                if (position <= -1) {
                    position = Mydata.size() - 1;
                }

                try {
                    String[] parts = Mydata.get(position).split(",");
                    String id = parts[0].trim();
                    String nom = parts[1].trim();
                    String quantite = parts[2].trim();

                    Commandid.setText(id);
                    Commandname.setText(nom);
                    CommandQuantity.setText(quantite);
                } catch (Exception e) {
                    Toast.makeText(showdata.this, e.toString() + "  " + position, Toast.LENGTH_SHORT).show();
                }
            }

        });












    }
}