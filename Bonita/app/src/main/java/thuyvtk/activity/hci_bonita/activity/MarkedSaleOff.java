package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import thuyvtk.activity.hci_bonita.R;

public class MarkedSaleOff extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marked_sale_off);
    }

    public void back(View view) {
        this.finish();
    }

    public void clickToGoDetail(View view) {
        Intent intent = new Intent(this,DetailDiscountActivity.class);
        startActivity(intent);
    }
}
