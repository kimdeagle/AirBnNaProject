
$(document).ready(function () {
	
	//add > 이미지 파일명 출력
	$("#image").on("change", function() {
		
		$("#imagename").text("");
		
		for (var i=0; i<$("#image")[0].files.length; i++) {
			//console.log($("#image")[0].files[i].name);
			$("#imagename").append($("#image")[0].files[i].name + "<br>");
		}
		
	});

	//add > searchModal Open
	$("#btnSearch").click(function() {
		$('#searchModal').modal('show');	
	});

	//add > searchModal > 검색창에서 엔터
	$("#keyword").keyup(function () {
		if (event.keyCode == 13) {
			getSearchResult();
		}
	});

	//add > searchModal > 검색 버튼 클릭
	$("#btnSearchResult").click(function () {
		getSearchResult();
	});

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
					temp += "<td><input type='radio' id='select"+ n +"' name='select' value="+ item.seq +"</td>";
					temp += "<td><label for='select"+ n +"'>"+ item.id +"</td>";
					temp += "<td><label for='select"+ n +"'>"+ item.name +"</td>";
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
	
});
