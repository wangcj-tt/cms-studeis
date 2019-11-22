package com.briup.cms.dao;

import com.briup.cms.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ICustomerDao extends JpaRepository<Customer,Integer> {
    Customer queryById(int id);
    //Customer queryAllBy(int id);
    @Transactional
    //@Query("delete from Customer c where c.name = ?1")
    void deleteByName(String name);
}
