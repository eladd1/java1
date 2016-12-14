package com.example.elad.android5777.model.datasource;

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
