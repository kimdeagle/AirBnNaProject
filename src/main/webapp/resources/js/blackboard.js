
$(document).ready(function () {
	
	//add > 이미지 파일명 출력
	$("#image").on("change", function() {
		
		//초기화
		$("#imagename").text("");
		
		for (var i=0; i<$("#image")[0].files.length; i++) {
			//console.log($("#image")[0].files[i].name);
			$("#imagename").append($("#image")[0].files[i].name + "<br>");
		}
		
	});

	//add > 신고대상회원 버튼 클릭
	$("#btnSearch").click(function() {

		//Reset keyword and tblResult's tbody
		$("#tblResult tbody").html("");
		$("#keyword").val("");
		
		//open searchModal
		$('#searchModal').modal('show');
	});
	
	//add > after open searchModal
	$("#searchModal").on('shown.bs.modal', function() {
		$("#keyword").focus();
	});

	//add > searchModal > enter
	$("#keyword").keyup(function () {
		if (event.keyCode == 13) {
			
			//remove whitespace
			trim();
			
			//is whitespace?
			if ($("#keyword").val() == "") {
				alert("검색어를 입력해주세요.");
				$("#keyword").focus();
				return;
			}
			
			getSearchResult();
		}
	});

	//add > searchModal > 검색 버튼 클릭
	$("#btnSearchResult").click(function () {
		
		//remove whitespace
		trim();

		//is whitespace?
		if ($("#keyword").val() == "") {
			alert("검색어를 입력해주세요.");
			$("#keyword").focus();
			return;
		}
		
		getSearchResult();
	});

	//remove whitespace
	function trim() {
		$("#keyword").val($.trim($("#keyword").val()));		
	}
	
	//add > searchModal > 신고대상회원 검색 결과 호출
	function getSearchResult() {
		$.ajax({
			type: "GET",
			url: "/bnna/member/board/blackboard/searchmember.action",
			data: "condition=" + $("#condition").val() + "&keyword=" + $("#keyword").val(),
			dataType: "json",
			success: function(result) {
				$("#tblResult tbody").html("");
				
				var n = 1;
				
				$(result).each(function(index, item) {
					
					console.log(item.name);
					
					let temp = "";
					
					temp += "<tr>";
					temp += "<td><input type='radio' id='select"+ n +"' name='select' value="+ item.seq +"></td>";
					temp += "<td><label for='select"+ n +"'>"+ item.name +"</td>";
					temp += "<td><label for='select"+ n +"'>"+ item.id +"</td>";
					temp += "</tr>";
					
					$("#tblResult tbody").append(temp);
					
					n++;
					
				});
				
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		});
	}
	
	//add > searchModal > 선택 버튼 클릭
	$("#choice").click(function() {
		
		//get seq, name id
		var target = $("#tblResult tbody tr input[type=radio]:checked");
		var seq = target.val();
		var name = target.parent().next().text();
		var id = target.parent().next().next().text();
		
		//print seq, name, id
		$("#seqIssueMember").val(seq);	
		$("#issueMemberInfo").text(name + " ("+ id +")");
		
		//close searchModal
		$("#searchModal").modal('hide');
		
	});
	
	//신고대상회원 검색하지 않은경우 submit 막기
	$("#add").submit(function(event) {
		if ($("#issueMemberInfo").text() == "") {
			alert("신고대상회원을 검색해주세요.");
			event.preventDefault();
		}
	});

	//view > 댓글 추가
	$("#addcmt").click(function() {
		
		$.ajax({
			type: "GET",
			url: "/bnna/member/board/blackboard/addcmt.action",
			dataType: "json",
			data: "seq=" + $("#seq").val() + "&content=" + $("#commentContent").val(),
			success: function(result) {
				$(result).each(function(index, item) {
					$("#tblComment tbody").append("<tr><td>"+ item.name +" ("+ item.id +")</td><td>"+ item.content +"</td><td>"+ item.regdate +"</td></tr>");					
				});
				$("#commentContent").val("");
				$("#commentContent").focus();
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		});

	});
	
	
});
