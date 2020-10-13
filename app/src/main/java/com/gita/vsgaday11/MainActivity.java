package com.gita.vsgaday11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.gita.vsgaday11.helper.DbHelper;
import com.gita.vsgaday11.model.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> itemList = new ArrayList<Data>();
    Adapter adapter;
    DbHelper SQLite = new DbHelper(this);

    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_ADDRESS = "address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //tambah SQLite
        SQLite = new DbHelper(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);

        //tambah list view
        listView = (ListView) findViewById(R.id.list_view);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEdit.class);
                startActivity(intent);
            }
        });

        //tambah adapter dan listview
        adapter = new Adapter (MainActivity.this, itemList);
        listView.setAdapter(adapter);
    }
}