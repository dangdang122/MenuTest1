package kr.ac.kopo.menutest1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button btn;
    int rotationDegree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        linear = findViewById(R.id.main);
        btn = findViewById(R.id.btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.item_yellow){
            linear.setBackgroundColor(Color.YELLOW);
            return true;
        }else if(item.getItemId() == R.id.item_pink){
            linear.setBackgroundColor(Color.MAGENTA);
            return true;
        }else if(item.getItemId() == R.id.item_blue) {
            linear.setBackgroundColor(Color.BLUE);
            return true;
        }else if(item.getItemId() == R.id.btn_rotate) {
            rotationDegree += 45;
            btn.setRotation(rotationDegree);
            return true;
        }else if(item.getItemId() == R.id.btn_zoomin){
            btn.setScaleX(2);
            return true;
        }
        return false;
    }
}