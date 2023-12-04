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
	public List<String> codigo_objeto = new ArrayList<String>();
	private Stack pilha_tipos = new Stack();
	private Stack pilha_rotulos = new Stack();
	int contador_rotulos = 0;
	private List<String> lista_id = new ArrayList<String>();
	private Map<String, String[]> tabela_simbolos  = new HashMap<String, String[]>();
	
	public String getCodigo_Objeto () {
		String str = "";
		for (int i = 0; i<codigo_objeto.size(); i++) {
			str += codigo_objeto.get(i);
				}
		return str;
	}
	
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
		case 129: metodo_acao129 ();  	   break;
		case 130: metodo_acao130 (token);  break;
		case 131: metodo_acao131 (token);  break;
		
	 	default:  System.out.println("Ação #"+action+", com token: "+token+" não foi implementada."); 
		}
    }
    
    private void metodo_acao131(Token token) throws SemanticError {
        String identificador = token.getLexeme();
        if (!tabela_simbolos.containsKey(identificador)) {
            throw new SemanticError(identificador + " não declarado", token.getPosition());
        }

        String[] tipoIdentificador = tabela_simbolos.get(identificador);

        if (tipoIdentificador[0].equals("const")) {
            switch (tipoIdentificador[0]) {
                case "int64":
                    codigo_objeto.add("ldc.i8 " + tipoIdentificador[2] + "\n");
                    break;
                case "float64":
                    codigo_objeto.add("ldc.r8 " + tipoIdentificador[2] + "\n");
                    break;
                case "string":
                    codigo_objeto.add("ldstr " + tipoIdentificador[2] + "\n");
                    break;
                case "bool":
                    codigo_objeto.add("ldc.i4." + (tipoIdentificador[2].equals("true") ? "1" : "0") + "\n");
                    break;
            }
            if (tipoIdentificador[0].equals("int64")) {
                codigo_objeto.add("conv.r8 \n");
            }
            pilha_tipos.push(tipoIdentificador[0]);
        } else {
            codigo_objeto.add("ldloc " + identificador + "\n");
            if (tipoIdentificador[0].equals("int64")) {
                codigo_objeto.add("conv.r8 \n");
            }
            pilha_tipos.push(tipoIdentificador[0]);
        }
    }

	private void metodo_acao130(Token token) {
        codigo_objeto.add("ldstr " + token.getLexeme() + "\n");
        codigo_objeto.add("call void [mscorlib]System.Console::Write(string)\n");
    }


    private void metodo_acao129() throws SemanticError {
        for (String id : lista_id) {
            if (!tabela_simbolos.containsKey(id)) {
                throw new SemanticError(id + " não declarado");
            }
            String[] tipoIdentificador = tabela_simbolos.get(id);
            String tipo = tipoIdentificador[0];
            codigo_objeto.add("call string [mscorlib]System.Console::ReadLine()\n");
            codigo_objeto.add("stloc " + id + "\n");
        }
        lista_id.clear();
    }
    
    private void metodo_acao128(Token token) throws SemanticError{
		String tipoExpressao = (String) pilha_tipos.pop();
		for(int i= 0; i < lista_id.size(); i++) {
			codigo_objeto.add("dup \n");
		}
		for(String id : lista_id) {
			if(!tabela_simbolos.containsKey(id)) {
				throw new SemanticError(id + " não declarado", token.getPosition());
			} 
			String[] tipoIdentificador = tabela_simbolos.get(id);
			if (tipoIdentificador != null && tipoIdentificador.length > 1 && tipoIdentificador[1] != null && tipoIdentificador[1].equals("const")) {
				throw new SemanticError("Não é possível atribuir valor a uma constante: " + id, token.getPosition());
			}
			
			if (tipoExpressao.equals("int64")) {
				codigo_objeto.add("conv.i8 \n");
			}
			
			codigo_objeto.add("stloc " + id + " \n");
		}
		
		lista_id.clear();
	}

	private void metodo_acao127(Token token) throws SemanticError{
		for (String id : lista_id) {
			if(tabela_simbolos.containsKey(id)) {
				throw new SemanticError(token.getLexeme() + "ja declarado", token.getPosition());
			}
		}
		for (String id : lista_id) {
			String tipo;
			if (id.startsWith("_i")) {
	            tipo = "int64";
	        } else if (id.startsWith("_f")) {
	            tipo = "float64";
	        } else if (id.startsWith("_s")) {
	            tipo = "string";
	        } else if (id.startsWith("_b")) {
	            tipo = "bool";
	        } else {
	            throw new SemanticError(id + " não é um identificador", token.getPosition());
	        }
			
			String[] tipoIdentificador = new String[2];
			tipoIdentificador[0] = tipo;
			tabela_simbolos.put(id, tipoIdentificador);
			codigo_objeto.add(".locals (" + tipo + " " + id + ") \n");
			
		}
		
		lista_id.clear();
		
	}

	private void metodo_acao126(Token token) throws SemanticError{
		for (String id : lista_id) {
			if(tabela_simbolos.containsKey(id)) {
				throw new SemanticError(token.getLexeme() + "ja declarado", token.getPosition());
			}
		}
			for (String id : lista_id) {
				String tipo;
		        if (id.startsWith("_i")) {
		            tipo = "int64";
		        } else if (id.startsWith("_f")) {
		            tipo = "float64";
		        } else if (id.startsWith("_s")) {
		            tipo = "string";
		        } else if (id.startsWith("_b")) {
		            tipo = "bool";
		        } else {
		            throw new SemanticError(id + " não é um identificador", token.getPosition());
		        }
		        
		        String[] tipoIdentificador = new String[2];
		        tipoIdentificador[0] = tipo;
		        tipoIdentificador[1] = token.getLexeme();
		        tabela_simbolos.put(id, tipoIdentificador);
			}
		lista_id.clear();
		
	}

	private void metodo_acao125(Token token) {
		lista_id.add(token.getLexeme());
	}

	private void metodo_acao124(Token token) throws SemanticError {
		Object tipoExpressao = pilha_tipos.pop();
    	if(!tipoExpressao.equals("bool")) {
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
    	String rotulo2 = "novo_rotulo" + contador_rotulos++;
    	codigo_objeto.add("brfalse " + rotulo2  + "\n"); //removido + contador_rotulos++
    	pilha_rotulos.push(rotulo2); //removido + contador_rotulos
	}
	

	private void metodo_acao121() {
		// TODO Auto-generated method stub
		String rotulo = "novo_rotulo" + contador_rotulos++;
		codigo_objeto.add(rotulo + ": " + "\n"); //removido + contador_rotulos++ 
		pilha_rotulos.push(rotulo); //removido + contador_rotulos
	}

	private void metodo_acao119() {
		// TODO Auto-generated method stub
		codigo_objeto.add(pilha_rotulos.pop() + ": " + "\n");
	}

	private void metodo_acao120() {
		// TODO Auto-generated method stub
		String rotulo = "novo_rotulo" + contador_rotulos++;
		codigo_objeto.add("br " + rotulo + "\n"); // removido: + contador_rotulos++ 
		String rotulo2 = (String) pilha_rotulos.pop();
		codigo_objeto.add(rotulo2 + ": " + "\n");
		pilha_rotulos.add(rotulo); //removido: + contador_rotulos
		}

	private void metodo_acao118(Token token) throws SemanticError {
		// TODO Auto-generated method stub
		if(!pilha_tipos.pop().equals("bool")) {
			throw new SemanticError ("expressao incompativel em comando de selecao", token.getPosition());
		}
    	String rotulo = "novo_rotulo" + contador_rotulos ++;
    	codigo_objeto.add("brfalse " + rotulo + "\n"); //removido  + contador_rotulos++
    	pilha_rotulos.push(rotulo); //removido  + contador_rotulos
	}

	private void metodo_acao117() {
	    Object tipoExpressao = pilha_tipos.pop();

	    if (tipoExpressao.equals("int64")) {
	        codigo_objeto.add("ldc.i8 -1 \n");
	        codigo_objeto.add("mul \n");
	        pilha_tipos.add("int64");
	    } else if (tipoExpressao.equals("float64")) {
	        codigo_objeto.add("ldc.r8 -1.0 \n");
	        codigo_objeto.add("mul \n");
	        pilha_tipos.add("float64");
	    }
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
            codigo_objeto.add("ceq \n");
            break;
        case "!=":
            codigo_objeto.add("ceq \n ldc.i4.0 \n ceq \n");
            break;
        case "<":
            codigo_objeto.add("clt \n");
            break;
        case ">":
            codigo_objeto.add("cgt \n");
            break;
        case "<=":
            codigo_objeto.add("clt \n ldc.i4.0 \n ceq \n");
            break;
        case ">=":
            codigo_objeto.add("cgt \n ldc.i4.0 \n ceq \n");
            break;
        default:
            break;
    }
		pilha_tipos.push("bool");
	}

	private void metodo_acao107() {
		// TODO Auto-generated method stub
		codigo_objeto.add("ldc.i4.1 \n xor \n" );
	}

	private void metodo_acao111() {
	    Object e1 = pilha_tipos.pop();
	    Object e2 = pilha_tipos.pop();
	    if ("int64".equals(e1) && "int64".equals(e2)) {
	        codigo_objeto.add("sub \n");
	        pilha_tipos.add("int64");
	    } else {
	        codigo_objeto.add("sub \n");
	        pilha_tipos.add("float64");
	    }
	}

	private void metodo_acao110() {
	    Object e1 = pilha_tipos.pop();
	    Object e2 = pilha_tipos.pop();
	    if ("int64".equals(e1) && "int64".equals(e2)) {
	        codigo_objeto.add("add \n");
	        pilha_tipos.add("int64");
	    } else {
	        codigo_objeto.add("add \n");
	        pilha_tipos.add("float64");
	    }
	}

	private void metodo_acao112() {
	    Object e1 = pilha_tipos.pop();
	    Object e2 = pilha_tipos.pop();
	    if ("int64".equals(e1) && "int64".equals(e2)) {
	        codigo_objeto.add("mul \n");
	        pilha_tipos.add("int64");
	    } else {
	        codigo_objeto.add("mul \n");
	        pilha_tipos.add("float64");
	    }
	}

	private void metodo_acao113() {
	    Object e1 = pilha_tipos.pop();
	    Object e2 = pilha_tipos.pop();
	    if ("int64".equals(e1) && "int64".equals(e2)) {
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
		pilha_tipos.push("bool");
		codigo_objeto.add("or \n");
		
	}

	private void metodo_acao103() {
		// TODO Auto-generated method stub
		pilha_tipos.pop();
		pilha_tipos.pop();
		pilha_tipos.push("bool");
		codigo_objeto.add("and \n");
		
	}

	private void metodo_acao116(Token token) {
		// TODO Auto-generated method stub
		pilha_tipos.push("string");
		codigo_objeto.add("ldstr " + token.getLexeme() + "\n");
	}

	private void metodo_acao106() {
		// TODO Auto-generated method stub
		pilha_tipos.push("bool");
		codigo_objeto.add("ldc.i4.0 \n");
	}

	private void metodo_acao105() {
		// TODO Auto-generated method stub
		pilha_tipos.push("bool");
		codigo_objeto.add("ldc.i4.1 \n");
	}

	private void metodo_acao115(Token token) {
		// TODO Auto-generated method stub
		pilha_tipos.add("float64");
		codigo_objeto.add("ldc.r8 " + token.getLexeme() + "\n");
	}

	private void metodo_acao114(Token token) {
		// TODO Auto-generated method stub
		pilha_tipos.push("float64");
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
		System.out.println(codigo_objeto);
		//for (int i = 0; i<codigo_objeto.size(); i++) {
		//	System.out.print(codigo_objeto.get(i));	
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