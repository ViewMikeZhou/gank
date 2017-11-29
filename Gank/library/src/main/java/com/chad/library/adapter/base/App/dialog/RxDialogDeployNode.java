package com.chad.library.adapter.base.App.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.chad.library.R;


/**
 * Created by vondear on 2016/7/19.
 * Mainly used for confirmation and cancel.
 */
public class RxDialogDeployNode extends RxDialog {

    private Context context;
    private boolean isShowOneEt;
    private TextView mTvSure;
    private TextView mTvCancel;
    private TextView mTvContent;
    private EditText etIp;
    private TextView mTvTitle;
    private EditText mEtPort;
   // private List<NodeScheme> mNodeSchemes;
    private Spinner mSpNodeMode;
    private EditText mEtPosition;
    private EditText mDeployIp;
    private EditText mDeployPort;

    public void setTitle(String title) {
        mTvTitle.setText(title);
    }

    public TextView getTvTitle() {
        return mTvTitle;
    }

    public String getID() {
        return etIp.getText().toString().trim().toUpperCase();
    }

    public String getPosition() {
        return mEtPosition.getText().toString().trim();
    }

    public int getDeployPort() {
        String p = mDeployPort.getText().toString().trim();
        if (p == null || p.length() == 0) {
            return 0;
        }
        return Integer.parseInt(p);
    }

    public String getDeloyIp() {
        return mDeployIp.getText().toString().trim();
    }

    //清空基站和节点
    public void setClear() {
        etIp.setText("");
        mEtPosition.setText("");
    }

    public TextView getTvContent() {
        return mTvContent;
    }

    public void setContent(String content) {
        this.mTvContent.setText(content);
    }

    public TextView getTvSure() {
        return mTvSure;
    }

    public void setSure(String strSure) {
        this.mTvSure.setText(strSure);
    }


    public TextView getTvCancel() {
        return mTvCancel;
    }


    public void setCancel(String strCancel) {
        this.mTvCancel.setText(strCancel);
    }

    private void initView() {
        View dialog_view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_node, null);
        mTvTitle = (TextView) dialog_view.findViewById(R.id.tv_logo);
        mTvSure = (TextView) dialog_view.findViewById(R.id.tv_sure);
        mTvCancel = (TextView) dialog_view.findViewById(R.id.tv_cancle);
        etIp = (EditText) dialog_view.findViewById(R.id.et_ip);
        mDeployIp = (EditText) dialog_view.findViewById(R.id.deploy_ip);
        mDeployPort = (EditText) dialog_view.findViewById(R.id.deploy_port);
        mEtPosition = (EditText) dialog_view.findViewById(R.id.et_position);
        //mTvContent = (TextView) dialog_view.findViewById(R.id.tv_title);
        mSpNodeMode = (Spinner) dialog_view.findViewById(R.id.sp_node_mode);
        setContentView(dialog_view);

    }

    private void initNodeScheme() {
    /*    mNodeSchemes = DaoUtil.getInstance().queryAllNodeScheme();
        String[] nodeMode = new String[mNodeSchemes.size()];
        for (int i = 0; i < mNodeSchemes.size(); i++) {
            nodeMode[i] = mNodeSchemes.get(i).getTitle();
        }
        ArrayAdapter adapter = new ArrayAdapter(context,
                android.R.layout.simple_spinner_dropdown_item, nodeMode);
        mSpNodeMode.setAdapter(adapter);*/
    }


    private void init() {

    }

    public RxDialogDeployNode(Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    public RxDialogDeployNode(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView();
    }

    public RxDialogDeployNode(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public RxDialogDeployNode(Activity context, boolean isShowOneEt) {
        super(context);
        this.isShowOneEt = isShowOneEt;
        initView();
    }

    public RxDialogDeployNode(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView();
    }

    @Override
    public void show() {
      //  initNodeScheme();
        super.show();
    }
}
