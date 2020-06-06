package com.example.sampleapp.ui.ui.login;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.sampleapp.R;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
//        EditText username = (EditText) view.findViewById(R.id.username);
//        displayName = username.getText().toString();
        return displayName;
    }

//    public void loginClick(View view) {
//        EditText username = (EditText) view.findViewById(R.id.username);
//        Log.i("Info", username.getText().toString());
//    }
}