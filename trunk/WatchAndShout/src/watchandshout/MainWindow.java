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
 * MainWindow.java
 *
 * Created on Apr 8, 2009, 1:32:17 PM
 */

package watchandshout;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import java.util.Properties;



/**
 *
 * @author franco
 */
public class MainWindow extends javax.swing.JFrame {
    private DirectoryMonitor dirMon;
    private Boolean running;
    private String version;
    private WavPlayer player;
    private Properties config;
    private String configFile;

    /** Creates new form MainWindow */
    public MainWindow() {
       
        initComponents();
        /* Set some default values */
        Image img = Toolkit.getDefaultToolkit().getImage("Gnome-modem.png");
        this.setIconImage(img);
        this.running=false;
        setStatus ("Stoped");

        // Try to load the default config file
        loadConfig("./WatchAndShout.config");
    }

    /* for passing the version nr. to the aboutwindow */
    public void setVersionNumber(String ver){
        this.version = ver;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jToolBar1 = new javax.swing.JToolBar();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleSound = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lblInterval = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextTestAudio = new javax.swing.JTextField();
        jTextAlarmAudio = new javax.swing.JTextField();
        jButtonBrowseTestAudio = new javax.swing.JButton();
        jButtonBrowseAlarmAudio = new javax.swing.JButton();
        listMsg = new java.awt.List();
        jToolBar2 = new javax.swing.JToolBar();
        jlblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WatchAndShout");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/watchandshout/Im-aim.png"))); // NOI18N
        jToggleButton1.setToolTipText("Run");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setIconTextGap(2);
        jToggleButton1.setMargin(new java.awt.Insets(0, 5, 0, 5));
        jToggleButton1.setRolloverEnabled(false);
        jToggleButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/watchandshout/Gnome-process-stop.png"))); // NOI18N
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton1);

        jToggleSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/watchandshout/soundoff.png"))); // NOI18N
        jToggleSound.setSelected(true);
        jToggleSound.setToolTipText("");
        jToggleSound.setFocusable(false);
        jToggleSound.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleSound.setIconTextGap(2);
        jToggleSound.setMargin(new java.awt.Insets(0, 5, 0, 5));
        jToggleSound.setRolloverEnabled(false);
        jToggleSound.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/watchandshout/soundon.png"))); // NOI18N
        jToggleSound.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleSoundActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleSound);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/watchandshout/Gnome-application-exit.png"))); // NOI18N
        jButton1.setToolTipText("Exit");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMargin(new java.awt.Insets(0, 5, 0, 5));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Checking Interval");

        jSlider1.setMinimum(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setToolTipText("Interval in minutes");
        jSlider1.setValue(10);
        jSlider1.setMaximumSize(new java.awt.Dimension(100, 49));
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSlider1MouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });

        jLabel2.setText("Directory");

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblInterval.setText("10 min");

        jCheckBox1.setText("Search subdirectories  ");

        jLabel3.setText("Test audio file (.wav)");

        jLabel5.setText("Alarm audio file (.wav)");

        jButtonBrowseTestAudio.setText("Browse");
        jButtonBrowseTestAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseTestAudioActionPerformed(evt);
            }
        });

        jButtonBrowseAlarmAudio.setText("Browse");
        jButtonBrowseAlarmAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseAlarmAudioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblInterval))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextAlarmAudio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTestAudio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBrowseAlarmAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBrowseTestAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblInterval))
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTestAudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBrowseTestAudio)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextAlarmAudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBrowseAlarmAudio)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jToolBar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jlblStatus.setText("jLabel4");
        jToolBar2.add(jlblStatus);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jMenu3.setText("File");

        jMenuItem2.setText("Save Settings");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem4.setText("Load Settings");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);
        jMenu3.add(jSeparator1);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Help");

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        close();
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       close();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        run();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            // Show the about dialog
            AboutDialog ad = new AboutDialog(this,true);
            ad.setVersion(version);
            ad.setIconImage(this.getIconImage());
            ad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    //Browse Directories
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       FileChooser dc = new FileChooser(this,true);
       dc.setTitle("Choose a directory to monitor");
       dc.setVisible(true);
       this.jTextField1.setText(dc.getDir());
    }//GEN-LAST:event_jButton2ActionPerformed


    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseReleased
    
    }//GEN-LAST:event_jSlider1MouseReleased

    private void jSlider1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseMoved
     
    }//GEN-LAST:event_jSlider1MouseMoved

    private void jSlider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseDragged
       lblInterval.setText( String.valueOf(jSlider1.getValue()) + " min");
    }//GEN-LAST:event_jSlider1MouseDragged

    //Stop sound if playing
    private void jToggleSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleSoundActionPerformed
        if(player != null){
                player.stop();
            }
}//GEN-LAST:event_jToggleSoundActionPerformed

    private void jButtonBrowseTestAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseTestAudioActionPerformed
       FileChooser dc = new FileChooser(this,true,"file",".wav");
       dc.setTitle("Choose a File");

       dc.setVisible(true);
       this.jTextTestAudio.setText(dc.getDir());
}//GEN-LAST:event_jButtonBrowseTestAudioActionPerformed

    private void jButtonBrowseAlarmAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseAlarmAudioActionPerformed
       FileChooser dc = new FileChooser(this,true,"file",".wav");
       dc.setTitle("Choose a File");
       
       dc.setVisible(true);
       this.jTextAlarmAudio.setText(dc.getDir());
}//GEN-LAST:event_jButtonBrowseAlarmAudioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
                save();
    }//GEN-LAST:event_jMenuItem2ActionPerformed



    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      FileChooser dc = new FileChooser(this,true,"file","none");
       dc.setTitle("Choose a Config File");

       dc.setVisible(true);
       loadConfig(dc.getDir());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /*load a config file */
    private void loadConfig(String file) {
        File f = new File (file);

        if (f.exists() && !(f.isDirectory())){
            config = new Properties();

                try {
                    config.load(new InputStreamReader(new FileInputStream(f)));

                    //load config values
                    jSlider1.setValue(Integer.parseInt(config.getProperty("timeout")));
                    jSlider1MouseDragged(null);
                    jTextField1.setText(config.getProperty("directory"));
                    jTextTestAudio.setText(config.getProperty("testaudio"));
                    jTextAlarmAudio.setText(config.getProperty("alarmaudio"));
                    if (config.getProperty("searchsubdirs").equals("true")){
                        jCheckBox1.setSelected(true);
                    }
                    setStatus("Settings loaded");

                    //Catch FNF and IO Exceptions and send msg
                 } catch (FileNotFoundException ex) {
                    setMsg("Could not open Config file:" + file);
                 } catch (IOException ex) {
                     setMsg("Error opening Config file:" + file);
                }
        }else{
            setMsg("Could not open Config file:" + file);
        }
    }

    //SAves Configuration
    private void save(){
        // New config
        config = new Properties();

        // Set values
        config.setProperty ("timeout", String.valueOf(jSlider1.getValue()) );
        config.setProperty("directory", jTextField1.getText());
        if (jCheckBox1.isSelected()){
            config.setProperty("searchsubdirs", "true");
        }else{
            config.setProperty("searchsubdirs", "false");
        }
        config.setProperty("testaudio", jTextTestAudio.getText());
        config.setProperty("alarmaudio", jTextAlarmAudio.getText());
        
        // open file chooser
        FileChooser dc = new FileChooser(this,true,"savefile");
        dc.setTitle("Choose a File");
        dc.setVisible(true);
        configFile=dc.getDir();

        //write to file
        try {
            config.store(new FileOutputStream(configFile), "WatchAndShout Config File");
        } catch (IOException ex) {
           setMsg("Could not save config file");
        }
    }

    // close the application
    private void close(){
        //stop sound if running
        if (player != null){
            player.stop();
        }
        //Stop monitor if running
        if (dirMon != null){
            dirMon.stop();
        }
       this.setVisible(false);
       System.exit(0);
    }

   
    // writes a status message
    public void setStatus(String status){
        jlblStatus.setText(status);
    }

    //write to msglist
    public void setMsg(String msg){
        if (listMsg.getItemCount() > 150){
                listMsg.removeAll();
        }
        listMsg.add(msg,0);
    }

       // plays test file if sound is on
    public void playTest(){
        if (jToggleSound.isSelected()){
            setMsg("Playing testfile");
            try {
            
                player = new WavPlayer(this.jTextTestAudio.getText());
         
                new Thread(player).start();
            }catch(IllegalArgumentException ex){
                setMsg(ex.getMessage());
            }
        }
    }

    /* Prints alarm msg and plays sound */
    public void setAlarm(){
        if (player != null){
            player.stop();
        }
        
        setMsg("::: ALARM NO NEW FILE FOUND :::");
         if (jToggleSound.isSelected()){
                player = new WavPlayer(this.jTextAlarmAudio.getText());
                new Thread(player).start();
         }
    }

    /* Start/stop the monitor */
    private void run(){
      try {
        if (!running){
                //start
                setMsg("Started");
                disableGui();
                dirMon = new DirectoryMonitor(this, jTextField1.getText(), jSlider1.getValue()*60, jCheckBox1.isSelected());
                // Play test audio file
                playTest();
        }else{
            //Stop Monitor and audio player
            if (dirMon != null){
               dirMon.stop();
            }
            if(player != null){
                player.stop();
            }
            //Re-enable the gui elements
            enableGui();
        }
        //Togle running variable
        running = ! running;

      // Catch Exeption throen by dirMon
      }catch(IllegalArgumentException ex){
        listMsg.add(ex.getMessage(),0);
        running = false;
        jlblStatus.setText("Stoped  ");
       jToggleButton1.setSelected(false);
        enableGui();
      }
    }


    private void disableGui(){
        toggleGui(false);
    }

    private void  enableGui(){
        toggleGui(true);
    }

       //Enables/disable the gui elements
    private void toggleGui(boolean enabled){
          this.jTextAlarmAudio.setEnabled(enabled);
        this.jTextTestAudio.setEnabled(enabled);
        this.jTextField1.setEnabled(enabled);
        this.jCheckBox1.setEnabled(enabled);
        this.jButton2.setEnabled(enabled);
        this.jSlider1.setEnabled(enabled);
        this.jButtonBrowseAlarmAudio.setEnabled(enabled);
        this.jButtonBrowseTestAudio.setEnabled(enabled);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonBrowseAlarmAudio;
    private javax.swing.JButton jButtonBrowseTestAudio;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextAlarmAudio;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextTestAudio;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleSound;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JLabel lblInterval;
    private java.awt.List listMsg;
    // End of variables declaration//GEN-END:variables

}