package com.why.shopserver.test.usercontroller;

import com.why.shopserver.commonenum.StatusEnum;
import com.why.shopserver.user.pojo.UserInfo;
import com.why.shopserver.user.repository.UserInfoRepository;

import com.why.shopserver.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息表测试接口
 *
 * @author why
 * @create 2022-04-21 14:46
 **/
@RestController
@RequestMapping("/test/user")
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;
//    @Autowired
//    private RedisUtil redisUtil;

    @GetMapping("/hello")
    public ResultVo hello(){
        return ResultVo.success(StatusEnum.CERTIFICATION_SUCCESS);
    }

    /**
     * 测试 jpa
     * @return
     */
    @GetMapping("/getUserInfo")
    public UserInfo userInfo(){
        return userInfoRepository.findById(1).orElse(null);
    }

    /**
     * redis存储数据
     */
    @PostMapping("/saveUser")
    public void saveUser(){
//        redisUtil.set("why",new UserInfo(1,"why","123","123",1));
    }

    /**
     * 获取redis数据
     * @return
     */
    @GetMapping("/getUserInfoCache")
    public UserInfo getUserInfoCache(){
//        return (UserInfo) redisUtil.get("why");
        return null;
    }
}