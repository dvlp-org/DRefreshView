package lczq.testrefreshview.PullToRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * 封装了ScrollView的下拉刷新
 * 
 * @author Li Hong
 * @since 2013-8-22
 */
public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView> {
    /**
     * 构造方法
     * 
     * @param context context
     */
    public PullToRefreshScrollView(Context context) {
        super(context);
    }
    
    /**
     * 构造方法
     * 
     * @param context context
     * @param attrs attrs
     */
    public PullToRefreshScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    /**
     * 构造方法
     * 
     * @param context context
     * @param attrs attrs
     * @param defStyle defStyle
     */
    public PullToRefreshScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     */
    @Override
    protected ScrollView createRefreshableView(Context context, AttributeSet attrs) {
        ScrollView scrollView = new ScrollView(context);
        return scrollView;
    }

    /**
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
