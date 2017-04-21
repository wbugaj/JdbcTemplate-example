package com.wbugaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbugaj on 2017-04-21.
 */
@Service
public class BasicService {

    private final BasicDao basicDao;

    @Autowired
    public BasicService(BasicDao basicDao) {
        this.basicDao = basicDao;
    }

    public void createTable(String tableName) {
        try {
            basicDao.createTable(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void dropTable(String tableName) {
        try {
            basicDao.dropTable(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertInto(String tableName, String text) {
        try {
            basicDao.insertInto(tableName, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<String> selectFrom(String tableName) {
        try {
            return basicDao.selectFrom(tableName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
