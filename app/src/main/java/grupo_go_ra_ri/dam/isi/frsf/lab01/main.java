package grupo_go_ra_ri.dam.isi.frsf.lab01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_do = (Button)findViewById(R.id.id_btn_do);

        btn_do.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView txt_response = (TextView)findViewById(R.id.id_txt_response);
                //txt_response.setVisibility(View.VISIBLE);
                //txt_response.setTextColor(getResources().getColor(R.color.ok));

                //if (1==0) {
                //    txt_response.setText("Plazo fijo realizado. Recibirá 5000 al vencimiento.");
                //    txt_response.setTextColor(getResources().getColor(R.color.ok));
                //}
            }
        });
    }
}
