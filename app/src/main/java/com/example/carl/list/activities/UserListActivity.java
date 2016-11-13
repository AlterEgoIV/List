package com.example.carl.list.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.carl.list.R;

/**
 * Created by Carl on 10/11/2016.
 */

public class UserListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {

    }
}
