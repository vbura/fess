package org.codelibs.fess.es.log.cbean.cq.bs;

import java.time.*;
import java.util.Collection;

import org.codelibs.fess.es.log.allcommon.EsAbstractConditionQuery;
import org.codelibs.fess.es.log.cbean.cq.SearchFieldLogCQ;
import org.dbflute.cbean.ckey.ConditionKey;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.IdsQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.PrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;


/**
 * @author ESFlute (using FreeGen)
 */
public abstract class BsSearchFieldLogCQ extends EsAbstractConditionQuery {

    protected static final Class<?> suppressUnusedImportLocalDateTime = LocalDateTime.class;

    // ===================================================================================
    //                                                                       Name Override
    //                                                                       =============
    @Override
    public String asTableDbName() {
        return "search_field_log";
    }

    @Override
    public String xgetAliasName() {
        return "search_field_log";
    }

    // ===================================================================================
    //                                                                       Query Control
    //                                                                       =============
    public void filtered(FilteredCall<SearchFieldLogCQ, SearchFieldLogCQ> filteredLambda) {
        filtered(filteredLambda, null);
    }

    public void filtered(FilteredCall<SearchFieldLogCQ, SearchFieldLogCQ> filteredLambda,
            ConditionOptionCall<BoolQueryBuilder> opLambda) {
        bool((must, should, mustNot, filter)->{
            filteredLambda.callback(must, filter);
        }, opLambda);
    }

    public void not(OperatorCall<SearchFieldLogCQ> notLambda) {
        not(notLambda, null);
    }

    public void not(final OperatorCall<SearchFieldLogCQ> notLambda, final ConditionOptionCall<BoolQueryBuilder> opLambda) {
        bool((must, should, mustNot, filter) -> notLambda.callback(mustNot), opLambda);
    }

    public void bool(BoolCall<SearchFieldLogCQ> boolLambda) {
        bool(boolLambda, null);
    }

    public void bool(BoolCall<SearchFieldLogCQ> boolLambda, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        SearchFieldLogCQ mustQuery = new SearchFieldLogCQ();
        SearchFieldLogCQ shouldQuery = new SearchFieldLogCQ();
        SearchFieldLogCQ mustNotQuery = new SearchFieldLogCQ();
        SearchFieldLogCQ filterQuery = new SearchFieldLogCQ();
        boolLambda.callback(mustQuery, shouldQuery, mustNotQuery, filterQuery);
        if (mustQuery.hasQueries() || shouldQuery.hasQueries() || mustNotQuery.hasQueries() || filterQuery.hasQueries()) {
            BoolQueryBuilder builder = regBoolCQ(mustQuery.getQueryBuilderList(), shouldQuery.getQueryBuilderList(), mustNotQuery.getQueryBuilderList(), filterQuery.getQueryBuilderList());
            if (opLambda != null) {
                opLambda.callback(builder);
            }
        }
    }

    // ===================================================================================
    //                                                                           Query Set
    //                                                                           =========
    public void setId_Equal(String id) {
        setId_Term(id, null);
    }

    public void setId_Equal(String id, ConditionOptionCall<TermQueryBuilder> opLambda) {
        setId_Term(id, opLambda);
    }

    public void setId_Term(String id) {
        setId_Term(id, null);
    }

    public void setId_Term(String id, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = regTermQ("_id", id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_NotEqual(String id) {
        setId_NotTerm(id, null);
    }

    public void setId_NotTerm(String id) {
        setId_NotTerm(id, null);
    }

    public void setId_NotEqual(String id, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        setId_NotTerm(id, opLambda);
    }

    public void setId_NotTerm(String id, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        not(not -> not.setId_Term(id), opLambda);
    }

    public void setId_Terms(Collection<String> idList) {
        setId_Terms(idList, null);
    }

    public void setId_Terms(Collection<String> idList, ConditionOptionCall<IdsQueryBuilder> opLambda) {
        IdsQueryBuilder builder = regIdsQ(idList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_InScope(Collection<String> idList) {
        setId_Terms(idList, null);
    }

    public void setId_InScope(Collection<String> idList, ConditionOptionCall<IdsQueryBuilder> opLambda) {
        setId_Terms(idList, opLambda);
    }

    public BsSearchFieldLogCQ addOrderBy_Id_Asc() {
        regOBA("_id");
        return this;
    }

    public BsSearchFieldLogCQ addOrderBy_Id_Desc() {
        regOBD("_id");
        return this;
    }

    public void setName_Equal(String name) {
        setName_Term(name, null);
    }

    public void setName_Equal(String name, ConditionOptionCall<TermQueryBuilder> opLambda) {
        setName_Term(name, opLambda);
    }

    public void setName_Term(String name) {
        setName_Term(name, null);
    }

    public void setName_Term(String name, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = regTermQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_NotEqual(String name) {
        setName_NotTerm(name, null);
    }

    public void setName_NotTerm(String name) {
        setName_NotTerm(name, null);
    }

    public void setName_NotEqual(String name, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        setName_NotTerm(name, opLambda);
    }

    public void setName_NotTerm(String name, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        not(not -> not.setName_Term(name), opLambda);
    }

    public void setName_Terms(Collection<String> nameList) {
        setName_Terms(nameList, null);
    }

    public void setName_Terms(Collection<String> nameList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = regTermsQ("name", nameList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_InScope(Collection<String> nameList) {
        setName_Terms(nameList, null);
    }

    public void setName_InScope(Collection<String> nameList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setName_Terms(nameList, opLambda);
    }

    public void setName_Match(String name) {
        setName_Match(name, null);
    }

    public void setName_Match(String name, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = regMatchQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_MatchPhrase(String name) {
        setName_MatchPhrase(name, null);
    }

    public void setName_MatchPhrase(String name, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = regMatchPhraseQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_MatchPhrasePrefix(String name) {
        setName_MatchPhrasePrefix(name, null);
    }

    public void setName_MatchPhrasePrefix(String name, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = regMatchPhrasePrefixQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_Fuzzy(String name) {
        setName_Fuzzy(name, null);
    }

    public void setName_Fuzzy(String name, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = regFuzzyQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_Prefix(String name) {
        setName_Prefix(name, null);
    }

    public void setName_Prefix(String name, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = regPrefixQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_GreaterThan(String name) {
        setName_GreaterThan(name, null);
    }

    public void setName_GreaterThan(String name, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("name", ConditionKey.CK_GREATER_THAN, name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_LessThan(String name) {
        setName_LessThan(name, null);
    }

    public void setName_LessThan(String name, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("name", ConditionKey.CK_LESS_THAN, name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_GreaterEqual(String name) {
        setName_GreaterEqual(name, null);
    }

    public void setName_GreaterEqual(String name, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("name", ConditionKey.CK_GREATER_EQUAL, name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_LessEqual(String name) {
        setName_LessEqual(name, null);
    }

    public void setName_LessEqual(String name, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("name", ConditionKey.CK_LESS_EQUAL, name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsSearchFieldLogCQ addOrderBy_Name_Asc() {
        regOBA("name");
        return this;
    }

    public BsSearchFieldLogCQ addOrderBy_Name_Desc() {
        regOBD("name");
        return this;
    }

    public void setSearchLogId_Equal(String searchLogId) {
        setSearchLogId_Term(searchLogId, null);
    }

    public void setSearchLogId_Equal(String searchLogId, ConditionOptionCall<TermQueryBuilder> opLambda) {
        setSearchLogId_Term(searchLogId, opLambda);
    }

    public void setSearchLogId_Term(String searchLogId) {
        setSearchLogId_Term(searchLogId, null);
    }

    public void setSearchLogId_Term(String searchLogId, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = regTermQ("searchLogId", searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_NotEqual(String searchLogId) {
        setSearchLogId_NotTerm(searchLogId, null);
    }

    public void setSearchLogId_NotTerm(String searchLogId) {
        setSearchLogId_NotTerm(searchLogId, null);
    }

    public void setSearchLogId_NotEqual(String searchLogId, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        setSearchLogId_NotTerm(searchLogId, opLambda);
    }

    public void setSearchLogId_NotTerm(String searchLogId, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        not(not -> not.setSearchLogId_Term(searchLogId), opLambda);
    }

    public void setSearchLogId_Terms(Collection<String> searchLogIdList) {
        setSearchLogId_Terms(searchLogIdList, null);
    }

    public void setSearchLogId_Terms(Collection<String> searchLogIdList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = regTermsQ("searchLogId", searchLogIdList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_InScope(Collection<String> searchLogIdList) {
        setSearchLogId_Terms(searchLogIdList, null);
    }

    public void setSearchLogId_InScope(Collection<String> searchLogIdList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setSearchLogId_Terms(searchLogIdList, opLambda);
    }

    public void setSearchLogId_Match(String searchLogId) {
        setSearchLogId_Match(searchLogId, null);
    }

    public void setSearchLogId_Match(String searchLogId, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = regMatchQ("searchLogId", searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_MatchPhrase(String searchLogId) {
        setSearchLogId_MatchPhrase(searchLogId, null);
    }

    public void setSearchLogId_MatchPhrase(String searchLogId, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = regMatchPhraseQ("searchLogId", searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_MatchPhrasePrefix(String searchLogId) {
        setSearchLogId_MatchPhrasePrefix(searchLogId, null);
    }

    public void setSearchLogId_MatchPhrasePrefix(String searchLogId, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = regMatchPhrasePrefixQ("searchLogId", searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_Fuzzy(String searchLogId) {
        setSearchLogId_Fuzzy(searchLogId, null);
    }

    public void setSearchLogId_Fuzzy(String searchLogId, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = regFuzzyQ("searchLogId", searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_Prefix(String searchLogId) {
        setSearchLogId_Prefix(searchLogId, null);
    }

    public void setSearchLogId_Prefix(String searchLogId, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = regPrefixQ("searchLogId", searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_GreaterThan(String searchLogId) {
        setSearchLogId_GreaterThan(searchLogId, null);
    }

    public void setSearchLogId_GreaterThan(String searchLogId, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("searchLogId", ConditionKey.CK_GREATER_THAN, searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_LessThan(String searchLogId) {
        setSearchLogId_LessThan(searchLogId, null);
    }

    public void setSearchLogId_LessThan(String searchLogId, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("searchLogId", ConditionKey.CK_LESS_THAN, searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_GreaterEqual(String searchLogId) {
        setSearchLogId_GreaterEqual(searchLogId, null);
    }

    public void setSearchLogId_GreaterEqual(String searchLogId, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("searchLogId", ConditionKey.CK_GREATER_EQUAL, searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSearchLogId_LessEqual(String searchLogId) {
        setSearchLogId_LessEqual(searchLogId, null);
    }

    public void setSearchLogId_LessEqual(String searchLogId, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("searchLogId", ConditionKey.CK_LESS_EQUAL, searchLogId);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsSearchFieldLogCQ addOrderBy_SearchLogId_Asc() {
        regOBA("searchLogId");
        return this;
    }

    public BsSearchFieldLogCQ addOrderBy_SearchLogId_Desc() {
        regOBD("searchLogId");
        return this;
    }

    public void setValue_Equal(String value) {
        setValue_Term(value, null);
    }

    public void setValue_Equal(String value, ConditionOptionCall<TermQueryBuilder> opLambda) {
        setValue_Term(value, opLambda);
    }

    public void setValue_Term(String value) {
        setValue_Term(value, null);
    }

    public void setValue_Term(String value, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = regTermQ("value", value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_NotEqual(String value) {
        setValue_NotTerm(value, null);
    }

    public void setValue_NotTerm(String value) {
        setValue_NotTerm(value, null);
    }

    public void setValue_NotEqual(String value, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        setValue_NotTerm(value, opLambda);
    }

    public void setValue_NotTerm(String value, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        not(not -> not.setValue_Term(value), opLambda);
    }

    public void setValue_Terms(Collection<String> valueList) {
        setValue_Terms(valueList, null);
    }

    public void setValue_Terms(Collection<String> valueList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = regTermsQ("value", valueList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_InScope(Collection<String> valueList) {
        setValue_Terms(valueList, null);
    }

    public void setValue_InScope(Collection<String> valueList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setValue_Terms(valueList, opLambda);
    }

    public void setValue_Match(String value) {
        setValue_Match(value, null);
    }

    public void setValue_Match(String value, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = regMatchQ("value", value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_MatchPhrase(String value) {
        setValue_MatchPhrase(value, null);
    }

    public void setValue_MatchPhrase(String value, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = regMatchPhraseQ("value", value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_MatchPhrasePrefix(String value) {
        setValue_MatchPhrasePrefix(value, null);
    }

    public void setValue_MatchPhrasePrefix(String value, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = regMatchPhrasePrefixQ("value", value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_Fuzzy(String value) {
        setValue_Fuzzy(value, null);
    }

    public void setValue_Fuzzy(String value, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = regFuzzyQ("value", value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_Prefix(String value) {
        setValue_Prefix(value, null);
    }

    public void setValue_Prefix(String value, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = regPrefixQ("value", value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_GreaterThan(String value) {
        setValue_GreaterThan(value, null);
    }

    public void setValue_GreaterThan(String value, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("value", ConditionKey.CK_GREATER_THAN, value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_LessThan(String value) {
        setValue_LessThan(value, null);
    }

    public void setValue_LessThan(String value, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("value", ConditionKey.CK_LESS_THAN, value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_GreaterEqual(String value) {
        setValue_GreaterEqual(value, null);
    }

    public void setValue_GreaterEqual(String value, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("value", ConditionKey.CK_GREATER_EQUAL, value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setValue_LessEqual(String value) {
        setValue_LessEqual(value, null);
    }

    public void setValue_LessEqual(String value, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = regRangeQ("value", ConditionKey.CK_LESS_EQUAL, value);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsSearchFieldLogCQ addOrderBy_Value_Asc() {
        regOBA("value");
        return this;
    }

    public BsSearchFieldLogCQ addOrderBy_Value_Desc() {
        regOBD("value");
        return this;
    }

}
