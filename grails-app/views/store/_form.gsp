<%@ page import="commerce.Store" %>



<div class="fieldcontain ${hasErrors(bean: storeInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="store.address.label" default="Address" />
		
	</label>
	<g:textField name="address" value="${storeInstance?.address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: storeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="store.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${storeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: storeInstance, field: 'tenantId', 'error')} required">
	<label for="tenantId">
		<g:message code="store.tenantId.label" default="Tenant Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="tenantId" type="number" value="${storeInstance.tenantId}" required=""/>
</div>

