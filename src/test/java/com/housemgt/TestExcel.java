package com.housemgt;

import com.housemgt.Dao.ElementDao;
import com.housemgt.model.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExcel {


    @Resource(name="dataSource")
    private DataSource dataSource;

    @Autowired
    ElementDao elementDao;
    /* JDBC 的批量操作 */
    @Test
    public void insertBatch() throws SQLException {
        Connection connection=dataSource.getConnection();
        connection.setAutoCommit(false);
        String sql="insert into element(buildingNumber,elementNumber, floorNumber, households, elevatorstatus, elementPicture) " +
                "   values(?,?,?,?,?,?) ";

        PreparedStatement element=connection.prepareStatement(sql);
        for (int i = 0; i < 1000 ; i++) {
            element.setString(1, "h"+i);
            element.setString(2, "jc"+i);
            element.setInt(3, i);
            element.setInt(4, i);
            element.setString(5, ""+i);
            element.setString(6, "jj"+i);
            element.addBatch();
        }
        long start=System.currentTimeMillis();
        element.executeBatch();
        connection.commit();
        connection.close();
        element.close();
        System.out.print("耗时：");
        System.out.println(System.currentTimeMillis()-start);
    }

    /* Mybatis的批量操作 */
    @Test
    public void insertElement() {
        long start=System.currentTimeMillis();
        for (int i = 0; i < 1000 ; i++) {
            Element element = new Element();
            element.setBuildingNumber("aaa"+i);
            element.setElementNumber("ll"+i+i*1+"*i");
            element.setElementPicture("00"+i);
            element.setElevatorstatus( i);
            element.setFloorNumber(i);
            element.setHouseholds(i);
            elementDao.addElement(element);
        }
        System.out.print("耗时：");
        System.out.println(System.currentTimeMillis()-start);
    }


}
