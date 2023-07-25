package com.example.aplicacaolivros.modelDominio;

import android.view.View;

public class Livro {
    private String titulo;
    private int anoLancamento;
    private float preco;
    private int genero;

    public Livro(String titulo, int anoLancamento, float preco, int genero) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.preco = preco;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getGeneroLiteral() {
        String retorno;
        if (this.genero == 1) {
            retorno = "Técnico";
        } else if (this.genero == 2) {
            retorno = "Ficção";
        } else {
            retorno = "Romance";
        }
        return retorno;
    }

    public interface LivroOnClickListener {
        public void onClickLivro(View view, int position, Livro curso);
    }
}
