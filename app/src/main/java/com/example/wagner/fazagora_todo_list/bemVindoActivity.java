package com.example.wagner.fazagora_todo_list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.ObjectServerError;
import io.realm.SyncCredentials;
import io.realm.SyncUser;

import static com.example.wagner.fazagora_todo_list.Constantes.AUTH_URL;

public class bemVindoActivity extends AppCompatActivity {

    private EditText mNicknameTextView;
    private View mProgressView;
    private  View mLoginFormView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        if(SyncUser.currentUser() !=null){
            //this.goToItemsActivity();

        }

        // Setar o formulario de log.
        mNicknameTextView = findViewById(R.id.nickname);
        Button loginButton = findViewById(R.id.login_button);
       // loginButton.setOnClickListener(view -> attemptLogin());
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void attemptLogin(){
        // resetar erros
        mNicknameTextView.setError(null);
        // armazenar valores de tentativas de login
        String nickname = mNicknameTextView.getText().toString();
        showProgress(true);
        SyncCredentials credentials;
        credentials = SyncCredentials.nickname(nickname, true);
        SyncUser.loginAsync(credentials, AUTH_URL, new SyncUser.Callback<SyncUser>() {
            @Override
            public void onSuccess(SyncUser user) {
                showProgress(false);
               // goToItemsActivity();
            }
            @Override
            public void onError(ObjectServerError error) {
                showProgress(false);
                mNicknameTextView.setError("Ah ouh um erro aconteceu! (verifique seu login por favor)");
                mNicknameTextView.requestFocus();
                Log.e("Login error", error.toString());
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mProgressView.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }
    //    private void goToItemsActivity(){
//        Intent intent = new Intent(bemVindoActivity.this, ItemsActivity.class);
//        startActivity(intent);
//    }
}
