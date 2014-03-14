package com.fedevela.cadenas;

/**
 *
 * @author fvelazquez
 */
public class CadenasEscape {

    public static void main(String[] args) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*) from prod.beu_pila\n");
        sql.append("where fecha BETWEEN to_date(to_char(sysdate - 1, 'DD/MM/YYYY') || ' 07:00:00')\n");
        sql.append("  and to_date(to_char(sysdate - 1, 'DD/MM/YYYY') || ' 19:00:00', 'DD/MM/YYYY HH24:MI:SS' ) and estatus = 3");
        
        System.out.println( sql.toString() );
    }
}
