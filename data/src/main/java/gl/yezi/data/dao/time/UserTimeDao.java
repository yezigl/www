/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.time;

import gl.yezi.data.mapper.time.UserBuyMapper;
import gl.yezi.data.mapper.time.UserSellMapper;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月5日
 */
@Repository
public class UserTimeDao {

    @Resource
    UserBuyMapper userBuyMapper;

    @Resource
    UserSellMapper userSellMapper;

}
