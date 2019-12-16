package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import thuyvtk.activity.hci_bonita.R;

public class OrderDetail extends Activity {
    LinearLayout linearLayout;
    String normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        linearLayout = findViewById(R.id.linear_sale);
        Intent intent = this.getIntent();
        normal = intent.getStringExtra("NORMAL");
        if (normal != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.height = 0;
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    public void back(View view) {
        this.finish();
    }

    public void clickToSendOrder(View view) {
        if(normal ==  null){
            Intent intent = new Intent(this, AceptedScreen.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Order success!", Toast.LENGTH_SHORT).show();
            this.finish();
        }

    }
}
