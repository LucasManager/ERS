//var date=new Date();
//var month=date.getMonth()+1;
//month="0"+month;
//month=month.substr(month.length-2);
//var curdate=date.getYear()+'-'+month+'-'+date.getDate();
function addCtn(){
	var selObj=setBookingCtnForm.ctntypeSelect;
	var ctnCode=selObj.value;
	var intlCode=selObj.options[selObj.selectedIndex].text;
	var key=intlCode;
	var ctnID=key;
	var chkboxName="attribute("+key+"_checked)";
	var ctnCodeName="attribute("+key+"_ctnCode)";
	var intlCodeName="attribute("+key+"_intlCode)";
	var ctnQtyName="attribute("+key+"_ctnQty)";	
//	var depotCodeName="attribute("+key+"_depotCode)";	
	
	var tbNode = ctntable;
	var trNode=document.createElement("TR");
    var tdNode1=document.createElement("TD");
    var tdNode2=document.createElement("TD");
    var tdNode3=document.createElement("TD");
    var tdNode4=document.createElement("TD");
    tdNode1.innerHTML="<input type='checkbox' checked='true' name='"+chkboxName+"' value='on'/>";
 	tdNode2.innerHTML="<input type='text' name='"+ctnCodeName+"' maxlength='10' size='8' readonly='readonly' value='"+ctnCode+"' class='inputbox' >";
 	tdNode3.innerHTML="<input type='text' name='"+intlCodeName+"' maxlength='5' size='5' readonly='readonly' value='"+intlCode+"'  class='inputbox' >";
    tdNode4.innerHTML="<input type='text' name='"+ctnQtyName+"' maxlength='3' size='3' value='1' class='inputbox' >";

    tdNode1.align="left";
    trNode.appendChild(tdNode1);
    trNode.appendChild(tdNode2);
    trNode.appendChild(tdNode3);
    trNode.appendChild(tdNode4);
    tbNode.tBodies[0].appendChild(trNode);

	selObj.remove(selObj.selectedIndex);
	selObj.options[0].selected=true;
}

function allChecks(obj){
	var elements=setBookingCtnForm.elements.tags("input");
	for(i=0;i<elements.length;i++){
		if(elements[i].type=="checkbox") {
			elements[i].checked=obj.checked;
		}
	}
}
function fnSubmit(){
	if (confirm(setBookingCtnForm.confirmStr.value+"?")==false){
			return false;
    }
//    var elements=setBookingCtnForm.elements.tags("input");
//	for(i=0;i<elements.length;i++){
//		if(elements[i].type=="checkbox") {
//			alert(setBookingCtnForm.attribute(1_ctnQty).value);
//		}
//	}
    
    return true;
}

