package lczq.testrefreshview.PullToRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import lczq.testrefreshview.R;
import pl.droidsonroids.gif.GifImageView;


/**
 * 这个类封装了下拉刷新的布局
 *
 * @author Li Hong
 * @since 2013-7-30
 */
public class FooterLoadingLayout extends LoadingLayout {
    /**
     * 进度条
     */
    private GifImageView mProgressBar;
    /**
     * 显示的文本
     */
    private TextView mHintView;

    /**
     * 构造方法
     *
     * @param context context
     */
    public FooterLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    /**
     * 构造方法
     *
     * @param context context
     * @param attrs   attrs
     */
    public FooterLoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context context
     */
    private void init(Context context) {
        mProgressBar = (GifImageView) findViewById(R.id.pull_to_load_footer_progressbar);
        mHintView = (TextView) findViewById(R.id.pull_to_load_footer_hint_textview);

        setState(State.RESET);
    }

    @Override
    protected View createLoadingView(Context context, AttributeSet attrs) {
        View container = LayoutInflater.from(context).inflate(R.layout.pull_to_load_footer_base, null);
        return container;
    }

    @Override
    public void setLastUpdatedLabel(CharSequence label) {
    }

    @Override
    public int getContentSize() {
        View view = findViewById(R.id.pull_to_load_footer_content);
        if (null != view) {
            if (view.getHeight()>0) {
                return view.getHeight();
            }
        }

        return (int) (getResources().getDisplayMetrics().density * 60);
    }
    @Override
    protected void onStateChanged(State curState, State oldState) {
        mProgressBar.setVisibility(View.GONE);
        mHintView.setVisibility(View.INVISIBLE);

        super.onStateChanged(curState, oldState);
    }

    @Override
    protected void onReset() {
        mHintView.setText("正在加载中");
    }

    @Override
    protected void onPullToRefresh() {
        mHintView.setVisibility(View.VISIBLE);
        mHintView.setText("上拉可以加载");
    }

    @Override
    protected void onReleaseToRefresh() {
        mHintView.setVisibility(View.VISIBLE);
        mHintView.setText("松开后加载");
    }

    @Override
    protected void onRefreshing() {
        mProgressBar.setVisibility(View.VISIBLE);
        mHintView.setVisibility(View.VISIBLE);
        mHintView.setText("正在加载下一页");
    }

    @Override
    protected void onNoMoreData() {
        mHintView.setVisibility(View.VISIBLE);
        mHintView.setText("没有更多了");
    }
}
