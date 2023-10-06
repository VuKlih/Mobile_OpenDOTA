package vn.edu.usth.usthopendotaclient.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.usthopendotaclient.network.models.PlayerObj;
import vn.edu.usth.usthopendotaclient.network.models.ProPlayerObj;

public class PrefUtil {

    public static void saveFavorite(Context context, ProPlayerObj player) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE);
        List<ProPlayerObj> list = getListFavorite(sharedPreferences);
        list.add(player);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("listFav", new Gson().toJson(list));
        editor.commit();
    }

    public static ArrayList<ProPlayerObj> getListFavorite(SharedPreferences sharedPreferences) {
        String strListFavorite = sharedPreferences.getString("listFav", null);
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<List<ProPlayerObj>>() {
            }.getType();
            ArrayList<ProPlayerObj> arr = gson.fromJson(strListFavorite, type);
            return arr == null ? new ArrayList<>() : arr;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
