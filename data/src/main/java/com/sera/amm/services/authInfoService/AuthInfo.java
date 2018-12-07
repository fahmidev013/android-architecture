package com.sera.amm.services.authInfoService;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;

/**
 * Created by Fahmi Hakim on 07/12/2018.
 * for SERA
 */
public class AuthInfo implements Serializable {
    private SharedPreferences authPref;
    private String userId;
    private String username;
    private String email;
    private String accessToken;
    private String refreshToken;

    public AuthInfo(Context context) {
        authPref = context.getSharedPreferences("AUTH_INFO", Context.MODE_PRIVATE);
        loadFromCache();
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    private void loadFromCache() {
        if (authPref != null && !isStringNullOrEmpty(authPref.getString("userId", null))) {
            this.userId = authPref.getString("userId", null);
            this.username = authPref.getString("username", null);
            this.email = authPref.getString("email", null);
            this.accessToken = authPref.getString("accessToken", null);
            this.refreshToken = authPref.getString("refreshToken", null);
        } else {
            reset();
        }
    }

    private void saveToCache() {
        SharedPreferences.Editor editor = authPref.edit();
        editor.putString("userId", this.userId);
        editor.putString("username", this.username);
        editor.putString("email", this.email);
        editor.putString("accessToken", this.accessToken);
        editor.putString("refreshToken", this.refreshToken);
        editor.commit();
    }

    private void removeFromCache() {
        SharedPreferences.Editor editor = authPref.edit();
        editor.remove("userId");
        editor.remove("username");
        editor.remove("email");
        editor.remove("accessToken");
        editor.remove("refreshToken");
        editor.commit();
    }

    private void reset() {
        this.userId = null;
        this.username = null;
        this.email = null;
        this.accessToken = null;
        this.refreshToken = null;
    }

    public void resetAndRemoveFromCache() {
        reset();
        removeFromCache();
    }

    public void updateFromLoginResponse(LoginResponse response) {
        this.userId = response.user_id.trim();
        this.username = response.user_name.trim();
        this.email = response.email.trim();
        this.accessToken = response.access_token.trim();
        this.refreshToken = response.refresh_token.trim();
        saveToCache();
    }


    public boolean isStringNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }
}
