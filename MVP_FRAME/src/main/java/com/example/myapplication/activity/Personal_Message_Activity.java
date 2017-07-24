package com.example.myapplication.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.zhy.android.percent.support.PercentLinearLayout;
import com.zhy.android.percent.support.PercentRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Personal_Message_Activity extends BaseActivity {

    private static final int IMAGE = 1;
    @BindView(R.id.information_back)
    ImageView informationBack;
    @BindView(R.id.information_head)
    ImageView informationHead;
    @BindView(R.id.ima)
    ImageView ima;
    @BindView(R.id.head)
    PercentRelativeLayout head;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.name_ima)
    ImageView nameIma;
    @BindView(R.id.information_name)
    PercentRelativeLayout informationName;
    @BindView(R.id.tuic_dengl)
    Button tuicDengl;
    @BindView(R.id.aa)
    PercentLinearLayout aa;
    private PopupWindow pop;
    private String name;
    private Uri photoUri;//自动获取照片uri
    private String picPath;//图片路径


    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_personal__message_;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        name = intent.getStringExtra("name");
        userName.setText(name);
        Glide.with(this).load(image).transform(new GlideCircleTransform(this)).into(informationHead);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.information_back, R.id.head, R.id.information_name, R.id.tuic_dengl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.information_back:
                finish();
                break;
            case R.id.head:
                popWindow();
                break;
            case R.id.information_name:
                Intent intent = new Intent(Personal_Message_Activity.this, UpData_Name_Activity.class);
                intent.putExtra("name", name);
                startActivity(intent);
                break;
            case R.id.tuic_dengl:
                SharedPreferences shape = getSharedPreferences("panda", MODE_PRIVATE);
                SharedPreferences.Editor editor = shape.edit();
                editor.putString("errMsg", "");
                editor.commit();

                Intent intent1 = new Intent(Personal_Message_Activity.this, Personal_center_Activity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }

    private void popWindow() {
        pop = new PopupWindow();
        View inflate = this.getLayoutInflater().inflate(R.layout.pop, null);
        pop.setContentView(inflate);
        Button xuanze = (Button) inflate.findViewById(R.id.xuanze);
        Button quxiao = (Button) inflate.findViewById(R.id.quxiao);
        Button paiyizhang = (Button) inflate.findViewById(R.id.paiyizhang);
        //设置PopupWindow弹出窗体的宽
        pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(null);
        pop.showAtLocation(Personal_Message_Activity.this.findViewById(R.id.aa), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        //设置popupWindow弹出后父布局的背景
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.6f;
        getWindow().setAttributes(params);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 1.0f;
                getWindow().setAttributes(params);
            }
        });
        paiyizhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String SDState = Environment.getExternalStorageState();
                    if (SDState.equals(Environment.MEDIA_MOUNTED))//如果有媒体安装的环境
                    {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//传拍的照
                        /***
                         * 需要说明一下，以下操作使用+拍照，拍照后的图片会存放在相册中的
                         * 这里使用的这种方式有一个好处就是获取的图片是拍照后的原图
                         * 如果不使用ContentValues存放照片路径的话，拍照后获取的图片为缩略图不清晰
                         */
                        ContentValues values = new ContentValues();//contentProvider存储？
                        photoUri = Personal_Message_Activity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);//自动获得uri
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        /**-----------------*/
                        startActivityForResult(intent, 1);//跳到拍照页面，这里1没用到，可以在一个onActivityResult里设置requestCode为0来接收新页面的数据。
                    } else {
                        Toast.makeText(Personal_Message_Activity.this, "内存卡不存在", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        xuanze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE);
            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent1 = new Intent(Personal_Message_Activity.this, Personal_center_Activity.class);
        startActivity(intent1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }
        if (resultCode == Activity.RESULT_OK && requestCode == 1)//&&的后面可有可无，因为只有一个返回结果，若多个就可用switch case判断一下。
        {
            String[] pojo = {MediaStore.Images.Media.DATA};
            Cursor cursor = managedQuery(photoUri, pojo, null, null, null);//Uri 和 图片数据   得到  picPath
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndexOrThrow(pojo[0]);
                cursor.moveToFirst();
                picPath = cursor.getString(columnIndex);
                cursor.close();
            }
    /*if(picPath != null && ( picPath.endsWith(".png") || picPath.endsWith(".PNG") ||picPath.endsWith(".jpg") ||picPath.endsWith(".JPG")  ))*/
            if (picPath != null) {
                Intent lastIntent = getIntent();//上面putExtra 这里getIntent
                lastIntent.putExtra("photo_path", picPath);//这是新页面，，再传送路径  返送回去EmployeeAttendanceActivity
                setResult(Activity.RESULT_OK, lastIntent);
                finish();
            } else {
                Toast.makeText(Personal_Message_Activity.this, "选择文件不正确!", Toast.LENGTH_LONG).show();
            }
        }
        onActivityResult(requestCode, resultCode, data);
    }

    private void showImage(String imaePath) {
        SharedPreferences shape = getSharedPreferences("panda", MODE_PRIVATE);
        SharedPreferences.Editor editor = shape.edit();
        editor.putString("iii", imaePath);
        editor.commit();
        pop.dismiss();
        Glide.with(this).load(imaePath).transform(new GlideCircleTransform(this)).into(informationHead);

    }

}
