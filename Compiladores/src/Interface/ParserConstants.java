package Interface;

public interface ParserConstants
{
    int START_SYMBOL = 37;

    int FIRST_NON_TERMINAL    = 37;
    int FIRST_SEMANTIC_ACTION = 71;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  1, -1, -1, -1, -1, -1, -1, -1, -1,  1,  1, -1,  1,  1, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  3, -1, -1, -1, -1, -1, -1, -1, -1,  3,  3, -1,  3,  3, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  4, -1, -1, -1, -1, -1, -1, -1, -1,  7,  5, -1,  6,  8, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, 13, 13, 13, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 15, 16, 17, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, 23, 21, -1, 22, 24, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 28, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 35, 35, 35, 35, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, 35, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, 35, 35, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 45, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 46, 46, 46, 46, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, 46, -1, -1, -1, 46, -1, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, 46, 46, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, -1, -1, 47, 47, -1, -1, -1, 47, -1, -1, -1, -1, -1, -1, -1, -1, -1, 49 },
        { -1, 50, 50, 50, 50, -1, -1, -1, 52, -1, -1, -1, -1, -1, -1, 51, -1, -1, -1, 53, -1, -1, -1, -1, 50, -1, -1, -1, -1, -1, -1, -1, 50, 50, -1, -1 },
        { -1, 54, 54, 54, 54, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, -1, -1, 54, 54, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 55, -1, -1, 55, 55, -1, -1, -1, 55, -1, -1, 56, 56, 56, 56, -1, -1, -1, 55 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 57, 58, 59, 60, -1, -1, -1, -1 },
        { -1, 61, 61, 61, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 61, -1, -1, -1, -1, -1, -1, -1, 61, 61, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 62, 62, -1, -1, -1, 62, -1, -1, 62, 62, 62, 62, 63, 64, -1, 62 },
        { -1, 65, 65, 65, 65, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 65, -1, -1, -1, -1, -1, -1, -1, 65, 65, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 66, 68, -1, 66, 66, -1, -1, -1, 66, -1, -1, 66, 66, 66, 66, 66, 66, 67, 66 },
        { -1, 69, 70, 71, 72, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 73, -1, -1, -1, -1, -1, -1, -1, 74, 75, -1, -1 },
        { -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, 41, 41, -1, 41, 41, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 43, -1, -1, -1, -1, -1, -1, -1, -1, 43, 43, -1, 43, 43, -1, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 171,  10,  13,  27,  38,  28, 172 },
        {  40,  39 },
        {   0 },
        {  38 },
        {  42,  41,  22 },
        {  46,  22 },
        {  52,  22 },
        {  55,  22 },
        {  57,  22 },
        {  24,  44 },
        {   0 },
        {  23,  58 },
        {   2,  43 },
        {   0 },
        {  21,  42 },
        {   3 },
        {   4 },
        {   5 },
        {  16 },
        {   9 },
        {  47,  22 },
        {  46,  22 },
        {  52,  22 },
        {  55,  22 },
        {  57,  22 },
        {  42,  23,  58 },
        {  12,  25,  48,  26 },
        {   5,  49 },
        {  42,  50 },
        {  21,  42,  51 },
        {   0 },
        {  22,  48 },
        {   0 },
        {  22,  48 },
        {  14,  25,  53,  26 },
        {  58, 173,  54 },
        {   0 },
        {  21,  53 },
        {  11,  25,  58,  26, 189,  27,  69,  28,  56, 190 },
        {   0 },
        { 191,   8,  27,  69,  28 },
        {  45,  70 },
        {   0 },
        {  69 },
        { 192,  17,  25,  58,  26, 193,   7,  27,  69,  28, 194 },
        { 192,  15,  27,  69,  28,  17,  25,  58,  26, 195 },
        {  60,  59 },
        {   0 },
        {  18,  60, 174,  59 },
        {  36,  60, 175,  59 },
        {  61 },
        {  16, 176 },
        {   9, 177 },
        {  20,  60, 178 },
        {  64,  62 },
        {   0 },
        {  63, 179,  64, 180 },
        {  29 },
        {  30 },
        {  31 },
        {  32 },
        {  66,  65 },
        {   0 },
        {  33,  66, 181,  65 },
        {  34,  66, 182,  65 },
        {  68,  67 },
        {   0 },
        {  35,  68, 183,  67 },
        {  19,  68, 184,  67 },
        {   2 },
        {   3, 185 },
        {   4, 186 },
        {   5, 187 },
        {  25,  58,  26 },
        {  33,  68 },
        {  34,  68, 188 }
    };

    String[] PARSER_ERROR =
    {
        "",
        "Era esperado fim de programa",
        "Era esperado id",
        "Era esperado constanteI",
        "Era esperado constanteF",
        "Era esperado constanteS",
        "Era esperado palavra_reservada",
        "Era esperado do",
        "Era esperado else",
        "Era esperado false",
        "Era esperado fun",
        "Era esperado if",
        "Era esperado in",
        "Era esperado main",
        "Era esperado out",
        "Era esperado repeat",
        "Era esperado true",
        "Era esperado while",
        "Era esperado \"&\"",
        "Era esperado \"/\"",
        "Era esperado \"!\"",
        "Era esperado \",\"",
        "Era esperado \";\"",
        "Era esperado \"=\"",
        "Era esperado \":\"",
        "Era esperado \"(\"",
        "Era esperado \")\"",
        "Era esperado \"{\"",
        "Era esperado \"}\"",
        "Era esperado \"==\"",
        "Era esperado \"!=\"",
        "Era esperado \"<\"",
        "Era esperado \">\"",
        "Era esperado \"+\"",
        "Era esperado \"-\"",
        "Era esperado \"*\"",
        "Era esperado \"|\"",
        "<program> inv�lido",
        "<lista_instrucoes> inv�lido",
        "<lista_instrucoes1> inv�lido",
        "<instrucao> inv�lido",
        "<instrucao1> inv�lido",
        "<lista_id> inv�lido",
        "<lista_id1> inv�lido",
        "<valor> inv�lido",
        "<cmd> inv�lido",
        "<cmd_entrada> inv�lido",
        "<cmd_atribuicao> inv�lido",
        "<lista_entrada> inv�lido",
        "<lista_entrada1> inv�lido",
        "<lista_entrada2> inv�lido",
        "<lista_entrada3> inv�lido",
        "<cmd_saida> inv�lido",
        "<lista_expressoes> inv�lido",
        "<lista_expressoes1> inv�lido",
        "<cmd_selecao> inv�lido",
        "<cmd_selecao1> inv�lido",
        "<cmd_repeticao> inv�lido",
        "<expressao> inv�lido",
        "<expressao_> inv�lido",
        "<elemento> inv�lido",
        "<relacional> inv�lido",
        "<relacional_> inv�lido",
        "<operador_relacional> inv�lido",
        "<aritmetica> inv�lido",
        "<aritmetica_> inv�lido",
        "<termo> inv�lido",
        "<termo_> inv�lido",
        "<fator> inv�lido",
        "<lista_cmd> inv�lido",
        "<lista_cmd1> inv�lido"
    };
}
