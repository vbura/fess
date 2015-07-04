package org.codelibs.fess.es.bsbhv;

import java.util.Map;

import org.codelibs.fess.es.bsentity.AbstractEntity;
import org.codelibs.fess.es.bsentity.AbstractEntity.RequestOptionCall;
import org.codelibs.fess.es.bsentity.dbmeta.RequestHeaderDbm;
import org.codelibs.fess.es.cbean.RequestHeaderCB;
import org.codelibs.fess.es.exentity.RequestHeader;
import org.dbflute.Entity;
import org.dbflute.bhv.readable.CBCall;
import org.dbflute.cbean.ConditionBean;
import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.cbean.result.PagingResultBean;
import org.dbflute.exception.IllegalBehaviorStateException;
import org.dbflute.optional.OptionalEntity;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.index.IndexRequestBuilder;

/**
 * @author FreeGen
 */
public abstract class BsRequestHeaderBhv extends AbstractBehavior<RequestHeader, RequestHeaderCB> {

    @Override
    public String asTableDbName() {
        return "request_header";
    }

    @Override
    protected String asIndexEsName() {
        return ".fess_config";
    }

    @Override
    public RequestHeaderDbm asDBMeta() {
        return RequestHeaderDbm.getInstance();
    }

    @Override
    protected <RESULT extends RequestHeader> RESULT createEntity(Map<String, Object> source, Class<? extends RESULT> entityType) {
        try {
            final RESULT result = entityType.newInstance();
            result.setCreatedBy((String) source.get("createdBy"));
            result.setCreatedTime((Long) source.get("createdTime"));
            result.setId((String) source.get("id"));
            result.setName((String) source.get("name"));
            result.setUpdatedBy((String) source.get("updatedBy"));
            result.setUpdatedTime((Long) source.get("updatedTime"));
            result.setValue((String) source.get("value"));
            result.setWebConfigId((String) source.get("webConfigId"));
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            final String msg = "Cannot create a new instance: " + entityType.getName();
            throw new IllegalBehaviorStateException(msg, e);
        }
    }

    public int selectCount(CBCall<RequestHeaderCB> cbLambda) {
        return facadeSelectCount(createCB(cbLambda));
    }

    public OptionalEntity<RequestHeader> selectEntity(CBCall<RequestHeaderCB> cbLambda) {
        return facadeSelectEntity(createCB(cbLambda));
    }

    protected OptionalEntity<RequestHeader> facadeSelectEntity(RequestHeaderCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends RequestHeader> OptionalEntity<ENTITY> doSelectOptionalEntity(RequestHeaderCB cb, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    @Override
    public RequestHeaderCB newConditionBean() {
        return new RequestHeaderCB();
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return facadeSelectEntity(downcast(cb)).orElse(null);
    }

    public RequestHeader selectEntityWithDeletedCheck(CBCall<RequestHeaderCB> cbLambda) {
        return facadeSelectEntityWithDeletedCheck(createCB(cbLambda));
    }

    public OptionalEntity<RequestHeader> selectByPK(String id) {
        return facadeSelectByPK(id);
    }

    protected OptionalEntity<RequestHeader> facadeSelectByPK(String id) {
        return doSelectOptionalByPK(id, typeOfSelectedEntity());
    }

    protected <ENTITY extends RequestHeader> ENTITY doSelectByPK(String id, Class<? extends ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(id), tp);
    }

    protected RequestHeaderCB xprepareCBAsPK(String id) {
        assertObjectNotNull("id", id);
        return newConditionBean().acceptPK(id);
    }

    protected <ENTITY extends RequestHeader> OptionalEntity<ENTITY> doSelectOptionalByPK(String id, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(id, tp), id);
    }

    @Override
    protected Class<? extends RequestHeader> typeOfSelectedEntity() {
        return RequestHeader.class;
    }

    @Override
    protected Class<RequestHeader> typeOfHandlingEntity() {
        return RequestHeader.class;
    }

    @Override
    protected Class<RequestHeaderCB> typeOfHandlingConditionBean() {
        return RequestHeaderCB.class;
    }

    public ListResultBean<RequestHeader> selectList(CBCall<RequestHeaderCB> cbLambda) {
        return facadeSelectList(createCB(cbLambda));
    }

    public PagingResultBean<RequestHeader> selectPage(CBCall<RequestHeaderCB> cbLambda) {
        // TODO same?
        return (PagingResultBean<RequestHeader>) facadeSelectList(createCB(cbLambda));
    }

    public void insert(RequestHeader entity) {
        doInsert(entity, null);
    }

    public void insert(RequestHeader entity, RequestOptionCall<IndexRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().indexOption(opLambda);
        }
        doInsert(entity, null);
    }

    public void update(RequestHeader entity) {
        doUpdate(entity, null);
    }

    public void update(RequestHeader entity, RequestOptionCall<IndexRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().indexOption(opLambda);
        }
        doUpdate(entity, null);
    }

    public void insertOrUpdate(RequestHeader entity) {
        doInsertOrUpdate(entity, null, null);
    }

    public void insertOrUpdate(RequestHeader entity, RequestOptionCall<IndexRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().indexOption(opLambda);
        }
        doInsertOrUpdate(entity, null, null);
    }

    public void delete(RequestHeader entity) {
        doDelete(entity, null);
    }

    public void delete(RequestHeader entity, RequestOptionCall<DeleteRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().deleteOption(opLambda);
        }
        doDelete(entity, null);
    }

    // TODO create, modify, remove
}