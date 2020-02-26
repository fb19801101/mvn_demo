package com.mvn.service;

public class LoginBeam {
    private String username;
    private String password;
    private boolean autologin;
    private boolean remberpwd;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public boolean getAutologin() {
        return autologin;
    }
    public void setAutologin(boolean autologin) {
        this.autologin = autologin;
    }
    public boolean getRemberpwd() {
        return remberpwd;
    }
    public void setRemberpwd(boolean remberpwd) {
        this.remberpwd = remberpwd;
    }
}
