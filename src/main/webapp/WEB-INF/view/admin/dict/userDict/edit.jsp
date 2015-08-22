<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fess | <bean:message key="labels.dict_userdict_configuration" /></title>
<jsp:include page="/WEB-INF/view/common/admin2/head.jsp"></jsp:include>
</head>
<body class="skin-blue sidebar-mini">
    <div class="wrapper">
	<jsp:include page="/WEB-INF/view/common/admin2/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/view/common/admin2/sidebar.jsp">
	    <jsp:param name="menuCategoryType" value="crawl" />
	    <jsp:param name="menuType" value="dict" />
	</jsp:include>
	<div class="content-wrapper">

	    <%-- Content Header --%>
	    <section class="content-header">
		<h1>
		    <bean:message key="labels.dict_userdict_title" />
		</h1>
	    </section>

	    <section class="content">

		<%-- Form --%>
		<la:form>
		    <la:hidden property="crudMode" />
		    <la:hidden property="dictId" />
		    <c:if test="${crudMode==2}">
			<la:hidden property="id" />
		    </c:if>
		    <div class="row">
			<div class="col-md-12">
			    <div class="box">
				<%-- Box Header --%>
				<div class="box-header with-border">
				    <h3 class="box-title">
					<c:if test="${crudMode == 1}">
					    <bean:message key="labels.dict_userdict_link_create" />
					</c:if>
					<c:if test="${crudMode == 2}">
					    <bean:message key="labels.dict_userdict_link_update" />
					</c:if>
				    </h3>
				    <div class="box-tools pull-right">
					<span class="label label-default">
					    <la:link href="../index">
						<bean:message key="labels.dict_list_link" />
					    </la:link>
					</span>
					<span class="label label-default">
					    <la:link href="index?dictId=${f:u(dictId)}">
						<bean:message key="labels.dict_userdict_list_link" />
					    </la:link>
					</span>
					<c:if test="${crudMode == 1}">
					    <span class="label label-default">
						<a href="#">
						    <bean:message key="labels.dict_userdict_link_create" />
						</a>
					    </span>
					</c:if>
					<c:if test="${crudMode == 2}">
					    <span class="label label-default">
						<a href="#">
						    <bean:message key="labels.dict_userdict_link_update" />
						</a>
					    </span>
					</c:if>
					<c:if test="${crudMode == 3}">
					    <span class="label label-default">
						<a href="#">
						    <bean:message key="labels.dict_userdict_link_delete" />
						</a>
					    </span>
					</c:if>
					<c:if test="${crudMode == 4}">
					    <span class="label label-default">
						<a href="#">
						    <bean:message key="labels.dict_userdict_link_confirm" />
						</a>
					    </span>
					</c:if>
					<span class="label label-default">
					    <la:link href="downloadpage?dictId=${f:u(dictId)}">
						<bean:message key="labels.dict_userdict_link_download" />
					    </la:link>
					</span>
					<span class="label label-default">
					    <la:link href="uploadpage?dictId=${f:u(dictId)}">
						<bean:message key="labels.dict_userdict_link_upload" />
					    </la:link>
					</span>
				    </div>
				</div>
				<%-- Box Body --%>
				<div class="box-body">
				    <%-- Message --%>
				    <div>
					<la:info id="msg" message="true">
					    <div class="alert-message info">
						<bean:write name="msg" ignore="true" />
					    </div>
					</la:info>
					<la:errors />
				    </div>

				    <%-- Form Fields --%>
				    <div class="form-group">
					<label for="token"><bean:message key="labels.dict_userdict_token" /></label>
					<la:text property="token" styleClass="form-control" />
				    </div>
				    <div class="form-group">
					<label for="segmentation"><bean:message key="labels.dict_userdict_segmentation" /></label>
					<la:text property="segmentation" styleClass="form-control" />
				    </div>
				    <div class="form-group">
					<label for="reading"><bean:message key="labels.dict_userdict_reading" /></label>
					<la:text property="reading" styleClass="form-control" />
				    </div>
				    <div class="form-group">
					<label for="pos"><bean:message key="labels.dict_userdict_pos" /></label>
					<la:text property="pos" styleClass="form-control" />
				    </div>
				</div>
				<%-- Box Footer --%>
				<div class="box-footer">
				    <c:if test="${crudMode == 1}">
					<input type="submit" class="btn" name="back" value="<bean:message key="labels.key_match_button_back"/>" />
					<input type="submit" class="btn btn-primary" name="confirmfromcreate"
					       value="<bean:message key="labels.key_match_button_create"/>"
										/>
				    </c:if>
				    <c:if test="${crudMode == 2}">
					<input type="submit" class="btn" name="back" value="<bean:message key="labels.key_match_button_back"/>" />
					<input type="submit" class="btn btn-primary" name="confirmfromupdate"
					       value="<bean:message key="labels.key_match_button_confirm"/>"
					/>
				    </c:if>
				</div>
			    </div>
			</div>
		    </div>
		</la:form>

	    </section>
	</div>

	<jsp:include page="/WEB-INF/view/common/admin2/footer.jsp"></jsp:include>
    </div>
    <jsp:include page="/WEB-INF/view/common/admin2/foot.jsp"></jsp:include>
</body>
</html>
