package thuyvtk.activity.hci_bonita.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.adapter.RecyclerViewAdapter;
import thuyvtk.activity.hci_bonita.dialog.ScrollPickerDialog;

public class BrandActivity extends FragmentActivity implements ScrollPickerDialog.ChooseModelListener{
    ImageButton btnBack;
    ImageButton btnSave;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    ScrollPickerDialog scrollPickerDialog;
    int flag = 0;
    RecyclerView recyclerView;
    ArrayList<String> slots;
    RecyclerViewAdapter recyclerViewHorizontalAdapter;
    LinearLayoutManager horizontalLayout;
    TextView number, address, time;
    TextView total;
    CheckBox check1,check2, check3, check4;
    int price = 40;
    int people = 1 ;
    int[] servicePrice = {40,10,10,120};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
        defineView();
        recyclerView = (RecyclerView) findViewById(R.id.rv_slotsAvailableBrand);
        recyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        AddItemsToRecyclerViewArrayList();
        recyclerViewHorizontalAdapter = new RecyclerViewAdapter(slots,false);

        horizontalLayout = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayout);

        recyclerView.setAdapter(recyclerViewHorizontalAdapter);

        // set checkbox
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price = price + servicePrice[0];
                }else{
                    price = price - servicePrice[0];
                }
                total.setText(people * price +"K");
            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price = price + servicePrice[1];
                }else{
                    price = price - servicePrice[1];
                }
                total.setText(people * price +"K");
            }
        });
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price = price + servicePrice[2];
                }else{
                    price = price - servicePrice[2];
                }
                total.setText(people * price +"K");
            }
        });
        check4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price = price + servicePrice[3];
                }else{
                    price = price - servicePrice[3];
                }
                total.setText(people * price +"K");
            }
        });
    }

    public void defineView() {
        btnBack = findViewById(R.id.btnBack);
        btnSave = findViewById(R.id.btnSave);
        btnBack.getBackground().setAlpha(150);
        btnSave.getBackground().setAlpha(150);
        number = findViewById(R.id.number);
        time = findViewById(R.id.time);
        address = findViewById(R.id.txtAddessBrand);
        check1 =  findViewById(R.id.check1);
        check2 =  findViewById(R.id.check2);
        check3 =  findViewById(R.id.check3);
        check4 =  findViewById(R.id.check4);
        total = findViewById(R.id.total);
    }

    public void clickToViewTime(View view) {
        flag = 2;
        FragmentManager fm = getSupportFragmentManager();
        String[] arrItems = new String[]{"Hôm nay", "Ngày mai", "Thứ 2", "Thứ 3","Thứ 4","Thứ 5","Thứ 6"};
        scrollPickerDialog = new ScrollPickerDialog(1, arrItems, "CHI NHÁNH");
        scrollPickerDialog.show(fm, "fragment_choose_slot");
    }

    public void clickToViewNumberOrder(View view) {
        flag = 1;
        FragmentManager fm = getSupportFragmentManager();
        String[] arrItems = new String[]{"1 Người", "2 Người", "3 Người", "4 Người"};
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
                people = Integer.parseInt(modelName.substring(0,1));
                total.setText(people * price+"K");
                break;
            case 2:
                time.setText(modelName);
                break;

        }
        scrollPickerDialog.dismiss();
    }

    public void clickToViewAllAddress(View view) {
        flag = 0;
        FragmentManager fm = getSupportFragmentManager();
        String[] arrItems = new String[]{"30 Shine Lê Văn Việt", "30 Shine Quang Trung", "30 Shine Quận 12", "30 Shine Tân Phú"};
        scrollPickerDialog = new ScrollPickerDialog(1, arrItems, "CHI NHÁNH");
        scrollPickerDialog.show(fm, "fragment_choose_slot");
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
        slots.add("14:00");
        slots.add("14:30");
        slots.add("15:00");
        slots.add("15:30");
        slots.add("16:00");
        slots.add("16:30");
        slots.add("17:00");
        slots.add("17:30");
        slots.add("18:00");

    }

    public void clickToOrder(View view) {
        Intent intent = new Intent(this, OrderDetail.class);
        intent.putExtra("NUMBER",people);
        intent.putExtra("NORMAL","normal");
        intent.putExtra("PRICE",price);
        startActivity(intent);
        this.finish();
    }

    public void clickToBack(View view) {
        this.finish();
    }

    public void clickToDetail(View view) {
        Intent intent = new Intent(this, DetailDiscountActivity.class);

        startActivity(intent);
    }
}
