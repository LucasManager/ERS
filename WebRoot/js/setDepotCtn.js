//var date=new Date();
//var month=date.getMonth()+1;
//month="0"+month;
//month=month.substr(month.length-2);
//var curdate=date.getYear()+'-'+month+'-'+date.getDate();
function addCtn(){
	var selObj=setDepotCtnForm.ctntypeSelect;
	var ctnCode=selObj.value;
	var chkboxName="attribute("+ctnCode+"_checked)";
	var ctnIDName="attribute("+ctnCode+"_id)";
	var ctnID="Add"+ctnCode;
	var initalDateName="attribute("+ctnCode+"_initalDate)";
	var initalQtyName="attribute("+ctnCode+"_initalQty)";	
	var tbNode = ctntable;
	var trNode=document.createElement("TR");
    var tdNode1=document.createElement("TD");
    var tdNode2=document.createElement("TD");
    var tdNode3=document.createElement("TD");
    var tdNode4=document.createElement("TD");
    tdNode1.innerHTML="<input type='checkbox' checked='true' name='"+chkboxName+"' value='on'/>";
 	tdNode2.innerHTML=ctnCode+"<input type='hidden' name='"+ctnIDName+"' value='"+ctnID+"'/>";
 	tdNode3.innerHTML="<input type='text' name='"+initalDateName+"' maxlength='10' size='10' onfocus='showCalendarControl(this);' class='inputbox'>";
    tdNode4.innerHTML="<input type='text' name='"+initalQtyName+"' maxlength='9' size='5' value='0' class='inputbox'>";
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
	var elements=setDepotCtnForm.elements.tags("input");
	for(i=0;i<elements.length;i++){
		if(elements[i].type=="checkbox") {
			elements[i].checked=obj.checked;
		}
	}
}
function fnSubmit(){
	if (confirm(setDepotCtnForm.confirmStr.value+"?")==false){
			return false;
    }
    return true;
}
