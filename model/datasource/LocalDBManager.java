package com.example.elad.android5777.model.datasource;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;

import com.example.elad.android5777.model.backend.DB_Manager;
import com.example.elad.android5777.model.entities.Active;
import com.example.elad.android5777.model.entities.Business;
import com.example.elad.android5777.model.entities.KindOfAction;
import com.example.elad.android5777.model.entities.User;

import java.net.SocketPermission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Elad and Dvir on 28/11/2016.
 *
 */

public class LocalDBManager implements DB_Manager {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Business> businesses = new ArrayList<>();
    private ArrayList<Active> activities = new ArrayList<>();

    private boolean businessUpdate = false;
    private boolean activitiesUpdate = false;
    private boolean usersUpdate = false;

    Date localUpdate;
    private static final String TAG = "LocalDBManager";

    @Override
    public void addUser(ContentValues obj) {
            usersUpdate = true;
            users.add(new User(
                    obj.getAsInteger("id"),
                    obj.getAsString("name"),
                    obj.getAsString("password")
            ));
    }


    @Override
    public void addBusiness(ContentValues obj) {
        businessUpdate = true;
        businesses.add(new Business(
                obj.getAsInteger("id"),
                obj.getAsString("name"),
                obj.getAsString("address"),
                obj.getAsString("phone"),
                obj.getAsString("email"),
                obj.getAsString("website")
        ));
    }

    @Override
    public void addActivity(ContentValues obj) {
        activitiesUpdate = true;
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        try {
            activities.add(new Active(
                    KindOfAction.TRAVEL_AGENCY,
                    obj.getAsString("country"),
                    formatDate.parse(obj.getAsString("start")),
                    formatDate.parse(obj.getAsString("end")),
                    obj.getAsDouble("price"),
                    obj.getAsString("description"),
                    obj.getAsInteger("businessId")
            ));
        }
        catch (ParseException ex)
        {
            System.out.println("Error with date casting" + ex);
        }
    }

    @Override
    public Cursor getActivity() {
        Active activity;
        MatrixCursor MatrixActions = new MatrixCursor(new String[]{
                "country",
                "start",
                "end",
                "price",
                "description",
                "BusinessId"});
        for (int i = 0; i < activities.size(); i++) {
            activity = activities.get(i);
            MatrixActions.addRow(new Object[]{
                    activity.getCountry(),
                    activity.getStart(),
                    activity.getEnd(),
                    activity.getPrice(),
                    activity.getDescription(),
                    activity.getBusinessId()});
        }
        return MatrixActions;
    }

    @Override
    public Cursor getBusiness() {
        Business business;
        MatrixCursor MatrixBusiness = new MatrixCursor(new String[]{
                "id",
                "name",
                "address",
                "phone",
                "email",
                "website"});
        for (int i = 0; i < businesses.size(); i++) {
            business = businesses.get(i);
            MatrixBusiness.addRow(new Object[]{
                    business.getId(),
                    business.getName(),
                    business.getAddress(),
                    business.getPhone(),
                    business.getEmail(),
                    business.getWebsite()});
        }
        return MatrixBusiness;
    }

    @Override
    public Cursor getUsers() throws Exception {
        User user;
        MatrixCursor MatrixUsers = new MatrixCursor(new String[]{
                "id",
                "name",
                "password"});
        for (int i = 0; i < users.size(); i++) {
            user = users.get(i);
            MatrixUsers.addRow(new Object[]{
                    user.getId(),
                    user.getName(),
                    user.getPassword()});
        }
        return MatrixUsers;
    }

    @Override
    public boolean isBusinessChanged() {
        if(businessUpdate)
        {
            businessUpdate = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean isActivityChanged() {
        if(activitiesUpdate)
        {
            activitiesUpdate = false;
            return true;
        }
        return false;
    }
}
