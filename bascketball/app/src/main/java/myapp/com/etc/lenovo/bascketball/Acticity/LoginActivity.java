package myapp.com.etc.lenovo.bascketball.Acticity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

;import myapp.com.etc.lenovo.bascketball.R;
import myapp.com.etc.lenovo.bascketball.application.MyApp;
import myapp.com.etc.lenovo.bascketball.entity.User;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Handler handler;
    private String responseText;
    private ProgressDialog loginDialog;
    private String url = "http://10.0.2.2:8080/test/servlet/com.basket.app.servlet.UserLoginServlet";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {

                super.handleMessage(msg);

                //销毁进度条对话框
                //loginDialog.dismiss();

                if (msg.what == 1) {

                    //解析数据
                    Gson gson = new Gson();
                    User user = gson.fromJson(responseText, User.class);

                    if (user != null) {
                        //将user对象保存到全局变量中
                        MyApp myApp = (MyApp) getApplication();
                        myApp.setUser(user);

                        //跳转到主界面
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        //Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
                        //关闭当前页面
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "用户名或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    //Toast.makeText(getApplicationContext(), "网络访问失败", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //用户登录
    public void login(View v) {

        //启动进度条对话
        // loginDialog.show();

        //启动网络访问线程
        new Thread(new LoginRunner()).start();
    }

//    public void register(View v){
//
//        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
//        startActivity(intent);
//    }

    private class LoginRunner implements Runnable {

        @Override
        public void run() {

            //实例化HttpClient对象

            HttpClient client = new DefaultHttpClient();

            //实例化post请求对象
            HttpPost request = new HttpPost(url);

            //发出post请求
            try {

                //封装请求参数
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", username.getText().toString()));
                params.add(new BasicNameValuePair("password", password.getText().toString()));

                //设置请求参数
                //request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                request.setEntity(new UrlEncodedFormEntity(params, "UTF_8"));

                //发出post请求
                HttpResponse response = client.execute(request);

                //接收返回数据
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                    responseText = EntityUtils.toString(response.getEntity());

                    //向主线程发送消息
                    handler.sendEmptyMessage(1);
                }

            } catch (ClientProtocolException e) {

                e.printStackTrace();
                handler.sendEmptyMessage(-1);
            } catch (IOException e) {

                e.printStackTrace();
                handler.sendEmptyMessage(-1);
            }
        }
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.login, menu);
//        return true;
//    }
    private DialogInterface.OnClickListener click1 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface arg0, int arg1) {
            Process.killProcess(Process.myPid());
        }
    };
    private DialogInterface.OnClickListener click2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface arg0, int arg1) {
            arg0.cancel();
        }
    };

    public void back(View view) {
        //Toast.makeText(this,"点击确认", Toast.LENGTH_LONG).show();
        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(this);
        alertdialogbuilder.setMessage("您确认要退出程序");
        alertdialogbuilder.setPositiveButton("确定", click1);
        alertdialogbuilder.setNegativeButton("取消", click2);
        AlertDialog alertdialog1 = alertdialogbuilder.create();
        alertdialog1.show();


    }

}
