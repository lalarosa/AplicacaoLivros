package com.example.aplicacaolivros.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacaolivros.databinding.ItemListRowBinding;
import com.example.aplicacaolivros.modelDominio.Livro;

import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.MyViewHolder> {
    private List<Livro> listaLivros;
    private Livro.LivroOnClickListener livroOnClickListener;

    public LivroAdapter(List<Livro> listaLivros, Livro.LivroOnClickListener livroOnClickListener) {
        this.listaLivros = listaLivros;
        this.livroOnClickListener = livroOnClickListener;
    }

    @Override
    public LivroAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListRowBinding itemListRowBinding = ItemListRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemListRowBinding);
    }

    @Override
    public void onBindViewHolder(final LivroAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Livro meuLivro = listaLivros.get(position);
        holder.itemListRowBinding.tvLivroTitulo.setText(meuLivro.getTitulo());
        holder.itemListRowBinding.tvLivroDataLan.setText("Ano de lançamento: " + String.valueOf(meuLivro.getAnoLancamento()));
        holder.itemListRowBinding.tvLivroPreco.setText("Preço: " + String.valueOf(meuLivro.getPreco()));
        holder.itemListRowBinding.tvLivroGenero.setText("Gênero: " + meuLivro.getGeneroLiteral());
        /* CUIDADO: .setText() precisa sempre de String. Se for outro tipo de dado, deve ser feita a conversão com o String.valueOf() */

        // tratando o clique no item
        if (livroOnClickListener != null) {
            holder.itemListRowBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    livroOnClickListener.onClickLivro(holder.itemView, position, meuLivro);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaLivros.size();
    }

    public interface LivroOnClickListener {
        void onClickLivro(View view, int position, Livro livro);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ItemListRowBinding itemListRowBinding;

        public MyViewHolder(ItemListRowBinding itemListRowBinding) {
            super(itemListRowBinding.getRoot());
            this.itemListRowBinding = itemListRowBinding;
        }
    }

}

