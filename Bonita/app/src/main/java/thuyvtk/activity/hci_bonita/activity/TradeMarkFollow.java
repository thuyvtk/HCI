package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import thuyvtk.activity.hci_bonita.R;

public class TradeMarkFollow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_mark_follow);
    }


    public void back(View view) {
        this.finish();
    }
}
