package com.example.elad.android5777.model.datasource;

import java.util.HashMap;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import java.lang.Exception;
import java.util.HashMap;
import android.content.ContentUris;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import com.example.elad.android5777.model.backend.DB_Manager;
import com.example.elad.android5777.model.entities.Business;

/**
 * Created by Elad and Dvir
 */

public class customContentProvider extends ContentProvider {

    static final String PROVIDER_NAME = "com.example.elad.android5777";
    static final String URL = "content://" + PROVIDER_NAME + "/cte";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String id = "id";
    static final String name = "name";
    static final int uriCode = 1;

    private static HashMap<String, String> values;

    // Creates a UriMatcher object.
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI("com.example.elad.android5777", "User", 1);
        sUriMatcher.addURI("com.example.elad.android5777", "Active", 2);
        sUriMatcher.addURI("com.example.elad.android5777", "Business", 3);
    }
    static final String TAG = "customContentProvider";

    DB_Manager db = DBManagerFactory.getManager();

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.d(TAG, "query");
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.d(TAG, "getType");
        return null;
    }

    /**
     *
     * @param uri
     * @param values
     * adding the content value to the correct list
     * @return null
     */
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        Log.d(TAG, "insert");
        //String table = uri.getPath().substring(1);
        switch (sUriMatcher.match(uri))
        {
            case 1:
                db.addUser(values);
                break;
            case 2:
                db.addActivity(values);
                break;
            case 3:
                db.addBusiness(values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
                //throw new exception("Error! number of uri must be between 1 to 3");
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
          // TODO: in "LocalDBManager" and in "DB_Manger" - create delete function and update here the functions
//        Log.d(TAG, "delete");
//        int userCount = 0;
//        int activeCount = 0;
//        int businessCount = 0;
//        //String table = uri.getPath().substring(1);
//        switch (sUriMatcher.match(uri))
//        {
//            case 1:
//                //userCount = db.deleteUser(TABLE_NAME, selection, selectionArgs);
//                getContext().getContentResolver().notifyChange(uri, null);
//                return userCount;
//            case 2:
//                //activeCount = db.deleteUser(TABLE_NAME, selection, selectionArgs);
//                getContext().getContentResolver().notifyChange(uri, null);
//                return activeCount;
//            case 3:
//                //businessCount = db.deleteUser(TABLE_NAME, selection, selectionArgs);
//                getContext().getContentResolver().notifyChange(uri, null);
//                return businessCount;
//            default:
//                throw new IllegalArgumentException("Unknown URI " + uri);
//                //throw new exception("Error! number of uri must be between 1 to 3");
//        }
        return Integer.parseInt(null);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Log.d(TAG, "update");
        // TODO: in "LocalDBManager" and in "DB_Manger" - create update function and update here the functions
//        switch (sUriMatcher.match(uri))
//        {
//            case 1:
//                //db.updateUser(values);
//                break;
//            case 2:
//                //db.updateActivity(values);
//                break;
//            case 3:
//                //db.updateBusiness(values);
//                break;
//            default:
//                throw new IllegalArgumentException("Unknown URI " + uri);
//                //throw new exception("Error! number of uri must be between 1 to 3");
//        }
        return Integer.parseInt(null);    }
}
