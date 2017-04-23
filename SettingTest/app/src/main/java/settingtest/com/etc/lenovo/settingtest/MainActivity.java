package settingtest.com.etc.lenovo.settingtest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private Button btnSetting;
    private EditText edtUsername;
    private User user;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsername = (EditText)findViewById(R.id.edtUsername);
        btnSetting = (Button)findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new OnClickListenerimpl());
    }
    private class OnClickListenerimpl implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnSetting:
                    String Username = edtUsername.getText().toString();
                    user = (User) MainActivity.this.getApplication();
                    user.setUsername(Username);
                    Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                    startActivityForResult(intent, 1);
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){   //操作成功
            //接收返回值
            edtUsername.setText(user.getUsername());
        }else{

        }
    }

}
