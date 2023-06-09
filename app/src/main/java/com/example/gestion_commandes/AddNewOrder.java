package com.example.gestion_commandes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewOrder extends AppCompatActivity {
   // public static  DatabaseHelper mydatabase;
    private  com.example.gestion_commandes.DatabaseHelper mydatabase;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addneworder);



        EditText editTextnum = findViewById(R.id.editTextTextPersonName2);

        EditText editTextName = findViewById(R.id.editTextTextPersonName3);


        EditText editTextQuntity = findViewById(R.id.editTextTextPersonName4);

        Button AddnewCommnd = findViewById(R.id.Addneworder);

        mydatabase = new DatabaseHelper(this);
        AddnewCommnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = editTextnum.getText().toString();
                String name = editTextName.getText().toString();

                String quantity = editTextQuntity.getText().toString();

                if (TextUtils.isEmpty(num)) {
                    editTextnum.setError("Please enter a valid number");
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    editTextName.setError("Please enter a valid name");
                    return;
                }

                if (TextUtils.isEmpty(quantity)) {
                    editTextQuntity.setError("Please enter a valid quantity");
                    return;
                }

                // All input fields are valid, proceed with database insertion

             boolean isinserted =   mydatabase.addCommande(Integer.parseInt(num), name, quantity  );
              if(isinserted)
              {
                  editTextnum.setText("");
                  editTextName.setText("");
                  editTextQuntity.setText("");
                  Toast.makeText(AddNewOrder.this, "Data is inserted", Toast.LENGTH_SHORT).show();
              }
              else {
                  Toast.makeText(AddNewOrder.this, "Something went wrong", Toast.LENGTH_SHORT).show();

              }
            }
        });







    }



}