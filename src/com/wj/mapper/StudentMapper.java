package com.wj.mapper;

import com.wj.entity.Grade;
import com.wj.entity.Student;
import com.wj.entity.StudentClass;

import java.util.List;

//操作mybatis的接口
public interface StudentMapper {
        /*
        约当的目标 ：省略statement，及根据预定  直接可以定位出sql语句

        1.方法名和Mapper.xml文件中的标签的id值相同
             2.方法的输入参数和mapper.xml文件中的标签的paramType类型相同
             3.方法的返回值和mapper.xml文件中标签的parameterType类型相同

                1.接口的全类名就是namespqce的值（mapper和接口一一对应）


            习惯 ：sql映射文件（mapper.xml)和接口放在同一个包中
        */

    public abstract Student quarrybyid(int stuno);

    public abstract List<Student> quarry();

    public abstract void add(Student student);

    public abstract void delete(int stuno);

    public abstract void update(Student student);

    public abstract  List<Student> quarrystubySQLtag(Student student);

    public abstract  List<Student> quarryStuWithStunosInGrade(Grade grade);

    public abstract Student quarryStudnetByNoWithObO(int stuno);

    public abstract  StudentClass quarryStudentAndClass(int classid);

    List<Student> quarryStudnetWithlazyLoding();
}
