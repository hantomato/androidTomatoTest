package com.nmj.att.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nmj.att.R;
import com.nmj.att.util.Logger;

/**
 * Created by nmj on 15. 7. 7..
 */
public class CustomDialogFragment extends DialogFragment {
    private static final String HEADER = "HEADER";
    private static final String CONTENT = "CONTENT";
    private static final String SUB_CONTENT = "SUB_CONTENT";
    private static final String SHOW_CANCEL = "SHOW_CANCEL";
    private static final String CANCELABLE = "CANCELABLE";
    private static final String BTN_TEXT_OK = "BTN_TEXT_OK";
    private static final String BTN_TEXT_CANCEL = "BTN_TEXT_CANCEL";

    public interface ButtonClickListener {
        public void OnClick(DialogFragment fragment, int btnId);
    }

    String mHeader;
    String mContent;
    String mSubContent;
    boolean mShowCancel;
    boolean mCancelable;
    String mBtnTextOk;
    String mBtnTextCancel;

    static CustomDialogFragment newInstance(String header, String content, String subContent) {
        CustomDialogFragment f = new CustomDialogFragment();

        Bundle args = new Bundle();
        args.putString(HEADER, header);
        args.putString(CONTENT, content);
        args.putString(SUB_CONTENT, subContent);
        args.putBoolean(SHOW_CANCEL, false);
        args.putBoolean(CANCELABLE, true);
        args.putString(BTN_TEXT_OK, "ok");
        args.putString(BTN_TEXT_CANCEL, "cancel");
        f.setArguments(args);
        return f;
    }

    static CustomDialogFragment newInstance(String header, String content, String subContent, boolean showCancelBtn, boolean cancelable) {
        CustomDialogFragment f = newInstance(header, content, subContent);
        Bundle args = f.getArguments();
        args.putBoolean(SHOW_CANCEL, showCancelBtn);
        args.putBoolean(CANCELABLE, cancelable);
        f.setArguments(args);
        return f;
    }

    static CustomDialogFragment newInstance(String header, String content, String subContent, boolean showCancelBtn, boolean cancelable, String okBtnText, String cancelBtnText) {
        CustomDialogFragment f = newInstance(header, content, subContent, showCancelBtn, cancelable);
        Bundle args = f.getArguments();
        args.putString(BTN_TEXT_OK, okBtnText);
        args.putString(BTN_TEXT_CANCEL, cancelBtnText);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHeader = getArguments().getString(HEADER);
        mContent = getArguments().getString(CONTENT);
        mSubContent = getArguments().getString(SUB_CONTENT);
        mShowCancel = getArguments().getBoolean(SHOW_CANCEL);
        mCancelable = getArguments().getBoolean(CANCELABLE);
        mBtnTextOk = getArguments().getString(BTN_TEXT_OK);
        mBtnTextCancel = getArguments().getString(BTN_TEXT_CANCEL);

        setStyle(DialogFragment.STYLE_NO_TITLE, 0);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View box = inflater.inflate(R.layout.dialog_messagebox, container, false);

        if (!TextUtils.isEmpty(mHeader)) {
            setText(box, R.id.tv_header, mHeader);
        }
        if (!TextUtils.isEmpty(mContent)) {
            setText(box, R.id.tv_content, mContent);
        }
        if (!TextUtils.isEmpty(mSubContent)) {
            setText(box, R.id.tv_sub_content, mSubContent);
        }


        setCancelable(mCancelable);

        Button btnCancel = (Button)box.findViewById(R.id.btn_cancel);
        btnCancel.setVisibility(mShowCancel ? View.VISIBLE : View.GONE);

        Button btnOk = (Button)box.findViewById(R.id.btn_ok);
        btnOk.setText(mBtnTextOk);
        btnOk.setOnClickListener(v -> {
            close(R.id.btn_ok);
        });

        btnCancel.setText(mBtnTextCancel);
        btnCancel.setOnClickListener(v -> {
            close(R.id.btn_cancel);
        });

        return box;
    }

    private void setText(View container, int textViewId, String text) {
        TextView tv = (TextView)container.findViewById(textViewId);
        tv.setVisibility(View.VISIBLE);
        tv.setText(text);
    }

    private void close(int btnId) {
        FragmentActivity fragment = getActivity();
        if (fragment instanceof ButtonClickListener) {
            ((ButtonClickListener)fragment).OnClick(this, btnId);
        } else {
            Logger.log("상속 안함.");
            dismiss();
        }
    }


}