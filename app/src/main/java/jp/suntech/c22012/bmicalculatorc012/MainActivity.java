package jp.suntech.c22012.bmicalculatorc012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btClear = findViewById(R.id.bt_Clear);
        Button btCalculator = findViewById(R.id.bt_Calculation);
        //リスナ・オブジェクトの用意
        BMIListener listener = new BMIListener();
        //ボタンにリスナを設定
        btClear.setOnClickListener(listener);
        btCalculator.setOnClickListener(listener);
    }

    private class BMIListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //入力欄であるEditTextオブジェクトを取得。
            EditText inputAge = findViewById(R.id.etAge);
            //入力欄であるEditTextオブジェクトを取得。
            EditText inputHeight = findViewById(R.id.etHeight);
            //入力欄であるEditTextオブジェクトを取得。
            EditText inputWeight = findViewById(R.id.etWeight);
            //メッセージを表示するTextViewオブジェクトを取得。
            TextView outputBMI = findViewById(R.id.tvBMI);
            TextView outputBestWeight = findViewById(R.id.tvBestWeight);
            TextView outputhimando = findViewById(R.id.tv_Degree);
            TextView outputhimando2 = findViewById(R.id.tv_Degree2);
            TextView outputkg = findViewById(R.id.tv_kg);



            //タップされた画面部品をidのR値を取得。
            int id = view.getId();
            //idのR値に応じて処理を分岐

            if(id==R.id.bt_Clear){
                inputAge.setText("");
                inputHeight.setText("");
                inputWeight.setText("");
                outputBMI.setText("");
                outputhimando.setText("");
                outputhimando2.setText("");
                outputkg.setText("");
                outputBestWeight.setText("");
            }
            if(id == R.id.bt_Calculation){
                String Height = inputHeight.getText().toString();
                double HeightNum = Double.parseDouble(Height);
                String Weight = inputWeight.getText().toString();
                double WeightNum = Double.parseDouble(Weight);

                double BMI = WeightNum / (HeightNum * 0.01 * HeightNum * 0.01);
                double BestWeight = 20 * (HeightNum * 0.01 * HeightNum * 0.01);

                String text = "";

                float fWeight = (float) BestWeight;

                String textWeight = String.format("%.1f",fWeight);

                if(BMI < 18.5){
                    text = "低体重";
                }else if(BMI < 25){
                    text = "普通体重";
                }else if(BMI < 30){
                    text = "肥満(1度)";
                }else if(BMI < 35){
                    text = "肥満(2度)";
                }else if(BMI < 40){
                    text = "肥満(3度)";
                }else{
                    text = "肥満(4度)";
                }


                outputBMI.setText(text);
                outputhimando.setText("あなたの肥満度は");
                outputhimando2.setText("あなたの適正体重は");
                outputBestWeight.setText(textWeight);
                outputkg.setText("kg");


            }
        }
    }
}