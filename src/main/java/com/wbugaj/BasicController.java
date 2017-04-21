package com.wbugaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wbugaj on 2017-04-21.
 */
@RestController
public class BasicController {

    private final BasicService basicService;

    /**
     * All GET calls for easy testing
     * @param basicService
     */


    @Autowired
    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping("/create/{table}")
    public void createTable(@PathVariable("table") String tableName) {
        this.basicService.createTable(tableName);
    }
    @GetMapping("/drop/{table}")
    public void dropTable(@PathVariable("table") String tableName) {
        this.basicService.dropTable(tableName);
    }
    @GetMapping("/insert/{table}/{text}")
    public void insertInto(@PathVariable("table") String tableName,
                           @PathVariable("text") String text) {
        this.basicService.insertInto(tableName, text);
    }
    @GetMapping("/select/{table}")
    public List<String> selectFrom(@PathVariable("table") String tableName) {
        return this.basicService.selectFrom(tableName);
    }
}
