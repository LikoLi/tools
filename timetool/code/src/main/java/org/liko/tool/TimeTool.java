package org.liko.tool;

import org.liko.tool.service.TimeService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeTool {
    public static void main(String[] args) {
        double mins;
        if (args.length != 1) {
            System.out.print("===> 你需要几分钟后提醒: ");
            Scanner scanner = new Scanner(System.in);
            mins = scanner.nextDouble();
        } else {
            mins = Integer.parseInt(args[0]);
        }
        System.out.println("Now : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        TimeService timeService = new TimeService(mins);
        timeService.startup();
    }
}
