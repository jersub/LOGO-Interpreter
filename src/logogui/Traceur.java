package logogui;

import java.awt.Graphics2D;
import java.awt.Graphics;

/**
 * Traceur dessinant les instructions LOGO interpr�t�es.
 *
 * @author Romain Fauvet
 * @author J�r�my Subtil
 */
public class Traceur {

    private static Traceur instance;
    private Graphics2D g2d;
    private double initx = 300, inity = 300;   // position initiale
    private double posx = initx, posy = inity; // position courante
    private int angle = 90;
    private double teta;

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
     * D�finit le support de dessin du traceur.
     *
     * @param g  le support de dessin
     */
    public void setGraphics(Graphics g) {
        g2d = (Graphics2D) g;
    }

    /**
     * Trace en avant.
     *
     * @param r  la longueur � tracer
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
     * Trace en arri�re.
     *
     * @param r  la longueur � tracer
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

    public void td(double r) {
        angle = (angle - toInt(r)) % 360;
        setTeta();
    }

    public void tg(double r) {
        angle = (angle + toInt(r)) % 360;
        setTeta();
    }

    /**
     * D�finit l'angle t�ta en radians � partir de l'angle d�finit en degr�s.
     */
    private void setTeta() {
        teta = Math.toRadians(angle);
    }

    /**
     * Transtype le nombre double donn� en int.
     *
     * @param a  la valeur � transtyper
     * @return   la valeur arrondie en int
     */
    private int toInt(double a) {
        return (int) Math.round(a);
    }
}
