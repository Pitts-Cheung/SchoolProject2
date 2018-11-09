package com.example.pitts.schoolproject2;

import java.util.ArrayList;

public class LMLStrings {

    private static ArrayList<String> Strings = new ArrayList<String>();
    private static String AStatus;
    private static String BStatus;
    private static String CStatus;

    public static String getAStatus() {
        return AStatus;
    }

    public static void setAStatus(String AStatus) {
        LMLStrings.AStatus = AStatus;
    }

    public static String getBStatus() {
        return BStatus;
    }

    public static void setBStatus(String BStatus) {
        LMLStrings.BStatus = BStatus;
    }

    public static String getCStatus() {
        return CStatus;
    }

    public static void setCStatus(String CStatus) {
        LMLStrings.CStatus = CStatus;
    }

    public static void add(String s){
        Strings.add(s);
    }

    public static ArrayList<String> getStrings(){
        return Strings;
    }
}
