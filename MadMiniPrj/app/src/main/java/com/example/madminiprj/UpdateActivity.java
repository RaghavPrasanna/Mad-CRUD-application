package com.example.madminiprj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    Button btnUpdate;
    EditText editId;
    EditText editName, editGender, editAge, editSalary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editText_name);
        editGender = (EditText) findViewById(R.id.editText_gender);
        editAge = (EditText) findViewById(R.id.editText_age);
        editSalary = (EditText) findViewById(R.id.editText_salary);
        editId = (EditText) findViewById(R.id.editText_id);
        btnUpdate = (Button) findViewById(R.id.button_update);
        UpdateData();

    }

    public void UpdateData() {
        btnUpdate .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updateData(editId.getText().toString(), editName.getText().toString(),editGender.getText().toString()
                        ,editAge.getText().toString(),editSalary.getText().toString());  //this will get text,convert to string and pass it to this fn.
                if(isUpdate == true)
                    Toast.makeText(UpdateActivity.this,"Data Updated Succesfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(UpdateActivity.this,"Data is NOT Updated", Toast.LENGTH_LONG).show();
            }
        });
    }


}