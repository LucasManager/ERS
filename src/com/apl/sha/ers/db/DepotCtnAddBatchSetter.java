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

public class DepotCtnAddBatchSetter implements BatchPreparedStatementSetter {
	private int batchSize;
	
	private Collection depotCtns;

	private Timestamp updatetime;
	private int userid;
	private String depotcode;
	public DepotCtnAddBatchSetter(Map depotCtns,String depotcode,java.util.Date updatetime,int userid ) {
		this.batchSize = depotCtns.size();
		this.depotCtns = depotCtns.values();
		this.depotcode=depotcode;
		this.updatetime = new Timestamp(updatetime.getTime());
		this.userid = userid;
	}
	public int getBatchSize() {
		return batchSize;
	}

	public void setValues(PreparedStatement ps, int i) throws SQLException {
		DepotCtn ctn=(DepotCtn) depotCtns.toArray()[i];
		ps.setString(1, depotcode);
		ps.setString(2,ctn.getCtnCode());
		ps.setInt(3,ctn.getInitalQty());
        ps.setDate(4, new Date(ctn.getInitalDate().getTime()));
        ps.setTimestamp(5, updatetime);
        ps.setInt(6, userid);
	}
	

}
