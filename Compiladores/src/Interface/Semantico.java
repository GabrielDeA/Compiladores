package Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Semantico implements Constants
{
	private String operador_relacional;
	//private ArrayList<String> codigo_objeto = new ArrayList<String>(); 
	private List<String> codigo_objeto = new ArrayList<String>();
	private Stack pilha_tipos = new Stack();
	
    public void executeAction(int action, Token token)	throws SemanticError
    {

    	switch (action) {
        case 100: metodo_acao100 ();       break;
		case 101: metodo_acao101 ();       break;
		case 102: metodo_acao102 ();       break;
		case 103: metodo_acao103 ();	   break;
		case 104: metodo_acao104 ();	   break;
		case 105: metodo_acao105 ();       break;
		case 106: metodo_acao106 ();       break;
		case 114: metodo_acao114 (token);  break;
		case 115: metodo_acao115 (token);  break;
		case 116: metodo_acao116 (token);  break;
	 	default:  System.out.println("Ação #"+action+", com token: "+token+" não foi implementada."); 
		}
    }

	private void metodo_acao104() {
		// TODO Auto-generated method stub
		pilha_tipos.pop();
		pilha_tipos.pop();
		pilha_tipos.add("bool");
		codigo_objeto.add("or \n");
		
	}

	private void metodo_acao103() {
		// TODO Auto-generated method stub
		pilha_tipos.pop();
		pilha_tipos.pop();
		pilha_tipos.add("bool");
		codigo_objeto.add("and \n");
		
		
		/*
		if(pilha_tipos.peek() == "bool") {
		Object elemento1 = pilha_tipos.pop();
			if(pilha_tipos.peek() == "bool") {
				
				pilha_tipos.pop();
				metodo_acao106();
				
			} else {
				pilha_tipos.add(elemento1);
			}
		}
		*/
	}

	private void metodo_acao116(Token token) {
		// TODO Auto-generated method stub
		pilha_tipos.push("string");
		codigo_objeto.add("ldstr" + token.getLexeme() + "\n");
	}

	private void metodo_acao106() {
		// TODO Auto-generated method stub
		pilha_tipos.add("bool");
		codigo_objeto.add("ldc.i4.0 \n");
	}

	private void metodo_acao105() {
		// TODO Auto-generated method stub
		pilha_tipos.add("bool");
		codigo_objeto.add("ldc.i4.1 \n");
	}

	private void metodo_acao115(Token token) {
		// TODO Auto-generated method stub
		pilha_tipos.add("float64");
		codigo_objeto.add("ldc.r8 " + token.getLexeme() + "\n");
	}

	private void metodo_acao114(Token token) {
		// TODO Auto-generated method stub
		pilha_tipos.add("int64");
		codigo_objeto.add("ldc.i8 " + token.getLexeme() + "\n");
		codigo_objeto.add("conv.r8" + "\n");
	}

	private void metodo_acao102() {
		// TODO Auto-generated method stub
		if(pilha_tipos.peek() == "int64") {
			codigo_objeto.add("conv.i8" + "\n");
			codigo_objeto.add("call void [mscorlib]System.Console::WriteLine(int64)" + "\n");
			pilha_tipos.pop();
			return;
		}
		if(pilha_tipos.peek() == "float64") {
			codigo_objeto.add("call void [mscorlib]System.Console::WriteLine(float64)" + "\n");
			pilha_tipos.pop();
			return;
		}
		if(pilha_tipos.peek() == "string") {
			codigo_objeto.add("call void [mscorlib]System.Console::WriteLine(string)" + "\n");
			pilha_tipos.pop();
			return;
		}
		if(pilha_tipos.peek() == "bool") {
			codigo_objeto.add("call void [mscorlib]System.Console::WriteLine(bool)" + "\n");
			pilha_tipos.pop();
			return;
		}
		
	}

	private void metodo_acao101() {
		// TODO Auto-generated method stub
		codigo_objeto.add("  ret\r\n"
				+ "  }\r\n"
				+ "}");
		for (int i = 0; i<codigo_objeto.size(); i++) {
			System.out.print(codigo_objeto.get(i));	
		}
		
	}

	private void metodo_acao100() {
		// TODO Auto-generated method stub
		codigo_objeto.add(".assembly extern mscorlib {}\r\n"
				+ ".assembly _programa{}\r\n"
				+ ".module _programa.exe\r\n"
				+ "\r\n"
				+ ".class public _programa{\r\n"
				+ "  .method static public void _principal(){\r\n"
				+ "     .entrypoint" + "\n");
	}	
    
}
