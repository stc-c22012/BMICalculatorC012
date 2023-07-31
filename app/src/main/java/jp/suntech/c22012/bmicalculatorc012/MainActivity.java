package jp.suntech.c22012.bmicalculatorc012;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import androidx.annotation.Nullable;

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
            TextView outputresult = findViewById(R.id.tvResult);




            //タップされた画面部品をidのR値を取得。
            int id = view.getId();
            //idのR値に応じて処理を分岐

            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();

            if(id==R.id.bt_Clear){
                inputAge.setText("");
                inputHeight.setText("");
                inputWeight.setText("");
                outputBMI.setText("");
                outputhimando.setText("");
                outputhimando2.setText("");
                outputkg.setText("");
                outputBestWeight.setText("");
                outputresult.setText("");
            }
            if(id == R.id.bt_Calculation){

                String Age = inputAge.getText().toString();
                int AgeNum = Integer.parseInt(Age);
                int hannbetu = 0;


                if(AgeNum < 6){
                    hannbetu = 1;
                }
                else if(AgeNum < 16) {
                    //dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
                    hannbetu = 2;
                }

                //BMI計算
                String Height = inputHeight.getText().toString();
                double HeightNum = Double.parseDouble(Height);
                String Weight = inputWeight.getText().toString();
                double WeightNum = Double.parseDouble(Weight);

                //使用指数
                String text = "";
                String textResult = "";
                double BMI = 0;
                double BestWeight = 0;

                switch (hannbetu){
                    case 0:
                        BMI = WeightNum / (HeightNum * 0.01 * HeightNum * 0.01);
                        BestWeight = 20 * (HeightNum * 0.01 * HeightNum * 0.01);

                        if(BMI < 18.5){
                            text = "低体重";
                        }else if(BMI < 25){
                            text = "普通体重";
                            outputBMI.setTextColor(Color.GREEN);
                        }else if(BMI < 30){
                            text = "肥満(1度)";
                            outputBMI.setTextColor(Color.YELLOW);
                        }else if(BMI < 35){
                            text = "肥満(2度)";
                        }else if(BMI < 40){
                            text = "肥満(3度)";
                        }else{
                            text = "肥満(4度)";
                            outputBMI.setTextColor(Color.RED);
                        }

                        textResult = "BMI";

                        break;
                    case 1:
                        BMI = WeightNum / (HeightNum * 0.01 * HeightNum * 0.01);
                        BestWeight = 20 * (HeightNum * 0.01 * HeightNum * 0.01);

                        if(BMI <= 10){
                            text = "消耗症";
                        }else if(BMI <= 13){
                            text = "栄養失調";
                        }else if(BMI <= 15){
                            text = "やせ";
                        }else if(BMI <= 19){
                            text = "正常";
                            outputBMI.setTextColor(Color.GREEN);
                        }else if(BMI <= 22){
                            text = "少し太り気味";
                            outputBMI.setTextColor(Color.YELLOW);
                        }else{
                            text = "肥りすぎ";
                            outputBMI.setTextColor(Color.RED);
                        }

                        textResult = "カウプ指数";
                        break;
                    case 2:
                        BMI = WeightNum / (HeightNum * HeightNum * HeightNum) * 10000000;
                        BestWeight = 130 * (HeightNum * HeightNum * HeightNum) / 10000000;

                        if(BMI < 100){
                            text = "やせすぎ";
                        }else if(BMI < 115){
                            text = "やせぎみ";
                        }else if(BMI < 145){
                            text = "普通";
                            outputBMI.setTextColor(Color.GREEN);
                        }else if(BMI < 160){
                            text = "太りぎみ";
                            outputBMI.setTextColor(Color.YELLOW);
                        }else{
                            text = "太りすぎ";
                            outputBMI.setTextColor(Color.RED);
                        }

                        textResult = "ローレン指数";
                        break;
                }


                float fWeight = (float) BestWeight;

                String textWeight = String.format("%.1f",fWeight);



                outputBMI.setText(text);
                outputhimando.setText("あなたの肥満度は");
                outputhimando2.setText("あなたの適正体重は");
                outputBestWeight.setText(textWeight);
                outputkg.setText("kg");
                outputresult.setText(textResult);


            }
        }
    }
}