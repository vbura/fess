/*
 * Copyright 2009-2015 the CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.codelibs.fess.app.web.admin.dict.kuromoji;

import javax.annotation.Resource;

import org.codelibs.core.misc.DynamicProperties;
import org.codelibs.fess.Constants;
import org.codelibs.fess.annotation.Token;
import org.codelibs.fess.app.pager.KuromojiPager;
import org.codelibs.fess.app.service.KuromojiService;
import org.codelibs.fess.app.web.CrudMode;
import org.codelibs.fess.app.web.admin.suggestelevateword.SuggestElevateWordEditForm;
import org.codelibs.fess.app.web.base.FessAdminAction;
import org.codelibs.fess.helper.SystemHelper;
import org.lastaflute.web.Execute;
import org.lastaflute.web.callback.ActionRuntime;
import org.lastaflute.web.response.HtmlResponse;
import org.lastaflute.web.response.render.RenderData;
import org.lastaflute.web.validation.VaErrorHook;

/**
 * @author Keiichi Watanabe
 */
public class AdminDictKuromojiAction extends FessAdminAction {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    private KuromojiService kuromojiService;
    @Resource
    private KuromojiPager kuromojiPager;
    @Resource
    private SystemHelper systemHelper;
    @Resource
    protected DynamicProperties crawlerProperties;

    // ===================================================================================
    //                                                                               Hook
    //                                                                              ======
    @Override
    protected void setupHtmlData(final ActionRuntime runtime) {
        super.setupHtmlData(runtime);
        runtime.registerData("helpLink", systemHelper.getHelpLink("userDict"));
    }

    // ===================================================================================
    //                                                                      Search Execute
    //                                                                      ==============
    @Execute
    public HtmlResponse index(final SearchForm form) {
        return asHtml(path_AdminDictKuromoji_IndexJsp).renderWith(data -> {
            searchPaging(data, form);
        });
    }

    @Execute
    public HtmlResponse list(final Integer pageNumber, final SearchForm form) {
        kuromojiPager.setCurrentPageNumber(pageNumber);
        return asHtml(path_AdminDictKuromoji_IndexJsp).renderWith(data -> {
            searchPaging(data, form);
        });
    }

    @Execute
    public HtmlResponse search(final SearchForm form) {
        copyBeanToBean(form.searchParams, kuromojiPager, op -> op.exclude(Constants.PAGER_CONVERSION_RULE));
        return asHtml(path_AdminDictKuromoji_IndexJsp).renderWith(data -> {
            searchPaging(data, form);
        });
    }

    @Execute
    public HtmlResponse reset(final SearchForm form) {
        kuromojiPager.clear();
        return asHtml(path_AdminDictKuromoji_IndexJsp).renderWith(data -> {
            searchPaging(data, form);
        });
    }

    @Execute
    public HtmlResponse back(final SearchForm form) {
        return asHtml(path_AdminDictKuromoji_IndexJsp).renderWith(data -> {
            searchPaging(data, form);
        });
    }

    protected void searchPaging(final RenderData data, final SearchForm form) {
        // TODO
    }

    // ===================================================================================
    //                                                                        Edit Execute
    //                                                                        ============
    // -----------------------------------------------------
    //                                            Entry Page
    //                                            ----------
    @Token(save = true, validate = false)
    @Execute
    public HtmlResponse createpage(final EditForm form) {
        form.initialize();
        form.crudMode = CrudMode.CREATE;
        return asHtml(path_AdminDictKuromoji_EditJsp);
    }

    @Token(save = true, validate = false)
    @Execute
    public HtmlResponse editpage(final int crudMode, final String id, final EditForm form) {
        form.crudMode = crudMode;
        form.id = id;
        verifyCrudMode(form, CrudMode.EDIT);
        // TODO loadUserDict(form);
        return asHtml(path_AdminDictKuromoji_EditJsp);
    }

    @Token(save = true, validate = false)
    @Execute
    public HtmlResponse editagain(final EditForm form) {
        return asHtml(path_AdminDictKuromoji_EditJsp);
    }

    @Token(save = true, validate = false)
    @Execute
    public HtmlResponse editfromconfirm(final EditForm form) {
        form.crudMode = CrudMode.EDIT;
        // TODO loadUserDict(form);
        return asHtml(path_AdminDictKuromoji_EditJsp);
    }

    @Token(save = true, validate = false)
    @Execute
    public HtmlResponse deletepage(final int crudMode, final String id, final EditForm form) {
        form.crudMode = crudMode;
        form.id = id;
        verifyCrudMode(form, CrudMode.DELETE);
        // TODO loadUserDict(form);
        return asHtml(path_AdminDictKuromoji_ConfirmJsp);
    }

    @Token(save = true, validate = false)
    @Execute
    public HtmlResponse deletefromconfirm(final EditForm form) {
        form.crudMode = CrudMode.DELETE;
        // TODO loadUserDict(form);
        return asHtml(path_AdminDictKuromoji_ConfirmJsp);
    }

    // -----------------------------------------------------
    //                                               Confirm
    //                                               -------
    @Execute
    public HtmlResponse confirmpage(final int crudMode, final String id, final EditForm form) {
        form.crudMode = crudMode;
        form.id = id;
        verifyCrudMode(form, CrudMode.CONFIRM);
        // TODO loadUserDict(form);
        return asHtml(path_AdminDictKuromoji_ConfirmJsp);
    }

    @Token(save = false, validate = true, keep = true)
    @Execute
    public HtmlResponse confirmfromcreate(final EditForm form) {
        validate(form, messages -> {}, toEditHtml());
        return asHtml(path_AdminDictKuromoji_ConfirmJsp);
    }

    @Token(save = false, validate = true, keep = true)
    @Execute
    public HtmlResponse confirmfromupdate(final EditForm form) {
        validate(form, messages -> {}, toEditHtml());
        return asHtml(path_AdminDictKuromoji_ConfirmJsp);
    }

    // -----------------------------------------------------
    //                                              Download
    //                                               -------
    @Token(save = false, validate = true)
    @Execute
    public HtmlResponse downloadpage(final SearchForm form) {
        return asHtml(path_AdminDictKuromoji_DownloadJsp);
    }

    @Token(save = false, validate = true)
    @Execute
    public HtmlResponse download(final SearchForm form) {
        // TODO Download

        return asHtml(path_AdminDictKuromoji_DownloadJsp);
    }

    // -----------------------------------------------------
    //                                                Upload
    //                                               -------
    @Token(save = false, validate = true)
    @Execute
    public HtmlResponse uploadpage(final UploadForm form) {
        // TODO Upload

        return asHtml(path_AdminDictKuromoji_UploadJsp);
    }

    // -----------------------------------------------------
    //                                         Actually Crud
    //                                         -------------
    @Token(save = false, validate = true)
    @Execute
    public HtmlResponse create(final EditForm form) {
        // TODO
        return redirect(getClass());
    }

    @Token(save = false, validate = true)
    @Execute
    public HtmlResponse update(final EditForm form) {
        // TODO
        return redirect(getClass());
    }

    @Execute
    public HtmlResponse delete(final EditForm form) {
        // TODO
        return redirect(getClass());
    }

    @Token(save = false, validate = true)
    @Execute
    public HtmlResponse upload(final UploadForm form) {
        // TODO
        return redirect(getClass());
    }

    //===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    protected void loadUserDict(final SuggestElevateWordEditForm form) {
        // TODO
    }

    // ===================================================================================
    //                                                                        Small Helper
    //                                                                        ============
    protected void verifyCrudMode(final EditForm form, final int expectedMode) {
        if (form.crudMode != expectedMode) {
            throwValidationError(messages -> {
                messages.addErrorsCrudInvalidMode(GLOBAL, String.valueOf(expectedMode), String.valueOf(form.crudMode));
            }, toEditHtml());
        }
    }

    protected VaErrorHook toEditHtml() {
        return () -> {
            return asHtml(path_AdminDictKuromoji_EditJsp);
        };
    }
}