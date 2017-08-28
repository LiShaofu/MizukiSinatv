package com.mizuki.sinatv.activity;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mizuki.sinatv.R;
import com.mizuki.sinatv.activity.base.BaseActivity;
import com.mizuki.sinatv.api.SignUpApi;
import com.mizuki.sinatv.api.UploadApi;
import com.mizuki.sinatv.bean.SignUpBean;
import com.mizuki.sinatv.bean.UploadBean;
import com.mizuki.sinatv.network.RetrofitManager;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mizuki.sinatv.utils.ToastUtils.showToastNull;

/**
 * 先得到图片地址，再注册
 * 先写上传图片，先拿到图片，。。。
 */
public class SignupActivity extends BaseActivity {

    @BindView(R.id.et_signup_phone)
    EditText etSignupPhone;
    @BindView(R.id.et_signup_user_name)
    EditText etSignupUserName;
    @BindView(R.id.iv_signup_avatar)
    ImageView ivSignupAvatar;
    @BindView(R.id.et_signup_sign)
    EditText etSignupSign;
    @BindView(R.id.et_signup_pwd)
    EditText etSignupPwd;
    @BindView(R.id.bt_signup)
    Button btSignup;
    @BindView(R.id.tx_signin)
    TextView txSignin;
    private String[] strings;

    private static int REQUEST_CAMERA_1 = 1;//从相册取图
    private static int REQUEST_CAMERA_2 = 2;//从相机取图

    @Override
    protected int getContentResId() {
        return R.layout.activity_signup;
    }

    //sign up的业务逻辑处理
    private void signup() {
        Toast.makeText(SignupActivity.this, "开始注册！", Toast.LENGTH_SHORT).show();
        // 1 获取输入的用户名和密码
        final String phone = etSignupPhone.getText().toString().trim();//电话号码
//        String avatar = ivSignupAvatar;//头像
        String sign = etSignupSign.getText().toString().trim();//签名
        final String user_name = etSignupUserName.getText().toString().trim();//用户名
        final String password = etSignupPwd.getText().toString().trim();//密码
        // 2 校验输入的用户名和密码不为空
        showToastNull(SignupActivity.this, phone, "输入的电话号码不能为空！");
        showToastNull(SignupActivity.this, user_name, "输入的用户名不能为空！");
        showToastNull(SignupActivity.this, sign, "输入的签名不能为空！");
        showToastNull(SignupActivity.this, password, "输入的密码不能为空！");
// 3 注册逻辑处理
        Log.e("TAG", phone + "\t" + sign + "\t" + user_name + "\t" + password);
        SignUpApi signUpApi = RetrofitManager.getTestRetrofit().create(SignUpApi.class);
        FormBody formBody = new FormBody.Builder()//用户注册参数
                .add("phone", phone)//手机号
                .add("user_name", user_name)//用户昵称
                .add("avatar", "http://n.sinaimg.cn/translate/20170828/xJjn-fykiuex6790482.jpg")//|String | 头像|
                .add("sign", sign)//个人签名
                .add("password", password)// 密码
                .build();
        Call<SignUpBean> upLoadAvatarCall = signUpApi.postSignUp(formBody);
        upLoadAvatarCall.enqueue(new Callback<SignUpBean>() {
            @Override
            public void onResponse(Call<SignUpBean> call, Response<SignUpBean> response) {
                Log.e("Test1Activity", "response.body():" + response.body().isResult());
                Log.e("Test1Activity", "response.body():" + response.body().getError_code());
                if (response.body().isResult()) {
                    Toast.makeText(SignupActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.putExtra("phone", phone);
                    intent.putExtra("password", password);
                    intent.setClass(SignupActivity.this, SigninActivity.class);
                    startActivity(intent);
                    new SigninActivity().finish();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<SignUpBean> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "网络连接失败或参数错误", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {
        builder.goneToolbar();
    }

    private void upload(File file) {
        MultipartBody.Part filepart = MultipartBody.Part
                .createFormData("pic", file.getName() + ".jpg",
                        RequestBody.create(MediaType.parse("image/*"), file));
        UploadApi uploadApi = RetrofitManager.getTestRetrofit().create(UploadApi.class);
        Call<UploadBean> upLoadBeanCall = uploadApi.upload(filepart);
        upLoadBeanCall.enqueue(new Callback<UploadBean>() {
            @Override
            public void onResponse(Call<UploadBean> call, Response<UploadBean> response) {
//                Toast.makeText(SignupActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UploadBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(SignupActivity.this, "权限申请成功了", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SignupActivity.this, "用户拒绝了", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void onViewClicked() {
//        requestPermission();
        if (ActivityCompat.checkSelfPermission(SignupActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    SignupActivity.this, Manifest.permission.CAMERA)) {
                Toast.makeText(SignupActivity.this, "我想要申请照相机权限，你要到设置中给我", Toast.LENGTH_SHORT).show();

            } else {
                ActivityCompat.requestPermissions(SignupActivity.this,
                        new String[]{Manifest.permission.CAMERA}, 100);
            }
        }
    }

    @OnClick({R.id.bt_signup, R.id.tx_signin, R.id.iv_signup_avatar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_signup:
                signup();
                break;
            case R.id.tx_signin:
                break;
            case R.id.iv_signup_avatar://点击头像，上传头像的逻辑处
                strings = new String[]{"相册", "相机"};
                //弹出AlerDialog
                new AlertDialog.Builder(this).setItems(strings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent;
                        switch (i) {
                            //相册
                            case 0:
                                intent = new Intent();
                                intent.setType("image/*");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(intent, REQUEST_CAMERA_1);
                                break;
                            // 启动系统相机
                            case 1:
                                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(intent, REQUEST_CAMERA_2);
                                break;
                        }
                    }
                }).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回数据
            if (requestCode == REQUEST_CAMERA_1) {
                doPhoto(requestCode, data);
                return;
            }
            if (requestCode == REQUEST_CAMERA_2) { // 判断请求码是否为REQUEST_CAMERA,如果是代表是这个页面传过去的，需要进行获取
                Bundle bundle = data.getExtras(); // 从data中取出传递回来缩略图的信息，图片质量差，适合传递小图片
                Bitmap bitmap = (Bitmap) bundle.get("data"); // 将data中的信息流解析为Bitmap类型
                ivSignupAvatar.setImageBitmap(bitmap);// 显示图片
                return;
            }
        }
    }

    private String picPath;//获取到的图片路径
    private Intent lastIntent;
    public static final String KEY_PHOTO_PATH = "photo_path";//从Intent获取图片路径的KEY
    private Uri photoUri;

    /**
     * 选择图片后，获取图片的路径
     */
    private void doPhoto(int requestCode, Intent data) {
        if (requestCode == REQUEST_CAMERA_1)  //从相册取图片，有些手机有异常情况，请注意
        {
            if (data == null) {
                Toast.makeText(this, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }
            photoUri = data.getData();
            if (photoUri == null) {
                Toast.makeText(this, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }
        }
        String[] pojo = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(photoUri, pojo, null, null, null);
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(pojo[0]);
            cursor.moveToFirst();
            picPath = cursor.getString(columnIndex);
            cursor.close();
        }
        Log.i("TAG", "imagePath = " + picPath);
        if (picPath != null && (picPath.endsWith(".png") || picPath.endsWith(".PNG") || picPath.endsWith(".jpg") || picPath.endsWith(".JPG"))) {
            lastIntent.putExtra(KEY_PHOTO_PATH, picPath);
            setResult(Activity.RESULT_OK, lastIntent);
            finish();
        } else {
            Toast.makeText(this, "选择图片文件不正确", Toast.LENGTH_LONG).show();
        }
    }
}
