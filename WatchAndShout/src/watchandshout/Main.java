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

package watchandshout;

/**
 *
 * @author franco
 */
public class Main {
    private static final String version = "0.1";
    private MainWindow mw;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          new Main();
    }

    public Main(){
        /* Start the MainWindow */
        mw = new MainWindow();
        mw.setVersionNumber(version);
        mw.setVisible(true);
        
    }
    public String getVersion(){
        return version;
    }

}
