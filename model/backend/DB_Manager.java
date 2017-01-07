package com.example.elad.android5777.model.backend;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.elad.android5777.model.entities.Active;
import com.example.elad.android5777.model.entities.Business;
import com.example.elad.android5777.model.entities.User;

import java.util.Collection;

/**
 * Created by Elad on 22/11/2016.
 */

public interface DB_Manager {

    public void addUser(ContentValues u);
    public void addBusiness (ContentValues b);
    public void addActivity (ContentValues a);

    public Cursor getUsers() throws Exception;
    public Cursor getActivity() throws Exception;
    public Cursor getBusiness() throws Exception;

    public boolean isBusinessChanged();
    public boolean isActivityChanged();
}
