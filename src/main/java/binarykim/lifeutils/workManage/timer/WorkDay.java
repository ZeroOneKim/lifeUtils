package binarykim.lifeutils.workManage.timer;


import binarykim.lifeutils.workManage.security.SecurityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@Service
public class WorkDay {
    @Autowired SecurityInfo securityInfo;

    private static String FILE_PATH;
    private List<String> workDayList = new ArrayList<>();

    public void startInit() {
        FILE_PATH = securityInfo.getWorkDayPath();
        File filePath = new File(FILE_PATH);
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bf.readLine()) != null) workDayList.add(line);
        } catch (Exception e) {

        }
    }

    public List<String> getWorkDayList() {
        return workDayList;
    }
}
