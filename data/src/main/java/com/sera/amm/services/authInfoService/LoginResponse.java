package com.sera.amm.services.authInfoService;

import java.io.Serializable;


public class LoginResponse implements Serializable{
    public String user_id;
    public String user_name;
    public String email;
    public String access_token;
    public String refresh_token;
}
