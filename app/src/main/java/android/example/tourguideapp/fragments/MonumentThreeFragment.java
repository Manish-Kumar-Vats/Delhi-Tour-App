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

public class MonumentThreeFragment  extends Fragment {

    public MonumentThreeFragment() {

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


        localization = "geo:" + "28.6562" + "," + "77.241" + "?q=" + Uri.encode("Red Fort");
        nameOfPlace.setText("Red Fort");
        placeAddress.setText("Netaji Subhash Road, Chandini Chowk");
        placeDescription.setText("The last garden tomb in Delhi, the Safdarjung’s Tomb is the mausoleum of Safdarjung. Built between 1753-54 by Safdarjung’s son Shuja-ud-Daula this tomb has numerous small canopies, such as the Moti Mahal, Badsha Pasand and Jangli Mahal among others. The complex of the Hunayun’s Tomb also contains a Madrasa and a library maintained by the archeological survey of India.\n" +
                "\n" +
                "Constructed in the centre of the Charbagh style gardens, a popular architectural style in Mughal constructions, Safdarjung’s Tomb is decorated with ponds and fountains. Crafted out of red sandstone with a white marble dome, the Safdarjung’s Tomb is built on a raised platform with a gate to its east and spacious walkways on the other three sides.");
        placeWorkingHours.setText("24X7");
        placeImage.setImageResource(R.drawable.monument_laal_qila);

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