package kr.ac.kopo.menutest1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    EditText editDegree;
    ImageView imageView;
    float inputDegree;
    float currentDegree;
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
        editDegree = findViewById(R.id.editDegree);
        imageView = findViewById(R.id.imageView);
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

        int id = item.getItemId();

        if (id == R.id.item_rotate) {
            String degreeStr = editDegree.getText().toString();
            if (!degreeStr.isEmpty()) {
                currentDegree += Float.parseFloat(degreeStr);
                imageView.setRotation(currentDegree);
            } else {
                Toast.makeText(getApplicationContext(), "각도를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
            }
            return true;
        } else if (id == R.id.item_img01) {
            item.setChecked(true);
            imageView.setImageResource(R.drawable.img01);
            return true;
        } else if (id == R.id.item_img02) {
            item.setChecked(true);
            imageView.setImageResource(R.drawable.img02);
            return true;
        } else if (id == R.id.item_img03) {
            item.setChecked(true);
            imageView.setImageResource(R.drawable.img03);
            return true;
        }

        return false;
    }
}