package com.example.carl.list;

/**
 * Created by Carl on 13/11/2016.
 */

public class UserItem
{
    private String itemName;
    private long listId;

    public UserItem(String itemName, long listId)
    {
        this.itemName = itemName;
        this.listId = listId;
    }

    public String getItemName()
    {
        return itemName;
    }

    public long getListId()
    {
        return listId;
    }
}
