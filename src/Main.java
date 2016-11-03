/**********************************************************************
 * file: Main.java
 * author: Kyle Turchik, Vu Dao, Marco Roman
 * class: CS 445 - Computer Graphics
 *
 * assignment: Quarter Project CP#1
 * date last modified: 11/01/2016
 *
 * purpose: This program uses the LWGJL to render a cube and allows
 *          keyboard commands to move the cube around a space. 
 *
 **********************************************************************/

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;

public class Main {

    // Main Window settings
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;
    public static final String WINDOW_TITLE = "Minecraft Rip Off";
    
    private FPCameraController fp = new FPCameraController(0f, 0f, 0f);

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
    
    // method: start
    // purpose: This method calls the methods which initialize the canvas
    // and render the cube.
    public void start() {
        try {
            createWindow();
            initGL();
            
            //render();
            fp.gameLoop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method: createWindow
    // purpose: initializes the window
    private void createWindow() throws Exception {
        Display.setFullscreen(false);
        Display.setDisplayMode(new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT));
        Display.setTitle(WINDOW_TITLE);
        Display.create();
    }

    // method: initGL
    // purpose: initializes original GL settings
    private void initGL() {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluPerspective(100.0f, WINDOW_WIDTH / WINDOW_HEIGHT, 0.1f, 300.0f);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_COLOR_ARRAY);
        glEnable(GL_DEPTH_TEST);
    }
}
