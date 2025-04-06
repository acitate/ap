package ap.exercises.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PacmanGUI extends JFrame implements KeyListener {

    Point pacmanPoint = new Point();
    final int width = 300, height = 300, boxSize = 5;
    static int direction = 1;
    final int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4;
    Point dotPoint = new Point();
    int score = 0, max_score = 10;
    long start = System.currentTimeMillis(), max_time = 20000;

    public PacmanGUI() {
        addKeyListener(this);
        pacmanPoint.setLocation((width / boxSize) / 2, (height / boxSize) / 2);
        getNewDotPointLocation();
        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g.clearRect(0, 0, width, height);
        logic();
        drawPacman(g2D);
        drawDotPoint(g2D);
        drawScore(g2D);
        drawTime(g2D);
        setVisible(true);
    }

    private void drawPacman(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(pacmanPoint.x * boxSize, pacmanPoint.y * boxSize, boxSize, boxSize);
    }

    private void drawDotPoint(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(dotPoint.x * boxSize, dotPoint.y * boxSize, boxSize, boxSize);
    }

    private void drawScore(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        String s = "Score: " + score;
        System.out.println(s);
        g2d.drawString(s, 25, 50);
    }

    private void drawTime(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        String time ="Time: " + ((max_time - (System.currentTimeMillis() - start)) / 1000);
        g2d.drawString(time, 25, 62);
    }

    private void logic() {
        long finish = System.currentTimeMillis();

        if (dotPoint.x == pacmanPoint.x && dotPoint.y == pacmanPoint.y) {
            getNewDotPointLocation();
            score++;
        }
        if (finish - start >= max_time) {
            System.out.println("Time's up! \n game over");
            System.exit(1);
        }
        if (score == max_score){
            System.out.println("You won!");
            System.exit(0);
        }
        movePacman();
    }

    private void movePacman() {
        int xMovement = 1;
        int yMovement = 0;
        switch (direction) {
            case LEFT:
                xMovement = -1;
                yMovement = 0;
                break;
            case RIGHT:
                xMovement = 1;
                yMovement = 0;
                break;
            case TOP:
                xMovement = 0;
                yMovement = -1;
                break;
            case BOTTOM:
                xMovement = 0;
                yMovement = 1;
                break;
            default:
                xMovement = yMovement = 0;
                break;
        }
        pacmanPoint.setLocation(pacmanPoint.x + xMovement, pacmanPoint.y + yMovement);
        handleCrossBorder();
    }

    private void getNewDotPointLocation() {
        Random rand = new Random();
        int delta = boxSize * 2;
        dotPoint.setLocation(rand.nextInt(width / boxSize - 2 * delta) + delta, rand.nextInt(height / boxSize - 2 * delta) + delta);
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            direction = 3;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            direction = 4;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            direction = 1;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            direction = 2;
        else if (e.getKeyCode() == KeyEvent.VK_P)
            direction = 0;
        else if (e.getKeyCode() == KeyEvent.VK_Q)
            System.exit(0);
        else
            direction = -1;

        System.out.println("direction:" + direction + "    <- e.getKeyCode()=" + e.getKeyCode());

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void handleCrossBorder() {
        if (pacmanPoint.x > width / 5 - 1) {
            pacmanPoint.setLocation(pacmanPoint.x - 1, pacmanPoint.y);

        } else if (pacmanPoint.x < 0) {
            pacmanPoint.setLocation(0, pacmanPoint.y);

        } else if (pacmanPoint.y > height / 5 - 1) {
              pacmanPoint.setLocation(pacmanPoint.x, pacmanPoint.y - 1);

        } else if (pacmanPoint. y < height / 50) {
            pacmanPoint.setLocation(pacmanPoint.x, height / 50 + 1);
            
        }
    }


    public static void main(String[] args) {
        PacmanGUI frame = new PacmanGUI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

