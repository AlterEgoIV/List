package com.example.carl.list.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.carl.list.ListDatabaseManager;
import com.example.carl.list.R;
import com.example.carl.list.UserItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 10/11/2016.
 */

public class UserListActivity extends ListActivity
{
    private ListDatabaseManager listDatabaseManager;
    private Intent intent;
    private List<UserItem> userItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listDatabaseManager = new ListDatabaseManager(this);
        userItems = new ArrayList<>();

        Cursor cursor = listDatabaseManager.getAllItems();

        cursor.moveToFirst();

        intent = getIntent();

        long id = intent.getExtras().getLong("listid");

        while(!cursor.isAfterLast())
        {
            if(cursor.getLong(1) == id)
            {
                UserItem userItem = new UserItem(cursor.getString(0));

                userItems.add(userItem);

                cursor.moveToNext();
            }
        }

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userItems));

        cursor.close();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {

    }
}
