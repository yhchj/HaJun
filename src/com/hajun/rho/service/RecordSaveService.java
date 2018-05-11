package com.hajun.rho.service;

import com.hajun.rho.model.LifePattern;
import com.hajun.rho.repository.RecordExecute;

public class RecordSaveService {
	
	
	public int saveLifePattern(LifePattern lifePattern) {
		RecordExecute recordExecute = new RecordExecute();
		return recordExecute.insertLifePattern(lifePattern);
	}
}
