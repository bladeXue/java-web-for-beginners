package com.blade.ssm.test;

import com.blade.ssm.dao.AdminDao;
import com.blade.ssm.dao.ImageDao;
import com.blade.ssm.dao.PositionDao;
import com.blade.ssm.model.Admin;
import com.blade.ssm.model.Image;
import com.blade.ssm.model.Position;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public class OneTest extends BaseJunit4Test{

    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void test(){

        System.out.println("233333");

//        DispatcherServlet
//        HandlerMapping
    }
}
