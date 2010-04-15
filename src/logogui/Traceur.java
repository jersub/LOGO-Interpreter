package logogui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

/**
 * Traceur dessinant les instructions LOGO interprétées.
 *
 * @author Romain Fauvet
 * @author Jérémy Subtil
 */
public class Traceur {

    private static Traceur instance;
    private Graphics2D g2d;
    private double initx = 300, inity = 300;   // position initiale
    private double posx = initx, posy = inity; // position courante
    private int angle = 90;
    private double teta;
    private static Color couleurs[] = {
        Color.BLACK,
        Color.RED,
        Color.GREEN,
        Color.YELLOW,
        Color.BLUE,
        Color.MAGENTA,
        Color.CYAN,
        Color.WHITE
    };

    /**
     * Constructeur.
     */
    public Traceur() {
        setTeta();
    }

    /**
     *Retourne l'instance du traceur.
     *
     * @return l'instance singleton
     */
    public static Traceur getInstance() {
        if (instance == null) {
            instance = new Traceur();
        }
        return instance;
    }

    /**
     * Définit le support de dessin du traceur.
     *
     * @param g  le support de dessin
     */
    public void setGraphics(Graphics g) {
        g2d = (Graphics2D) g;
    }

    /**
     * Trace en avant.
     *
     * @param r  la longueur à tracer
     */
    public void avance(double r) {
        double a = posx + r * Math.cos(teta);
        double b = posy - r * Math.sin(teta);
        int x1 = toInt(posx);
        int y1 = toInt(posy);
        int x2 = toInt(a);
        int y2 = toInt(b);
        g2d.drawLine(x1, y1, x2, y2);
        posx = a;
        posy = b;
    }

    /**
     * Trace en arrière.
     *
     * @param r  la longueur à tracer
     */
    public void recule(double r) {
        double a = posx - r * Math.cos(teta);
        double b = posy + r * Math.sin(teta);
        int x1 = toInt(posx);
        int y1 = toInt(posy);
        int x2 = toInt(a);
        int y2 = toInt(b);
        g2d.drawLine(x1, y1, x2, y2);
        posx = a;
        posy = b;
    }

    /**
     * Tourne l'orientation du traceur du côté droit.
     *
     * @param r  l'angle de rotation en degrés
     */
    public void tourneDroite(double r) {
        angle = (angle - toInt(r)) % 360;
        setTeta();
    }

    /**
     * Tourne l'orientation du traceur du côté gauche.
     *
     * @param r  l'angle de rotation en degrés
     */
    public void tourneGauche(double r) {
        angle = (angle + toInt(r)) % 360;
        setTeta();
    }

    /**
     * Définit la position courante du traceur.
     *
     * @param x
     * @param y
     */
    public void fixePosition(double x, double y) {
        posx = x;
        posy = y;
    }

    /**
     * Fixe le cap du traceur.
     *
     * 0   -> haut
     * 90  -> gauche
     * 180 -> bas
     * 270 -> droite
     *
     * @param r  le cap en degrés
     */
    public void fixeCap(double r) {
        angle = (90 + toInt(r)) % 360;
        setTeta();
    }

    /**
     * Définit la couleur du traceur.
     *
     * @param c  la valeur de la couleur
     */
    public void couleur(int c) {
        g2d.setColor(couleurs[c % 8]);
    }

    /**
     * Définit l'angle têta en radians à partir de l'angle définit en degrés.
     */
    private void setTeta() {
        teta = Math.toRadians(angle);
    }

    /**
     * Transtype le nombre double donné en int.
     *
     * @param a  la valeur à transtyper
     * @return   la valeur arrondie en int
     */
    private int toInt(double a) {
        return (int) Math.round(a);
    }
}
