package co.il.dmobile.myapplication_2;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<Car> cars;
    public CarAdapter(List<Car> cars)
    {
        this.cars = cars;
    }

    public void AddCar(Car car)
    {
        cars.add(car);
        notifyDataSetChanged();
        DataPersistencyHelper.StoreData(cars);
    }

    public void DeleteCar(int position)
    {
        cars.remove(position);
        notifyDataSetChanged();
        DataPersistencyHelper.StoreData(cars);
    }
    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,parent,false);
        CarViewHolder vh = new CarViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);

        holder.avatar.setImageResource(car.getPhoto());
        holder.model.setText(car.getModel());
        holder.year.setText(car.getYear());
        holder.price.setText(car.getPrice());
        holder.brand.setText(car.getBrand());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity2.class);
                i.putExtra("user", car);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                holder.avatar,
                                "avatarTrasnition"
                        );
                v.getContext().startActivity(i,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
