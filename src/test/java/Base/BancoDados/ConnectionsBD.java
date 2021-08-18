package Base.BancoDados;

import Base.BaseUtil;
import utilities.Property;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.testng.Assert.fail;

public class ConnectionsBD {

    public static Connection conexao;

    public static ConnectionsBD action() {
        return new ConnectionsBD();
    }

    public static Connection getConnectionBD() {
        try {
            Properties prop = Property.getProp();
            String ambiente = prop.getProperty("ambiente");

            Connection conn = null;

            if(ambiente.equals("DEV")) {
                Class.forName("org.postgresql.Driver");
                String connUrl = "jdbc:postgresql://pgsql-dev1:5432/dbveragifin";
                conn = DriverManager.getConnection(connUrl, "rl_dbveragifin_adm", "rl_dbveragifin_admdev");
            }
            if(ambiente.equals("HML")) {
                Class.forName("org.postgresql.Driver");
                String connUrl = "jdbc:postgresql://pgsql-hom1:5432/dbveragifin";
                conn = DriverManager.getConnection(connUrl, "rl_dbveragifin_adm", "rl_dbveragifin_admhom");
            }

            return conn;
        } catch (Exception var2) {
            System.out.println(var2);
            BaseUtil.action()
                    .Report("FAIL", false, "", false, null, "Banco de Dados: " + var2.getMessage() + " - Falha", false);
            fail("Erro no BD:" + var2.getMessage());
            return null;
        }
    }

    public static Connection getConexao() {
        return conexao;
    }

    public static void setConexao(Connection conexao) {
        ConnectionsBD.conexao = conexao;
    }

    public static void closeConnection(Connection conexao) throws SQLException {
        ConnectionsBD.conexao.close();
    }


}

