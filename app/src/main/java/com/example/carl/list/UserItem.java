package com.example.carl.list;

/**
 * Created by Carl on 13/11/2016.
 */

public class UserItem
{
    private String itemName;

    public UserItem(String itemName)
    {
        this.itemName = itemName;
    }

    public String getItemName()
    {
        return itemName;
    }

    @Override
    public String toString()
    {
        return itemName;
    }
}
