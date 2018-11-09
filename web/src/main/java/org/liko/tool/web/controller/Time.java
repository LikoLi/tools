package org.liko.tool.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Time {
    @RequestMapping("/todate")
    public String timestampToDate(Long timestamp) {
        String result;
        if (timestamp == null) {
            result = "timestamp不能为空";
        } else {
            Date date = new Date(timestamp);
            result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
        }
        return result;
    }
}
