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
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

//public class WavPlayer extends Thread {
   public class WavPlayer implements Runnable {
	private String filename;
    private boolean stoped;
	private Position curPosition;

	private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb

	enum Position {
		LEFT, RIGHT, NORMAL
	};

	public WavPlayer(String wavfile) {
		filename = wavfile;
		curPosition = Position.NORMAL;
	}

	
    public void stop(){
        stoped=true;
    }

    @Override
	public void run() throws IllegalArgumentException{
        stoped= false;
		File soundFile = new File(filename);
		if (!soundFile.exists()) {
			throw new IllegalArgumentException("File " + filename + " not found");
			
		}

		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e1) {
			throw new IllegalArgumentException("File " + filename + " not supported");
			
		} catch (IOException e1) {
			throw new IllegalArgumentException("File " + filename + " not supported");
			
		}

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			throw new IllegalArgumentException("File " + filename + " not supported");

		} catch (Exception e) {
			throw new IllegalArgumentException("File " + filename + " not supported");

		}

		if (auline.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan = (FloatControl) auline
					.getControl(FloatControl.Type.PAN);
			if (curPosition == Position.RIGHT)
				pan.setValue(1.0f);
			else if (curPosition == Position.LEFT)
				pan.setValue(-1.0f);
		}

		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

		try {
			while (nBytesRead != -1 && !stoped) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Error playing file: " + filename);

		} finally {
			auline.drain();
			auline.close();
		}

	}
}