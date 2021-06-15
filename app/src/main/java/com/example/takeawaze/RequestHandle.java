package com.example.takeawaze;

import org.json.JSONException;

public interface RequestHandle {
    public abstract void processResponse(String response) throws JSONException;
}
