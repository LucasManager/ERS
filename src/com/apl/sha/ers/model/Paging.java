package com.apl.sha.ers.model;

import java.io.Serializable;

public class Paging implements Serializable{
	int page=1;
	int size=20;
	int total;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPages() {
		return (int)(Math.ceil((double)total/size));
	}
	public int getFirstRow() {
		return (page-1)*size+1;
	}
	public int getLastRow() {
		return page*size;
	}
	public int getBeginPage() {
		if(page>=5) {
			return page-4;
		}else {
			return 1;
		}
	}
	public int getEndPage() {
		if(getPages()<=page+5||getPages()<=getBeginPage()+9) {
			return getPages();
		}else {
			return getBeginPage()+9;
		}
	}
}
