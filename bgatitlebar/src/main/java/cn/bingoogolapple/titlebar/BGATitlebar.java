package cn.bingoogolapple.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.zhy.android.percent.support.PercentRelativeLayout;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/4 下午4:51
 * 描述:
 */
public class BGATitlebar extends PercentRelativeLayout implements View.OnClickListener {
    private AppCompatCheckedTextView mTitleCtv;
    private AppCompatButton mLeftBtn;
    private AppCompatButton mRightBtn;
    private BGATitlebarDelegate mDelegate;

    public BGATitlebar(Context context) {
        this(context, null);
    }

    public BGATitlebar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BGATitlebar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_bgatitlebar, this);
        initView();
        setListener();
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BGATitlebar);
        final int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            initAttr(typedArray.getIndex(i), typedArray);
        }
        typedArray.recycle();
    }

    protected void initView() {
        mLeftBtn = getViewById(R.id.btn_bgatitlebar_left);
        mRightBtn = getViewById(R.id.btn_bgatitlebar_right);
        mTitleCtv = getViewById(R.id.ctv_bgatitlebar_title);
    }

    protected void setListener() {
        mLeftBtn.setOnClickListener(this);
        mTitleCtv.setOnClickListener(this);
        mRightBtn.setOnClickListener(this);
    }

    protected void initAttr(int attr, TypedArray typedArray) {
        if (attr == R.styleable.BGATitlebar_bgatitlebar_leftText) {
            setLeftText(typedArray.getText(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleText) {
            setTitleText(typedArray.getText(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_rightText) {
            setRightText(typedArray.getText(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_leftIcon) {
            setLeftIcon(typedArray.getDrawable(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleIcon) {
            setTitleIcon(typedArray.getDrawable(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_rightIcon) {
            setRightIcon(typedArray.getDrawable(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_leftTextSize) {
            mLeftBtn.setTextSize(typedArray.getDimensionPixelOffset(attr, sp2px(getContext(), 12)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_rightTextSize) {
            mRightBtn.setTextSize(typedArray.getDimensionPixelOffset(attr, sp2px(getContext(), 12)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleTextSize) {
            mTitleCtv.setTextSize(typedArray.getDimensionPixelOffset(attr, sp2px(getContext(), 16)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_leftTextColor) {
            mLeftBtn.setTextColor(typedArray.getColorStateList(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_rightTextColor) {
            mRightBtn.setTextColor(typedArray.getColorStateList(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleTextColor) {
            mTitleCtv.setTextColor(typedArray.getColorStateList(attr));
        }
    }

    public void hiddenLeftBtn() {
        mLeftBtn.setVisibility(GONE);
    }

    public void showLeftBtn() {
        mLeftBtn.setVisibility(VISIBLE);
    }

    public void setLeftText(@StringRes int resid) {
        setLeftText(getResources().getString(resid));
    }

    public void setLeftText(CharSequence text) {
        mLeftBtn.setText(text);
        showLeftBtn();
    }

    public void setLeftIcon(Drawable drawable) {
        Drawable[] drawables = mLeftBtn.getCompoundDrawables();
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        mLeftBtn.setCompoundDrawables(drawable, drawables[1], drawables[2], drawables[3]);
        showLeftBtn();
    }

    public void hiddenTitleCtv() {
        mTitleCtv.setVisibility(GONE);
    }

    public void showTitleCtv() {
        mTitleCtv.setVisibility(VISIBLE);
    }

    public void setTitleText(CharSequence text) {
        mTitleCtv.setText(text);
        showTitleCtv();
    }

    public void setTitleText(@StringRes int resid) {
        setTitleText(getResources().getString(resid));
    }

    public void setTitleIcon(Drawable drawable) {
        Drawable[] drawables = mTitleCtv.getCompoundDrawables();
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        mTitleCtv.setCompoundDrawables(drawables[0], drawables[1], drawable, drawables[3]);
        showTitleCtv();
    }

    public void hiddenRightBtn() {
        mRightBtn.setVisibility(GONE);
    }

    public void showRightBtn() {
        mRightBtn.setVisibility(VISIBLE);
    }

    public void setRightText(CharSequence text) {
        mRightBtn.setText(text);
        showRightBtn();
    }

    public void setRightText(@StringRes int resid) {
        setRightText(getResources().getString(resid));
    }

    public void setRightIcon(Drawable drawable) {
        Drawable[] drawables = mRightBtn.getCompoundDrawables();
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        mRightBtn.setCompoundDrawables(drawables[0], drawables[1], drawable, drawables[3]);
        showRightBtn();
    }

    public void setTitleCtvChecked(boolean checked) {
        mTitleCtv.setChecked(checked);
    }

    public AppCompatButton getLeftBtn() {
        return mLeftBtn;
    }

    public AppCompatButton getRightBtn() {
        return mRightBtn;
    }

    public AppCompatCheckedTextView getTitleCtv() {
        return mTitleCtv;
    }

    @Override
    public void onClick(View v) {
        if (mDelegate != null) {
            int id = v.getId();
            if (id == R.id.btn_bgatitlebar_left) {
                mDelegate.onClickLeftBtn();
            } else if (id == R.id.ctv_bgatitlebar_title) {
                mDelegate.onClickTitleBtn();
            } else if (id == R.id.btn_bgatitlebar_right) {
                mDelegate.onClickRightBtn();
            }
        }
    }

    public void setDelegate(BGATitlebarDelegate delegate) {
        mDelegate = delegate;
    }

    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) findViewById(id);
    }

    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context.getResources().getDisplayMetrics());
    }

    public static class BGATitlebarDelegate {
        public void onClickLeftBtn() {
        }

        public void onClickTitleBtn() {
        }

        public void onClickRightBtn() {
        }
    }

}