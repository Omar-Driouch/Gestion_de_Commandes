package com.example.gestion_commandes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button Ajouterunenouvellcommand;
    private Button Consulterlescommand;
    private Intent intent;
    private Intent intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ajouterunenouvellcommand = findViewById(R.id.Ajouternouvellecomand);
        Consulterlescommand = findViewById(R.id.Consulterlescommandes);
        intent =   new Intent(this,AjouternouvelleCommande.class);
        Ajouterunenouvellcommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent);


            }
        });








        intent2 =   new Intent(this,showdata.class);
        Consulterlescommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent2);


            }
        });



    }
}