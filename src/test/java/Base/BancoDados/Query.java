package Base.BancoDados;

public class Query {
    public static Query action() {
        return new Query();
    }

    public StringBuilder retornaNumeroStatusEdiLoader123() {
        StringBuilder sql = new StringBuilder("SELECT id_edi, nr_status ")
                .append("FROM invoice_draft.tb_eletronic_data_interchange_edi WHERE nr_status = 1 or nr_status = 2 or nr_status = 3 ORDER BY ts_created_date desc fetch FIRST 1 ROWS ONLY");
        return sql;
    }

    public StringBuilder retornaNumeroUltimoStatusEdiLoader4(int id) {
        StringBuilder sql = new StringBuilder("SELECT id_edi, nr_status ")
                .append("FROM invoice_draft.tb_eletronic_data_interchange_edi WHERE id_edi = " + id + " ORDER BY ts_created_date desc fetch FIRST 1 ROWS ONLY");
        return sql;
    }
    public StringBuilder retornaNumeroNSA(int number) {
        StringBuilder sql = new StringBuilder("SELECT nr_nsa ")
                .append("FROM payment.tb_treasury_trea WHERE nr_nsa = " + number);
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_invoice_draft_indr() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("invoice_draft.tb_invoice_draft_indr");
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_invoice_invo() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("invoice_draft.tb_invoice_invo CASCADE");
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_bordero_revision_brdr() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("prepayment.tb_bordero_revision_brdr");
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_prepayment_operation_history_pohi() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("prepayment.tb_prepayment_operation_history_pohi");
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_bordero_bord() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("prepayment.tb_bordero_bord CASCADE");
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_prepayment_operation_draft_podr() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("prepayment.tb_prepayment_operation_draft_podr CASCADE");
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_prepayment_operation_prop() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("prepayment.tb_prepayment_operation_prop CASCADE");
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_potential_draft_podr() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("prepayment.tb_potential_draft_podr");
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_potential_values_pova() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("prepayment.tb_potential_values_pova");
        return sql;
    }

    public StringBuilder limpaBaseDados_tb_potential_pote() {
        StringBuilder sql = new StringBuilder("truncate table ")
                .append("prepayment.tb_potential_pote CASCADE");
        return sql;
    }

    public StringBuilder retornaIdPayerDirect(String payer) {
        StringBuilder sql = new StringBuilder("select id_payer ")
                .append("from prepayment.tb_payer_paye where st_name = '" + payer + "'");
        return sql;
    }

    public StringBuilder returnStatusAfterDirect(String idDuplicate) {
        StringBuilder sql = new StringBuilder("select id_invoice_draft_status ")
                .append("from invoice_draft.tb_invoice_draft_indr where st_invoice_draft_number = '" + idDuplicate + "'");
        return sql;
    }

    public StringBuilder retornaIdPayerSt_PrefixDirect(int id_payer) {
        StringBuilder sql = new StringBuilder("select id_financier_payer, st_edi_prefix ")
                .append("from prepayment.tb_financier_payer_fipa where id_payer = " + id_payer);
        return sql;
    }

    public StringBuilder retornaIdFinancierPayerDirect(String nickPayer, int id_financier_payer) {
        StringBuilder sql = new StringBuilder("update prepayment.tb_financier_payer_fipa ")
                .append("set st_edi_prefix = '1111111@2222222@" + nickPayer + "' where id_financier_payer =" + id_financier_payer);
        return sql;
    }

    public StringBuilder retornaIdFinancierPayerDirectNoPrefix(String nickPayer, int id_financier_payer) {
        StringBuilder sql = new StringBuilder("update prepayment.tb_financier_payer_fipa ")
                .append("set st_edi_prefix = '" + "' where id_financier_payer =" + id_financier_payer);
        return sql;
    }

    public StringBuilder returnIdOccurrence(String idBank, String StatusOcorrencia) {
        StringBuilder sql = new StringBuilder("select st_bank_issuetype ")
                .append("from global_parameter.tb_bank_issuetype_bait where id_bank = '" + idBank + "' and st_status = '" + StatusOcorrencia + "'");
        return sql;
    }

}