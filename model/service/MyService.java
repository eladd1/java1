package com.example.elad.android5777.model.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.elad.android5777.model.backend.DB_Manager;
import com.example.elad.android5777.model.datasource.DBManagerFactory;

/**
 * Created by Elad on 01/12/2016.
 */

public class MyService extends Service {
    
    DB_Manager db;
    private final int timeToSleep = 4000;
    Thread background;
    boolean running = true;
    
    public MyService() {
        db = DBManagerFactory.getManager();
        background = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    searchForChange();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    stopSearch();
                }
            }
        });
    }

    private void searchForChange() throws InterruptedException {
        while (running) {
            if (db.isBusinessChanged() || db.isActivityChanged())
            {
                broadcastIntent();
            }
            Thread.sleep(timeToSleep);
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        background.start();
        //Toast.makeText(getApplicationContext(),"hi2",Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    public void broadcastIntent() {
        Intent intent = new Intent();
        intent.putExtra("message", "Activity/BusinnessUpdade");
        intent.setAction("com.javacodegeeks.android.A_CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        stopSearch();
    }

    private void stopSearch() {
        running = false;
    }
}
