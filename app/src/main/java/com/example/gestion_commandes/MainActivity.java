package com.example.gestion_commandes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button Ajouterunenouvellcommand;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ajouterunenouvellcommand = findViewById(R.id.Ajouternouvellecomand);
        intent =   new Intent(this,AjouternouvelleCommande.class);
        Ajouterunenouvellcommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent);


            }
        });




    }
}