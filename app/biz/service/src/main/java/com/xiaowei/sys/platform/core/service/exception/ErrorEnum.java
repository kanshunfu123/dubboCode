package com.xiaowei.sys.platform.core.service.exception;

/**
 * 错误码
 *
 * @author jim
 * @date 16/10/12
 */
public enum ErrorEnum {
    /**
     * 错误码分内外两种
     * 对内使用最细粒度错误吗，对外使用统一错误码
     * 对外统一使用本类型第一个错误码。
     */
    //1开头为对外不可以接收细节错误码
    ERROR_DEFAULT(10000, 10000, "系统异常"),
    ERROR_DEPT_NAME_EXIST_FAIL(10000, 15001, "组织架构名称已存在"),
    ERROR_USER_LOGIN_FAIL(10000, 15002, "登录信息异常"),
    ERROR_USER_INFO_LIST_FAIL(10000, 15003, "查询用户信息列表异常"),
    ERROR_DEPT_TREE_FAIL(10000, 15004, "查询组织架构树信息异常"),
    ERROR_ADD_DEPT_FAIL(10000, 15005, "新增组织架构信息异常"),
    ERROR_EDIT_DEPT_FAIL(10000, 15006, "编辑组织架构信息异常"),
    ERROR_ADD_DEPT_CODE_NAME_FAIL(10000, 15007, "新增组织架构时，参数值重复。推荐使用>="),
    ERROR_DELL_DEPT_FAIL(10000, 15008, "删除组织架构信息异常"),
    ERROR_UPDATE_USER_FAIL(10000, 15009, "编辑用户信息异常"),
    ERROR_UPDATE_AREA_FAIL(10000, 15010, "编辑区域信息异常"),
    ERROR_DELL_USER_FAIL(10000, 15011, "删除用户信息异常"),
    ERROR_INSERT_USER_FAIL(10000, 15012, "新增用户信息异常"),
    ERROR_UPDATE_DEPT_NO_EXIST_FAIL(10000, 15013, "待更新的组织架构不存在"),
    ERROR_UPDATE_AREA_NO_EXIST_FAIL(10000, 15014, "待更新的区域不存在"),
    ERROR_DEL_DEPT_NO_EXIST_FAIL(10000, 15015, "待删除的组织架构不存在，您无法删除"),
    ERROR_DEL_AREA_NO_EXIST_FAIL(10000, 15016, "待删除区域不存在，您无法删除"),
    ERROR_DEL_AREA_EXIST_CHILD_DEPT_FAIL(10000, 15017, "该区域下还有用户,您无法删除"),
    ERROR_DEL_DEPT_EXIST_USER_FAIL(10000, 15018, "该组织架构下还有员工，您无法删除"),
    ERROR_DEL_DEPT_EXIST_CHILD_DEPT_FAIL(10000, 15019, "该组织架构下还有子部门,您无法删除"),
    ERROR_LOGIN_USER_ERROR_FAIL(10000, 15020, "用户名或者密码错误"),
    ERROR_LOGIN_USER_DELETED_FAIL(10000, 15021, "您的账户已被删除"),
    ERROR_USER_EMAIL_EXIST(10000,15022,"邮箱已存在"),
    ERROR_USER_PHONE_EXIST(10000,15023,"手机号已存在"),
    ERROR_ADD_USER_DEPT_NOT_EXIST_EXIST(10000,15024,"新增用户时,所属组织架构信息不存在"),
    ERROR_ADD_USER_AREA_NOT_EXIST_EXIST(10000,15025,"新增用户时,所属区域信息不存在"),
    ERROR_USER_INFO_BY_UUID_NOT_EXIST(10000,15026,"待查看的用户不存在"),
    ERROR_LOOK_USER_INFO_FAIL(10000,15027,"待查看的用户信息异常"),
    ERROR_LOOK_DEPT_NOT_EXIST_INFO_FAIL(10000,15028,"待查看的组织架构信息异常"),
    ERROR_DEL_USER_ROLE_HAS_EXITS_FAIL(1000,15029,"该角色在角色用户关系中已存在,您无法删除"),
    ERROR_DEL_ROLE_ACL_HAS_EXITS_FAIL(1000,15030,"该角色在角色权限表中已存在，您无法删除"),
    ERROR_ADD_ROLE_PASS_FAIL(1000,15031,"添加角色时，权限数据传参不正确"),
    ERROR_ADD_ROLE_IS_EXIT(1000,15032,"该角色名称已存在，您无法重复添加"),
    ERROR_EDIT_ROLE_IS_EXIT(1000,15033,"该角色名称已存在，您无法修改"),
    ERROR_SAVE_WATER_STANDARD_IS_EXIT(1000,15034,"该水质名称已存在,您无法重复添加"),
    ERROR_FIND_WATER_STANDARD_IS_EXIT(1000,15035,"该水质标准已存在,您无法删除"),
    ERROR_USER_INFO_NOT_EXIST_FAIL(10000,15036,"待更新的用户不存在"),
    ERROR_AREA_TREE_FAIL(10000,15037,"获取区域树异常"),
    ERROR_ROLE_LIST_FAIL(10000,15038,"获取角色列表异常"),
    ERROR_ROLE_ACL_TREE_FAIL(10000,15039,"获取该角色的权限树异常"),
    ERROR_ROLE_ACL_MENU_TREE_FAIL(10000,15040,"获取该角色的权限菜单异常"),
    ERROR_ROLE_NOT_EXIST_FAIL(10000,15041,"待编辑的角色不存在"),
    ERROR_WATING_PERMISSION_ACL_FAIL(10000,15042,"获取待授权列表异常"),
    ERROR_USER_ACL_FAIL(10000,15043,"获取动态权限菜单异常"),
    ERROR_ADD_AREA_TREE_FAIL(10000,15044,"新增区域树异常"),
    ERROR_EDIT_AREA_TREE_FAIL(10000,15045,"编辑区域树异常"),
    ERROR_DEL_AREA_TREE_FAIL(10000,15046,"删除区域树异常"),
    ERROR_AREA_NAME_EXIST_FAIL(10000, 15047, "存在相同名称的区域"),
    ERROR_DICTIONARY_NAME_EXIST_FAIL(10000, 15048, "同一层级下存在相同名称的字典"),
    ERROR_DICTIONARY_TREE_FAIL(10000, 15049, "查询字典架构树信息异常"),
    ERROR_ADD_DICTIONARY_FAIL(10000, 15050, "新增字典架构信息异常"),
    ERROR_ADD_DICTIONARY_CODE_NAME_FAIL(10000,15051,"新增字典字段值重复"),
    ERROR_ADD_AREA_CODE_NAME_FAIL(10000,15052,"新增区域参数值重复"),
    ERROR_ADD_AREA_PARENT_ID_NAME_FAIL(10000,15053,"新增区域父级id不能为空"),
    ERROR_EDIT_AREA_PARENT_ID_NAME_FAIL(10000,15054,"编辑区域父级id不能为空"),
    ERROR_ADD_PARAMETER_VALUE(10000,15055,"新增参数参数值重复"),
    ERROR_EDIT_PARAMETER_VALUE(10000,15056,"编辑参数参数值重复"),
    ERROR_ADD_PARAMETER_NAME(10000,15057,"新增参数参数名称重复"),
    ERROR_ADD_PARAMETER_FIELD_VALUE_FAIL(10000,15058,"新增参数字段值不存在"),
    ERROR_EDIT_DICTIONARY_FAIL(10000, 15059, "编辑字典架构信息异常"),
    ERROR_DELL_DICTIONARY_FAIL(10000, 15060, "删除字典架构信息异常"),
    ERROR_UPDATE_DICTIONARY_NO_EXIST_FAIL(10000, 15061, "待更新的字典不存在"),
    ERROR_DEL_DICTIONARY_NO_EXIST_FAIL(10000, 15062, "待删除的字典不存在，您无法删除"),
    ERROR_DEL_DICTIONARY_EXIST_CHILD_DEPT_FAIL(10000, 15063, "该字典下还有子级字典,您无法删除"),
    ERROR_DEL_DICTIONARY_EXIST_USER_FAIL(10000, 15064, "该字典下还有子级字典，您无法删除"),
    ERROR_ADD_PARAMETER_FAIL(10000, 15065, "新增参数信息异常"),
    ERROR_EDIT_PARAMETER_FAIL(10000, 15066, "编辑参数信息不存在"),
    ERROR_DEL_PARAMETER_FAIL(10000, 150067, "删除参数信息异常"),
    ERROR_SELECT_PARAMETER_FAIL(10000, 150068, "查看参数信息异常"),
    ERROR_FIND_DICTIONARY_FAIL(10000, 15069, "查询数据字典信息异常"),
    ERROR_DELETE_STANDARD_EXIT(10000, 15070, "水质表中已存在该数据字典字段"),
    ERROR_ALL_ROLE_FAIL(10000,15071,"获取全部角色信息列表异常"),
    ERROR_CANSHU_WATER_STANDARD(10000, 15072, "水质修改参数为空"),
    ERROR_CANSHU_STANDARD_PARM(10000, 15073, "水质参数有误，请输入合法参数"),
    ERROR_DETELE_PARM_NULL(10000, 15074, "水质参数删除有误，请求参数为空"),
    ERROR_DETELE_DATA_FALSE(10000, 15075, "删除的水质标准不存在"),
    ERROR_MENU_ROLE_FAIL(10000,15076,"获取菜单角色列表异常"),
    ERROR_DEPT_CODE_NAME_NOT_EXIST_FAIL(10000,15077,"上级字典参数值不存在"),
    ERROR_AREA_CODE_NAME_NOT_EXIST_FAIL(10000,15078,"上级区域参数值不存在"),
    ERROR_DICTIONARY_CODE_NAME_NOT_EXIST_FAIL(10000,15079,"上级字典参数值不存在"),
    ERROR_STANDARD_LIST_FAIL(10000, 15080, "删除的水质网管层对接有误"),
    ERROR_FIND_DATA_NO_EXIST_FAIL(10000, 15081, "查询的水质标准不存在"),
    ERROR_DEPT_CODE_NAME_NOT_MODIFY_FAIL(10000,15082,"组织架构参数值不容许修改"),
    ERROR_DICTIONARY_CODE_NAME_NOT_MODIFY_FAIL(10000,15083,"字典参数值不容许修改"),
    ERROR_STAND_PAGE_FAIL(10000,15084,"水质标准分页异常"),
    ERROR_STANDARD_FAND_FAIL(10000,15085,"水质标准查询异常"),
    ERROR_STANDARD_TYPE_SELECT_NULL(10000,15086,"该codeValue传值不正确"),
    ERROR_STANDARD_NAME_EXIST(10000,15087,"该水质标准名称已存在"),
    ERROR_DICTIONARY_PAGE_FAIL(10000,15088,"数据字典分页异常"),
    ERROR_USER_FAIL(10000,15089,"待查询的用户不存在"),
    ERROR_CHILD_DEPT_USER_FAIL(10000,15090,"获取部门及子部门用户信息异常"),
    ERROR_HAS_ACL_FAIL(10000,15091,"获取用户是否有权限访问系统资源异常"),
    ERROR_CHILD_AREA_LIST_FAIL(10000,15092,"根据父级id查看子区域信息列表异常"),
    ERROR_FATHER_AREA_NOT_EXIST_FAIL(10000,15093,"您查询的区域信息不存在"),
    ERROR_AREA_UUID_INFO_FAIL(10000,15094,"根据uuid查询区域信息异常"),
    ERROR_AREA_ID_INFO_FAIL(10000,15095,"根据id查询区域信息异常"),
    ERROR_CHILD_DICT_ERROR(10000,15096,"查询子数据字典异常"),
    ERROR_DICT_NOT_EXIST_ERROR(10000,15097,"查询数据字典不存在"),
    ERROR_DICT_ATTR_ERROR(10000,15098,"查询商品属性列表异常"),
    ERROR_DICT_ATTR_IDS_ERROR(10000,15099,"根据 ids 批量查询字典异常"),
    ERROR_DICT_ATTR_CODE_VALUE_ERROR(10000,15100,"根据 codeValue 查字典异常"),
    ERROR_PARMETER_ID_LIST_FAIL(10000,15101,"根据id集合查询参数失败"),
    ERROR_PARMETER_INFO_BY_UUID_FAIL(10000,15102,"根据uuid查询参数详情失败"),
    ERROR_PARMETER_INFO_BY_ID_FAIL(10000,15103,"根据uuid查询参数详情失败"),
    ERROR_DICTIONARY_INFO_BY_ID_FAIL(10000,15104,"根据ud查询字典失败"),
    ERROR_PRIVANCES_FAIL(10000,-1,"根据省市区的uuid分别查询对象异常"),
    ERROR_DICT_ACL_FAIL(10000,15105,"删除字典时，关联参数表有数据时，不能删除"),
    //2开头为参数校验信息错误
    ERROR_PARAM(20000, 20000, "参数错误"),
    ERROR_PARAM_EMPTY(20000, 20001, "参数为空"),
    ERROR_PARAM_FORMAT(20000, 20002, "参数格式不正确"),
    ERROR_PARAM_KEY_NOT_EXIST(20000, 20007, "参数不存在"),
    ERROR_PARAM_TEMPLATE_TYPE_INVALID(20000,20008,"模板类型无效"),
    ERROR_SMS_SEND_FAIL(20000,20009,"短信发送失败"),
    ;

    private final int errorCode;
    private final int parentCode;
    private final String errorMessage;

    ErrorEnum(int parentCode, int errorCode, String errorMessage) {
        this.parentCode = parentCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public int getParentCode() {
        if (String.valueOf(errorCode).startsWith("1")) {
            return errorCode;
        }

        return parentCode;
    }

    public ErrorEnum getOutError() {
        return getErrorByCode(getParentCode());
    }

    public static ErrorEnum getErrorByCode(int code) {
        for (ErrorEnum errorEnum : values()) {
            if (errorEnum.getErrorCode() == code) {
                return errorEnum;
            }
        }
        return null;
    }
}
