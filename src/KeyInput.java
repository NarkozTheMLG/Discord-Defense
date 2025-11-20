import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    // --- VARIABLES ---
    // Public so GamePanel can access them
    public boolean qPressed, wPressed, ePressed, uPressed,iPressed,oPressed,pPressed;
    public boolean spacePressed; // For shooting

    // --- METHODS ---

    @Override
    public void keyTyped(KeyEvent e) {
        // We usually leave this empty for movement games
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // Get the ID of the key pressed

        if (code == KeyEvent.VK_Q) {
            qPressed = true;
        }
        if (code == KeyEvent.VK_W) {
            wPressed = true;
        }
        if (code == KeyEvent.VK_E) {
            ePressed = true;
        }
        if (code == KeyEvent.VK_U) {
            uPressed = true;
        }
        if (code == KeyEvent.VK_I) {
            iPressed = true;
        }
        if (code == KeyEvent.VK_O) {
            oPressed = true;
        }
        if (code == KeyEvent.VK_P) {
            pPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_Q) {
            qPressed = false;
        }
        if (code == KeyEvent.VK_W) {
            wPressed = false;
        }
        if (code == KeyEvent.VK_E) {
            ePressed = false;
        }
        if (code == KeyEvent.VK_U) {
            uPressed = false;
        }
        if (code == KeyEvent.VK_I) {
            iPressed = false;
        }
        if (code == KeyEvent.VK_O) {
            oPressed = false;
        }
        if (code == KeyEvent.VK_P) {
            pPressed = false;
        }
    }
}