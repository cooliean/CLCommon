package com.cooliean.common.core.utils;


/**
 * Created by Cooliean on 15/7/29.
 * SomeRemark
 *
 */
public class ThemesUtils {
//    /**
//     * 设置状态栏、导航栏为主题颜色
//     *  5.0（api>=21）以上
//     * R.attr.theme_color
//     * @param activity
//     */
//    public static void setStatusBarThemeColor(Activity activity) {
//        setStatusBar(activity,Color.parseColor("#20000000"),resolveColor(activity, R.attr.theme_color, Color.TRANSPARENT));
//    }
//
//    /**
//     * 设置状态栏、导航栏透明
//     *  5.0（api>=21）以上
//     * @param activity
//     */
//    public static void setStatusBarTransparent(Activity activity) {
//        setStatusBar(activity,Color.parseColor("#00000000"),activity.getResources().getColor(R.color.transparent));
//    }
//
//
//
//    /**
//     * 根据传入的颜色设置状态栏、导航栏颜色
//     * 5.0（api>=21）以上
//     * @param activity
//     * @param statusBarColor
//     * @param navigationBarColor
//     */
//    public static void setStatusBar(Activity activity,int statusBarColor,int navigationBarColor) {
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            activity.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//            Window window = activity.getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//            );
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(statusBarColor);
//            window.setNavigationBarColor(navigationBarColor);
//        }
//    }
//
//    /**
//     * 根据属性获取对应的内容
//     * @param context
//     * @param attr
//     * @param fallback
//     * @return
//     */
//    public static int resolveColor(Context context, @AttrRes int attr, int fallback) {
//        TypedArray a = context.getTheme().obtainStyledAttributes(new int[]{attr});
//        try {
//            return a.getColor(0, fallback);
//        } finally {
//            a.recycle();
//        }
//    }

}
