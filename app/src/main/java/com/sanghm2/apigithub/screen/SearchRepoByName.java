package com.sanghm2.apigithub.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sanghm2.apigithub.R;

public class SearchRepoByName extends AppCompatActivity {
    EditText searchName;
    Button btnsearch ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_repo_by_name);
        initView();
        actionView();
    }

    private void actionView() {
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(searchName.getText().toString().trim().equals("")){
                   Toast.makeText(SearchRepoByName.this, "Vui lòng nhập tên github để tìm kiếm repo ", Toast.LENGTH_SHORT).show();
               }else {
                   hideKeyBoard();
                   String name = searchName.getText().toString().trim();
                   Intent intent = new Intent(SearchRepoByName.this , MainActivity.class);
                   intent.putExtra("name",name);
                   startActivity(intent);
                   searchName.setText("");
               }
            }
        });
    }

    private void initView() {
        searchName  = findViewById(R.id.searchName);
        btnsearch  = findViewById(R.id.btnSearch);
    }
    private void hideKeyBoard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}