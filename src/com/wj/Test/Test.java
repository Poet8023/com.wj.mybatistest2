package com.wj.Test;

import com.wj.entity.Grade;
import com.wj.entity.Student;
import com.wj.entity.StudentCard;
import com.wj.entity.StudentClass;
import com.wj.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static  void main(String [] args) throws  IOException{
        Test te=new Test();
//        te.quarrybyid();
//       te.quarrystubySQLtag();
//        te.quarryStuWithStunosInGrade();
        te.quarryStudnetByNoWithObO();
//        te.quarryStudentAndClass();
//        te.quarryStudnetWithlazyLoding();
//        te.quarry()
//        te.add();
//        te.quarry();
//        te.delete();
//        te.update();
//        te.quarry();

    }


    public void add() throws IOException{
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionfactory.openSession();
        Student stu=new Student(10,"小飞机",44,"一班");
//        int count = session.insert(statement, stu);
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.add(stu);
        System.out.println("添加成功");
        session.commit();
        session.close();
    }

    public void delete() throws IOException {
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionfactory.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
//        int count = session.delete(statement, 2);
        studentMapper.delete(9);
            System.out.println("删除成功");
        session.close();
    }

    public void update()throws IOException{
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionfactory.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student stu =new Student();
        stu.setStuno(1 );
        stu.setStuname("安吉拉华");
        studentMapper.update(stu);
        session.commit();
        System.out.println("添加成功");
        session.close();
    }

    public void  quarrybyid()throws IOException{
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionfactory.openSession();
        StudentMapper studentmapper = session.getMapper(StudentMapper.class);
        Student student = studentmapper.quarrybyid(1);
        System.out.println(student);
        session.close();
    }
    public void  quarry()throws IOException{
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionfactory.openSession();
        StudentMapper studentmapper = session.getMapper(StudentMapper.class);
        List<Student> student = studentmapper.quarry();
        System.out.println(student);
        session.close();
    }
    //根据学生的姓名和年龄来查询学生的信息
    public void  quarrystubySQLtag()throws IOException{
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionfactory.openSession();
        StudentMapper studentmapper = session.getMapper(StudentMapper.class);

        Student stu=new Student();
        stu.setStuname("安吉拉华");
        stu.setStuage(23);
        List<Student> student = studentmapper.quarrystubySQLtag(stu);
        System.out.println(student);
        session.close();
    }
    //查询年级中所有人的个数
    public void  quarryStuWithStunosInGrade()throws IOException{
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionfactory.openSession();
        StudentMapper studentmapper = session.getMapper(StudentMapper.class);

        Grade grade=new Grade();
        List<Integer> stuNos=new ArrayList<>();
        stuNos.add(1);
        stuNos.add(2);
        stuNos.add(3);
        grade.setStuNos(stuNos);
        List<Student> student = studentmapper.quarryStuWithStunosInGrade(grade);
        System.out.println(student);
        session.close();
    }
    //一对一查询
    public void  quarryStudnetByNoWithObO()throws IOException{
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        //第一次查询
        SqlSession session=sessionfactory.openSession();
        StudentMapper studentmapper = session.getMapper(StudentMapper.class);
        Student student = studentmapper.quarryStudnetByNoWithObO(1);
        System.out.println(student);
        session.close();
        //第二次查询
        SqlSession session2=sessionfactory.openSession();
        StudentMapper studentmapper2 = session2.getMapper(StudentMapper.class);
        Student student2 = studentmapper2.quarryStudnetByNoWithObO(1);
        System.out.println(student2);
        session2.close();
        //第三次查询
        SqlSession session3=sessionfactory.openSession();
        StudentMapper studentmapper3 = session3.getMapper(StudentMapper.class);
        Student student3 = studentmapper3.quarryStudnetByNoWithObO(1);
        System.out.println(student3);
        session3.close();

//        Student student2 = studentmapper.quarryStudnetByNoWithObO(1);
//        System.out.println(student2);


    }

    //延迟加载
    public void  quarryStudnetWithlazyLoding()throws IOException{
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionfactory.openSession();
        StudentMapper studentmapper = session.getMapper(StudentMapper.class);
        List<Student> students = studentmapper.quarryStudnetWithlazyLoding();
        for (Student student:students) {
            System.out.println(student.getStuno()+","+student.getStuname());

            StudentCard studentCard = student.getStudentCard();
            System.out.println(studentCard.getStucardId()+","+studentCard.getStucardInfo());
        }
        session.close();
    }
    //一对多查询
    public void  quarryStudentAndClass()throws IOException{
        Reader reader=Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionfactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionfactory.openSession();
        StudentMapper studentmapper = session.getMapper(StudentMapper.class);
        StudentClass studentClass = studentmapper.quarryStudentAndClass(1);
        System.out.println(studentClass.getclassId()+","+studentClass.getclassName());
        List<Student> students = studentClass.getStudents();
        for (Student stu:students) {
            System.out.println(stu.getStuno()+","+stu.getStuname()+","+stu.getStuage());
        }
        session.close();
    }
}
