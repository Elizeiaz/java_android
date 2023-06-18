package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = random.nextInt(20); // Максимальная длина случайной строки (в данном примере до 20 символов)

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String[] generateStringArray(int n) {
        String[] array = new String[n];

        for (int i = 0; i < n; i++){
            array[i] = generateRandomString();
        }

        return array;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] array = generateStringArray(100);

        setContentView(R.layout.activity_main);

        // получаем элемент ListView
        ListView countriesList = findViewById(R.id.countriesList);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                                                        android.R.layout.simple_list_item_1, array);

        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);
    }
}