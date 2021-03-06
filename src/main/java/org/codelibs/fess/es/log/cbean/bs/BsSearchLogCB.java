package org.codelibs.fess.es.log.cbean.bs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codelibs.fess.es.log.allcommon.EsAbstractConditionBean;
import org.codelibs.fess.es.log.bsentity.dbmeta.SearchLogDbm;
import org.codelibs.fess.es.log.cbean.SearchLogCB;
import org.codelibs.fess.es.log.cbean.cq.SearchLogCQ;
import org.codelibs.fess.es.log.cbean.cq.bs.BsSearchLogCQ;
import org.dbflute.cbean.ConditionQuery;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author ESFlute (using FreeGen)
 */
public class BsSearchLogCB extends EsAbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsSearchLogCQ _conditionQuery;
    protected HpSpecification _specification;

    // ===================================================================================
    //                                                                             Control
    //                                                                             =======
    @Override
    public SearchLogDbm asDBMeta() {
        return SearchLogDbm.getInstance();
    }

    @Override
    public String asTableDbName() {
        return "search_log";
    }

    @Override
    public boolean hasSpecifiedColumn() {
        return _specification != null;
    }

    @Override
    public ConditionQuery localCQ() {
        return doGetConditionQuery();
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    public SearchLogCB acceptPK(String id) {
        assertObjectNotNull("id", id);
        BsSearchLogCB cb = this;
        cb.query().docMeta().setId_Equal(id);
        return (SearchLogCB) this;
    }

    @Override
    public void acceptPrimaryKeyMap(Map<String, ? extends Object> primaryKeyMap) {
        acceptPK((String)primaryKeyMap.get("_id"));
    }

    // ===================================================================================
    //                                                                               Build
    //                                                                               =====

    @Override
    public SearchRequestBuilder build(SearchRequestBuilder builder) {
        if (_conditionQuery != null) {
            QueryBuilder queryBuilder = _conditionQuery.getQuery();
            if (queryBuilder != null) {
                builder.setQuery(queryBuilder);
            }
            _conditionQuery.getFieldSortBuilderList().forEach(sort -> {
                builder.addSort(sort);
            });
        }

        if (_specification != null) {
            builder.setFetchSource(_specification.columnList.toArray(new String[_specification.columnList.size()]), null);
        }

        return builder;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    public BsSearchLogCQ query() {
        assertQueryPurpose();
        return doGetConditionQuery();
    }

    protected BsSearchLogCQ doGetConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = createLocalCQ();
        }
        return _conditionQuery;
    }

    protected BsSearchLogCQ createLocalCQ() {
        return new SearchLogCQ();
    }

    // ===================================================================================
    //                                                                             Specify
    //                                                                             =======
    public HpSpecification specify() {
        assertSpecifyPurpose();
        if (_specification == null) {
            _specification = new HpSpecification();
        }
        return _specification;
    }

    protected void assertQueryPurpose() {
    }

    protected void assertSpecifyPurpose() {
    }

    public static class HpSpecification {
        private List<String> columnList = new ArrayList<>();

        private void doColumn(String name) {
            columnList.add(name);
        }

        public void columnId() {
            doColumn("_id");
        }

        public void columnAccessType() {
            doColumn("accessType");
        }
        public void columnUser() {
            doColumn("user");
        }
        public void columnRoles() {
            doColumn("roles");
        }
        public void columnQueryId() {
            doColumn("queryId");
        }
        public void columnClientIp() {
            doColumn("clientIp");
        }
        public void columnHitCount() {
            doColumn("hitCount");
        }
        public void columnQueryOffset() {
            doColumn("queryOffset");
        }
        public void columnQueryPageSize() {
            doColumn("queryPageSize");
        }
        public void columnReferer() {
            doColumn("referer");
        }
        public void columnRequestedAt() {
            doColumn("requestedAt");
        }
        public void columnResponseTime() {
            doColumn("responseTime");
        }
        public void columnQueryTime() {
            doColumn("queryTime");
        }
        public void columnSearchWord() {
            doColumn("searchWord");
        }
        public void columnUserAgent() {
            doColumn("userAgent");
        }
        public void columnUserInfoId() {
            doColumn("userInfoId");
        }
        public void columnUserSessionId() {
            doColumn("userSessionId");
        }
    }
}
