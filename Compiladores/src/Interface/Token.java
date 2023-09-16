package Interface;

import java.util.HashMap;
import java.util.Map;

public class Token
{
	static final Map<Integer, String> classNames = new HashMap<>();
    private int id;
    private String lexeme;
    private int position;

    public Token(int id, String lexeme, int position)
    {
        this.id = id;
        this.lexeme = lexeme;
        this.position = position;
    }
    
    static {
    	classNames.put(Constants.t_id, "identificador");
    	classNames.put(Constants.t_constanteI, "constante_int");
    	classNames.put(Constants.t_constanteF, "constante_float");
    	classNames.put(Constants.t_constanteS, "constante_string");
    	classNames.put(Constants.t_palavra_reservada, "palavra reservada");
    	classNames.put(Constants.t_do, "palavra reservada");
    	classNames.put(Constants.t_else, "palavra reservada");
    	classNames.put(Constants.t_false, "palavra reservada");
    	classNames.put(Constants.t_fun, "palavra reservada");
    	classNames.put(Constants.t_if, "palavra reservada");
    	classNames.put(Constants.t_in, "palavra reservada");
    	classNames.put(Constants.t_main, "palavra reservada");
    	classNames.put(Constants.t_out, "palavra reservada");
    	classNames.put(Constants.t_repeat, "palavra reservada");
    	classNames.put(Constants.t_true, "palavra reservada");
    	classNames.put(Constants.t_while, "palavra reservada");
    	classNames.put(Constants.t_TOKEN_18, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_19, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_20, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_21, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_22, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_23, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_24, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_25, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_26, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_27, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_28, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_29, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_30, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_31, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_32, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_33, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_34, "símbolo especial");
    	classNames.put(Constants.t_TOKEN_35, "símbolo especial");
    }
    
    public static String getClassName(int classId) {
    	String className = classNames.get(classId);
    	if (className != null) {
    		return className;
    	} else {
    		return ScannerConstants.SCANNER_ERROR[classId];    	
    	}
    }

    public final int getId()
    {
        return id;
    }

    public final String getLexeme()
    {
        return lexeme;
    }

    public final int getPosition()
    {
        return position;
    }
    
    public boolean isErrorToken(Token token) {
    	return token.getId() == Constants.ERROR_TOKEN_ID;
    }

    public String toString()
    {
        return id+" ( "+lexeme+" ) @ "+position;
    };
}
