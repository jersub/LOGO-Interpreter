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
	ECRIS_VAR;
	SQRT = 'SQRT';
	SIN = 'SIN';
	COS = 'COS';
	POUR = 'POUR';
	FIN = 'FIN';
	CHAINE;
	RET = 'RET';
}
@lexer::header {
	package logoparsing;
}
@header {
	package logoparsing;
	import java.util.TreeSet;
	import java.util.TreeMap;
	import logogui.Log;
}
@members {
	boolean valide = true;
	Procedure currentProcedure;
	public boolean getValide(){
		return valide;
	}
	public TreeMap<String,Procedure> getProcedures(){
		return procedures;
	}
	private Procedure createProcedure(String procedureName) {
		Procedure p = new Procedure(procedureName);
		procedures.put(procedureName, p);
		return p;
	}
	TreeSet<String> vars = new TreeSet<String>();
	TreeMap<String,Procedure> procedures = new TreeMap<String,Procedure>();
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
	|	LOCALE^ a = id_ecriture
		{
			if (currentProcedure.hasVar($a.s)) {
				valide = false;
				Log.appendnl("La variable "+$a.s+" est deja define en tant que parametre de la procedure "+currentProcedure.getName()+".");
			} else {
				vars.add($a.s);
			}
		}
	|	DONNE^ a = id_ecriture expr {vars.add($a.s);}
	|	( AV^ |	TD^ | TG^ | REC^ | FCAP^ ) expr
	|	FPOS^ '['! expr expr ']'!
	|	FCC^ INT
	|	LC^
	|	BC^
	|	VE^
	|	ecris
	|	procedure
	|	exec
	|	ret
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
	|	exec
	|	SQRT^ expr
	|	COS^ expr
	|	SIN^ expr

	;
atomBool:	VRAI
	|	FAUX
	|	expr ((CMP_EGAL^|CMP_SUP^|CMP_INF^|CMP_SUP_EGAL^|CMP_INF_EGAL^) expr)?
	|	'('! exprBool ')'!
	;
chaine	:	'"' ID -> ^(CHAINE ID)
	;
id_lecture
	:	':'! a = ID { if (!vars.contains($a.getText())) {valide = false; Log.appendnl("La variable "+$a.getText()+" n'a pas ete declaree.");}}
	;
id_ecriture returns [String s]
	:	'"'! a = ID {$s = $a.getText();}
	;
ecris	:	ECRIS^ (chaine|expr)
	|	ECRIS id_lecture -> ^(ECRIS_VAR id_lecture)
	;
procedure
@after {
	currentProcedure = null;
}
	:	POUR a = ID {currentProcedure = createProcedure($a.getText());}
		(':' b = ID
		{
			String varName = $b.getText();
			currentProcedure.addVar(varName);
			vars.add(varName);
		}
		)* liste_instructions FIN
		-> ^(POUR ID ID* ^(BLOC liste_instructions))
	;
exec
@init {
	int arite = 0;
	Procedure p = null;
}
	:	a = ID^
		{
			p = procedures.get($a.getText());
			if (p == null) {
				valide = false;
				Log.appendnl("La procedure "+$a.getText()+" n'a pas ete declaree.");
			}
		}
		((expr | id_lecture | chaine) {arite++;})*
		{
			if (p.countParams() != arite) {
				valide = false;
				Log.appendnl("La procedure "+p.getName()+" doit etre appelee avec "+p.countParams()+" argument(s).");
			}	
		}
	;
ret	:	RET^ (expr|chaine)
	;
