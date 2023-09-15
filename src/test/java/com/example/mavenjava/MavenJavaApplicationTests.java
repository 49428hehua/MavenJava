package com.example.mavenjava;

import com.example.mavenjava.configbean.Student;
import com.example.mavenjava.configbean.User;
import com.example.mavenjava.configbean.person;
import com.example.mavenjava.mybatiscatalog.CommentMapper;
import com.example.mavenjava.mybatiscatalog.jpa.DiscussRepository;
import com.example.mavenjava.mybatiscatalog.redis.Address;
import com.example.mavenjava.mybatiscatalog.redis.Family;
import com.example.mavenjava.mybatiscatalog.redis.Personredis;
import com.example.mavenjava.mybatiscatalog.redis.PersonRepository;
import com.example.mavenjava.profileconfig.DBConnector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private PersonRepository repository1;

    @Test
    public void saveRedisPerson() {
        Personredis personRedis = new Personredis();
        personRedis.setFirstname("哇羊羊");
        personRedis.setLastname("哈羊羊");
        Address address = new Address();
        address.setCity("羊村");
        address.setCountry("中国");
        personRedis.setAddress(address);
        List<Family> list = new ArrayList<>();
        Family dad = new Family("父亲", "张羊");
        Family mom = new Family("母亲", "李羊");
        list.add(dad);
        list.add(mom);
        personRedis.setFamilyList(list);
        Personredis personResult = repository1.save(personRedis);
        System.out.println(personResult);
    }

    @Test
    public void contextLoads1() {
        List<Personredis> listPerson = repository1.findByLastname("哈羊羊");
        System.out.println(listPerson);
    }

    @Test
    public void contextLoads() {
        /*System.out.println("单元测试返回的persion数据---"+person);
        System.out.println("单元测试返回的User数据---"+user);*/

        //Myproperties myproperties=(Myproperties) applicationContext.getBean("Myproperties");
        //if (myproperties!=null){
        //myproperties.getResult();
        //}
        //System.out.println(dbConnector.config());
        //Comment comment=commentMapper.findById(1);
        //System.out.println(comment);
        /*List <Discuss> list = repository.findByAuthorNotNull();
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
        Example example = Example.of(discuss);
        List<Discuss> list1 =repository.findAll(example);
        System.out.println(list1);

        Discuss discuss1 = new Discuss();
        discuss.setAuthor("张");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("author",startsWith());
        Example<Discuss> example1 = Example.of(discuss,matcher);
        List<Discuss> list2 = repository.findAll(example1);
        System.out.println(list2);*/

    }
}
