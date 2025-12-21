package GameSystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

	public boolean[] keys = new boolean[256];

	public boolean[] locked = new boolean[256];

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code >= 0 && code < 256) {
			keys[code] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code >= 0 && code < 256) {
			keys[code] = false;
			locked[code] = false;
		}
	}

	public boolean isPressedOnce(int keyCode) {
		if (keys[keyCode] && !locked[keyCode]) {
			locked[keyCode] = true;
			return true;
		}
		return false;
	}
}