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

import com.example.aplicacaolivros.databinding.FragmentCadastroBinding;
import com.example.aplicacaolivros.modelDominio.Livro;
import com.example.aplicacaolivros.viewModel.InformacoesViewModel;


public class CadastroFragment extends Fragment {

    FragmentCadastroBinding binding;
    InformacoesViewModel informacoesViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.bCadastroSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.etCadastroTitulo.getText().toString().equals("")) {
                    binding.etCadastroTitulo.setError("Informe o título do livro!");
                    binding.etCadastroTitulo.requestFocus();
                    return;
                }
                if (binding.etCadastroAnodeLan.getText().toString().equals("")) {
                    binding.etCadastroAnodeLan.setError("Informw o ano de lançamento do livro!");
                    binding.etCadastroAnodeLan.requestFocus();
                    return;
                }
                if (binding.etCadastroPreco.getText().toString().equals("")) {
                    binding.etCadastroPreco.setError("Informe o preço do livro!");
                    binding.etCadastroPreco.requestFocus();
                    return;
                }
                boolean generoLivroEstaPreenchido = binding.rbCadastroTecnico.isChecked()
                        || binding.rbCadastroFiccao.isChecked()
                        || binding.rbCadastroRomance.isChecked();
                if (generoLivroEstaPreenchido == false) {
                    Toast.makeText(getContext(), "Selecione o gênero do livro!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String titulo = binding.etCadastroTitulo.getText().toString();
                int anoLancamento = Integer.parseInt(binding.etCadastroAnodeLan.getText().toString());
                float preco = Float.parseFloat(binding.etCadastroPreco.getText().toString());
                int genero = 0;
                if (binding.rbCadastroTecnico.isChecked()) {
                    genero = 1;
                } else if (binding.rbCadastroFiccao.isChecked()) {
                    genero = 2;
                } else {
                    genero = 3;
                }

                Livro meuLivro = new Livro(titulo, anoLancamento, preco, genero);

                informacoesViewModel.getListaLivros().add(meuLivro);
                Toast.makeText(getContext(), "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                limpaCampos();

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cadastro, container, false);
        binding = FragmentCadastroBinding.inflate(inflater, container, false);
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        return binding.getRoot();
    }

    public void limpaCampos() {
        binding.etCadastroTitulo.setText("");
        binding.etCadastroAnodeLan.setText("");
        binding.etCadastroPreco.setText("");
        binding.rgCadastroGenero.clearCheck();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}