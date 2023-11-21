package Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
	private String operador_relacional;
	//private ArrayList<String> codigo_objeto = new ArrayList<String>(); 
	private List<String> codigo_objeto = new ArrayList<String>();
	private Stack pilha_tipos = new Stack();
	private Stack pilha_rotulos = new Stack();
	int contador_rotulos = 0;
	private List<String> lista_id = new ArrayList<String>();
	private Map<String, String[]> tabela_simbolos  = new HashMap<String, String[]>();
	
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
		case 107: metodo_acao107 ();       break;
		case 108: metodo_acao108 (token);  break;
		case 109: metodo_acao109 ();	   break;
		case 110: metodo_acao110 ();	   break;
		case 111: metodo_acao111 ();	   break;
		case 112: metodo_acao112 ();	   break;
		case 113: metodo_acao113 ();	   break;
		case 114: metodo_acao114 (token);  break;
		case 115: metodo_acao115 (token);  break;
		case 116: metodo_acao116 (token);  break;
		case 117: metodo_acao117 (); 	   break;
		case 118: metodo_acao118 (token);  break;
		case 119: metodo_acao119 (); 	   break;
		case 120: metodo_acao120 (); 	   break;
		case 121: metodo_acao121 ();  	   break;
		case 122: metodo_acao122 (token);  break;
		case 123: metodo_acao123 ();  	   break;
		case 124: metodo_acao124 (token);  break;
		case 125: metodo_acao125 (token);  break;
		case 126: metodo_acao126 (token);  break;
		case 127: metodo_acao127 (token);  break;
		case 128: metodo_acao128 (token);  break;
		
	 	default:  System.out.println("Ação #"+action+", com token: "+token+" não foi implementada."); 
		}
    }

    private void metodo_acao128(Token token) throws SemanticError{
		pilha_tipos.pop();
		for(int i= 0; i > lista_id.size(); i--) {
			codigo_objeto.add("dup");
		}
		for(String id : lista_id) {
			if(tabela_simbolos.containsKey(id)) {
				throw new SemanticError(token.getLexeme() + "ja declarado");
			} else if (id.startsWith("_i")){
				codigo_objeto.add("conv.i8");
			}
			codigo_objeto.add("stloc" + id);
		}
	}

	private void metodo_acao127(Token token) throws SemanticError{
		for (String id : lista_id) {
			if(tabela_simbolos.containsKey(id)) {
				throw new SemanticError(token.getLexeme() + "ja declarado");
			}
			if(id.startsWith("_i")) {
				String[] SeInt64 = new String[2];
				SeInt64[0] = "int64";
				tabela_simbolos.put(id, SeInt64);
				codigo_objeto.add(".locals (int64" + id + ") \n" );
			}
			if(id.startsWith("_f")) {
				String[] SeFloat64 = new String[2];
				SeFloat64[0] = "float64";
				tabela_simbolos.put(id, SeFloat64);
				codigo_objeto.add(".locals (float64" + id + ") \n" );
			}
			if(id.startsWith("_s")) {
				String[] SeString = new String[2];
				SeString [0] = "string";				
				tabela_simbolos.put(id, SeString );
				codigo_objeto.add(".locals (string" + id + ") \n" );
			}
			if(id.startsWith("_b")) {
				String[] SeBool = new String[2];
				SeBool[0] = "bool";
				tabela_simbolos.put(id, SeBool);
				codigo_objeto.add(".locals (bool" + id + ") \n" );
			}
			
		}
		
		lista_id.clear();
		
	}

	private void metodo_acao126(Token token) throws SemanticError{

		for (String id : lista_id) {
			if(tabela_simbolos.containsKey(id)) {
				throw new SemanticError(token.getLexeme() + "ja declarado");
			}
			if(id.startsWith("_i")) {
				String[] SeInt64 = new String[2];
				SeInt64[0] = "int64";
				SeInt64[1] = token.getLexeme();
				tabela_simbolos.put(id, SeInt64);
			}
			if(id.startsWith("_f")) {
				String[] SeFloat64 = new String[2];
				SeFloat64[0] = "float64";
				SeFloat64[1] = token.getLexeme();
				tabela_simbolos.put(id, SeFloat64);
			}
			if(id.startsWith("_s")) {
				String[] SeString = new String[2];
				SeString [0] = "string";
				SeString [1] = token.getLexeme();
				tabela_simbolos.put(id, SeString );
			}
			if(id.startsWith("_b")) {
				String[] SeBool = new String[2];
				SeBool[0] = "bool";
				SeBool [1] = token.getLexeme();
				tabela_simbolos.put(id, SeBool);
		}
			}
		lista_id.clear();
		
	}

	private void metodo_acao125(Token token) {
		lista_id.add(token.getLexeme());
	}

	private void metodo_acao124(Token token) throws SemanticError {
		// TODO Auto-generated method stub
    	if(!pilha_tipos.pop().equals("bool")) {
			throw new SemanticError ("expressao incompativel em comando de repeticao", token.getPosition());
		}
    	String rotulo = (String) pilha_rotulos.pop();
    	codigo_objeto.add("brtrue" + rotulo + "\n");
	}

	private void metodo_acao123() {
		// TODO Auto-generated method stub
		String rotulo1 = (String) pilha_rotulos.pop();
		String rotulo2 = (String) pilha_rotulos.pop();
		codigo_objeto.add("br " + rotulo1 + "\n");
		codigo_objeto.add(rotulo2 + ": " + "\n");
	}

	private void metodo_acao122(Token token) throws SemanticError {
		// TODO Auto-generated method stub
    	if(!pilha_tipos.pop().equals("bool")) {
			throw new SemanticError ("expressao incompativel em comando de repeticao", token.getPosition());
		}
    	String rotulo = "novo_rotulo";
    	codigo_objeto.add("brfalse " + rotulo + contador_rotulos++ + "\n");
    	pilha_rotulos.push(rotulo + contador_rotulos);
	}
	

	private void metodo_acao121() {
		// TODO Auto-generated method stub
		String rotulo = "novo_rotulo";
		codigo_objeto.add(rotulo + contador_rotulos++ + ": " + "\n");
		pilha_rotulos.push(rotulo + contador_rotulos);
	}

	private void metodo_acao119() {
		// TODO Auto-generated method stub
		codigo_objeto.add(pilha_rotulos.pop() + ": " + "\n");
	}

	private void metodo_acao120() {
		// TODO Auto-generated method stub
		String rotulo = "novo_rotulo";
		codigo_objeto.add("br " + rotulo + contador_rotulos++ + "\n");
		String rotulo2 = (String) pilha_rotulos.pop();
		codigo_objeto.add(rotulo2 + ": " + "n");
		pilha_rotulos.add(rotulo + contador_rotulos);
		}

	private void metodo_acao118(Token token) throws SemanticError {
		// TODO Auto-generated method stub
		if(!pilha_tipos.pop().equals("bool")) {
			throw new SemanticError ("expressao incompativel em comando de selecao", token.getPosition());
		}
    	String rotulo = "novo_rotulo";
    	codigo_objeto.add("brfalse " + rotulo + contador_rotulos++ + "\n");
    	pilha_rotulos.push(rotulo + contador_rotulos);
	}

	private void metodo_acao117() {
		// TODO Auto-generated method stub
		codigo_objeto.add("ldc.i8 -1 \n");
		codigo_objeto.add("conv.r8 \n");
		codigo_objeto.add("mul \n");
	}

	private void metodo_acao108(Token token) {
		// TODO Auto-generated method stub
		operador_relacional = token.getLexeme();
	}
    
    private void metodo_acao109() {
		Object e1 = pilha_tipos.pop();
		Object e2 = pilha_tipos.pop();
		switch(operador_relacional) {
		case "==":
			pilha_tipos.add("bool");
			codigo_objeto.add("ceq \n");
			break;
		case "!=":
			pilha_tipos.add("bool");
			codigo_objeto.add("ceq \n");
			metodo_acao106();
			codigo_objeto.add("ceq \n");
			break;
		case ">":
			pilha_tipos.add("bool");
			codigo_objeto.add("cgt \n");
			break;
		case "<":
			pilha_tipos.add("bool");
			codigo_objeto.add("clt \n");
			break;
			default:
		}
		
	}

	private void metodo_acao107() {
		// TODO Auto-generated method stub
		codigo_objeto.add("ldc.i4.1 \n xor \n" );
	}

	private void metodo_acao111() {
		// TODO Auto-generated method stub
		Object e1 = pilha_tipos.pop();
		Object e2 = pilha_tipos.pop();
		if(e1 == "int64" && e2 == "int64") {
			codigo_objeto.add("sub \n");
			pilha_tipos.add("int64");
		} else {
			codigo_objeto.add("sub \n");
			pilha_tipos.add("float64");
		}
	}

	private void metodo_acao110() {
		// TODO Auto-generated method stub
		Object e1 = pilha_tipos.pop();
		Object e2 = pilha_tipos.pop();
		if(e1 == "int64" && e2 == "int64") {
			codigo_objeto.add("add \n");
			pilha_tipos.add("int64");
		} else {
			codigo_objeto.add("add \n");
			pilha_tipos.add("float64");
		}
	}

	private void metodo_acao112() {
		// TODO Auto-generated method stub
		Object e1 = pilha_tipos.pop();
		Object e2 = pilha_tipos.pop();
		if(e1 == "int64" && e2 == "int64") {
			codigo_objeto.add("mul \n");
			pilha_tipos.add("int64");
		} else {
			codigo_objeto.add("mul \n");
			pilha_tipos.add("float64");
		}
	}
	
	private void metodo_acao113() {
		// TODO Auto-generated method stub
		Object e1 = pilha_tipos.pop();
		Object e2 = pilha_tipos.pop();
		if(e1 == "int64" && e2 == "int64") {
			codigo_objeto.add("div \n");
			pilha_tipos.add("int64");
		} else {
			codigo_objeto.add("div \n");
			pilha_tipos.add("float64");
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
