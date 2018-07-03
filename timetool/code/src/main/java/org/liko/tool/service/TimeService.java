package org.liko.tool.service;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeService extends TimerTask{
    private double mins;

    public TimeService(double mins) {
        this.mins = mins;
    }

    @Override
    public void run() {
        Date now = new Date();
        if (now.after(getDateByHour(now, 20)) || now.before(getDateByHour(now, 10))) {
            System.out.println("不在上班时间~");
        }
        JOptionPane.showMessageDialog(null, "你已经" + mins + "分钟没有休息啦, 喝口水, 看看天, 休息一下眼睛吧!");
    }

    public void startup() {
        Timer timer = new Timer();
        Double time = mins * 60 * 1000;
        timer.schedule(this, time.longValue(), time.longValue());
    }

    private Date getDateByHour(Date now, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
