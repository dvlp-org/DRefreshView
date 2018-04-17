package lczq.testrefreshview.PullToRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.thinkive.android.invest_views.scrolls.InertiaWithRecyclerViewScrollView;


/**
 * {@link InertiaWithRecyclerViewScrollView}解决了ScrollView嵌套RecyclerView时，滑动RecyclerView没反应的问题
 * 
 * @author Li Hong
 * @since 2013-8-22
 */
public class TKPullToRefreshScrollView extends PullToRefreshBase<InertiaWithRecyclerViewScrollView> {

    private Context mContext;

    /**
     * 构造方法
     *
     * @param context context
     */
    public TKPullToRefreshScrollView(Context context) {
        super(context);
    }

    /**
     * 构造方法
     *
     * @param context context
     * @param attrs attrs
     */
    public TKPullToRefreshScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 构造方法
     *
     * @param context context
     * @param attrs attrs
     * @param defStyle defStyle
     */
    public TKPullToRefreshScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    void init(Context context, AttributeSet attrs) {
        super.init(context, attrs);
        mContext = context;
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

    /**
     * 创建Header的布局
     *
     * @param context context
     * @param attrs 属性
     * @return LoadingLayout对象
     */
    @Override
    protected LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attrs) {
        return new StatusMatchHeaderLoadingLayout(context);
    }



    /**
     * 设置头部填充布局
     * @param headHeightPx 头部填充布局高度
     */
    public void setContainerViewToHead(int headHeightPx) {
        View statusContainerView = new View(mContext);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, headHeightPx);
        statusContainerView.setLayoutParams(params);
        setContainerViewToHead(statusContainerView);

    }

    /**
     * 设置头部填充布局
     * @param headView 头部填充布局对象
     */
    public void setContainerViewToHead(View headView) {
        LinearLayout llRootView = ((StatusMatchHeaderLoadingLayout) getHeaderLoadingLayout()).getContainerView();
        llRootView.addView(headView, 0);
    }
}
