package es.oaemdl.cavoshcafe2026;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import es.oaemdl.cavoshcafe2026.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = binding.navView;
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(navView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            int id = destination.getId();

            // Ocultar la barra en pantallas de autenticación o flujo inicial
            if (id == R.id.navigation_splash ||
                    id == R.id.navigation_login ||
                    id == R.id.navigation_registrar ||
                    id == R.id.navigation_verificar) {

                navView.setVisibility(View.GONE);
            } else {
                // Forzar que la barra sea visible en el resto de pantallas (Inicio, Menú, etc.)
                navView.setVisibility(View.VISIBLE);
            }
        });
    }
}