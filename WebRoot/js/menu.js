function getLocation(){
	var tmp=document.all.tags("meta");
	var title;
	for(i=0;i<tmp.length;i++){
		if(tmp[i].name=="keywords"){
			title=tmp[i].content;
			break;
		}
	}
	return title;
}

function menuSelect(){
	var title=getLocation();
//	alert(title);
	if(title==null){return;}
	var menu=title.toLowerCase().substring(0,title.indexOf(","));
	if(menu==="") {menu=title;}
	var obj=document.getElementById(menu+"menutd");
//	alert(menu+"menutd");
//	alert(obj);
	obj.className="Ms-phnavmidc0sel";
}

function subMenuSelect(){
	var title=getLocation();
	if(title.indexOf(",")===-1) {return;}
	var menu=title.toLowerCase().substring(title.indexOf(",")+1);
	if(menu!=="") {
	var obj=document.getElementById(menu+"submenutd");
//	alert(menu+"menutd");
//	alert(obj);
	obj.className="Ms-phnavmidc1Sel";
	}
}