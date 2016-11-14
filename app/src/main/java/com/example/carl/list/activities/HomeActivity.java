package com.example.carl.list.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.carl.list.ListDatabaseManager;
import com.example.carl.list.R;
import com.example.carl.list.UserList;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends ListActivity {

    private ListDatabaseManager listDatabaseManager;
    private List<UserList> userLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userLists = new ArrayList<UserList>();

        listDatabaseManager = new ListDatabaseManager(this);

        listDatabaseManager.open();
        //listDatabaseManager.insertList("Games", "The games");
        //listDatabaseManager.insertItem("FFXV");
        Cursor cursor = listDatabaseManager.getAllLists();
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            UserList userList = new UserList(cursor.getString(1), cursor.getString(2));

            userLists.add(userList);

            cursor.moveToNext();
        }

        setListAdapter(new ArrayAdapter<UserList>(this, android.R.layout.simple_list_item_1, userLists));

        // String listName = cursor.getString(1);
        // Log.d("Listname", listName);
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
