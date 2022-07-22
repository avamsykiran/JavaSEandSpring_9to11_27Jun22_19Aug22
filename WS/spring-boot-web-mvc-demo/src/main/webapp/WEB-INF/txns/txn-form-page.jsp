<%@page import="com.cts.spring.boot.web.mvc.demo.entity.TxnType" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="/header" />
<section style="border:1px solid black;padding:10px;margin:auto;width:40%">
	
	<h3>Transaction</h3>
	
	<form:form method="POST" modelAttribute="txn">
		<div>
			<form:label path="txnId">Txn Id</form:label>
			<form:input path="txnId" readonly="true"/>
		</div>	
		<div>
			<form:label path="description">Description</form:label>
			<form:input path="description" />
			<form:errors path="description"></form:errors>
		</div>	
		<div>
			<form:label path="type">Type</form:label>
			<form:select path="type">
				<form:option value="">---SELECT---</form:option>
				<form:options items="${TxnType.values() }"/>
			</form:select>
			<form:errors path="description"></form:errors>
		</div>	
		<div>
			<form:label path="amount">Amount</form:label>
			<form:input path="amount" type="number"/>
			<form:errors path="amount"></form:errors>
		</div>	
		<div>
			<form:label path="txnDate">Date</form:label>
			<form:input path="txnDate" type="date"/>
			<form:errors path="txnDate"></form:errors>
		</div>	
		<div style="text-align:right">
			<button>SAVE</button>
		</div>
		
	</form:form>
</section>
<jsp:include page="/footer" />