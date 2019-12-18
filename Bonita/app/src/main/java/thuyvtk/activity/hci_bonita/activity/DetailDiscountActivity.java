package thuyvtk.activity.hci_bonita.activity;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.adapter.RecyclerViewAdapter;
import thuyvtk.activity.hci_bonita.adapter.SliderAdapter;
import thuyvtk.activity.hci_bonita.dialog.ScrollPickerDialog;

public class DetailDiscountActivity extends FragmentActivity implements ScrollPickerDialog.ChooseModelListener, OnMapReadyCallback {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    ArrayList<String> slots;
    RecyclerViewAdapter recyclerViewHorizontalAdapter;
    LinearLayoutManager horizontalLayout;
    ScrollPickerDialog scrollPickerDialog;
    TextView address, number, time;
    GoogleMap mMap;
    SliderView imageSlider;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_discount);
        address = findViewById(R.id.address);
        number = findViewById(R.id.number);
        time = findViewById(R.id.time);
        recyclerView = (RecyclerView) findViewById(R.id.rv_slotsAvailable);
        recyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // show slider
        showThumbnails();

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();

        recyclerViewHorizontalAdapter = new RecyclerViewAdapter(slots);

        horizontalLayout = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayout);

        recyclerView.setAdapter(recyclerViewHorizontalAdapter);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void showThumbnails() {
        imageSlider = findViewById(R.id.imageSlider);
        Integer[] listThumnail = {
                R.drawable.deadline3,
                R.drawable.detail1,
                R.drawable.detail3,
                R.drawable.detail2,
        };
        imageSlider.setSliderAdapter(new SliderAdapter(listThumnail));
        imageSlider.setAutoCycle(false);
        imageSlider.startAutoCycle();
        imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM);
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider.setScrollTimeInSec(10);
    }

    public void AddItemsToRecyclerViewArrayList() {
        slots = new ArrayList<>();
        slots.add("07:00");
        slots.add("07:30");
        slots.add("08:00");
        slots.add("08:30");
        slots.add("09:00");
        slots.add("09:30");
        slots.add("10:00");
        slots.add("10:30");
        slots.add("11:00");
        slots.add("11:30");
        slots.add("12:00");
        slots.add("12:30");
        slots.add("13:00");
        slots.add("13:30");
    }

    int flag = 0;

    public void clickToViewAllAddress(View view) {
        flag = 0;
        FragmentManager fm = getSupportFragmentManager();
        String[] arrItems = new String[]{"30 Shine Lê Văn Việt", "30 Shine Quang Trung", "30 Shine Quận 12", "30 Shine Tân Phú"};
        scrollPickerDialog = new ScrollPickerDialog(1, arrItems, "CHI NHÁNH");
        scrollPickerDialog.show(fm, "fragment_choose_slot");
    }

    @Override
    public void itemPicked(Integer itemType, Integer modelId, String modelName) {
        switch (flag) {
            case 0:
                address.setText(modelName);
                break;
            case 1:
                number.setText(modelName);
                int people = Integer.parseInt(modelName.substring(0,1));
                recyclerViewHorizontalAdapter = new RecyclerViewAdapter(slots,true,people );
                recyclerView.setAdapter(recyclerViewHorizontalAdapter);
                break;
            case 2:
                time.setText(modelName);
                break;

        }
        scrollPickerDialog.dismiss();
    }


    public void clickToViewNumberOrder(View view) {
        flag = 1;
        FragmentManager fm = getSupportFragmentManager();
        String[] arrItems = new String[]{"1 Người", "2 Người", "3 Người", "4 Người"};
        scrollPickerDialog = new ScrollPickerDialog(1, arrItems, "CHI NHÁNH");
        scrollPickerDialog.show(fm, "fragment_choose_slot");
    }

    public void clickToViewTime(View view) {
        flag = 2;
        FragmentManager fm = getSupportFragmentManager();
        String[] arrItems = new String[]{"Hôm nay", "Ngày mai", "Thứ 2", "Thứ 3","Thứ 4","Thứ 5","Thứ 6"};
        scrollPickerDialog = new ScrollPickerDialog(1, arrItems, "CHI NHÁNH");
        scrollPickerDialog.show(fm, "fragment_choose_slot");
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(10.835890, 106.658622);
        mMap.addMarker(new MarkerOptions().position(sydney).title("30 shine Quang Trung"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20));
    }

    public void clickToOrder(View view) {
        Intent intent = new Intent(this, OrderDetail.class);
        startActivity(intent);
        this.finish();
    }
}
