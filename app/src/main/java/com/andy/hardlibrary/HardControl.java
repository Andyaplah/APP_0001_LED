package com.andy.hardlibrary;

public class HardControl {

    public static native int ledCtrl(int which,int status);
    public static native int ledOpen();
    public static native void ledClose();

    //加载c库 定义static模块
    static {
        try {
            System.loadLibrary("hardcontrol");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
