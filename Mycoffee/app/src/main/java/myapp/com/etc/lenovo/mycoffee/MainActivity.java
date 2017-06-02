package myapp.com.etc.lenovo.mycoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView quantity;
    private TextView price;
    private TextView message;

    private Button btnadd;
    private Button btnsub;
    private Button btnorder;

    private EditText Name;

    private CheckBox WhippedcreamCheckBox;
    private CheckBox ChocolateCheckBox;

    private int quantityNumber = 0;
    private int priceNumber;

    private String msg = null;

    private int UnitPrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantity = (TextView) findViewById(R.id.quantity);
        price = (TextView) findViewById(R.id.price);
        message = (TextView) findViewById(R.id.message);

        btnadd = (Button) findViewById(R.id.btnadd);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnorder = (Button) findViewById(R.id.btnorder);

        Name = (EditText) findViewById(R.id.name);

        WhippedcreamCheckBox = (CheckBox) findViewById(R.id.Whipped);


        ChocolateCheckBox = (CheckBox) findViewById(R.id.Chocolate);



        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityNumber++;
                quantity.setText(String.valueOf(quantityNumber));
                price.setText(String.valueOf(quantityNumber*UnitPrice));
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(quantityNumber>0){
                    quantityNumber--;
                    quantity.setText(String.valueOf(quantityNumber));
                    price.setText(String.valueOf(quantityNumber*UnitPrice));
                }else{
                    Toast.makeText(getApplicationContext(), "最少0杯Coffee哦~", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnorder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int price = quantityNumber*UnitPrice;
                if(!Name.equals("")){
                    msg = "Name: "+ Name.getText() + "\n";
                }
                if(WhippedcreamCheckBox.isChecked()){
                    price += 3;
                    Toast.makeText(getApplicationContext(), "添加了Whippedcream", Toast.LENGTH_SHORT).show();
                }
                if( ChocolateCheckBox.isChecked()){
                    price += 5;
                    Toast.makeText(getApplicationContext(), "添加了Chocolate", Toast.LENGTH_SHORT).show();
                }
                msg += "您本次购买咖啡"+quantityNumber+"杯，共消费金额"+ price +"刀，感谢您的光临，再见！";
                message.setText(msg);
            }
        });

    }
}
