# API

###新建课程

```
GET /school/class/add
```

参数

```
int teacherId:"课程教师ID"
String className:"课程名称"
String classProject:"课程包含的实训项目名称"
int classTime:"课程学时"
String classLevel:"课程难易程度"
String classTeacher:"当前任课教师"
String classHome:"当前上课班级"
String classProjectTime:"计划上课时间"
String classAddress:"上课地点"
```

###课程信息编辑

```
GET /school/class/update
```

参数

```
int classId:"课程ID",
String className:"课程名称"
String classProject:"课程包含的实训项目名称"
int classTime:"课程学时"
String classLevel:"课程难易程度"
String classTeacher:"当前任课教师"
String classHome:"当前上课班级"
String classProjectTime:"计划上课时间"
String classAddress:"上课地点"
```

###删除课程

```
GET /school/class/delete
```

参数

```
int classId:"课程ID"
```

###显示所有课程

```
GET /school/class/showAll
```

参数

```
无
```

###显示一个课程内容

```
GET /school/class/showOne
```

参数

```
int classID:"课程ID"
```

###手动评分

```
GET /school/evaluation/add
```

参数

```
int eId:"评分ID"
int eGrade:"评分分数"
String className:"课程名称"
int studentId:"学生id"
```

###学生进行相关资源上传

```
GET /school/implementation/add
```

参数

```
int studentId:"学生ID"
int classId:"课程id"
String className:"课程名称"
String ImplFont:"上传的文字"
String ImplImg:"上传图片url"
String ImplVideo:"上传视频url"
```

###显示所有学生上传的资源

```
GET /school/implementation/showAll
```

参数

```
无
```

###显示单个学生上传的资源

```
GET /school/implementation/showOne
```

参数

```
int ImplId:"上传ID"
```

###添加教程

```
GET /school/prepare/add
```

参数

```
int teacherId:"教师ID"
int classId:"课程id";
String pTFont:"文字教程"
String pTImg:"图片教程url"
String pVideo:"视频教程url"
String pAssessment:"考核要点"
```

###展示教程

```
GET /school/prepare/show
```

参数

```
int pId:"教程ID"
```

###修改教程

```
GET /school/prepare/update
```

参数

```
int teacherId:"教师ID"
int classId:"课程id";
String pTFont:"文字教程"
String pTImg:"图片教程url"
String pVideo:"视频教程url"
String pAssessment:"考核要点"
```

###学生提出疑难问题

```
GET /school/question/add
```

参数

```
int studentId:"学生ID"
int classId:"课程ID"
String qFont:"文字问题"
String qImg:"图片问题url"
String qVideo:"视频问题url"
```

###显示学生提出的疑难问题

```
GET /school/question/show
```

参数

```
无
```

###教师对疑难问题进行解答

```
GET /school/question/answer
```

参数

```
int teacherId:"教师ID"
int classId:"课程ID"
String aFont:"文字回答"
String aImg:"图片回答url"
String aVideo:"视频回答url"
```
###学生注册

```
GET /school/student/create
```

参数

```
String studentName:"学生姓名"
String studentAccount:"学生账号"
String studentPassword:"学生密码"
```
###学生登陆

```
GET /school/student/login
```

参数

```
String studentAccount:"学生账号"
String studentPassword:"学生密码"
```
###显示学生信息

```
GET /school/student/display
```

参数

```
String studentAccount:"学生账号"
```
###教师登陆

```
GET /school/teacher/login
```

参数

```
String teacherAccount:"教师账号"
String teacherPassword:"教师密码"
```
###显示教师信息

```
GET /school/teacher/display
```

参数

```
String teacherAccount:"教师账号"
```
###学生账号登出

```
GET /school/student/logout
```

参数

```
无
```
###教师账号登出

```
GET /school/teacher/logout
```

参数

```
无
```
###根据教师id查询课程

```
GET /school/class/showByT
```

参数

```
teacherId:"教师ID"
```

###根据课程id查询教程

```
GET /school/prepare/showByC
```

参数

```
classId:"课程id"
```

###根据课程id查询实训

```
GET /school/implementation/showByClassId
```

参数

```
classId:"课程id"
```

###根据学生id获取评分

```
GET /school/evaluation/showBySid
```

参数

```
studentId:"学生id"
```
###根据学生id查询问题

```
GET /school/question/showBySid
```

参数

```
studentId:"学生id"
```
###根据课程id查询问题

```
GET /school/question/showByCid
```

参数

```
classId:"课程id"
```