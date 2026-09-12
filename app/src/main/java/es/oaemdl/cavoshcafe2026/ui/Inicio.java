package es.oaemdl.cavoshcafe2026.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import es.oaemdl.cavoshcafe2026.R;
import es.oaemdl.cavoshcafe2026.databinding.FragmentInicioBinding;

public class Inicio extends Fragment {
    private FragmentInicioBinding binding;
    private Context context;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentInicioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);

        // Inicializar ambos RecyclerViews
        setupNewProductsRecyclerView();
        setupFrequentProductsRecyclerView();
    }

    private void setupNewProductsRecyclerView() {
        binding.rvNewProducts.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        );

        List<Producto> newProducts = new ArrayList<>();
        newProducts.add(new Producto("Frappuccino Choco", "$4.50", R.drawable.ic_cafe_remove));
        newProducts.add(new Producto("Iced Latte", "$3.80", R.drawable.ic_cafe_menu));
        newProducts.add(new Producto("Iced Cold Brew", "$4.20", R.drawable.ic_cafe_muestra));

        ProductAdapter adapter = new ProductAdapter(newProducts);
        binding.rvNewProducts.setAdapter(adapter);
    }

    private void setupFrequentProductsRecyclerView() {
        binding.rvFrequentProducts.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        );

        List<Producto> frequentProducts = new ArrayList<>();
        frequentProducts.add(new Producto("Frappuccino Choco", "Grande, Crema batida", "$5.50", R.drawable.ic_cafe_remove));
        frequentProducts.add(new Producto("Iced Latte", "Mediano, Leche de almendras", "$4.80", R.drawable.ic_cafe_menu));

        FrequentAdapter freqAdapter = new FrequentAdapter(frequentProducts);
        binding.rvFrequentProducts.setAdapter(freqAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}