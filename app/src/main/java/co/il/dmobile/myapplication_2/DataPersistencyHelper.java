package co.il.dmobile.myapplication_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataPersistencyHelper {

    public static Context Context;

    public static void StoreData(List<Car> cars)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(cars);
        editor.putString("users", json);
        editor.commit();
    }

    public static List<Car> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("car",null);
        if (json != null)
        {
            Type type = new TypeToken<List<Car>>(){}.getType();
            return new Gson().fromJson(json,type);
        }
        else
        {
            List<Car> cars = new ArrayList<Car>();
            cars.add(new Car(R.drawable.teslax,"Tesla","X","2021","50000"));
            cars.add(new Car(R.drawable.bmw,"BMW","i8","2019","220000"));
            cars.add(new Car(R.drawable.audi2,"Audi","RSQ3","2021","100000"));
            cars.add(new Car(R.drawable.vantage,"Aston Martin","Vantage 12","2019","150000"));
            cars.add(new Car(R.drawable.porsche,"Porsche","911 GT3RS","2021","250000"));
            cars.add(new Car(R.drawable.fiatabarth,"Fiat","Abarth","2021","45000"));
            cars.add(new Car(R.drawable.audiq,"Audi","Q8","2021","300000"));
            cars.add(new Car(R.drawable.macan,"Porsche","Macan S","2021","160000"));
            return cars;
        }
    }

}
