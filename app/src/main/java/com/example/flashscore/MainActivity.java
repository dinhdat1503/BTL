package com.example.flashscore;
import com.google.android.material.appbar.MaterialToolbar;
import android.os.Bundle;
import com.example.flashscore.R;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import android.widget.Toast;
import android.view.Menu;


import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
private BottomNavigationView bottomNavigationView;
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar_menu, menu);
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);

        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topAppBar);

        topAppBar.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();

            if (id == R.id.action_notifications) {
                Toast.makeText(MainActivity.this, "🔔 Cập nhật trận đấu, đội hình, kết quả...", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.action_account) {
                Toast.makeText(MainActivity.this, "👤 Quản lý tài khoản, đội yêu thích...", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, new HomeFragment()).commit();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment selectedFragment = null;
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            selectedFragment = new HomeFragment();
        } else if (id == R.id.nav_standings) {
            selectedFragment = new StandingsFragment();
        } else if (id == R.id.nav_leagues) {
            selectedFragment = new LeaguesFragment();
        } else if (id == R.id.nav_search) {
            selectedFragment = new SearchFragment();
        }

        if (selectedFragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment, selectedFragment)
                    .commit();
        }
        return true;
    };
}