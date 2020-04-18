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

public class MonumentFiveFragment  extends Fragment {

    private String localization="";

    public MonumentFiveFragment() {

    }

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


        localization = "geo:" + "28.5535" + "," + "77.2588" + "?q=" + Uri.encode("Lotus Temple");
        nameOfPlace.setText("Lotus Temple");
        placeAddress.setText("Kalkaji");
        placeDescription.setText("This house of worship for the Bahá’í religion costing $10 million opened in 1986. It is open to all and requires no religious affiliations or other qualifications of its visitors, who come in droves to see it.\n" +
                "\n" +
                "Considered to be an architectural marvel, the temple accommodates 2500 people. It has 27 petals etched out of marble, which are arranged in clusters of three to form nine sides. Space is only meant for gathering, reflecting and worshipping. Though rituals are not permitted; singing, chanting, praying or reading any religious text in any language is allowed along with lecturing, sermonising, and fund-raising.");
        placeWorkingHours.setText("24X7");
        placeImage.setImageResource(R.drawable.monument_lotus_temple);

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