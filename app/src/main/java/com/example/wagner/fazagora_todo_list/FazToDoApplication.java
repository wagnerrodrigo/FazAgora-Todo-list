package com.example.wagner.fazagora_todo_list;

import android.app.Application;
import io.realm.Realm;

public class FazToDoApplication extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
    }
}
