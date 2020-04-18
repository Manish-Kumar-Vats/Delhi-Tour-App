package android.example.tourguideapp.fragments;

import android.content.Intent;
import android.example.tourguideapp.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MonumentSixFragment  extends Fragment {

    public MonumentSixFragment() {

    }
    private String localization = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_detailed_place, container, false);
        View toolbarLayout=rootView.findViewById(R.id.toolbar);
        toolbarLayout.setVisibility(View.GONE);
        ScrollView scrollView = (ScrollView) rootView.findViewById(R.id.scrollView);
        OverScrollDecoratorHelper.setUpOverScroll(scrollView);

        TextView nameOfPlace = rootView.findViewById(R.id.name_place);
        TextView placeAddress = rootView.findViewById(R.id.address_place);
        TextView placeDescription = rootView.findViewById(R.id.description);
        TextView placeWorkingHours = rootView.findViewById(R.id.working_hours);
        ImageView placeImage = rootView.findViewById(R.id.place_image);
        LinearLayout phoneNumberLayout = rootView.findViewById(R.id.phone_number_layout);
        LinearLayout webPageLayout = rootView.findViewById(R.id.web_page_layout);
        Button localizationButton = rootView.findViewById(R.id.localization_button);


        localization = "geo:" + "28.6127" + "," + "77.2773" + "?q=" + Uri.encode("Swaminarayan Akshardham");
        nameOfPlace.setText("Swaminarayan Akshardham");
        placeAddress.setText("Patparganj");
        placeDescription.setText("Inaugurated in 2005, this temple complex combines the finest example of traditional Hindu/Indian culture, architecture and spirituality. Sitting near the banks of the Yamuna, the temple attracts a huge number of visitors, many of whom believe it to be the temporal abode of God on earth. Etched with intricate carvings, the Akshardham Mandir alone is 141-foot high, spans 316-foot wide, and extends 356-foot long.");
        placeWorkingHours.setText("24X7");
        placeImage.setImageResource(R.drawable.monument_swaminarayan_akshardham);

        phoneNumberLayout.setVisibility(View.GONE);
        webPageLayout.setVisibility(View.GONE);

        localizationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(localization));
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });



        return rootView;
    }


}