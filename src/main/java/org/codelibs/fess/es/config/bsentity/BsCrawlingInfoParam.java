package org.codelibs.fess.es.config.bsentity;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

import org.codelibs.fess.es.config.allcommon.EsAbstractEntity;
import org.codelibs.fess.es.config.bsentity.dbmeta.CrawlingInfoParamDbm;

/**
 * ${table.comment}
 * @author ESFlute (using FreeGen)
 */
public class BsCrawlingInfoParam extends EsAbstractEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final long serialVersionUID = 1L;
    protected static final Class<?> suppressUnusedImportLocalDateTime = LocalDateTime.class;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** crawlingInfoId */
    protected String crawlingInfoId;

    /** createdTime */
    protected Long createdTime;

    /** key */
    protected String key;

    /** value */
    protected String value;

    // [Referrers] *comment only

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    public CrawlingInfoParamDbm asDBMeta() {
        return CrawlingInfoParamDbm.getInstance();
    }

    @Override
    public String asTableDbName() {
        return "crawling_info_param";
    }

    // ===================================================================================
    //                                                                              Source
    //                                                                              ======
    @Override
    public Map<String, Object> toSource() {
        Map<String, Object> sourceMap = new HashMap<>();
        if (crawlingInfoId != null) {
            sourceMap.put("crawlingInfoId", crawlingInfoId);
        }
        if (createdTime != null) {
            sourceMap.put("createdTime", createdTime);
        }
        if (key != null) {
            sourceMap.put("key", key);
        }
        if (value != null) {
            sourceMap.put("value", value);
        }
        return sourceMap;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(crawlingInfoId);
        sb.append(dm).append(createdTime);
        sb.append(dm).append(key);
        sb.append(dm).append(value);
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public String getCrawlingInfoId() {
        checkSpecifiedProperty("crawlingInfoId");
        return convertEmptyToNull(crawlingInfoId);
    }

    public void setCrawlingInfoId(String value) {
        registerModifiedProperty("crawlingInfoId");
        this.crawlingInfoId = value;
    }

    public Long getCreatedTime() {
        checkSpecifiedProperty("createdTime");
        return createdTime;
    }

    public void setCreatedTime(Long value) {
        registerModifiedProperty("createdTime");
        this.createdTime = value;
    }

    public String getKey() {
        checkSpecifiedProperty("key");
        return convertEmptyToNull(key);
    }

    public void setKey(String value) {
        registerModifiedProperty("key");
        this.key = value;
    }

    public String getValue() {
        checkSpecifiedProperty("value");
        return convertEmptyToNull(value);
    }

    public void setValue(String value) {
        registerModifiedProperty("value");
        this.value = value;
    }
}
