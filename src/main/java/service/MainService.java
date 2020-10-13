package service;

import dboperation.SqlOperations;
import model.Entry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.List;


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
            sqlOperations.commitData();

            String xml = xmlService.createStringXml(sqlOperations.getData("test"));
            File file1 = new File("1.xml");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
            bufferedWriter.write(xml);
            bufferedWriter.close();

            File file2 = new File("2.xml");
            xmlService.transformXML(file1, file2);

            XMLHandler xmlHandler = new XMLHandler();
            xmlService.parseXML(file2, xmlHandler);

            averageSum(xmlHandler.getEntryList());

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private void averageSum(List<Entry> entryList) {
        double result = 0;
        for (Entry entry : entryList) {
            result += entry.getField();
        }
        System.out.println("Average sum is " + result / entryList.size());
    }
}