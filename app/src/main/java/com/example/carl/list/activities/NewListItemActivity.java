package com.example.carl.list.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carl.list.ListDatabaseManager;
import com.example.carl.list.R;
import com.example.carl.list.UserItem;

public class NewListItemActivity extends ListActivity
{
    private ListDatabaseManager listDatabaseManager;
    private UserItem userItem;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list_item);

        intent = getIntent();
        ((TextView)findViewById(R.id.listName)).setText(intent.getExtras().getString("listname"));

        listDatabaseManager = new ListDatabaseManager(this);
        listDatabaseManager.open();

        // Button addList onClickListener
        findViewById(R.id.addItem).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //userItem = new UserItem(((EditText)findViewById(R.id.newItem)).getText().toString());
                String itemName = ((EditText)findViewById(R.id.newItem)).getText().toString();

                if(!itemName.equals(""))
                {
                    userItem = new UserItem(itemName);
                    listDatabaseManager.insertItem(userItem.getItemName(), intent.getExtras().getLong("listid"));
                    ((EditText)findViewById(R.id.newItem)).setText("");
                }
                else
                {
                    Toast.makeText(NewListItemActivity.this, "Must enter text", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
