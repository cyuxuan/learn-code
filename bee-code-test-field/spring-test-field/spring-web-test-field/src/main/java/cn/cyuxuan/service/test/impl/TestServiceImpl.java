package cn.cyuxuan.service.test.impl;


import cn.cyuxuan.dao.test.TestDao;
import cn.cyuxuan.service.test.TestService;
import cn.cyuxuan.service.test2.Testa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestDao testDao;

    @Autowired
    Testa testa;

    @Override
    public String testService() {
        try {
            Thread.sleep(700);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name = testDao.selectNameById(1);
        String sex = testDao.selectSexById(1);
        testa.tt();
        this.testMore("123");
        return "test" + " " + name + " " + sex;
    }

    @Override
    public String testMore(String str) {
        String name = testDao.selectNameById(1);
        return doMore();
    }

    private String doMore() {
        return "123";
    }
}
