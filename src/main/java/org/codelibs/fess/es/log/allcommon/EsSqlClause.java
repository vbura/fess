package org.codelibs.fess.es.log.allcommon;

import org.dbflute.cbean.sqlclause.AbstractSqlClause;
import org.dbflute.dbway.DBWay;

/**
 * @author ESFlute (using FreeGen)
 */
public class EsSqlClause extends AbstractSqlClause {

    private static final long serialVersionUID = 1L;

    public EsSqlClause(String tableDbName) {
        super(tableDbName);
    }

    @Override
    public void lockForUpdate() {
    }

    @Override
    public DBWay dbway() {
        return null;
    }

    @Override
    protected void doFetchFirst() {
    }

    @Override
    protected void doFetchPage() {
    }

    @Override
    protected void doClearFetchPageClause() {
    }

    @Override
    protected String createSelectHint() {
        return null;
    }

    @Override
    protected String createFromBaseTableHint() {
        return null;
    }

    @Override
    protected String createFromHint() {
        return null;
    }

    @Override
    protected String createSqlSuffix() {
        return null;
    }
}
