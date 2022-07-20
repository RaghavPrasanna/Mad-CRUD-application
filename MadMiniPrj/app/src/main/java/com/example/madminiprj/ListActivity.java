package com.example.madminiprj;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    ListView userlist;

    ArrayList<String> listItem;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        myDb = new DatabaseHelper(this);

        listItem = new ArrayList<>();
        userlist =findViewById(R.id.users_list);
        viewData();

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String text = userlist.getItemAtPosition(i).toString();
                Toast.makeText(ListActivity.this, ""+text, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void viewData() {
        Cursor cursor = myDb.viewData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data to show", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                listItem.add("ID:" + cursor.getString(0) );
                listItem.add("Name:" + cursor.getString(1) );
                listItem.add("Gender:" + cursor.getString(2) );
                listItem.add("Age:" + cursor.getString(3) );
                listItem.add("Salary:" + cursor.getString(4) +"\n\n\n");
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);
        }
    }
}