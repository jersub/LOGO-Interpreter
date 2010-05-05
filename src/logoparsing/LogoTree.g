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
   ^(AV a = expr) {traceur.avance($a.v);}
 | ^(TD a = expr) {traceur.tourneDroite($a.v);}
 | ^(TG a = expr) {traceur.tourneGauche($a.v);}
 | ^(REC a = expr) {traceur.recule($a.v);}
 | ^(FPOS a = expr b = expr) {traceur.fixePosition($a.v, $b.v);}
 | ^(FCAP a = expr) {traceur.fixeCap($a.v);}
 | ^(FCC c = INT) {int m = Integer.parseInt($c.getText()); traceur.couleur(m);}
 | LC {traceur.setTrace(false);}
 | BC {traceur.setTrace(true);}
 | VE {traceur.init();}
;
expr returns [double v] :
  ^(PLUS x=expr y=expr) {$v = $x.v + $y.v;}
| ^(MOINS x=expr y=expr) {$v = $x.v - $y.v;}
| ^(MULT x=expr y=expr) {$v = $x.v * $y.v;}
| ^(DIV x=expr y=expr) {$v = $x.v / $y.v;}
| a = INT {$v = Double.parseDouble($a.getText());}
;
