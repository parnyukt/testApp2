package util;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class AppUtils {
    static final String TAG = AppUtils.class.getSimpleName();

    public static JSONObject loadJsonFromAssets(Context context, String fileName){
        InputStream input = null;
        try {

            input = readFromAssets(context, fileName);

            int size = 0;
            size = input.available();

            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            // byte buffer into a string
            String data = new String(buffer);
            JSONObject jo = new JSONObject(data);
            return jo;

        }catch (IOException e) {
            Log.e(TAG, "Error reading file", e);
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing Json", e);
        }
        return null;
    }

    private static InputStream readFromAssets(Context context, String fileName) throws IOException {
        AssetManager assetManager = context.getAssets();
        return assetManager.open(fileName);
    }
}
