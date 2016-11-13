package com.example.carl.list.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.carl.list.ListDatabaseManager;
import com.example.carl.list.R;
import com.example.carl.list.UserItem;

public class NewListItemActivity extends AppCompatActivity
{
    private ListDatabaseManager listDatabaseManager;
    private UserItem userItem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list_item);

        listDatabaseManager = new ListDatabaseManager(this);

        // Button addList onClickListener
        findViewById(R.id.addList).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userItem = new UserItem(findViewById(R.id.newItem).toString());

                if(userItem.getItemName().length() > 0)
                {
                    listDatabaseManager.insertItem(userItem.getItemName());
                }
            }
        });
    }
}
