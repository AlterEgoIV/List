package com.example.carl.list;

/**
 * Created by Carl on 13/11/2016.
 */

public class UserList
{
    private String listName;
    private String listDescription;

    public UserList(String listName, String listDescription)
    {
        this.listName = listName;
        this.listDescription = listDescription;
    }

    public String getListName()
    {
        return listName;
    }

    public String getListDescription()
    {
        return listDescription;
    }
}
