

//이미지 파일명 출력
$("#image").on("change", function() {
	
	$("#imagename").text("");
	
	for (var i=0; i<$("#image")[0].files.length; i++) {
		//console.log($("#image")[0].files[i].name);
		$("#imagename").append($("#image")[0].files[i].name + "<br>");
	}
	
});

//searchModal Open
$("#btnSearch").click(function() {
	$('#searchModal').modal('show');	
});
	
	