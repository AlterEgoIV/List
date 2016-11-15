package com.example.carl.list.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carl.list.ListDatabaseManager;
import com.example.carl.list.R;
import com.example.carl.list.UserItem;
import com.example.carl.list.UserList;

public class NewListActivity extends AppCompatActivity
{
    private ListDatabaseManager listDatabaseManager;
    private UserList userList;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        intent = new Intent(this, NewListItemActivity.class);

        listDatabaseManager = new ListDatabaseManager(this);
        listDatabaseManager.open();

        // Button addList onClickListener
        findViewById(R.id.addList).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Find the list name and description from the EditTexts
                String listName = ((EditText)findViewById(R.id.listName)).getText().toString();
                String listDescription = ((EditText)findViewById(R.id.listDescription)).getText().toString();

                // If the list name is not empty
                if(!listName.equals(""))
                {
                    userList = new UserList(listName, listDescription);
                    long listId = listDatabaseManager.insertList(userList.getListName(), userList.getListDescription());

                    intent.putExtra("listid", listId);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(NewListActivity.this, "Must enter a list name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
