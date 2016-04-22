var key=0;
var date=new Date();
var month=date.getMonth()+1;
month="0"+month;
month=month.substr(month.length-2);
var curdate=date.getYear()+'-'+month+'-'+date.getDate();
function addCtn(ctnCode,intlCode,ctnQty,depotCode){
	var selObj=setBookingCtnForm.depotCodeSelect;
	//var ctnCode=selObj.value;
	if(key==0){
		key=setBookingCtnForm.ctnCount.value;
	}
	key++;
	var ctnID=key;
	var chkboxName="attribute("+key+"_checked)";
	var ctnCodeName="attribute("+key+"_ctnCode)";
	var intlCodeName="attribute("+key+"_intlCode)";
	var ctnQtyName="attribute("+key+"_ctnQty)";	
	var depotCodeName="attribute("+key+"_depotCode)";	
	
	var tbNode = ctntable;
	var trNode=document.createElement("TR");
    var tdNode1=document.createElement("TD");
    var tdNode2=document.createElement("TD");
    var tdNode3=document.createElement("TD");
    var tdNode4=document.createElement("TD");
    var tdNode5=document.createElement("TD");
    tdNode1.innerHTML="<input type='checkbox' checked='true' name='"+chkboxName+"' value='on'/>";
 	tdNode2.innerHTML="<input type='text' name='"+ctnCodeName+"' maxlength='10' size='8' readonly='readonly' value='"+ctnCode+"' class='inputbox' >";
 	tdNode3.innerHTML="<input type='text' name='"+intlCodeName+"' maxlength='5' size='5' readonly='readonly' value='"+intlCode+"'  class='inputbox' >";
    tdNode4.innerHTML="<input type='text' name='"+ctnQtyName+"' maxlength='5' size='5' value='"+ctnQty+"' class='inputbox' >";
    //tdNode5.innerHTML="<input type='text' name='"+depotCodeName+"' maxlength='5' size='5' value='"+depotCode+"' class='inputbox'>";
    tdNode5.innerHTML="<select name='"+depotCodeName+"' id='"+depotCode+key+"'>"+selObj.innerHTML+"</select>";
//    alert("<select name='"+depotCodeName+"'>"+selObj.innerHTML+"</select>");
	//eval("setBookingCtnForm."+depotCodeName).value=depotCode;
    tdNode1.align="left";
    trNode.appendChild(tdNode1);
    trNode.appendChild(tdNode2);
    trNode.appendChild(tdNode3);
    trNode.appendChild(tdNode4);
    trNode.appendChild(tdNode5);
    tbNode.tBodies[0].appendChild(trNode);
	document.getElementById(depotCode+key).value=depotCode;

//    for(var i=0;selObj.options.length;i++){
//		if(selObj.options[i].selected){
//			selObj.remove(i);
//			selObj.options[0].selected=true;
//			break;
//		}
//    }
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

