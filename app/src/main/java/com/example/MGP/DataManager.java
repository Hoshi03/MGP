package com.example.MGP;

public class DataManager {

    private static DataManager instance;
    private boolean isButtonClickable;
    private int bossCount = 0;

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public boolean isButtonClickable() {
        return isButtonClickable;
    }

    public void setButtonClickable(boolean value) {
        isButtonClickable = value;
    }

    public int getBossCount(){
        return bossCount;
    }

    public void setBossCount(){
        bossCount++;
    }
}
