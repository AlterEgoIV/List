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

        userLists = new ArrayList<>();

        listDatabaseManager = new ListDatabaseManager(this);

        listDatabaseManager.open();

        // Return all rows from the List table to the Cursor
        Cursor cursor = listDatabaseManager.getAllLists();

        // Position the Cursor at the first row in the List table
        cursor.moveToFirst();

        // While the Cursor is still pointing at a row in the List table
        while(!cursor.isAfterLast())
        {
            // Create a UserList which holds the current rows list name and list description
            UserList userList = new UserList(cursor.getString(1), cursor.getString(2));

            userLists.add(userList); // add the UserList to the ArrayList of UserLists

            cursor.moveToNext(); // Move the Cursor to the next row
        }

        // Set the ListView to display the contents of userLists
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userLists));

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
        startActivity(new Intent(this, UserListActivity.class));
    }
}
