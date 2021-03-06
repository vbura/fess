package org.codelibs.fess.es.log.bsentity;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

import org.codelibs.fess.es.log.allcommon.EsAbstractEntity;
import org.codelibs.fess.es.log.bsentity.dbmeta.FavoriteLogDbm;

/**
 * ${table.comment}
 * @author ESFlute (using FreeGen)
 */
public class BsFavoriteLog extends EsAbstractEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final long serialVersionUID = 1L;
    protected static final Class<?> suppressUnusedImportLocalDateTime = LocalDateTime.class;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** createdAt */
    protected LocalDateTime createdAt;

    /** url */
    protected String url;

    /** docId */
    protected String docId;

    /** queryId */
    protected String queryId;

    /** userInfoId */
    protected String userInfoId;

    // [Referrers] *comment only

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    public FavoriteLogDbm asDBMeta() {
        return FavoriteLogDbm.getInstance();
    }

    @Override
    public String asTableDbName() {
        return "favorite_log";
    }

    // ===================================================================================
    //                                                                              Source
    //                                                                              ======
    @Override
    public Map<String, Object> toSource() {
        Map<String, Object> sourceMap = new HashMap<>();
        if (createdAt != null) {
            sourceMap.put("createdAt", createdAt);
        }
        if (url != null) {
            sourceMap.put("url", url);
        }
        if (docId != null) {
            sourceMap.put("docId", docId);
        }
        if (queryId != null) {
            sourceMap.put("queryId", queryId);
        }
        if (userInfoId != null) {
            sourceMap.put("userInfoId", userInfoId);
        }
        return sourceMap;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(createdAt);
        sb.append(dm).append(url);
        sb.append(dm).append(docId);
        sb.append(dm).append(queryId);
        sb.append(dm).append(userInfoId);
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public LocalDateTime getCreatedAt() {
        checkSpecifiedProperty("createdAt");
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime value) {
        registerModifiedProperty("createdAt");
        this.createdAt = value;
    }

    public String getUrl() {
        checkSpecifiedProperty("url");
        return convertEmptyToNull(url);
    }

    public void setUrl(String value) {
        registerModifiedProperty("url");
        this.url = value;
    }

    public String getDocId() {
        checkSpecifiedProperty("docId");
        return convertEmptyToNull(docId);
    }

    public void setDocId(String value) {
        registerModifiedProperty("docId");
        this.docId = value;
    }

    public String getQueryId() {
        checkSpecifiedProperty("queryId");
        return convertEmptyToNull(queryId);
    }

    public void setQueryId(String value) {
        registerModifiedProperty("queryId");
        this.queryId = value;
    }

    public String getUserInfoId() {
        checkSpecifiedProperty("userInfoId");
        return convertEmptyToNull(userInfoId);
    }

    public void setUserInfoId(String value) {
        registerModifiedProperty("userInfoId");
        this.userInfoId = value;
    }
}
