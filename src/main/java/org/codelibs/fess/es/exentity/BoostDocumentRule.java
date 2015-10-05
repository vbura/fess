package org.codelibs.fess.es.exentity;

import org.codelibs.fess.es.bsentity.BsBoostDocumentRule;

/**
 * @author FreeGen
 */
public class BoostDocumentRule extends BsBoostDocumentRule {

    private static final long serialVersionUID = 1L;

    @Override
    public String getId() {
        return asDocMeta().id();
    }

    @Override
    public void setId(final String id) {
        asDocMeta().id(id);
    }

    public Long getVersionNo() {
        return asDocMeta().version();
    }

    public void setVersionNo(final Long version) {
        asDocMeta().version(version);
    }
}