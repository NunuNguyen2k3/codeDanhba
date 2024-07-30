package com.example.danhba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menuToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menutoolbar);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_res,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itdiachi) {
            Toast.makeText(this, "chuc nang chua duoc cap nhat !!!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.itdienthoai) {
            Intent intent = new Intent(menuToolbar.this, manhinhdanhba.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.ithocvan) {
            Toast.makeText(this, "chuc nang chua duoc cap nhat", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.itExit) {
            Intent intent = new Intent(menuToolbar.this, Login.class);
            startActivity(intent);
            return true;
            //finish();
        }
        return super.onOptionsItemSelected(item);
    }

}