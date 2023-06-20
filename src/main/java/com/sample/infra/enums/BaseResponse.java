package com.sample.infra.enums;

/**
 * 抽象响应接口
 * @author zengfeiyue
 */
public interface BaseResponse {

    /**
     * 响应代码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 提示信息
     *
     * @return 提示信息
     */
    String getMsg();

    /**
     * 获取数据
     * @return
     */
    Object getData();

}
