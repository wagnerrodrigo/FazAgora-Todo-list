package com.example.wagner.fazagora_todo_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.ObjectServerError;
import io.realm.SyncCredentials;
import io.realm.SyncUser;

import static com.example.wagner.fazagora_todo_list.bemVindoActivity.Constants.AUTH_URL;

public class bemVindoActivity extends AppCompatActivity {

    private EditText mNicknameTextView;
    private View mProgressView;
    private  View mLoginFormView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        if(SyncUser.currentUser() !=null){
            this.goToItemsActivity();

        }

        // Setar o formulario de log.
        mNicknameTextView = findViewById(R.id.nickname);
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(view -> attemptLogin());
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void attemptLogin(){
        // resetar erros
        mNicknameTextView.setError(null);
        // armazenar valores de tentativas de login

    }






}
