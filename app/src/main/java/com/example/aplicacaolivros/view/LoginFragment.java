package com.example.aplicacaolivros.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.aplicacaolivros.R;
import com.example.aplicacaolivros.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.bLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.etLoginUsuario.getText().toString().equals("")) {
                    binding.etLoginUsuario.setError("Informe o usuário!");
                    binding.etLoginUsuario.requestFocus();
                    return;
                }
                if (binding.etLoginSenha.getText().toString().equals("")) {
                    binding.etLoginSenha.setError("Informe a senha!");
                    binding.etLoginSenha.requestFocus();
                    return;
                }
                String usuario = binding.etLoginUsuario.getText().toString();
                String senha = binding.etLoginSenha.getText().toString();

                if (usuario.equalsIgnoreCase("Maria") && senha.equalsIgnoreCase("123456")) {
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_menuFragment);
                }
            }
        });

        binding.bLoginCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etLoginUsuario.setText("");
                binding.etLoginSenha.setText("");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}