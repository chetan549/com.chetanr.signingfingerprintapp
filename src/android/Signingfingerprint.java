package com.chetanr.plugin;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.Scope;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.apache.cordova.engine.SystemWebChromeClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.PluginResult;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import android.content.pm.Signature;


public class Signingfingerprint extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("getSha1")) {

            /*get finger print*/

            String packageName = webView.getContext().getPackageName();
            int flags = PackageManager.GET_SIGNATURES;
            PackageManager pm = webView.getContext().getPackageManager();
            try {
                PackageInfo packageInfo = pm.getPackageInfo(packageName, flags);
                Signature[] signatures = packageInfo.signatures;
                byte[] cert = signatures[0].toByteArray();

                String strResult = "";
                MessageDigest md;
                md = MessageDigest.getInstance("SHA1");
                md.update(cert);
                for (byte b : md.digest()) {
                    String strAppend = Integer.toString(b & 0xff, 16);
                    if (strAppend.length() == 1) {
                        strResult += "0";
                    }
                    strResult += strAppend;
                    strResult += ":";
                }
         
                strResult = strResult.substring(0, strResult.length()-1);
                strResult = strResult.toUpperCase();

                callbackContext.success(strResult);

            } catch (Exception e) {
                e.printStackTrace();
                callbackContext.success(e.getMessage());
            }

            /*get finger print*/

            return true;

        } else {

            return false;

        }
    }
}
