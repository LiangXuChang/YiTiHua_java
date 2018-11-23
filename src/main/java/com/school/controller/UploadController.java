package com.school.controller;

import com.school.dataobject.*;
import com.school.service.ImplementationService;
import com.school.service.PrepareService;
import com.school.service.QuestionService;
import com.school.utils.AliOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

//@RestController
@Controller
@RequestMapping("/school/test")
@CrossOrigin
public class UploadController {
//    private static Logger logger = Logger.getLogger(UploadController.class);
    /**
     * 本地存放目录
     */
    private static String uoloadPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "upload/";

    @Autowired
    ImplementationService implementationService;

    @Autowired
    PrepareService prepareService;

    @Autowired
    QuestionService questionService;

    @GetMapping(value="/gouploadimg")
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
//        response.sendRedirect(E:/workspace/school/src/main/resources/templates/uploading.html);
        return "uploading";
    }

    @RequestMapping(value="/ivideoupload", method = RequestMethod.POST)
    public String ivideoUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file,int classId,String studentName,String className,String implFont,int studentId) {
        if (!file.isEmpty()) {
            try {
                // 上传文件信息
//                logger.info("OriginalFilename：" + file.getOriginalFilename());
//                logger.info("ContentType：" + file.getContentType());
//                logger.info("Name：" + file.getName());
//                logger.info("Size：" + file.getSize());
                //TODO:文件大小、名称、类型检查的业务处理

                // 检查上传目录
                File targetFile = new File(uoloadPath);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }

                // 实例化输出流
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(uoloadPath + file.getOriginalFilename()));
                out.write(file.getBytes());
                out.flush();
                out.close();

                // 上传到OSS
                String url = AliOSSUtil.uploadLocalFile(new File(uoloadPath + file.getOriginalFilename()), "upload/avatar/");
//                String url1 = AliOSSUtil.uploadLocalFile(new File(uoloadPath + file1.getOriginalFilename()), "upload/avatar/");
                if (url == null) {
                    //TODO:上传失败的业务处理


                    return "上传失败";
                }
                Implementation implementation = new Implementation();
                implementation.setImplVideo(url);
                implementation.setClassId(classId);
//                implementation.setImplImg(url1);
                implementation.setStudentName(studentName);
                implementation.setClassName(className);
                implementation.setImplFont(implFont);
                implementation.setStudentId(studentId);
                implementationService.addImpl(implementation);

//                System.out.println(url);
//                System.out.println(uoloadPath);
//                System.out.println(file.getOriginalFilename());
//                logger.info("上传完毕,访问地址:"+url);
                return "uploading";
            } catch (IOException e) {
                e.printStackTrace();
//                logger.error("上传失败", e);
                return "上传失败";
            }
        }
        return "上传失败，因为文件是空的.";
    }

    @RequestMapping(value="/pvedioupload", method = RequestMethod.POST)
    public String pvedioUpload(HttpServletResponse response, HttpServletRequest request, @RequestParam("file") MultipartFile file,int classId, String pAssessment, String ptfont) {
        if (!file.isEmpty()) {
            try {
                //TODO:文件大小、名称、类型检查的业务处理

                // 检查上传目录
                File targetFile = new File(uoloadPath);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }

                // 实例化输出流
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(uoloadPath + file.getOriginalFilename()));
                out.write(file.getBytes());
                out.flush();
                out.close();

                // 上传到OSS
                String url = AliOSSUtil.uploadLocalFile(new File(uoloadPath + file.getOriginalFilename()), "upload/avatar/");
//                String url1 = AliOSSUtil.uploadLocalFile(new File(uoloadPath + file1.getOriginalFilename()), "upload/avatar/");
                if (url == null) {
                    //TODO:上传失败的业务处理


                    return "上传文件为空";
                }
                Prepare prepare = new Prepare();
                prepare.setClassId(classId);
                prepare.setPVideo(url);
//                prepare.setPTImg(url1);
                prepare.setPTFont(ptfont);
                prepare.setPAssessment(pAssessment);
                prepareService.addTutorial(prepare);

                return "uploading";
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
        }
        return "上传失败";
    }

    @RequestMapping(value="/qvedioupload", method = RequestMethod.POST)
    public String qvedioUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file,int classId,String qFont,String studentName,int studentAccount) {
        if (!file.isEmpty()) {
            try {
                //TODO:文件大小、名称、类型检查的业务处理

                // 检查上传目录
                File targetFile = new File(uoloadPath);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }

                // 实例化输出流
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(uoloadPath + file.getOriginalFilename()));
                out.write(file.getBytes());
                out.flush();
                out.close();

                // 上传到OSS
                String url = AliOSSUtil.uploadLocalFile(new File(uoloadPath + file.getOriginalFilename()), "upload/avatar/");
//                String url1 = AliOSSUtil.uploadLocalFile(new File(uoloadPath + file1.getOriginalFilename()), "upload/avatar/");
                if (url == null) {
                    //TODO:上传失败的业务处理


                    return "上传失败";
                }
                Question question = new Question();
                question.setClassId(classId);
                question.setQVideo(url);
//                question.setQImg(url1);
                question.setQFont(qFont);
                question.setStudentName(studentName);
                question.setStudentAccount(studentAccount);
                questionService.addQuestion(question);

                return "uploading";
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
        }
        return "上传失败，因为文件是空的.";
    }

    @RequestMapping(value="/avedioupload", method = RequestMethod.POST)
    public String avedioUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file,String aFont,int qid,int studentAccount) {
        if (!file.isEmpty()) {
            try {
                //TODO:文件大小、名称、类型检查的业务处理

                // 检查上传目录
                File targetFile = new File(uoloadPath);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }

                // 实例化输出流
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(uoloadPath + file.getOriginalFilename()));
                out.write(file.getBytes());
                out.flush();
                out.close();

                // 上传到OSS
                String url = AliOSSUtil.uploadLocalFile(new File(uoloadPath + file.getOriginalFilename()), "upload/avatar/");
//                String url1 = AliOSSUtil.uploadLocalFile(new File(uoloadPath + file1.getOriginalFilename()), "upload/avatar/");
                if (url == null) {
                    //TODO:上传失败的业务处理


                    return "上传失败";
                }
                Question question = new Question();
                question.setQId(qid);
                question.setAVideo(url);
//                question.setAImg(url1);
                question.setAFont(aFont);
                question.setStudentAccount(studentAccount);
                questionService.addAnswer(question);

                return "uploading";
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
        }
        return "上传失败，因为文件是空的.";
    }
}
