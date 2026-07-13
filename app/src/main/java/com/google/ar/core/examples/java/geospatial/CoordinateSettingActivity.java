package com.google.ar.core.examples.java.geospatial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class CoordinateSettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_setting);

        EditText editTextA = findViewById(R.id.editTextA);
        EditText editTextB = findViewById(R.id.editTextB);
        EditText editTextC = findViewById(R.id.editTextC);
        String inputTextA = editTextA.getText().toString();
        String inputTextB = editTextB.getText().toString();
        String inputTextC = editTextC.getText().toString();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            String strA = editTextA.getText().toString().replaceAll(" ", "");
            String strB = editTextB.getText().toString().replaceAll(" ", "");
            String strC = editTextC.getText().toString().replaceAll(" ", "");

            if (strA.isEmpty() || strB.isEmpty() || strC.isEmpty()) {
                showAlertDialog();
            } else {
                Intent intentSub = new Intent();

                String[] points = {strA, strB, strC};
                intentSub.putExtra(GeospatialActivity.EXTRA_MESSAGE, points);

//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

                setResult(RESULT_OK, intentSub);

                finish();
            }
        });
    }

    private void showAlertDialog() {
        // AlertDialogを構築
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("アラート");
        builder.setMessage("緯度経度高度を入力してください！");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // OKボタンが押されたときの処理
                dialog.dismiss(); // ダイアログを閉じる
            }
        });

        // AlertDialogを表示
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // 文字列が数字であるかを判定するメソッド
    private static boolean isNumeric(String str) {
        try {
            // 文字列を整数に変換
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            // 変換できない場合は例外が発生するので、falseを返す
            return false;
        }
    }
}
