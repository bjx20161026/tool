 function Get(){ 
    $.ajax({ 
            async:false,
            type:"get", 
            contentType:"application/json", 
            url:"http://localhost:9180/MyTool/rest/EsbUpload/test", 
//            data:"{}", 
//            dataType:"json", 
            success:function(result){ 
                if(result!=null){ 
                    alert("doGet--->>>"+result);//这里肯定能看到 1 
                    series=JSON.parse(result);   //num 是有值的.... 
                    return result;          
                } 
            } 
      }); 
} 