package com.example.madminiprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button btn_insert;
    Button btn_update;
    Button btn_delete;
    Button btn_select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInsertActivity();
            }
        });

        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUpdateActivity();
            }
        });

        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeleteActivity();
            }
        });

        btn_select = (Button) findViewById(R.id.btn_select);
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelectActivity();
            }
        });



    }

    public void openInsertActivity() {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }

    public void openUpdateActivity() {
        Intent intent = new Intent(this, UpdateActivity.class);
        startActivity(intent);
    }

    public void openDeleteActivity() {
        Intent intent = new Intent(this, DeleteActivity.class);
        startActivity(intent);
    }

    public void openSelectActivity() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }


}