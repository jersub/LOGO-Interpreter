tree grammar LogoTree;
options {
	tokenVocab = Logo;
	ASTLabelType=CommonTree;
}
@header {
	package logoparsing;
	import logogui.Traceur;
	import logogui.Log;
	import java.util.HashMap;
	import java.util.TreeMap;
}
@members {
	Traceur traceur;
	int level = 0;
	HashMap<String,String> globalVars = new HashMap<String,String>();
	TreeMap<String,Integer> procedures = new TreeMap<String,Integer>();
	
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
	private void store(String key,String value) {
		for (int s = $bloc.size()-1; s>=0 ; s--) {
			if ($bloc[s]::var.get(key) != null) {
				$bloc[s]::var.put(key,value);
				return;
			}
		}
		globalVars.put(key,value);
	}
	private String value(String key) {
		for (int s = $bloc.size()-1; s>=0 ; s--) {
			String v = $bloc[s]::var.get(key);
			if ( v != null)
				return v;
		}
		return globalVars.containsKey(key) ? globalVars.get(key) : null;
	}
}
prog	:	^(PROGRAMME liste_instructions) {Log.appendnl("Programme principal");}
	;
bloc
scope {
	HashMap<String,String> var;
}
@init {
	$bloc::var = new HashMap<String,String>();
	level++;
}
@after {
	level--;
}
	:	^(BLOC liste_instructions)
	;
liste_instructions
	:	(instruction)+
	;
instruction
	:	bloc
	|	^(ECRIS x = expr){Log.appendnl(Double.toString(x));}
	|	^(ECRIS_VAR a = ID){Log.appendnl(value($a.getText()));}
	|	^(ECRIS_CHAINE str = CHAINE){Log.appendnl($str.getText());}
	|	repete
	|	tantque
	|	si
	|	^(LOCALE a=ID) {$bloc::var.put($a.getText(), "---");}
	|	^(DONNE a=ID x=expr) {store($a.getText(), Double.toString($x.v));}
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
	|	procedure
	|	exec
	;
expr returns [double v]
	:	^(OP_PLUS x=expr y=expr) {$v = $x.v + $y.v;}
	|	^(OP_MOINS x=expr y=expr) {$v = $x.v - $y.v;}
	|	^(OP_MULT x=expr y=expr) {$v = $x.v * $y.v;}
	|	^(OP_DIV x=expr y=expr) {$v = $x.v / $y.v;}
	|	a = INT {$v = Double.parseDouble($a.getText());}
	|	b = ID {$v = Double.parseDouble(value($b.getText()));}
	|	^(SQRT x = expr) {$v = Math.sqrt(x);}
	|	^(COS x = expr) {$v = Math.cos(x);}
	|	^(SIN x = expr) {$v = Math.sin(x);}
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
tantque
@init {
	int mark_cond = 0;
	int mark_list = 0;
}
  	:	^(TANTQUE ({mark_cond = input.mark();} a=exprBool) {mark_list = input.mark();} . )
  		{
  		boolean b = $a.v;
  		while (b) {
			push(mark_list);
			bloc();
			pop();
			push(mark_cond);
			b = exprBool();
			pop();
		}
		}
	;
si
@init {
	int mark_list = -1;
}
  	:	^(SI b=exprBool {if ($b.v) mark_list = input.mark();} . ({if (!$b.v) mark_list = input.mark();} .)?)
  		{
  		if (mark_list != -1) {
  			push(mark_list);
			bloc();
			pop();
		}
		}
	;
procedure
@init {
	int mark_list = 0;
}
  	:	^(POUR a = ID ID* {mark_list = input.mark();} . ) {procedures.put($a.getText(), mark_list);}
	;
exec	:	a = ID
		{
			int mark_list = procedures.get($a.getText());
			push(mark_list);
			bloc();
			pop();
		}
	;