<%@page import="com.cts.spring.boot.rest.api.demo.entity.TxnType" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<section>
	
	<h3>Income Statement</h3>
	
	<c:choose>
		<c:when test="${txns==null || txns.isEmpty() }">
			<p><strong>No Records To Display</strong>
		</c:when>
		<c:otherwise>
			<table style="border:1px solid #000000;width:80%;margin:auto;">
				<thead>
					<tr>
						<th>Txn#</th>
						<th>Date</th>
						<th>Description</th>
						<th>Credit</th>
						<th>Debit</th>					
						<th>ACTION</th>	
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${txns }">
						<tr>
							<td style="text-align:right">${t.txnId }</td>
							<td>${t.txnDate }</td>
							<td>${t.description }</td>
							<td style="text-align:right">${t.type==TxnType.CREDIT?String.valueOf(t.amount):""}</td>
							<td style="text-align:right">${t.type==TxnType.DEBIT?String.valueOf(t.amount):""}</td>
							<td>
								<a href="/txns/edit?txnId=${t.txnId }">EDIT</a> <span> | </span>
								<a href="/txns/del?txnId=${t.txnId }">DELETE</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</section>
<jsp:include page="/footer" />