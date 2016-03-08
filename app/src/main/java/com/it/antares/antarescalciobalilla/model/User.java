package com.it.antares.antarescalciobalilla.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.File;

/**
 * Created by Fabio on 04/03/2016.
 */
@ParseClassName("User")
public class User extends ParseObject {
    public User() {
    }

    public String getObjectId(){
        return getString("objectId");
    }

    public void setObjectId(String objectId){
        put("objectId", objectId);
    }

    public String getUsername(){
        return getString("username");
    }

    public void setUsername(String username){
        put("username", username);
    }

    public String getName(){
        return getString("Name");
    }

    public void setName(String Name){
        put("Name", Name);
    }

    public String getEmail(){
        return getString("email");
    }

    public void setEmail(String email){
        put("email", email);
    }
}
