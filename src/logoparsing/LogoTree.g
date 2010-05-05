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
@members {
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
prog	:	^(PROGRAMME liste_instructions) {Log.appendnl("Programme principal");}
	;
bloc	:	^(BLOC liste_instructions)
	;
liste_instructions
	:	(instruction)+
	;
instruction
	:	repete
	|	^(AV x = expr) {traceur.avance($x.v);}
	|	^(TD x = expr) {traceur.tourneDroite($x.v);}
	|	^(TG x = expr) {traceur.tourneGauche($x.v);}
	|	^(REC x = expr) {traceur.recule($x.v);}
	|	^(FPOS x = expr y = expr) {traceur.fixePosition($x.v, $y.v);}
	|	^(FCAP x = expr) {traceur.fixeCap($x.v);}
	|	^(FCC c = INT) {int m = Integer.parseInt($c.getText()); traceur.couleur(m);}
	|	LC {traceur.setTrace(false);}
	|	BC {traceur.setTrace(true);}
	|	VE {traceur.init();}
	|	^('TEST' b = exprBool) {Log.appendnl(Boolean.toString($b.v));}
	;
expr returns [double v]
	:	^(OP_PLUS x=expr y=expr) {$v = $x.v + $y.v;}
	|	^(OP_MOINS x=expr y=expr) {$v = $x.v - $y.v;}
	|	^(OP_MULT x=expr y=expr) {$v = $x.v * $y.v;}
	|	^(OP_DIV x=expr y=expr) {$v = $x.v / $y.v;}
	|	a = INT {$v = Double.parseDouble($a.getText());}
;
exprBool returns [boolean v]
	:	^(CMP_EGAL x=expr y=expr) {$v = $x.v == $y.v;}
	|	^(CMP_SUP x=expr y=expr) {$v = $x.v > $y.v;}
	|	^(CMP_INF x=expr y=expr) {$v = $x.v < $y.v;}
	|	^(CMP_SUP_EGAL x=expr y=expr) {$v = $x.v >= $y.v;}
	|	^(CMP_INF_EGAL x=expr y=expr) {$v = $x.v <= $y.v;}
	|	^(OP_OU b1=exprBool b2=exprBool) {$v = $b1.v || $b2.v;}
	|	^(OP_ET b1=exprBool b2=exprBool) {$v = $b1.v && $b2.v;}
	|	a=expr {$v = $a.v != 0;}
	|	VRAI {$v = true;}
	|	FAUX {$v = false;}
	;
repete
@init {
	int mark_list = 0;
}
  	:	^(REPETE a=expr {mark_list = input.mark();} . )
  		{
  		for (int i = 0; i < $a.v ; i++) {
			push(mark_list);
			bloc();
			pop();
		}
		}
	;
