/*
 WatchAndShout
    Copyright (C) 2009 franco fallica

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package watchandshout;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Franco Fallica
 */
public class DirectoryMonitor extends TimerTask {

    private int interval;
    private File dir;
    private Timer timer;
    private long lastmodified;
    private boolean foundNew,  searchSubDirs, firstRun;
    private MainWindow mw;
    private int count;

    public DirectoryMonitor(MainWindow w, String dir, int iv, boolean subs) throws IllegalArgumentException {
        this.interval = iv;
        this.searchSubDirs = subs;
        this.lastmodified = 0;
        this.dir = new File(dir);
        mw = w;
        this.firstRun=true;
        timer = new Timer();
        if (!(this.dir.exists() && this.dir.isDirectory())) {
            throw new IllegalArgumentException("Need a Directory");
        } else {

            count = 1;
            timer.schedule(this, 1000, 1000);
            Thread.currentThread().setPriority(2);
        }
    }

    private void visitFiles(File dir) {

        if (dir.isDirectory() && this.searchSubDirs && !(foundNew)) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                visitFiles(new File(dir, children[i]));
            }
        } else {
            if (dir.lastModified() > this.lastmodified) {

                this.lastmodified = dir.lastModified();
                this.foundNew = true;
            }
          
        }

    }

    public void run() {
        count--;
        if (count == 0) {
            mw.setStatus("Running");
            runner();
            count = this.interval;
        } else {
            int min = count / 60;
            int sec = count % 60;
            String str;
            if (min < 10) {
                str = "Time to next run: 0" + Integer.toString(min) + " min";
            } else {
                str = "Time to next run: " + Integer.toString(min) + " min";
            }
            if (sec < 10) {
                str += " 0" + Integer.toString(sec) + " sec";
            } else {
                str += " " + Integer.toString(sec) + " sec";
            }
            mw.setStatus(str);

        }
    }

    private void runner() {
        this.foundNew = false;
       
        String[] files = this.dir.list();
        if (this.lastmodified == 0){
            firstRun=true;
        }

        for (int i = 0; i < files.length; i++) {
            visitFiles(new File(dir.getAbsolutePath() + "/" + files[i]));
        }

        if (!foundNew && !firstRun) {
           mw.setAlarm();
        }else{
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            mw.setMsg("( " + formatter.format(new Date())  + ") Run and found new file" );
            firstRun=false;
        }
    }

 
    /* This stops the Monitor */
    public void stop() {
        timer.cancel();
        mw.setStatus("Stoped");
        mw.setMsg("Stoped");
    }
}
