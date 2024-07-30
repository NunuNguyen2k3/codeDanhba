package com.example.danhba1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class manhinhdanhba extends AppCompatActivity {

    private EditText etTen, etSoDienThoai;
    private Button btnThem,btnSua,btnXoa;
    private ListView lvDanhBa;
    private ArrayList<DanhBa> danhBaList;
    private ArrayAdapter<DanhBa> adapter;
    private int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.manhinhdanhba);

        etTen = findViewById(R.id.etTen);
        etSoDienThoai = findViewById(R.id.etSoDienThoai);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        lvDanhBa = findViewById(R.id.lvDanhBa);

        danhBaList = new ArrayList<>();

        danhBaList.add(new DanhBa("Yasuo","0123456789"));
        danhBaList.add(new DanhBa("Leesin","0987654321"));
        danhBaList.add(new DanhBa("Malphite","0246813579"));


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, danhBaList);
        lvDanhBa.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = etTen.getText().toString();
                String soDienThoai = etSoDienThoai.getText().toString();
                DanhBa danhBa = new DanhBa(ten, soDienThoai);
                danhBaList.add(danhBa);
                adapter.notifyDataSetChanged();
                etTen.setText("");
                etSoDienThoai.setText("");
            }
        });
        lvDanhBa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DanhBa selectedDanhBa = danhBaList.get(position);
                etTen.setText(selectedDanhBa.getTen());
                etSoDienThoai.setText(selectedDanhBa.getSoDienThoai());
                selectedIndex = position;
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIndex != -1) {
                    String ten = etTen.getText().toString();
                    String soDienThoai = etSoDienThoai.getText().toString();
                    DanhBa danhBa = new DanhBa(ten, soDienThoai);
                    danhBaList.set(selectedIndex, danhBa);
                    adapter.notifyDataSetChanged();
                    etTen.setText("");
                    etSoDienThoai.setText("");
                    selectedIndex = -1;
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIndex != -1) {
                    danhBaList.remove(selectedIndex);
                    adapter.notifyDataSetChanged();
                    etTen.setText("");
                    etSoDienThoai.setText("");
                    selectedIndex = -1;
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}