package com.v5ent.generate.appender;

import com.v5ent.generate.config.AppenderConfig;
import com.v5ent.generate.model.FileVo;

public interface BaseAppender {
	
	public abstract FileVo doInvoke(AppenderConfig appender);
}
