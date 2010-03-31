package logomain;

import java.io.StringReader;
import java.util.Scanner;

import logogui.ASTFrame;
import logogui.LogoFrame;
import logoparsing.LogoLexer;
import logoparsing.LogoParser;
import logoparsing.LogoTree;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//parse1();
		//parse2();
		ui();
	}
	static void parse1() {
		// Tokens d'un programme
		Scanner scanner = new Scanner(System.in);
		System.out.print("Texte : ");
		String s = scanner.nextLine();
		try {
			LogoLexer lexer = new LogoLexer(new ANTLRReaderStream(new StringReader(s)));
			Token t = lexer.nextToken();
			while (t.getType() != Token.EOF) {
				System.out.printf("%s - %d\n", t.getText(), t.getType());
				t = lexer.nextToken();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static void parse2() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Texte : ");
		String s = scanner.nextLine();
		try {
			LogoLexer lexer = new LogoLexer(new ANTLRReaderStream(new StringReader(s)));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			LogoParser parser = new LogoParser(tokens);
			LogoParser.programme_return r = parser.programme();
			CommonTree t = (CommonTree) r.getTree();
	        System.out.println(t.toStringTree());
	        ASTFrame af = new ASTFrame("Tree", t);
	        af.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void ui() {
		new LogoFrame();
	}
}
