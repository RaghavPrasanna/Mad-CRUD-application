package com.example.madminiprj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText editName, editGender, editAge, editSalary;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editText_name);
        editGender = (EditText) findViewById(R.id.editText_gender);
        editAge = (EditText) findViewById(R.id.editText_age);
        editSalary = (EditText) findViewById(R.id.editText_salary);
        btnAddData = (Button) findViewById(R.id.button_update);
        AddData();
    }

    public void AddData() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted =  myDb.insertData(editName.getText().toString(),
                        editGender.getText().toString(),
                        editAge.getText().toString(),
                        editSalary.getText().toString() );

                if(isInserted == true)
                    Toast.makeText(InsertActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(InsertActivity.this,"Data is NOT Inserted", Toast.LENGTH_LONG).show();

            }
        });
    }


}