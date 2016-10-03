<%@tag description='brouwer form' pageEncoding='UTF-8'%>
<%@ attribute name='url' required='true' type='java.lang.String'%>
<%@ attribute name='knopTekst' required='true' type='java.lang.String'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<form:form action='${url}' commandName='brouwer' id='brouwerform'>
	<form:label path='naam'>Naam:<form:errors path='naam' />
	</form:label>
	<form:input path='naam' autofocus='autofocus' required='required' />
	<form:label path='adres.straat'>Straat:
<form:errors path='adres.straat' />
	</form:label>
	<form:input path='adres.straat' required='required' />
	<form:label path='adres.huisNr'>Huisnr.:
<form:errors path='adres.huisNr' />
	</form:label>
	<form:input path='adres.huisNr' required='required' />
	<form:label path='adres.postcode'>Postcode:
<form:errors path='adres.postcode' />
	</form:label>
	<form:input path='adres.postcode' required='required' type='number'
		min='1000' max='9999' />
	<form:label path='adres.gemeente'>Gemeente:
<form:errors path='adres.gemeente' />
	</form:label>
	<form:input path='adres.gemeente' required='required' />
	<form:label path='omzet'>Omzet:<form:errors path='omzet' />
	</form:label>
	<form:input path='omzet' required='required' />
	<input type='submit' value='${knopTekst}' id='submitknop'>
	<script>
		document.getElementById('brouwerform').onsubmit = function() {
			document.getElementById('submitknop').disabled = true;
		};
	</script>
</form:form>