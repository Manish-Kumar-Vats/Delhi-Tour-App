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

public class MonumentOneFragment extends Fragment {

    public MonumentOneFragment() {

    }

    private String localization = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_detailed_place, container, false);
        View toolbarLayout = rootView.findViewById(R.id.toolbar);
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


        localization = "geo:" + "28.6129" + "," + "77.2295" + "?q=" + Uri.encode("India Gate");
        nameOfPlace.setText("India Gate");
        placeAddress.setText("Rajpath,New Delhi");
        placeDescription.setText("Synonymous with New Delhi and situated in the heart of the city, India Gate is one of the most popular monuments in the city. The foundation stone of India Gate was laid in 1920 and the structure was unveiled in 1933. Designed by Edwin Lutyens, India Gate was dedicated to all the Indian soldiers of the British Army who died in World War I. Another memorial, the Amar Jawan Jyoti was added later and was dedicated to soldiers who sacrificed their lives in the Indo-Pakistan war of 1971.\n" +
                "\n" +
                "The India Gate is flanked by lush green lawns, which are a popular picnic spot, especially during winter afternoons and summer evenings. The wide roads surrounding the India Gate are also frequented by morning and evening walkers. There is also a small pond nearby where one can enjoy boating as well. At nightfall India Gate is beautifully lit up, including the surrounding fountains and makes for a beautiful sight.");
        placeWorkingHours.setText("24X7");
        placeImage.setImageResource(R.drawable.monument_india_gate);

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