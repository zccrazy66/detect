package cn.wmyskxz.springboot.utils.constants;

/**
 * @description: 通用常量类, 单个业务的常量请单开一个类, 方便常量的分类管理
 */
public class Constants {

    public static final Integer SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "请求成功";

    /**
     * session中存放用户信息的key值
     */
    public static final String SESSION_USER_INFO = "userInfo";
    public static final String SESSION_USER_PERMISSION = "userPermission";
}
