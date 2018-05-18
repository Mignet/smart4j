package com.v5ent.mybatis.paginator;

import com.v5ent.mybatis.paginator.domain.PageRequest;
import com.v5ent.mybatis.paginator.domain.PageResponse;

public interface PageSearchHandler {
	public PageResponse getData(PageRequest page);
}
