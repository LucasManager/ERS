function allChecks(obj){
	var elements=setBookingCtnStatusForm.elements.tags("input");
	for(i=0;i<elements.length;i++){
		if(elements[i].type=="checkbox") {
			elements[i].checked=obj.checked;
		}
	}
}
function fnSubmit(){
	if (confirm(setBookingCtnStatusForm.confirmStr.value+"?")==false){
			return false;
    }
    var elements=setBookingCtnStatusForm.elements.tags("input");
    var count=0;
    var ctnNbr="";
	for(i=0;i<elements.length;i++){
		if(elements[i].type=="checkbox" && elements[i].name=="ctnID" ) {
			if(elements[i].checked) {
				count++;
				ctnNbr=eval("setBookingCtnStatusForm.ctnnbr"+elements[i].value).value;
//				alert(ctnNbr);
				if(!chkCtnNbr(ctnNbr)){
					alert(setBookingCtnStatusForm.ctnNbrErr.value);
					return false;
				}
			}
		}
	}
	if(count==0) {
		alert(setBookingCtnStatusForm.uncheckedStr.value);
		return false;
	}
    return true;
}

function fnPrint(){
	if (confirm(setBookingCtnStatusForm.confirmStr.value+"?")==false){
			return false;
    }
    var elements=setBookingCtnStatusForm.elements.tags("input");
    var count=0;
    var ctnNbr="";
	for(i=0;i<elements.length;i++){
	    //alert(elements[i].name);
		if(elements[i].name=="PrintID" ) {
		    if(elements[i].checked) {
				//alert("ok");
				count++;
			}
		}
	}
	
	if(count==0) {
		alert(setBookingCtnStatusForm.uncheckedStr.value);
		return false;
	}
    return true;
}

function fnSubmitStatus(){
	if(setBookingStatusForm.remark.value.length>100){
		alert(document.getElementById("remarkMaxLenStr").value);
		return false;
	}
	if (confirm(setBookingCtnStatusForm.confirmStr.value+"?")==false){
			return false;
    }
	//link_setRemark.href=link_setRemark.href+setBookingCtnStatusForm.remark.value;
	//link_setRemark.click();
	return true;
}

function showCtnList(divID){
	var obj=document.getElementById(divID);
	if(obj.style.display=="none"){
		obj.style.display="block";
	}else{
		obj.style.display="none";	
	}
}

function chkCtnNbr(ctnNbr){
	if(ctnNbr.length>0){
		if(ctnNbr.length<10){return false;}
		if(ctnNbr.match(/[A-Za-z]{4}[\d]{6,7}/)==null){
		return false;
		}
	}
	return true;
}
function distributionDepot(blnumber){
	document.getElementById("distr").setAttribute("disabled", "true");
	var f = document.createElement("form");
	var i = document.createElement("input");
	document.body.appendChild(f);
	f.action="distributionDepot.do";
	i.name = "blnumber";
	i.type="hidden";
	i.value=blnumber;
	f.appendChild(i);
	f.submit();
}