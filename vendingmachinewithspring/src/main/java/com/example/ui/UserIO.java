package com.example.ui;


public interface UserIO {

    void print(String message);

    double readDouble(String promptMsg);

    double readDouble(String promptMsg, double minVal, double maxVal);

    float readFloat(String promptMsg);

    float readFloat(String promptMsg, float minVal, float maxVal);

    int readInt(String promptMsg);

    int readInt(String promptMsg, int minVal, int maxVal);

    long readLong(String promptMsg);

    long readLong(String promptMsg, long minVal, long maxVal);

    String readString(String promptMsg);

}
