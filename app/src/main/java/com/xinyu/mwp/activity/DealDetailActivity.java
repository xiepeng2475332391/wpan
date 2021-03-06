package com.xinyu.mwp.activity;

import android.os.Handler;
import android.view.View;

import com.xinyu.mwp.R;
import com.xinyu.mwp.activity.base.BaseControllerActivity;
import com.xinyu.mwp.view.CellView;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by Benjamin on 17/1/12.
 */

public class DealDetailActivity extends BaseControllerActivity {
    @ViewInject(R.id.rootLayout)
    private View rootLayout;
    @ViewInject(R.id.dealType)
    private CellView dealType;
    @ViewInject(R.id.dealKinds)
    private CellView dealKinds;
    @ViewInject(R.id.dealTime)
    private CellView dealTime;
    @ViewInject(R.id.dealMoney)
    private CellView dealMoney;
    @ViewInject(R.id.dealSafe)
    private CellView dealSafe;
    @ViewInject(R.id.dealCounter)
    private CellView dealCounter;

    @Override
    protected int getContentView() {
        return R.layout.activity_dealdetail;
    }

    @Override
    protected void initView() {
        super.initView();
        setTitle("交易详情");
    }

    @Override
    protected void initData() {
        super.initData();
        showLoader();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dealType.updateContent("买涨");
                dealKinds.updateContent("白银");
                dealTime.updateContent("16-16-16 16:16");
                dealMoney.updateContent("19999.00");
                dealSafe.updateContent("19999.00");
                dealCounter.updateContent("0.99%");
                rootLayout.setVisibility(View.VISIBLE);
                closeLoader();
            }
        }, 2000);
    }
}
