grammar Logo;
options {
	output = AST;
	backtrack = true;
}
tokens {
	PROGRAMME;
	BLOC;
	REPETE = 'REPETE';
	TANTQUE = 'TANTQUE';
	SI = 'SI';
	LOCALE = 'LOCALE';
	DONNE = 'DONNE';
	AV = 'AV';
	TD = 'TD';
	TG = 'TG';
	REC = 'REC';
	FPOS = 'FPOS';
	FCAP = 'FCAP';
	FCC = 'FCC';
	LC = 'LC' ;
	BC = 'BC' ;
	VE = 'VE';
	OP_PLUS = '+' ;
	OP_MOINS = '-' ;
	OP_MULT = '*' ;
	OP_DIV = '/' ;
	OP_ET = '&' ;
	OP_OU = '|' ;
	CMP_EGAL = '=';
	CMP_SUP = '>';
	CMP_INF = '<';
	CMP_SUP_EGAL = '>=';
	CMP_INF_EGAL = '<=';
	ECRIS = 'ECRIS';
	ECRIS_CHAINE;
	ECRIS_VAR;
	SQRT = 'SQRT';
	SIN = 'SIN';
	COS = 'COS';
	POUR = 'POUR';
	FIN = 'FIN';
}
@lexer::header {
	package logoparsing;
}
@header {
	package logoparsing;
	import java.util.TreeSet;
	import logogui.Log;
}
@members {
	boolean valide = true;
	public boolean getValide(){
		return valide;
	}
	TreeSet<String> vars = new TreeSet<String>();
	TreeSet<String> procedures = new TreeSet<String>();
}
INT	:	('0'..'9')+;
VRAI	:	'VRAI'|'vrai';
FAUX	:	'FAUX'|'faux';
ID	:	('a'..'z'|'A'..'Z')('0'..'9'|'a'..'z'|'A'..'Z')*;
WS	:	(' '|'\t'|('\r'? '\n'))+ { skip(); } ;
programme
	:	liste_instructions -> ^(PROGRAMME liste_instructions)
	;
liste_instructions
	:	(instruction)+ 
	;
bloc	:	'[' liste_instructions ']' -> ^(BLOC liste_instructions)
	;
instruction
	:	bloc
	|	REPETE^ expr bloc
	|	TANTQUE^ exprBool bloc
	|	SI^ exprBool bloc bloc?
	|	LOCALE^ a = id_ecriture {vars.add($a.s);}
	|	DONNE^ a = id_ecriture expr {vars.add($a.s);}
	|	( AV^ |	TD^ | TG^ | REC^ | FCAP^ ) expr
	|	FPOS^ '['! expr expr ']'!
	|	FCC^ INT
	|	LC^
	|	BC^
	|	VE^
	|	ECRIS '"' ID -> ^(ECRIS_CHAINE ID)
	|	ECRIS id_lecture -> ^(ECRIS_VAR id_lecture)
	|	ECRIS^ expr
	|	procedure
	|	exec
	;
expr	:	sumExpr
	;
sumExpr	:	multExpr ((OP_PLUS^|OP_MOINS^) multExpr)*
	;
multExpr:	atom ((OP_MULT^|OP_DIV^) atom)*
	;
exprBool:	exprOu
	;
exprOu	:	exprEt (OP_OU^ exprEt)*
	;
exprEt	:	atomBool (OP_ET^ atomBool)*
	;
atom	:	id_lecture
	|	INT
	|	'('! expr ')'!
	|	SQRT^ expr
	|	COS^ expr
	|	SIN^ expr
	;
atomBool:	VRAI
	|	FAUX
	|	expr ((CMP_EGAL^|CMP_SUP^|CMP_INF^|CMP_SUP_EGAL^|CMP_INF_EGAL^) expr)?
	|	'('! exprBool ')'!
	;
id_lecture
	:	':'! a = ID { if (!vars.contains($a.getText())) {valide = false; Log.appendnl("La variable "+$a.getText()+" n'a pas ete declaree.");}}
	;
id_ecriture returns [String s]
	:	'"'! a = ID {$s = $a.getText();}
	;
procedure
	:	POUR a = ID id_lecture* {procedures.add($a.getText());} liste_instructions FIN -> ^(POUR ID id_lecture* ^(BLOC liste_instructions))
	;
exec	:	a = ID { if (!procedures.contains($a.getText())) {valide = false; Log.appendnl("La procedure "+$a.getText()+" n'a pas ete declaree.");}}
	;
