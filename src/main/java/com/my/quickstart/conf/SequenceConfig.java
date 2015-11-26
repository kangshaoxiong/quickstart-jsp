package com.my.quickstart.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.my.quickstart.sequence.Sequence;
import com.my.quickstart.sequence.SequenceDao;
import com.my.quickstart.sequence.impl.DefaultSequence;
/**
 * 配置序列值
 * @author Alan
 *
 */
@Configuration
public class SequenceConfig {

	@Autowired
	private SequenceDao sequenceDao;

	@Bean(name="globalSequence")
	public Sequence getGlobalSequence(){
		DefaultSequence sequence=new DefaultSequence();
		sequence.setSequenceDao(sequenceDao);
		sequence.setCode("seq_global_id");
		return sequence;
	}
}
