package android.example.tourguideapp;

import android.example.tourguideapp.adapters.PlacesAdapter;
import android.example.tourguideapp.modal.Place;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;


public class EatAndDrinksActivity extends AppCompatActivity {

    ImageView toolbar_menu;
    TextView toolbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        toolbar_menu=findViewById(R.id.menu);
        toolbar_title=findViewById(R.id.title);

        toolbar_menu.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        toolbar_title.setText(getString(R.string.eat_amp_drinks));

        toolbar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ArrayList<Place> famousPlaces = new ArrayList<>();
for (int i=0;i<3;i++) {
    famousPlaces.add(new Place(getString(R.string.food_name_one), getString(R.string.food_address_one), getString(R.string.food_description_one), "10:00AM to 05:00PM, Sunday closed.", 28.6872, 77.2103, R.drawable.food_one));
   famousPlaces.add(new Place(getString(R.string.food_name_two), getString(R.string.food_address_two), getString(R.string.food_description_two), "11:00AM to 08:00PM", 28.6872, 77.2103, R.drawable.food_two));
   famousPlaces.add(new Place(getString(R.string.food_name_three), getString(R.string.food_address_three), getString(R.string.food_description_three), "10:00AM to 05:00PM, Sunday closed.", 28.6872, 77.2103, R.drawable.food_three));
   famousPlaces.add(new Place(getString(R.string.food_name_four), getString(R.string.food_address_four), getString(R.string.food_description_four), "08:00AM to 09:00PM", 28.6872, 77.2103, R.drawable.food_four));
   famousPlaces.add(new Place(getString(R.string.food_name_five), getString(R.string.food_address_five), getString(R.string.food_description_five), "11:00AM to 11:00PM, Wednesday closed.", 28.6872, 77.2103, R.drawable.food_five));
   famousPlaces.add(new Place(getString(R.string.food_name_six), getString(R.string.food_address_six), getString(R.string.food_description_six), "11:00AM to 04:00PM, Sunday closed.", 28.6872, 77.2103, R.drawable.food_six));

}
        PlacesAdapter adapter = new PlacesAdapter(this,famousPlaces);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
        OverScrollDecoratorHelper.setUpOverScroll(listView);


    }
}
