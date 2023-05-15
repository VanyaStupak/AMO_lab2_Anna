package com.example.amo_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView sorted, output, checkTime;
    private EditText n, low, top;
    private long[] array, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10;
    public static double[] time = new double[10];


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.textView9);
        n = findViewById(R.id.enterN);
        low = findViewById(R.id.enterLow);
        top = findViewById(R.id.enterTop);
        Button generate = findViewById(R.id.generate);
        Button sort = findViewById(R.id.sortButton);
        Button sort2 = findViewById(R.id.sortButton2);
        Button graph = findViewById(R.id.sortButton3);
        checkTime = findViewById(R.id.textView5);
        output.setMovementMethod(new ScrollingMovementMethod());

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#E10DC5")));
        getSupportActionBar().setTitle("Лабораторна робота №2");
        output.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (Integer.parseInt(String.valueOf(n.getText())) <= 0) {
                        checkTime.setText("Кількість елементів масиву не може бути від'ємною!");
                    } else {
                        array = new long[Integer.parseInt(String.valueOf(n.getText()))];
                        long toplimit = Integer.parseInt(String.valueOf(top.getText()));
                        long bottomLimit = Integer.parseInt(String.valueOf(low.getText()));

                        for (int i = 0; i < array.length; i++) {
                            array[i] = (long) (Math.random() * (toplimit - bottomLimit + 1) + (bottomLimit));
                        }
                        if (bottomLimit > toplimit) {
                            checkTime.setText("Верхня границя має бути більшою за нижню!");
                        } else {
                            output.setText(Arrays.toString(array));
                        }
                    }
                } catch (NumberFormatException e) {
                    output.setText("Введіть коректні  числа!");
                }
                sort.setText("cортувати масив");
            }
        });
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    long m = System.currentTimeMillis();
                    int n = array.length;
                    boolean swapped;

                    for (int i = 0; i < n - 1; i++) {
                        swapped = false;

                        for (int j = 0; j < n - i - 1; j++) {
                            if (array[j] > array[j + 1]) {
                                // Обмін елементів
                                long temp = array[j];
                                array[j] = array[j + 1];
                                array[j + 1] = temp;
                                swapped = true;
                            }
                        }

                        // Якщо в цій ітерації не було жодного обміну, то масив вже відсортований
                        if (!swapped) {
                            break;
                        }
                    }

                    checkTime.setText("Час сортування = " + String.valueOf((double) ((System.currentTimeMillis() - m) / 1000.0) + "s"));
                    output.setText(Arrays.toString(array));
                } catch (
                        NullPointerException e) {
                    output.setText("Cпочатку згенеруйте масив!");
                }
            }
        });


        arr1 = new long[10];
        arr2 = new long[100];
        arr3 = new long[500];
        arr4 = new long[800];
        arr5 = new long[1000];
        arr6 = new long[3000];
        arr7 = new long[5000];
        arr8 = new long[10000];
        arr9 = new long[30000];
        arr10 = new long[50000];
        sort2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long m1 = System.currentTimeMillis();
                sort10mas(arr1, 0);
                sort10mas(arr2, 1);
                sort10mas(arr3, 2);
                sort10mas(arr4, 3);
                sort10mas(arr5, 4);
                sort10mas(arr6, 5);
                sort10mas(arr7, 6);
                sort10mas(arr8, 7);
                sort10mas(arr9, 8);
                sort10mas(arr10, 9);
                checkTime.setText("Масиви відсортовано за " + String.valueOf((double) ((System.currentTimeMillis() - m1) / 1000.0)) + "s");
                output.setText(Arrays.toString(time));
            }
        });

        fullarr(arr1, arr1.length);

        fullarr(arr2, arr2.length);

        fullarr(arr3, arr3.length);

        fullarr(arr4, arr4.length);

        fullarr(arr5, arr5.length);

        fullarr(arr6, arr6.length);

        fullarr(arr7, arr7.length);

        fullarr(arr8, arr8.length);

        fullarr(arr9, arr9.length);

        fullarr(arr10, arr10.length);


    }

    public void sort10mas(long[] array1, int arraycount) {
        long m = System.currentTimeMillis();
        int n = array1.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array1[j] > array1[j + 1]) {
                    // Обмін елементів
                    long temp = array1[j];
                    array1[j] = array1[j + 1];
                    array1[j + 1] = temp;
                    swapped = true;
                }
            }

            // Якщо в цій ітерації не було жодного обміну, то масив вже відсортований
            if (!swapped) {
                break;
            }
        }
        time[arraycount] = (System.currentTimeMillis() - m) / 1000.0;
    }

    public void fullarr(long[] arr, long length) {
        for (int i = 0; i < length; i++) {
            arr[i] = (long) (Math.random() * 2000 - 1000);
        }
    }

    public void startNewActivity(View v) {
        Intent intent = new Intent(this, Graph1.class);
        startActivity(intent);

    }
}