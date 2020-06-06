package com.example.sampleapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.sampleapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    SearchView laptopSearchView;
    ListView laptopList, suppliersList;
    ArrayList<String> list;
    ArrayAdapter<String> laptopArrayAdapter, suppliersArrayAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        /* Suppliers List Display : Array Approach */
        String[] suppliers = {"Laptop Geeks","Laptop Nerds","Laptop Wizards","Laptop Gurus", "Laptop Jedi"};
        suppliersArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, suppliers);
        suppliersList = (ListView) root.findViewById(R.id.suppliers_list);
        suppliersList.setAdapter(suppliersArrayAdapter);

        /* Laptop List Display : ArrayList Approach */
        laptopSearchView = (SearchView) root.findViewById(R.id.laptop_search);
        laptopList = (ListView) root.findViewById(R.id.laptop_list);

        list = new ArrayList<String>();

        list.add("HP Spectre x360");
        list.add("Dell XPS 13");
        list.add("Acer Aspire 5");
        list.add("Apple MacBook Pro 16");
        list.add("Asus ZenBook 13");
        list.add("Razer Blade 15");

        laptopArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
        laptopList.setAdapter(laptopArrayAdapter);

        /* List Search */

        laptopSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                laptopArrayAdapter.getFilter().filter(newText);

                return false;
            }
        });

        laptopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.nav_gallery);
            }
        });

        return root;
    }
}