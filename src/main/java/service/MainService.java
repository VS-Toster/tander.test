package service;

import dboperation.SqlOperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class MainService {
    public void start(long n) {
        try {
            SqlOperations sqlOperations = new SqlOperations();
            XmlService xmlService = new XmlService();
            if (sqlOperations.existingData("test")) {
                sqlOperations.truncateTable("test");
            }
            for (long i = 1; i <= n; i++) {
                sqlOperations.insertData("test", i);
            }
            String xml = xmlService.createStringXml(sqlOperations.getData("test"));
            File file = new File("1.xml");
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(xml);
            out.close();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
