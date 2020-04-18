package android.example.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class DetailedPlaceActivity extends AppCompatActivity {



    ImageView toolbar_menu;
    TextView toolbar_title;

    TextView nameOfPlace;
    TextView placeAddress;
    TextView placeDescription;
    TextView placeWorkingHours;
    TextView placePhoneNumber;
    TextView placeWebPage;
    ImageView placeImage;
    Intent intent;
    LinearLayout workingHoursLayout;
    LinearLayout phoneNumberLayout;
    LinearLayout webPageLayout;
    Button localizationButton;

    String localization="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_place);

        toolbar_menu=findViewById(R.id.menu);
        toolbar_title=findViewById(R.id.title);

        toolbar_menu.setImageResource(R.drawable.ic_arrow_back_black_24dp);



        nameOfPlace = findViewById(R.id.name_place);
        placeAddress = findViewById(R.id.address_place);
        placeDescription = findViewById(R.id.description);
        placeWorkingHours = findViewById(R.id.working_hours);
        placePhoneNumber = findViewById(R.id.phone_number);
        placeWebPage = findViewById(R.id.web_page);
        placeImage = findViewById(R.id.place_image);
        workingHoursLayout = findViewById(R.id.working_hours_layout);
        phoneNumberLayout = findViewById(R.id.phone_number_layout);
        webPageLayout = findViewById(R.id.web_page_layout);
        localizationButton = findViewById(R.id.localization_button);



        intent = getIntent();

        localization = "geo:"+intent.getStringExtra("LATITUDE")+","+intent.getStringExtra("LONGITUDE")+"?q="+ Uri.encode(intent.getStringExtra("NAME_PLACE"));

        nameOfPlace.setText(intent.getStringExtra("NAME_PLACE"));
        placeAddress.setText(intent.getStringExtra("ADDRESS"));
        placeDescription.setText(intent.getStringExtra("DESCRIPTION"));
        placeWorkingHours.setText(intent.getStringExtra("WORKING_HOURS"));
        placePhoneNumber.setText(intent.getStringExtra("PHONE_NUMBER"));
        placeWebPage.setText(intent.getStringExtra("WEB_PAGE"));
        placeImage.setImageResource(intent.getExtras().getInt("IMAGE_PLACE"));

        toolbar_title.setText(intent.getStringExtra("NAME_PLACE"));

        toolbar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        OverScrollDecoratorHelper.setUpOverScroll(scrollView);


        if(intent.getStringExtra("PHONE_NUMBER")==null || intent.getStringExtra("PHONE_NUMBER").equals("")) {
            phoneNumberLayout.setVisibility(View.GONE);
        }

        if(intent.getStringExtra("WORKING_HOURS")==null || intent.getStringExtra("WORKING_HOURS").equals("")) {
            workingHoursLayout.setVisibility(View.GONE);
        }

        if(intent.getStringExtra("DESCRIPTION")==null || intent.getStringExtra("DESCRIPTION").equals("")) {
            placeDescription.setVisibility(View.GONE);
        }

        if(intent.getStringExtra("WEB_PAGE")==null || intent.getStringExtra("WEB_PAGE").equals("")) {
            webPageLayout.setVisibility(View.GONE);
        }

        localizationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(localization));
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

    }
}
