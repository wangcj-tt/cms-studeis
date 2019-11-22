package com.briup.cms;

import com.briup.cms.bean.Customer;
import com.briup.cms.dao.ICustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsStudeisApplicationTests {
    @Autowired
    private ICustomerDao customerDao;
    @Test
    public void contextLoads() {
        Customer customer = new Customer();
        customer.setId(58);
        customer.setName("lisi");
        customer.setMoney(55754);
        Customer customer1 = new Customer();
        customer1.setId(8);
        customer1.setName("wangwu");
        customer1.setMoney(141);
        Customer customer2 = new Customer();
        customer2.setId(53);
        customer2.setName("zhangsan");
        customer2.setMoney(52524);
        customerDao.save(customer);
        customerDao.save(customer1);
        customerDao.save(customer2);
    }
    @Test
    public void Test() {
    customerDao.deleteAll();
    }
    @Test
    public void Test1() {
        customerDao.deleteById(10);
    }
    @Test
    public void Test2() {
    customerDao.deleteByName("wangwu");
    }
    @Test
    public void test5() {
        List<Customer> list = customerDao.findAll();
        list.forEach(t -> System.out.println(t));

    }
    @Test
    public void test6() {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        List<Customer> list = customerDao.findAll(sort);
        list.forEach(t -> System.out.println(t));
    }
    @Test
    public void test7() {
        Pageable pageable = PageRequest.of(1,2);
        Page<Customer> page = customerDao.findAll(pageable);
        System.out.println(page.getTotalPages());//总页数
        System.out.println(page.getTotalElements());//总记录数
        List<Customer> list = page.getContent();//获取查询出来的结果
        list.forEach(t -> System.out.println(t));
    }
}
