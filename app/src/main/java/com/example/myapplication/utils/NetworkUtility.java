package com.example.myapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkUtility {
    public static boolean checkConnection(Context context){
        return checkConnection(context,true);
    }
    public static boolean checkConnection(Context context,boolean isDialogRequired){
        final ConnectivityManager connMgr=(ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        if(connMgr!=null){
            NetworkInfo activeNetworkInfo=connMgr.getActiveNetworkInfo();
            if(activeNetworkInfo!=null){
                if(activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI){
                    return  true;
                }else
                    return activeNetworkInfo.getType()==ConnectivityManager.TYPE_MOBILE;
            }
        }if(isDialogRequired)
            Toast.makeText(context, "Check network Connection", Toast.LENGTH_SHORT).show();
            return false;
    }
}
