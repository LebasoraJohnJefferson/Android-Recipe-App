package com.example.cookingrecipe;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cookingrecipe.category.categoryActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_getStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_getStart = findViewById(R.id.getStarted);
        getBtnGetStart().setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,categoryActivity.class);
            startActivity(intent);
        });
    }

    private Button getBtnGetStart() {
        return btn_getStart;
    }
}