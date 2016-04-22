function smtCfm(obj){
	if (confirm(obj.confirmStr.value+"?")==false){
			return false;
    }
    return true;
}

function smtCfm(){
	var obj=document.getElementById("cfmStr");
	if (confirm(obj.value+"?")==false){
			return false;
    }
    return true;
}

function copyOptions(src,dest){
	copyOptions(src,dest,0);
}

function copyOptions(src,dest,start){
	if(start==null) start=0;
	for(var i=start;i<src.options.length;i++){
		var oOption = document.createElement("OPTION");
		dest.options.add(oOption);
		oOption.innerText = src.options[i].innerText;
		oOption.value = src.options[i].value;
	}
}