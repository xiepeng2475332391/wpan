package com.xinyu.mwp.activity;

import android.os.Handler;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;

import com.xinyu.mwp.R;
import com.xinyu.mwp.activity.base.BaseControllerActivity;
import com.xinyu.mwp.exception.CheckException;
import com.xinyu.mwp.helper.CheckHelper;
import com.xinyu.mwp.util.ActivityUtil;
import com.xinyu.mwp.util.Utils;
import com.xinyu.mwp.view.WPEditText;

import org.xutils.view.annotation.ViewInject;

/**
 * @author : created by chuangWu
 * @version : 0.01
 * @email : chuangwu127@gmail.com
 * @created time : 2017-01-11 11:30
 * @description : none
 * @for your attention : none
 * @revise : none
 */
public class RegisterActivity extends BaseControllerActivity {


    @ViewInject(R.id.phoneEditText)
    private WPEditText phoneEditText;
    @ViewInject(R.id.msgEditText)
    private WPEditText msgEditText;
    @ViewInject(R.id.soundEditText)
    private WPEditText soundEditText;
    @ViewInject(R.id.pwdEditText)
    private WPEditText pwdEditText;
    @ViewInject(R.id.nextButton)
    private Button nextButton;
    private CheckHelper checkHelper = new CheckHelper();

    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        super.initView();
        setTitle("注册");
        phoneEditText.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        checkHelper.checkButtonState(nextButton, phoneEditText, msgEditText, soundEditText, pwdEditText);
        checkHelper.checkVerificationCode(msgEditText.getRightText(), phoneEditText);
        checkHelper.checkVerificationCode(soundEditText.getRightText(), phoneEditText);
    }

    @Override
    protected void initListener() {
        super.initListener();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckException exception = new CheckException();
                if (checkHelper.checkMobile(phoneEditText.getEditTextString(), exception)
                        && checkHelper.checkPassword(pwdEditText.getEditTextString(), exception)) {
                    Utils.closeSoftKeyboard(v);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ActivityUtil.nextResetDealPwd(context);
                        }
                    }, 100);
                } else {
                    showToast(exception.getErrorMsg());
                }
            }
        });
    }
}
