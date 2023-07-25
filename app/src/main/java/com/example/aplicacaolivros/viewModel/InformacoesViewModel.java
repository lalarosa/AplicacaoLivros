package com.example.aplicacaolivros.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aplicacaolivros.modelDominio.Livro;

import java.util.ArrayList;

public class InformacoesViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Livro>> mlistaLivro;

    public ArrayList<Livro> getListaLivros() {
        if (mlistaLivro == null) {
            mlistaLivro = new MutableLiveData<>();
            ArrayList<Livro> listaLivros = new ArrayList<>();
            mlistaLivro.setValue(listaLivros);
        }
        return mlistaLivro.getValue();
    }
}
