package dingw.com.newversion.base;

/**
 * Created by 12348 on 2017/5/3 0003.
 * 基本功能接口
 */

public interface BaseFunc {
    /**初始化布局加载*/
    void initContentView();
    /**初始化数据方法 */
    void initData();

    /**初始化UI控件方法 */
    void initView();

    /** 初始化事件监听方法 */
    void initListener();

    /** 初始化界面加载方法 */
    void initLoad();
}
