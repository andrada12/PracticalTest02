package ro.pub.cs.systems.eim.practicaltest02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PracticalTest02MainActivity extends AppCompatActivity {


    // Server widgets
    private EditText serverPortEditText = null;
    private Button connectButton = null;

    // Client widgets
    private EditText clientAddressEditText = null;
    private EditText clientPortEditText = null;
    private Spinner informationTypeSpinner = null;
    private Button getValueButton = null;
    private TextView valueTextView = null;

    //private ServerThread serverThread = null;
    //private ClientThread clientThread = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test02_main);

        serverPortEditText = (EditText)findViewById(R.id.server_port_edit_text);
        connectButton = (Button)findViewById(R.id.connect_button);
        //connectButton.setOnClickListener(connectButtonClickListener);

        clientAddressEditText = (EditText)findViewById(R.id.client_address_edit_text);
        clientPortEditText = (EditText)findViewById(R.id.client_port_edit_text);
        informationTypeSpinner = (Spinner)findViewById(R.id.information_type_spinner);
        getValueButton = (Button)findViewById(R.id.get_weather_forecast_button);
        //getValueButton.setOnClickListener(getWeatherForecastButtonClickListener);
        valueTextView = (TextView)findViewById(R.id.weather_forecast_text_view);
    }
}
