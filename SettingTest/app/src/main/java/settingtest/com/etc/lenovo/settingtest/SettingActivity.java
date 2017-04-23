package settingtest.com.etc.lenovo.settingtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    //声明控件
    //private ImageView imgUserPhoto;
    private TextView txtUsername;
    private EditText edtUsername;
    private Button btnClose;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Intent intent = this.getIntent();
        Toast.makeText(getApplicationContext(),user.getUsername(),Toast.LENGTH_SHORT).show();
        //获得传来的数据
//        Intent intent = this.getIntent();
//        Bundle bundle = intent.getExtras();
//        String Username = bundle.getString("Username");
//        String Password = bundle.getString("Password");
//        String UserPhoto = bundle.getString("UserPhoto");
//        String Score = bundle.getString("Score");

        //获得控件
        //imgUserPhoto = (ImageView) findViewById(R.id.imgUserPhoto);
        btnClose = (Button)findViewById(R.id.btnClose);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtUsername.setVisibility(View.GONE);

        //为组件添加文字
        txtUsername.setText(user.getUsername());

        //点击事件监听器
        //imgUserPhoto.setOnClickListener(new ClOnClickListerner());
        txtUsername.setOnClickListener(new ClOnClickListerner());
        btnClose.setOnClickListener(new ClOnClickListerner());

        //设置横屏与全屏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }
    private class ClOnClickListerner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
//                case R.id.imgUserPhoto:
//                    break;
                case R.id.txtUsername:
                    txtUsername.setVisibility(View.GONE);
                    edtUsername.setVisibility(View.VISIBLE);
                    user.setUsername(edtUsername.getText().toString());
                    break;
                case R.id.btnClose:
                    finish();
                    break;
                default:
                    break;
            }
        }
    }
}
