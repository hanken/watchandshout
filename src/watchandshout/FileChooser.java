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
 * FileChooser.java
 *
 * Created on Apr 8, 2009, 5:10:37 PM
 */
package watchandshout;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author franco
 */
public class FileChooser extends javax.swing.JDialog {

    private final String filter;

    /** Creates new form DirChooser
     * @param parent
     * @param modal
     */
    public FileChooser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        filter = "";
        this.jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    public FileChooser(java.awt.Frame parent, boolean modal, String mode) {
        super(parent, modal);
        initComponents();
        filter = "";
        if (mode.equals("savefile")) {
            jFileChooser1.setDialogType(JFileChooser.SAVE_DIALOG);
        }
        this.jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }

    public FileChooser(java.awt.Frame parent, boolean modal, String mode, final String filter) {
        super(parent, modal);
        initComponents();
        this.filter = filter;
        this.jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (!filter.equals("none")) {
            this.jFileChooser1.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File file) {
                    return (file.getName().endsWith(filter));
                }

                @Override
                public String getDescription() {
                    return filter + " files";
                }
            });
        }
    }

    public String getDir() {
        return this.jFileChooser1.getSelectedFile().toString();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setTitle("Choose a directory to monitor");

        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jFileChooser1ActionPerformed
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                DirChooser dialog = new DirChooser(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
