package com.felix.dateselector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.felix.dateselectorlibrary.widget.DateTimeSelectorDialogBuilder;
import com.felix.dateselectorlibrary.widget.LocationSelectorDialogBuilder;


public class MainActivity extends Activity implements OnClickListener, DateTimeSelectorDialogBuilder.OnSaveListener, LocationSelectorDialogBuilder.OnSaveLocationLister {
    private TextView daTextView;
    private TextView locationText;
    private DateTimeSelectorDialogBuilder dialogBuilder;
    private LocationSelectorDialogBuilder locationBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt).setOnClickListener(this);
        findViewById(R.id.bt_2).setOnClickListener(this);

        daTextView = findViewById(R.id.tv_date);
        locationText = findViewById(R.id.tv_location);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                if (dialogBuilder == null) {
                    dialogBuilder = DateTimeSelectorDialogBuilder.getInstance(this);
                    dialogBuilder.setOnSaveListener(this);
                }
                dialogBuilder.show();
                break;
            case R.id.bt_2:
                if (locationBuilder == null) {
                    locationBuilder = LocationSelectorDialogBuilder.getInstance(this);
                    locationBuilder.setOnSaveLocationLister(this);
                }
                locationBuilder.show();
                break;
            default:
                break;
        }

    }

    @Override
    public void onSaveSelectedDate(String selectedDate) {
        daTextView.setText(selectedDate);
    }

    @Override
    public void onSaveLocation(String location, String provinceId, String cityId) {
        locationText.setText(location);
    }

}
