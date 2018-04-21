package com.example.ankita.project;

/**
 * Created by ankita on 31-Mar-18.
 */

public class contact {
    String name,email,uname,pass;
    String adminusername,adminpass;

    // for name
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    //for email
    public String getEmail()
    {
        return this.email;
    }

    public void setEmail (String email)
    {
        this.email=email;
    }

    // for username
    public String getUname()
    {
        return this.uname;
    }

    public void setUname (String uname)
    {
        this.uname=uname;
    }

    // for password
    public String getPass()
    {
        return this.pass;
    }

    public void setPass (String pass)
    {
        this.pass=pass;
    }

    //for admin
    public String getAdminusername()
    {
        return this.adminusername;
    }

    public void setAdminusername(String adminusername)
    {
        this.adminusername = adminusername;
    }

    public String getAdminpass()
    {
        return this.adminpass;
    }
    public void setAdminpass(String adminpass)
    {
        this.adminpass=adminpass;
    }
}
