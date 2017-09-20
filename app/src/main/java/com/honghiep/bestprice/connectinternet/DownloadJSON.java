package com.honghiep.bestprice.connectinternet;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.honghiep.bestprice.model.trangchu.xulymenuitem.XuLyMenuItem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo S410p on 6/25/2016.
 */
public class DownloadJSON {
    public static String getJson(String api){
        String link="http://192.168.100.17:8080"+api;
        URL url = null;
        try {
            url = new URL(link);
            String content = "";
            InputStream in = url.openStream();
            byte b[] = new byte[1024];
            int le = in.read(b);
            while (le >= 0 ) {
                content = content + new String(b, 0, le);
                le = in.read(b);
            }
            in.close();
            return content;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
