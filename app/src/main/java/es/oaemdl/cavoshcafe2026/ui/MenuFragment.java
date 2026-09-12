package es.oaemdl.cavoshcafe2026.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import es.oaemdl.cavoshcafe2026.R;
import es.oaemdl.cavoshcafe2026.databinding.FragmentMenuBinding;
import es.oaemdl.cavoshcafe2026.model.Categoria;
import es.oaemdl.cavoshcafe2026.model.Producto;

public class MenuFragment extends Fragment {
    private FragmentMenuBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupCategories();
        setupProductsGrid();
    }

    private void setupCategories() {
        binding.rvCategories.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)
        );

        List<Categoria> categories = new ArrayList<>();
        categories.add(new Categoria("Hot drinks", R.drawable.ic_cafe_menu, true));
        categories.add(new Categoria("Cold drinks", R.drawable.ic_cafe_muestra, false));
        categories.add(new Categoria("Snacks", R.drawable.ic_cafe_remove, false));

        CategoryAdapter adapter = new CategoryAdapter(categories);
        binding.rvCategories.setAdapter(adapter);
    }

    private void setupProductsGrid() {
        // Configuramos 2 columnas para el Grid
        binding.rvMenuProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));

        List<Producto> products = new ArrayList<>();
        products.add(new Producto("Caramel Macchiato", "$4.00", R.drawable.ic_cafe_menu));
        products.add(new Producto("Vanilla Latte", "$3.00", R.drawable.ic_cafe_muestra));
        products.add(new Producto("Traditional Cappuccino", "$3.50", R.drawable.ic_cafe_menu));
        products.add(new Producto("White Chocolate Mocha", "$4.00", R.drawable.ic_cafe_remove));

        ProductAdapter adapter = new ProductAdapter(products);
        binding.rvMenuProducts.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}