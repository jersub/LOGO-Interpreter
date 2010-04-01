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
 | ^(TD a = INT) {double m = Double.parseDouble($a.getText()); traceur.td(m);}
 | ^(TG a = INT) {double m = Double.parseDouble($a.getText()); traceur.tg(m);}
 | ^(REC a = INT) {double m = Double.parseDouble($a.getText()); traceur.recule(m);}
;
