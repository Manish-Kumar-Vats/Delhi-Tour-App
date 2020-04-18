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

public class ShoppingActivity extends AppCompatActivity {


    ImageView toolbar_menu;
    TextView toolbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        toolbar_menu=findViewById(R.id.menu);
        toolbar_title=findViewById(R.id.title);

        toolbar_menu.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        toolbar_title.setText(getString(R.string.shopping));

        toolbar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        final ArrayList<Place> famousPlaces = new ArrayList<>();

        for (int i=0;i<3;i++) {
            famousPlaces.add(new Place(getString(R.string.shopping_name_one), getString(R.string.shopping_address_one), getString(R.string.shopping_description_one), "", "", getString(R.string.shopping_workinghours_one), 28.5733, 77.2076, R.drawable.shopping_dilli_haut));

            famousPlaces.add(new Place(getString(R.string.shopping_name_two), getString(R.string.shopping_address_two), getString(R.string.shopping_description_two), "", "", getString(R.string.shopping_workinghours_two), 28.6291, 77.2188, R.drawable.shopping_janpath_market));


            famousPlaces.add(new Place(getString(R.string.shopping_name_three), getString(R.string.shopping_address_three), getString(R.string.shopping_description_three), "", "", getString(R.string.shopping_workinghours_three), 28.6001, 77.2270, R.drawable.shopping_khan_market));

            famousPlaces.add(new Place(getString(R.string.shopping_name_four), getString(R.string.shopping_address_four), getString(R.string.shopping_description_four), "", "", getString(R.string.shopping_workinghours_four), 28.5740, 77.1991, R.drawable.shopping_sarojini_market));

            famousPlaces.add(new Place(getString(R.string.shopping_name_five), getString(R.string.shopping_address_five), getString(R.string.shopping_description_five), "", "", getString(R.string.shopping_workinghours_five), 28.6505, 77.2303, R.drawable.shopping_chandni_chowk));
        }

        PlacesAdapter adapter = new PlacesAdapter(this,famousPlaces);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
        OverScrollDecoratorHelper.setUpOverScroll(listView);


    }
}