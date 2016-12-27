package com.example.elad.android5777.model.datasource;

import android.content.ContentValues;

import com.example.elad.android5777.model.backend.DB_Manager;

/**
 * Created by Elad on 26/11/2016.
 */

public class DBManagerFactory {
    enum DBtype {Local, RemoteServer};

    static DBtype type = DBtype.Local;

    private static DB_Manager manager = null;
    public static DB_Manager getManager()
    {
        if(manager == null)
        {
            switch(type)
            {
                case Local:
                    manager = new LocalDBManager();
                    ContentValues c = new ContentValues();
                    c.put("id", 1);
                    c.put("name", "elad@gmail.com");
                    c.put("password", "1234");
                    manager.addUser(c);
                    c.put("id", 2);
                    c.put("name", "dvir@gmail.com");
                    c.put("password", "5678");
                    manager.addUser(c);
                    break;
                //case RemoteServer:
                //manager = new ServerDBManager();
                //break;
                default:
                    break;
            }
        }
    return manager;
    }
}
