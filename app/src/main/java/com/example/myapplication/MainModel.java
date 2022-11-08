package com.example.myapplication;

public class MainModel {
    String NameSV, EmailSV, turl;

    MainModel(){

    }

    public MainModel(String nameSV, String emailSV, String turl) {
        NameSV = nameSV;
        EmailSV = emailSV;
        this.turl = turl;

    }

    public String getNameSV() {
        return NameSV;
    }

    public void setNameSV(String nameSV) {
        NameSV = nameSV;
    }

    public String getEmailSV() {
        return EmailSV;
    }

    public void setEmailSV(String emailSV) {
        EmailSV = emailSV;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }


}

