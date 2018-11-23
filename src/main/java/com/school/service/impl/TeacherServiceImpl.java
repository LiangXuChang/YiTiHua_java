package com.school.service.impl;

import com.school.constant.CookieConstant;
import com.school.constant.RedisConstant;
import com.school.dataobject.Result;
import com.school.dataobject.Student;
import com.school.dataobject.Teacher;
import com.school.enums.ResultEnum;
import com.school.repository.TeacherRepository;
import com.school.service.TeacherService;
import com.school.utils.CookieUtil;
import com.school.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.school.config.WebSecurityConfig.SESSION_KEY;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    //教师登陆
    public Result teacherLogin(String teacherAccount, String teacherPassword,HttpServletResponse response){
        Map<String, Object> map = new HashMap<>();
        if(teacherRepository.findByteacherAccount(teacherAccount).isEmpty()){
            return ResultUtil.error(1,"账号或密码错误");
        }else if (!teacherRepository.findByteacherAccount(teacherAccount).get(0).getTeacherAccount().equals(teacherAccount)||!teacherRepository.findByteacherAccount(teacherAccount).get(0).getTeacherPassword().equals(teacherPassword)) {
            return ResultUtil.error(1,"账号或密码错误");
        }else {
            map.put("message", "登录成功");

//            //1. 设置token至redis
//            String token = UUID.randomUUID().toString();
//            Integer expire = RedisConstant.EXPIRE;
//
//            redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), teacherAccount, expire, TimeUnit.SECONDS);
//
//            //2. 设置token至cookie
//            CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
            return ResultUtil.success(map);
        }
    }

    //显示教师信息
    public Result<Teacher> showTeacher(String teacherAccount, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute(SESSION_KEY)!= null){
            return ResultUtil.success(teacherRepository.findByteacherAccount(teacherAccount));
//            return ResultUtil.success(studentRepository.getAllRecord());
        }else {
            return ResultUtil.error(1,"对不起您未登陆，请先登陆");
        }
    }

    //教师登出
    public Result logout(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<>();
//        //1. 从cookie里查询
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie != null) {
//            //2. 清除redis
//            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
//
//            //3. 清除cookie
//            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
//        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMsg());
        return ResultUtil.success(map);
    }
}
