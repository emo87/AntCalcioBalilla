package com.it.antares.antarescalciobalilla.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Fabio on 04/03/2016.
 */
@ParseClassName("Team")
public class Team extends ParseObject {
    public Team()
    {
        super();
    }

    public Team(String name){
        super();
        setName(name);
    }

    public String getObjectId(){
        return getString("objectId");
    }

    public void setObjectId(String objectId){
        put("objectId", objectId);
    }

    public String getName(){
        return getString("Name");
    }

    public void setName(String Name){
        put("Name", Name);
    }

    public String getFirstUserId(){
        return getString("FirstUserId");
    }

    public void setFirstUserId(String FirstUserId){
        put("FirstUserId", FirstUserId);
    }

    public String getSecondUserId(){
        return getString("SecondUserId");
    }

    public void setSecondUserId(String SecondUserId){
        put("SecondUserId", SecondUserId);
    }
}
