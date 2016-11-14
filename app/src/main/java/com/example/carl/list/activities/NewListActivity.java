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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        listDatabaseManager = new ListDatabaseManager(this);
        listDatabaseManager.open();

        // Button addList onClickListener
        findViewById(R.id.addList).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*userList = new UserList(findViewById(R.id.listName).toString(), findViewById(R.id.listDescription).toString());

                if(userList.getListName().length() > 0)
                {
                    listDatabaseManager.insertList(userList.getListName(), userList.getListDescription());
                    //listDatabaseManager.close();
                }

                startActivity(new Intent(NewListActivity.this, NewListItemActivity.class));*/

                String listName = ((EditText)findViewById(R.id.listName)).getText().toString();
                String listDescription = ((EditText)findViewById(R.id.listDescription)).getText().toString();

                if(!listName.equals(""))
                {
                    userList = new UserList(listName, listDescription);
                    listDatabaseManager.insertList(userList.getListName(), userList.getListDescription());
                    //findViewById(R.id.newItem).setContentDescription("");
                    //((EditText)findViewById(R.id.newItem)).setText("");
                }
                else
                {
                    Toast.makeText(NewListActivity.this, "Must enter a list name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
