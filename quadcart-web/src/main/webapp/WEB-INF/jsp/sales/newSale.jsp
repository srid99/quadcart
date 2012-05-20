<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp" %>
<div id="outer_wrapper" >
	<div id="leftPane">
		Search: <input type="text" name="Search" />
		<h2><b>Product Results </b></h2>
		<div id="resultsPane" >
			<div >
				<div >
					Product name |
					Manufacturer |
					0.0 |
					<input type="button" value="add" />
				</div>
			</div>
		</div>
	</div>
	<div id="rightPane">
	<h2><b>Cart</b></h2>
		<table>
			<thead>
				<tr>
					<th >S.No</th>
					<th >Name</th>
					<th >Qty</th>
					<th >Price</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Product name</td>
					<td><input type="text" value="1" size="2"/></td>
					<td>1.0</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>