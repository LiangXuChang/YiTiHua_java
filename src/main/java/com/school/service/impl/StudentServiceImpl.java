package com.school.service.impl;

import com.school.constant.CookieConstant;
import com.school.constant.RedisConstant;
import com.school.dataobject.Result;
import com.school.dataobject.Student;
import com.school.enums.ResultEnum;
import com.school.repository.StudentRepository;
import com.school.service.StudentService;
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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    //学生账号注册
    public Student addStudent(Student student){
        student.setStudentName(student.getStudentName());
        student.setStudentPassword(student.getStudentPassword());
        student.setStudentAccount(student.getStudentAccount());
        return studentRepository.save(student);
    }

    //学生登陆
    public Result studentLogin(String studentAccount, String studentPassword, HttpServletResponse response){
        Map<String, Object> map = new HashMap<>();
        if(studentRepository.findBystudentAccount(studentAccount).isEmpty()){
            return ResultUtil.error(ResultEnum.LOGIN_ERROR.getCode(),ResultEnum.LOGIN_ERROR.getMsg());
        }else if (!studentRepository.findBystudentAccount(studentAccount).get(0).getStudentAccount().equals(studentAccount)||!studentRepository.findBystudentAccount(studentAccount).get(0).getStudentPassword().equals(studentPassword)) {
            return ResultUtil.error(ResultEnum.LOGIN_ERROR.getCode(),ResultEnum.LOGIN_ERROR.getMsg());
        }else {
//            // 设置session
//            session.setAttribute(SESSION_KEY, studentAccount);
            map.put("message", "登录成功");

//            //1. 设置token至redis
//            String token = UUID.randomUUID().toString();
//            Integer expire = RedisConstant.EXPIRE;
//
//            redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), studentAccount, expire, TimeUnit.SECONDS);
//
//            //2. 设置token至cookie
//            CookieUtil.set(response, CookieConstant.TOKEN, token, expire);

            return ResultUtil.success(map);
        }
    }

    //显示学生信息
    public Result<Student> showStudent(String studentAccount,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute(SESSION_KEY)!= null){
            return ResultUtil.success(studentRepository.findBystudentAccount(studentAccount));
//            return ResultUtil.success(studentRepository.getAllRecord());
        }else {
            return ResultUtil.error(ResultEnum.DISPLAY_ERROR.getCode(),ResultEnum.DISPLAY_ERROR.getMsg());
        }
    }

    //学生登出
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
