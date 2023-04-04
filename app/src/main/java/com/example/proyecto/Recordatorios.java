package com.example.proyecto;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Recordatorios extends AppCompatActivity implements View.OnClickListener{

    private Button button_añadir_recordatorio;
    private ListView lvRecordatorios;
    private EditText etRecordarme;
    private EditText etFecha;
    private List<String> listaRecordatorios = new ArrayList<>();
    private ArrayAdapter<String> Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_añadir_recordatorio = findViewById(R.id.button_añadir_recordatorio);
        button_añadir_recordatorio.setOnClickListener(this);
        lvRecordatorios = findViewById(R.id.lvRecordatorios);
        etRecordarme = findViewById(R.id.etRecordarme);
        etFecha = findViewById(R.id.etFecha);
        etFecha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_añadir_recordatorio:
                String recordar = etRecordarme.getText().toString().trim();
                String fecha = etFecha.getText().toString().trim();
                String mensaje = "Recordatorio establecido.";
                String recordatorio = "Detalle: " + recordar + "\nFecha: " + fecha;
                listaRecordatorios.add(recordatorio);
                etRecordarme.getText().clear();
                etFecha.getText().clear();
                Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaRecordatorios);
                lvRecordatorios.setAdapter(Adapter);
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                break;
            case R.id.etFecha:
                showDatePickerDialog();
                break;
        }
    }
    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                etFecha.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public static class DatePickerFragment extends DialogFragment {

        private DatePickerDialog.OnDateSetListener listener;

        public static DatePickerFragment newInstance(DatePickerDialog.OnDateSetListener listener) {
            DatePickerFragment fragment = new DatePickerFragment();
            fragment.setListener(listener);
            return fragment;
        }

        public void setListener(DatePickerDialog.OnDateSetListener listener) {
            this.listener = listener;
        }

        @Override
        @NonNull
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), listener, year, month, day);
        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}