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

public class FunActivitiesActivity extends AppCompatActivity {

    ImageView toolbar_menu;
    TextView toolbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        toolbar_menu=findViewById(R.id.menu);
        toolbar_title=findViewById(R.id.title);

        toolbar_menu.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        toolbar_title.setText(getString(R.string.fun_activities));

        toolbar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ArrayList<Place> famousPlaces = new ArrayList<>();
for (int i=0;i<3;i++) {
    famousPlaces.add(new Place(getString(R.string.fun_name_one), getString(R.string.fun_address_one), getString(R.string.fun_description_one), "", "", "", 28.5275, 77.2172, R.drawable.fun_one));
    famousPlaces.add(new Place(getString(R.string.fun_name_two), getString(R.string.fun_address_two), getString(R.string.fun_description_two), "", "", "", 28.425, 77.039, R.drawable.fun_two));
    famousPlaces.add(new Place(getString(R.string.fun_name_three), getString(R.string.fun_address_three), getString(R.string.fun_description_three), "", "", "", 28.5673, 77.3212, R.drawable.fun_three));
    famousPlaces.add(new Place(getString(R.string.fun_name_four), getString(R.string.fun_address_four), getString(R.string.fun_description_four), "", "", "", 28.6422, 77.1064, R.drawable.fun_four));
    famousPlaces.add(new Place(getString(R.string.fun_name_five), getString(R.string.fun_address_five), getString(R.string.fun_description_five), "", "", "", 28.5823, 77.1623, R.drawable.fun_five));

}
        PlacesAdapter adapter = new PlacesAdapter(this,famousPlaces);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
        OverScrollDecoratorHelper.setUpOverScroll(listView);


    }
}