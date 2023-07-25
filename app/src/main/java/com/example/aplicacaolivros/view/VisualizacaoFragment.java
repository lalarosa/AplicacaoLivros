package com.example.aplicacaolivros.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.aplicacaolivros.adapter.LivroAdapter;
import com.example.aplicacaolivros.databinding.FragmentVisualizacaoBinding;
import com.example.aplicacaolivros.modelDominio.Livro;
import com.example.aplicacaolivros.viewModel.InformacoesViewModel;

public class VisualizacaoFragment extends Fragment {

    FragmentVisualizacaoBinding binding;
    InformacoesViewModel informacoesViewModel;
    LivroAdapter livroAdapter;
    Livro.LivroOnClickListener trataCliqueItem = new Livro.LivroOnClickListener() {
        @Override
        public void onClickLivro(View view, int position, Livro livro) {
            Toast.makeText(getContext(), "LIVRO - Título:  " + livro.getTitulo() + "; Ano de Lançamento: " + livro.getAnoLancamento() + "; Preço: " + livro.getPreco() + "; Gênero: " + livro.getGeneroLiteral(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        if (informacoesViewModel.getListaLivros() != null) {
            atualizaListagem();
        }

    }

    public void atualizaListagem() {
        livroAdapter = new LivroAdapter(informacoesViewModel.getListaLivros(), trataCliqueItem);
        binding.rvVisualizacaoLivros.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvVisualizacaoLivros.setItemAnimator(new DefaultItemAnimator());
        binding.rvVisualizacaoLivros.setAdapter(livroAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_visualizacao, container, false);
        binding = FragmentVisualizacaoBinding.inflate(inflater, container, false);
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}