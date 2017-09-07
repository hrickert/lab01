package grupo_go_ra_ri.dam.isi.frsf.lab01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class main extends AppCompatActivity {

    private SeekBar seekBar_days;
    private TextView selectDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar_days = (SeekBar)findViewById(R.id.id_inversion_days);
        seekBar_days.setMax(60);
        selectDays = (TextView)findViewById(R.id.id_select_days);
        selectDays.setText("0");

        seekBar_days.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int days, boolean b) {
                selectDays.setText(days + "");
            }
        });



        Button btn_do = (Button)findViewById(R.id.id_btn_do);
        btn_do.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView txt_response = (TextView)findViewById(R.id.id_txt_response);
                TextView email_txt = (TextView)findViewById(R.id.id_email_txt);
                TextView cuit_txt = (TextView)findViewById(R.id.id_cuit_txt);
                TextView amount_txt = (TextView)findViewById(R.id.id_amount_txt);
                TextView selectDays = (TextView)findViewById(R.id.id_select_days);

                int amount = Integer.parseInt(amount_txt.getText().toString());
                int days = Integer.parseInt(selectDays.getText().toString());
                int rate = 1;
                if(!TextUtils.isEmpty(email_txt.getText())&& !TextUtils.isEmpty(cuit_txt.getText()) &&
                        !TextUtils.isEmpty(amount_txt.getText())) {

                    rate = tasa(amount,days);

                    double total = amount*(Math.pow((1+(rate/100)), 1)-1);

                    txt_response.setText("Plazo fijo realizado. Recibirá "+total+" al vencimiento.");
                    txt_response.setTextColor(getResources().getColor(R.color.ok));
                    txt_response.setVisibility(View.VISIBLE);
                }
                else {
                    txt_response.setText(R.string.response);
                    txt_response.setTextColor(getResources().getColor(R.color.error));
                    txt_response.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    private int tasa (int monto, int dias){
        if (monto < 5000) {
            return (dias < 30)? Integer.valueOf(R.string._0_5000_min30) : R.string._0_5000_mayeq30;
        }
        else if (monto < 99999) {
            return (dias < 30)? R.string._5000_999999_min30 : R.string._5000_999999_mayeq30;
        }
        else {
            return (dias < 30)? R.string._99999_more_min30 : R.string._99999_more_mayeq30;
        }
    }
}
