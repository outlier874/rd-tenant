<%@ page import="commerce.Merchant" %>



<div class="fieldcontain ${hasErrors(bean: merchantInstance, field: 'domain', 'error')} ">
	<label for="domain">
		<g:message code="merchant.domain.label" default="Domain" />
		
	</label>
	<g:textField name="domain" value="${merchantInstance?.domain}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: merchantInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="merchant.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${merchantInstance?.name}"/>
</div>

