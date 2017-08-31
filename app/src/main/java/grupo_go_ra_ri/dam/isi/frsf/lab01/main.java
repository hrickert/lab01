package grupo_go_ra_ri.dam.isi.frsf.lab01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
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

                if (1==1) {
                    txt_response.setText("Plazo fijo realizado. Recibirá 5000 al vencimiento.");
                    txt_response.setTextColor(getResources().getColor(R.color.ok));
                }

                //txt_response.setVisibility(View.VISIBLE);
                //txt_response.setTextColor(getResources().getColor(R.color.ok));
            }
        });

        SeekBar inversion_days = (SeekBar) findViewById(R.id.id_inversion_days);
        inversion_days.setMax(360);
        inversion_days.setProgress(1);
        inversion_days.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView sel_days = (TextView)findViewById(R.id.id_select_days);
                sel_days.setText((char) i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
