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

public class MonumentTwoFragment  extends Fragment {

    public MonumentTwoFragment() {

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


        localization = "geo:" + "28.5245" + "," + "77.1855" + "?q=" + Uri.encode("Qutub Minar ");
        nameOfPlace.setText("Qutub Minar ");
        placeAddress.setText("Mehrauli");
        placeDescription.setText("The Qutub Minar is a towering 73 meter high tower built by Qutub-ud-Din Aibak in 1193. The tower was built to celebrate Muslim dominance in Delhi after the defeat of Delhi’s last Hindu ruler. This tower is the highest tower in India, complete with five storeys and projecting balconies. The first three storeys of the Qutub Minar are made of red sandstone and the last two are made of marble and sandstone.\n" +
                "\n" +
                "The construction of the Qutub Minar was started by Qitub-ud-Din Aibak, but he only constructed the basement. The construction of the tower was later taken over by his successor Iltutmish who constructed three more stories. The last two storeys were completed Firoz Shah Tuglak. The different architectural styles from the time of Aibak to Tuglak are clearly visible in the Qutub Minar.\n" +
                "\n" +
                "Apart from the tower, the Qutub Minar complex comprises of the Quwwat-us-Islam Mosque (the first mosque to be built in India), a 7 metre high iron pillar, the tomb of Iltutmish, Ala’i-Darwaza and the Ala’I Minar.");
        placeWorkingHours.setText("Sunrise to sunset");
        placeImage.setImageResource(R.drawable.monument_qutub_minar);

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