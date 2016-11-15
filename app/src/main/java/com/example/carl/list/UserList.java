package com.example.carl.list;

/**
 * Created by Carl on 13/11/2016.
 */

public class UserList
{
    private String listName;
    private String listDescription;
    private long id;

    public UserList(String listName, String listDescription)
    {
        this.listName = listName;
        this.listDescription = listDescription;
    }

    public UserList(long id, String listName, String listDescription)
    {
        this.listName = listName;
        this.listDescription = listDescription;
        this.id = id;
    }

    public long getId()
    {
        return id;
    }

    public String getListName()
    {
        return listName;
    }

    public String getListDescription()
    {
        return listDescription;
    }

    @Override
    public String toString()
    {
        return listName;
    }
}
