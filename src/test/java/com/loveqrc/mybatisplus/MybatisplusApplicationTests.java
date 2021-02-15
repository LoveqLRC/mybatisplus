package com.loveqrc.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.loveqrc.mybatisplus.entity.User;
import com.loveqrc.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {


    @Autowired
    public UserMapper userMapper;

    @Test
    void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


    /**
     * 不需要设置主键id，自动生成id值
     */
    @Test
    public void addUser() {
        User user = new User();
        user.setName("marry me");
        user.setAge(16);
        user.setEmail("123456@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("插入结果： " + insert);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1360594500372484098L);
        user.setName("hello rc");
        int result = userMapper.updateById(user);
        System.out.println("更新结果： " + result);
    }


    /**
     * 测试乐观锁
     */
    @Test
    public void updateUser2() {
        User user = userMapper.selectById(1361138527387901953L);
        user.setName("hello rc aa");
        int result = userMapper.updateById(user);
        System.out.println("更新结果： " + result);
    }

    /**
     * 分页查找
     */
    @Test
    public void getDataByPage() {
        Page<User> page = new Page<>(2, 2);
        userMapper.selectPage(page, null);

        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());

    }

    @Test
    public void deleteUser() {
        int result = userMapper.deleteById(1361138527387901953L);
        System.out.println("删除结果： " + result);
    }

}
