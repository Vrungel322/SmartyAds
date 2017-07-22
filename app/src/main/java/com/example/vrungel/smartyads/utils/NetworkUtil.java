package com.example.vrungel.smartyads.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by John on 26.01.2017.
 */

public final class NetworkUtil {

  /**
   * Returns true if the Throwable is an instance of RetrofitError with an
   * http status code equals to the given one.
   */
  public static boolean isNetworkConnected(Context context) {
    ConnectivityManager cm =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
  }
}
