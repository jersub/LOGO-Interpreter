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
}
@lexer::header {
	package logoparsing;
}
@header {
	package logoparsing;
}
@members {
	boolean valide = true;
	public boolean getValide(){
		return valide;
	}
}
INT	:	('0'..'9')+ ;
VRAI	:	'VRAI'|'vrai';
FAUX	:	'FAUX'|'faux'; 
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
	:	REPETE^ expr bloc
	|	TANTQUE^ exprBool bloc
	|	SI^ exprBool bloc bloc?
	|	( AV^ |	TD^ | TG^ | REC^ | FCAP^ ) expr
	|	FPOS^ '['! expr expr ']'!
	|	FCC^ INT
	|	LC^
	|	BC^
	|	VE^
	|	'TEST'^ exprBool
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
atom	:	INT | '('! expr ')'!
	;
atomBool:	VRAI
	|	FAUX
	|	expr ((CMP_EGAL^|CMP_SUP^|CMP_INF^|CMP_SUP_EGAL^|CMP_INF_EGAL^) expr)?
	|	'('! exprBool ')'!
	;
