package Base.BancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseUtilBD {
    public static BaseUtilBD action() {
        return new BaseUtilBD();
    }

    public ResultSet consultaBanco(Connection conexao, String query) throws Exception {
        try {
            PreparedStatement comando = conexao.prepareStatement(query);
            ResultSet executeQuery = comando.executeQuery();
            return executeQuery;
        }
        catch (Exception e)
        {
            String txt1 = e.getMessage() + "|" + e.getStackTrace().toString();
        }
        return null;
    }
}
