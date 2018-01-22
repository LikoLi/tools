package org.liko.tool.service;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimeService extends TimerTask{
    private double mins;

    public TimeService(double mins) {
        this.mins = mins;
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, "你已经" + mins + "分钟没有休息啦, 喝口水, 看看天, 休息一下眼睛吧!");
    }

    public void startup() {
        Timer timer = new Timer();
        Double time = mins * 60 * 1000;
        timer.schedule(this, time.longValue(), time.longValue());
    }
}
