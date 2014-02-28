package gui;

import agents.Base;
import environment.Carte;
import environment.Case;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sylvainchen on 26/02/14.
 */
public class GridOfSprites extends JFrame implements ActionListener{

    public static void main(String[] args) {
        new GridOfSprites();
    }
    BufferedImage[] sprites;
    JFrame window;
    MyCanvas canvas;
    int boxSize = 20,
    width = 0,
    height = 0;
    private ArrayList<Base<Point>> bases = new ArrayList<Base<Point>>();
    private Carte c;
    final String[][] matrix = new String[][] {
            { " ","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," " },
            { " ","|"," "," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," " },
            { " ","|","|"," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," " },
            { " "," ","|"," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," " },
            { " "," ","|"," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," " },
            { " "," ","|"," "," "," "," "," "," "," "," "," "," "," ","|"," ","|"," " },
            { " "," ","|","|","|","|","|","|","|"," "," "," "," "," ","|"," "," "," " },
            { " "," "," "," "," "," "," "," ","|"," "," "," ","|"," ","|","|"," "," " },
            { " "," "," "," "," "," "," "," ","|"," "," "," ","|"," "," "," "," "," " },
            { " "," "," "," "," "," ","|"," ","|"," "," "," ","|"," "," "," "," "," " },
            { " ","|","|","|","|","|","|"," ","|"," "," "," ","|","|","|"," ","|","|" },
            { " ","|"," "," "," "," "," "," ","|"," "," "," ","|"," "," "," "," "," " },
            { " ","|"," "," "," "," "," "," ","|"," ","|"," ","|"," "," "," ","|"," " },
            { " ","|"," "," "," "," "," "," ","|","|","|"," ","|"," "," "," "," "," " },
            { " ","|"," "," "," "," "," "," "," "," "," "," ","|"," "," "," ","|"," " },
    };

    public GridOfSprites() {
        Carte carte = new Carte(matrix);
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();
        width = boxSize*largeur;
        height = boxSize*hauteur;
        Base<Point> b = new Base<Point>(300,300,300,"Base1", c, new Point(0,0));
        Base<Point> b2 = new Base<Point>(300,300,300,"Base2", c, new Point(largeur-1, hauteur-1));
        bases.add(b);
        bases.add(b2);
        loadSprites();

        window = new JFrame();
        canvas = new MyCanvas(carte);
        canvas.setPreferredSize(new Dimension(width, height));
        window.getContentPane().add(canvas);
        window.pack();
        window.setVisible(true);
    }

    private void loadSprites() {
        try {
            sprites = new BufferedImage[3];
            sprites[0] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire/src/main/resources/grass.jpg"));
            sprites[1] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire/src/main/resources/Bricks.jpg"));
            sprites[2] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire/src/main/resources/tower3.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(GridOfSprites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class MyCanvas extends JPanel {

        private Carte carte;
        public MyCanvas(Carte c) {
            carte = c;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            update(g);
        }

        public void update(Graphics g) {
            drawGrid(g);
            drawSprites(g);
        }

        private void drawGrid(Graphics g) {
            g.setColor(Color.BLACK);

            for (int i = 0; i < carte.getLargeur(); i++) {
                g.drawLine(i * boxSize, 0, i * boxSize, height);

            }
            for (int i = 0; i < carte.getHauteur(); i++) {
                g.drawLine(0, i * boxSize, width, i * boxSize);
            }
        }

        private void drawSprites(Graphics g) {
            Map<Point, Case> map = carte.getMap();

            for(Point p : carte.getPoints()) {
                Case c = map.get(p);
                if(c.estObstacle())
                    g.drawImage(sprites[1], boxSize * (int)p.getY(), boxSize * (int)p.getX(), null);
            }

            for(Base<Point> b : bases) {
                int x = (int)b.getIndex().getX();
                int y = (int)b.getIndex().getY();
                g.drawImage(sprites[2], boxSize * x, boxSize * y, null);
            }
            //g.drawImage(sprites[0], boxSize * 5, boxSize * 3, null);
            //g.drawImage(sprites[1], boxSize * 2, boxSize * 1, null);
            //g.drawImage(sprites[1], boxSize * 7, boxSize * 9, null);
        }
    }





    public void jouer() {

    }


    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
