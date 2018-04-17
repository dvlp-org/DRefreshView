package lczq.testrefreshview.PullToRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.thinkive.android.invest_views.scrolls.InertiaWithRecyclerViewScrollView;


/**
 * 封装了NestScrollView的下拉刷新
 * 
 * @author Li Hong
 * @since 2013-8-22
 */
public class PullToRefreshInertiaWithRecyclerScrollView extends PullToRefreshBase<InertiaWithRecyclerViewScrollView> {
    /**
     * 构造方法
     *
     * @param context context
     */
    public PullToRefreshInertiaWithRecyclerScrollView(Context context) {
        super(context);
    }

    /**
     * 构造方法
     *
     * @param context context
     * @param attrs attrs
     */
    public PullToRefreshInertiaWithRecyclerScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 构造方法
     *
     * @param context context
     * @param attrs attrs
     * @param defStyle defStyle
     */
    public PullToRefreshInertiaWithRecyclerScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     */
    @Override
    protected InertiaWithRecyclerViewScrollView createRefreshableView(Context context, AttributeSet attrs) {
        return new InertiaWithRecyclerViewScrollView(context);
    }

    /**
     *
     */
    @Override
    protected boolean isReadyForPullDown() {
        return mRefreshableView.getScrollY() == 0;
    }

    /**
     */
    @Override
    protected boolean isReadyForPullUp() {
        View scrollViewChild = mRefreshableView.getChildAt(0);
        if (null != scrollViewChild) {
            return mRefreshableView.getScrollY() >= (scrollViewChild.getHeight() - getHeight());
        }
        return false;
    }
}
