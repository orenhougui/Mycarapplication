package co.il.dmobile.myapplication_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        Car car = (Car) b.getSerializable("car");

        ImageView avatar = findViewById(R.id.imageView);
        TextView year = findViewById(R.id.year);
        TextView brand = findViewById(R.id.brand);
        TextView price = findViewById(R.id.price);
        TextView model = findViewById(R.id.model);

        avatar.setImageResource(car.getPhoto());
        year.setText(car.getYear());
        brand.setText(car.getBrand());
        price.setText(car.getPrice());
        model.setText(car.getModel());
    }
}