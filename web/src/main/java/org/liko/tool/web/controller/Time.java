package org.liko.tool.web.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Time {

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/todate")
    public String timestampToDate(Long timestamp) {
        String result;
        if (timestamp == null) {
            result = "timestamp不能为空";
        } else {
            Date date = new Date(timestamp);
            result = FORMAT.format(date);
        }
        return result;
    }

    @RequestMapping("/totimestamp")
    public String dateToTimestamp(String date) throws ParseException {
        String result = "";
        if (StringUtils.isEmpty(date)) {
            result = "date不能为空";
        } else  {
            result = FORMAT.parse(date).getTime() + "";
        }

        return result;
    }
}
