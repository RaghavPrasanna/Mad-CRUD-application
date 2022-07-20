package com.example.madminiprj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    Button btnDelete;
    EditText editId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        myDb = new DatabaseHelper(this);

        editId = (EditText) findViewById(R.id.editText_id);
        btnDelete = (Button) findViewById(R.id.button_delete);

        DeleteData();

    }

    public void DeleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer deletedRows = myDb.deleteData(editId.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(DeleteActivity.this,"Data Deleted Succesfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DeleteActivity.this,"Data is NOT Deleted", Toast.LENGTH_LONG).show();
            }
        });

    }

}