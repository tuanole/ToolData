package com.mydu.letian.repository;

import com.mydu.letian.entity.Base;

public interface BaseRepositoryCustom {

	public Long getMaxBaseId();
	
	public Base updateBase(Base base);
	
}
