package com.v5ent.generate.appender;

import com.v5ent.generate.config.AppenderConfig;
import com.v5ent.generate.model.FileVo;

public class FileAppender implements BaseAppender{

	@Override
	public FileVo doInvoke(AppenderConfig appender) {
		FileVo fileVo = new FileVo();
		fileVo.setFileName(appender.getFileName());
		fileVo.setFilePath(appender.getPath());
		fileVo.setTemplateFile(appender.getTemplate());
		return fileVo;
	}
	
}
