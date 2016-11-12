package com.example.carl.list;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class HomeActivity extends ListActivity {

    private ListDatabaseManager listDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listDatabaseManager = new ListDatabaseManager(this);

        listDatabaseManager.open();
        //listDatabaseManager.insertList("Games", "The games");
        //listDatabaseManager.insertItem("FFXV", "New Final Fantasy");
        Cursor cursor = listDatabaseManager.getAllLists();
        cursor.moveToFirst();
        //String listName = cursor.getString(1);
        //Log.d("Listname", listName);
        cursor.close();
        listDatabaseManager.close();

        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(HomeActivity.this, NewListActivity.class));
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {

    }
}
