package com.example.myapplication.module.roll_video.utils;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by ASUS on 2017/7/21.
 */

public class ThreadUtils {
    private static Handler handler=new Handler(Looper.getMainLooper());
    public static void getUIThread(Runnable task){
        handler.post(task);
    }
    public static void getSThread(Runnable task){
        new Thread(task).start();
    }
}
