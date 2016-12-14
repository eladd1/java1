package com.example.elad.android5777.model.backend;

import android.content.ContentValues;

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

    public boolean isAdded ();

    public Collection<User> getUsers();
    public Collection<Business> getBusinesses();
    public Collection<Active> getActivities();
    public void checkForChanges();
}
