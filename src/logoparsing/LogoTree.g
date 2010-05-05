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
   ^(AV x = expr) {traceur.avance($x.v);}
 | ^(TD x = expr) {traceur.tourneDroite($x.v);}
 | ^(TG x = expr) {traceur.tourneGauche($x.v);}
 | ^(REC x = expr) {traceur.recule($x.v);}
 | ^(FPOS x = expr y = expr) {traceur.fixePosition($x.v, $y.v);}
 | ^(FCAP x = expr) {traceur.fixeCap($x.v);}
 | ^(FCC c = INT) {int m = Integer.parseInt($c.getText()); traceur.couleur(m);}
 | LC {traceur.setTrace(false);}
 | BC {traceur.setTrace(true);}
 | VE {traceur.init();}
 |^('TEST' b = exprBool) {Log.appendnl(Boolean.toString($b.v));}
;
expr returns [double v] :
  ^(OP_PLUS x=expr y=expr) {$v = $x.v + $y.v;}
| ^(OP_MOINS x=expr y=expr) {$v = $x.v - $y.v;}
| ^(OP_MULT x=expr y=expr) {$v = $x.v * $y.v;}
| ^(OP_DIV x=expr y=expr) {$v = $x.v / $y.v;}
| a = INT {$v = Double.parseDouble($a.getText());}
;
exprBool returns [boolean v] :
  ^(CMP_EGAL x=expr y=expr) {$v = $x.v == $y.v;}
| ^(CMP_SUP x=expr y=expr) {$v = $x.v > $y.v;}
| ^(CMP_INF x=expr y=expr) {$v = $x.v < $y.v;}
| ^(CMP_SUP_EGAL x=expr y=expr) {$v = $x.v >= $y.v;}
| ^(CMP_INF_EGAL x=expr y=expr) {$v = $x.v <= $y.v;}
;
