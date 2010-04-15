tree grammar LogoTree;
options {
  tokenVocab = Logo;
  ASTLabelType=CommonTree;
}
@header {
  package logoparsing;
  import logogui.Traceur;
  import logogui.Log;
}
@members{
  Traceur traceur;
  public void initialize(java.awt.Graphics g) {
    traceur = Traceur.getInstance();
    traceur.setGraphics(g);
  }
  public void push(int index) {
     ((CommonTreeNodeStream)input).push(index);
  }
  public void pop() {
     ((CommonTreeNodeStream)input).pop();
  }
}
 prog : ^(PROGRAMME (instruction)*) 
     {Log.appendnl("Programme principal");}
;
instruction :
   ^(AV a = INT) {double m = Double.parseDouble($a.getText()); traceur.avance(m);}
 | ^(TD a = INT) {double m = Double.parseDouble($a.getText()); traceur.tourneDroite(m);}
 | ^(TG a = INT) {double m = Double.parseDouble($a.getText()); traceur.tourneGauche(m);}
 | ^(REC a = INT) {double m = Double.parseDouble($a.getText()); traceur.recule(m);}
 | ^(FPOS a = INT b = INT) {double x = Double.parseDouble($a.getText()); double y = Double.parseDouble($b.getText()); traceur.fixePosition(x, y);}
 | ^(FCAP a = INT) {double m = Double.parseDouble($a.getText()); traceur.fixeCap(m);}
 | ^(FCC a = INT) {int m = Integer.parseInt($a.getText()); traceur.couleur(m);}
;
