export default {
  // configure
  baseURL: 'http://106.15.200.225:80/',
  method: 'post',

  register:{url:'user/signup/'}, //注册
  login:{url:'user/signin/'},  //登陆

  getCourses:{url:'course/list'}, //获得所有课程
  getUserCourses:{url:'course/mycourses'}, //获得用户的课程
  getCourseInfo:{url:'course/course'}, //获得课程详细信息
  addCourse:{url:'course/user_add'},  //用户添加课程
}
