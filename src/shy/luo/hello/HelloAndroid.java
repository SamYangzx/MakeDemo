package shy.luo.hello;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.android.settings.password.ChooseLockGeneric;
import com.android.settings.password.ChooseLockSettingsHelper;

import shy.luo.hello.R;


public class HelloAndroid extends Activity {
    private final static String LOG_TAG = "fenghe";
    private static final int CHOOSE_LOCK_GENERIC_REQUEST = 227;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.i(LOG_TAG, "HelloAndroid Activity Created.");
        initView();
    }

    private void initView() {
        Button testBtn = (Button) findViewById(R.id.test);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "testBtn is clicked.");
                testAlertDialog();
//                Intent intent = new Intent();
////                intent.setClassName("com.android.settings", "com.android.settings.password.ChooseLockGeneric");
//                intent.setClassName("com.android.settings", "com.android.settings.PasswordManagerActivity");
////                intent.putExtra(ChooseLockGeneric.ChooseLockGenericFragment.MINIMUM_QUALITY_KEY,
////                        DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
////                intent.putExtra(ChooseLockGeneric.ChooseLockGenericFragment.HIDE_DISABLED_PREFS, true);
//                intent.putExtra("has_challenge", true);
//                intent.putExtra("challenge", 0);
//                intent.putExtra("for_fingerprint", true);
//                intent.putExtra("for_lock_security", true);
//                startActivityForResult(intent, CHOOSE_LOCK_GENERIC_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHOOSE_LOCK_GENERIC_REQUEST && resultCode != Activity.RESULT_CANCELED) {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.ChooseLockGeneric");
            startActivity(intent);
        }
    }

    private void testAlertDialog() {
        final String items[] = {"男", "未知", "女"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle(R.string.test);                                     //设置标题
//        builder.setIcon(R.mipmap.ic_launcher);                      //设置图标，图片id即可

        //设置单选按钮
        //  items   为列表项
        //  0       为默认选中第一个
        //  第三个参数是监听器
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
                Toast.makeText(HelloAndroid.this, items[which], Toast.LENGTH_SHORT).show();
            }
        });

        //  设置监听器
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(HelloAndroid.this, R.string.yes, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();

    }

}
