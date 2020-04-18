package android.example.tourguideapp.adapters;


import android.content.Context;
import android.content.Intent;
import android.example.tourguideapp.DetailedPlaceActivity;
import android.example.tourguideapp.R;
import android.example.tourguideapp.modal.Place;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Place> {

    public PlacesAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.place_layout, parent, false);
        }

        Place currentPlace = getItem(position);

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_name);

        placeTextView.setText(currentPlace.getNameOfPlace());

        TextView addressTextView = (TextView) listItemView.findViewById(R.id.place_address);

        addressTextView.setText(currentPlace.getAddress());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        imageView.setImageResource(currentPlace.getImageResourceId());

        imageView.setVisibility(View.VISIBLE);

        final Intent intent = new Intent(getContext(), DetailedPlaceActivity.class);
        intent.putExtra("NAME_PLACE", currentPlace.getNameOfPlace());
        intent.putExtra("ADDRESS", currentPlace.getAddress());
        intent.putExtra("DESCRIPTION", currentPlace.getDescription());
        intent.putExtra("PHONE_NUMBER", currentPlace.getPhoneNumber());
        intent.putExtra("WEB_PAGE", currentPlace.getWebPage());
        intent.putExtra("WORKING_HOURS", currentPlace.getWorkingHours());
        intent.putExtra("LATITUDE", currentPlace.getLatitude());
        intent.putExtra("LONGITUDE", currentPlace.getLongitude());
        intent.putExtra("IMAGE_PLACE", currentPlace.getImageResourceId());

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}