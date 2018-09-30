package com.example.wagner.fazagora_todo_list.Model;

import java.util.Date;
import java.util.UUID;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Item extends RealmObject {
    @PrimaryKey
    @Required
    private String itemId;

    @Required private String body;

    @Required private Boolean isDone;

    @Required private Date timestamp;


}
