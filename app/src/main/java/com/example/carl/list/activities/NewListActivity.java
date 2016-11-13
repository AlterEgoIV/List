package com.example.carl.list.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.carl.list.R;
import com.example.carl.list.UserList;

public class NewListActivity extends AppCompatActivity {

    private UserList userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        findViewById(R.id.addList).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userList = new UserList(findViewById(R.id.listName).toString(), findViewById(R.id.listDescription).toString());
                startActivity(new Intent(NewListActivity.this, NewListItemActivity.class));
            }
        });
    }
}
