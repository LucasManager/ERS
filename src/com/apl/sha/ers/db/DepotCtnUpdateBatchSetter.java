package com.apl.sha.ers.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.apl.sha.ers.model.DepotCtn;

public class DepotCtnUpdateBatchSetter implements BatchPreparedStatementSetter {
	private int batchSize;
	
	private Collection depotCtns;

	private java.util.Date updatetime;
	private int userid;
	
	public DepotCtnUpdateBatchSetter(List depotCtns,java.util.Date updatetime,int userid) {
		this.batchSize = depotCtns.size();
		this.depotCtns = depotCtns;
		this.updatetime = updatetime;
		this.userid = userid;
	}
	public DepotCtnUpdateBatchSetter(Map depotCtns,java.util.Date updatetime,int userid) {
		this.batchSize = depotCtns.size();
		this.depotCtns = depotCtns.values();
		this.updatetime = updatetime;
		this.userid = userid;
	}
	public int getBatchSize() {
		return batchSize;
	}

	public void setValues(PreparedStatement ps, int i) throws SQLException {
		DepotCtn ctn=(DepotCtn) depotCtns.toArray()[i];
		ps.setInt(1,ctn.getInitalQty());
        ps.setDate(2, new Date(ctn.getInitalDate().getTime()));
        ps.setTimestamp(3, new Timestamp(updatetime.getTime()));
        ps.setInt(4, userid);
        ps.setInt(5,ctn.getId());
	}
	

}
