package lczq.refreshview.PullToRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * 能自适应状态栏高度的下拉刷新头部布局。
 * Announcements：
 *
 * @author 王志鸿
 * @corporation Thinkive
 * @date 2017/3/23
 */
public class StatusMatchHeaderLoadingLayout extends HeaderLoadingLayout {

    public StatusMatchHeaderLoadingLayout(Context context) {
        super(context);
    }

    public StatusMatchHeaderLoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    protected void init(Context context) {
//        super.init(context);
////        ViewGroup.LayoutParams params = mHeaderContainer.getLayoutParams();
////        params.height += BaseThinkiveUtil.getStatusBarHeightPx(context);
////        mHeaderContainer.setLayoutParams(params);
//
////        View statusContainerView = new View(context);
////        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
////                ViewGroup.LayoutParams.MATCH_PARENT, BaseThinkiveUtil.getStatusBarHeightPx(context));
////        statusContainerView.setLayoutParams(params);
////        LinearLayout llRootView = (LinearLayout) mContainer;
////        llRootView.addView(statusContainerView, 0);
//    }

    public LinearLayout getContainerView() {
        return (LinearLayout) mContainer;
    }
}
