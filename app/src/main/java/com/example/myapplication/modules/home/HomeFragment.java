package com.example.myapplication.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.listener.ItemClickListener;
import com.example.myapplication.model.Facts;
import com.example.myapplication.model.Row;
import com.example.myapplication.modules.item.MainActivity;
import com.example.myapplication.utils.NetworkUtility;

import java.util.List;

public class HomeFragment extends Fragment  implements ItemClickListener {
    FragmentHomeBinding binding;

RowViewModel rowViewModel;
RecyclerAdapter adapter;
List<Row>rowList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       binding= DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_home,container,false);
        rowViewModel= ViewModelProviders.of(this).get(RowViewModel.class);
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter=new RecyclerAdapter(this::onClickItem);
        binding.setAdapter(adapter);
        if(NetworkUtility.checkConnection(getContext())) {
            rowViewModel.getFacts().observe(getActivity(), new Observer<Facts>() {
                @Override
                public void onChanged(Facts facts) {
                    rowList = facts.getRows();
                    adapter.addRowList(rowList);
                    adapter.notifyDataSetChanged();
                    binding.setModel(facts);


                }
            });
        }


    }



    @Override
    public void onClickItem(Object obj) {
        if(obj instanceof Integer){
            Intent intent=new Intent(getContext(), MainActivity.class);
            intent.putExtra("title",rowList.get((Integer)obj).getTitle());
            intent.putExtra("description",rowList.get((Integer)obj).getDescription());
            startActivity(intent);
        }

    }
}
