package com.example.carl.list;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class HomeActivity extends ListActivity {

    private ListDatabaseManager listDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listDatabaseManager = new ListDatabaseManager(this);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {

    }
}
