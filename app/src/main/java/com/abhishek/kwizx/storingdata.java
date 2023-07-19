package com.abhishek.kwizx;

public class storingdata {
    String usename,fullname,email,password;

    public storingdata() {

    }

    public storingdata(String usename, String fullname, String email, String password) {
        this.usename = usename;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
