package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import thuyvtk.activity.hci_bonita.R;

public class OrderDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
    }

    public void back(View view) {
        this.finish();
    }

    public void clickToSendOrder(View view) {
        Intent intent = new Intent(this,AceptedScreen.class);
        startActivity(intent);
    }
}
