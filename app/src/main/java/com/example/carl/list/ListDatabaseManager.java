package com.example.carl.list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Carl on 10/11/2016.
 */

public class ListDatabaseManager
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_LISTNAME = "list_name";
    public static final String KEY_LIST_DESCRIPTION = "list_description";

    private static final String DATABASE_NAME = "ListDatabase";
    private static final String DATABASE_TABLE = "List";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table Tasks " +
                    "(_id integer primary key autoincrement, " +
                    "list_name text not null, " +
                    "list_description text not null);";

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ListDatabaseManager(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            // dB structure change..

        }
    }

    public ListDatabaseManager open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        DBHelper.close();
    }

    public long insertItem(String taskName, String taskDescription, int completeStatus)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_LISTNAME, taskName);
        initialValues.put(KEY_LIST_DESCRIPTION, taskDescription);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    public boolean deleteTask(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    public Cursor getAllTasks()
    {
        return db.query(DATABASE_TABLE, new String[]
                        {
                                KEY_ROWID,
                                KEY_LISTNAME,
                                KEY_LIST_DESCRIPTION
                        },
                null, null, null, null, null);
    }

    public Cursor getTask(long rowId) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]
                                {
                                        KEY_ROWID,
                                        KEY_LISTNAME,
                                        KEY_LIST_DESCRIPTION
                                },
                        KEY_ROWID + "=" + rowId,  null, null, null, null, null);

        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }

        return mCursor;
    }

    public boolean updateTask(long rowId, String taskName, String taskDescription, int completeStatus)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_LISTNAME, taskName);
        args.put(KEY_LIST_DESCRIPTION, taskDescription);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
