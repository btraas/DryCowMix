package me.supersimplelifts.drycowmix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalculatedActivity extends AppCompatActivity {

    TextView numCowsView;
    TextView twoDaysWorthView;
    TextView cornSilageView;
    TextView strawView;
    TextView hayView;
    TextView highMoistCornView;
    TextView supplementView;
    TextView mineralsView;
    TextView magSulphateView;
    TextView twoDaysWorth2View;
    TextView grandTotalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated);

        int numCows = getIntent().getIntExtra("numCows", 0);
        int twoDaysWorth = (numCows * 2) + 5;

        int cornSilage      = twoDaysWorth * 12;
        int straw           = twoDaysWorth * 3;
        int hay             = Math.round(new Float(twoDaysWorth * 2.5734));  // round to integer
        int highMoistCorn   = twoDaysWorth;
        int supplement      = Math.round(new Float(twoDaysWorth * 1.5));    // round to integer
        double minerals     = roundOne(twoDaysWorth * 0.06);
        double magSulphate  = roundOne(twoDaysWorth * 0.2);

        // just strip the last...
        int total = (int)(
                cornSilage + straw + hay + highMoistCorn + supplement + minerals + magSulphate
        );



        numCowsView = ((TextView)findViewById(R.id.numCowsVal));
        numCowsView.setText(""+numCows);

        twoDaysWorthView = ((TextView)findViewById(R.id.twoDaysWorthVal));
        twoDaysWorthView.setText(""+twoDaysWorth);

        cornSilageView = ((TextView)findViewById(R.id.cornSilageVal));
        cornSilageView.setText(""+cornSilage);

        strawView = ((TextView)findViewById(R.id.strawVal));
        strawView.setText(""+straw);

        hayView = ((TextView)findViewById(R.id.hayVal));
        hayView.setText(""+hay);

        highMoistCornView = ((TextView)findViewById(R.id.highMoistCornVal));
        highMoistCornView.setText(""+highMoistCorn);

        supplementView = ((TextView)findViewById(R.id.supplementVal));
        supplementView.setText(""+supplement);


        mineralsView = ((TextView)findViewById(R.id.mineralsVal));
        mineralsView.setText(Double.valueOf(minerals).toString());

        magSulphateView = ((TextView)findViewById(R.id.magSulphateVal));
        magSulphateView.setText(Double.valueOf(magSulphate).toString());

        /*
        twoDaysWorth2View = ((TextView)findViewById(R.id.twoDaysWorthVal2));
        twoDaysWorth2View.setText(""+twoDaysWorth);
        */

        grandTotalView = ((TextView)findViewById(R.id.grandTotalVal));
        grandTotalView.setText(""+total);

    }

    private double roundOne(double in) {
        return Math.round(in * 10) / 10.0;
    }

}
