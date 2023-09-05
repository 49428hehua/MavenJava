package com.example.mavenjava;

import com.example.mavenjava.configbean.Student;
import com.example.mavenjava.configbean.User;
import com.example.mavenjava.configbean.person;
import com.example.mavenjava.customconfig.Myproperties;
import com.example.mavenjava.mybatiscatalog.Comment;
import com.example.mavenjava.mybatiscatalog.CommentMapper;
import com.example.mavenjava.mybatiscatalog.jpa.Discuss;
import com.example.mavenjava.mybatiscatalog.jpa.DiscussRepository;
import com.example.mavenjava.profileconfig.DBConnector;
import org.hibernate.criterion.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MavenJavaApplicationTests {

    @Autowired
    ChapterApplication chapterApplication;
    @Autowired
    Student student;
    @Autowired
    person person;
    @Autowired
    User user;
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DBConnector dbConnector;

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private DiscussRepository repository;

    @Test


    public void contextLoads() {
        //System.out.println("单元测试返回的persion数据---"+person);
        // System.out.println("单元测试返回的User数据---"+user);

        //Myproperties myproperties=(Myproperties) applicationContext.getBean("Myproperties");
        //if (myproperties!=null){
        //myproperties.getResult();
        //}
        //System.out.println(dbConnector.config());
        //Comment comment=commentMapper.findById(1);
        //System.out.println(comment);
        List <Discuss> list = repository.findByAuthorNotNull();
        System.out.println(list);

        Optional<Discuss> optional = repository.findById(1);
        if (optional.isPresent()) {
            System.out.println(optional.get());
            System.out.println();
        }

        Pageable pageable = PageRequest.of(0, 3);
        List<Discuss> allPaged = repository.getDiscussPaged(1, pageable);
        System.out.println(allPaged);

        Discuss discuss = new Discuss();
        discuss.setAuthor("张三");
        Example<Discuss> example = Example.of(discuss);
        List<Discuss> list1 =repository.findAll(example);
        System.out.println(list1);

        Discuss discuss1 = new Discuss();
        discuss.setAuthor("张");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("author",startsWith());
        Example<Discuss> example1 = Example.of(discuss,matcher);
        List<Discuss> list2 = repository.findAll(example1);
        System.out.println(list2);
    }
}
