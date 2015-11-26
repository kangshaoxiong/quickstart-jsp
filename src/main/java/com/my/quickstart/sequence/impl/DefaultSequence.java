package com.my.quickstart.sequence.impl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.my.quickstart.sequence.Sequence;
import com.my.quickstart.sequence.SequenceDao;
import com.my.quickstart.sequence.SequenceException;
import com.my.quickstart.sequence.SequenceRange;
/**
 * 
 * @author Alan
 *
 */
public class DefaultSequence implements Sequence {
	private final Lock lock = new ReentrantLock();
	/**
	 * 序列编码，保证唯一
	 */
	private String code;

	private volatile SequenceRange currentRange;

	private SequenceDao sequenceDao;

	public long nextValue() throws SequenceException {
		if (currentRange == null) {
			lock.lock();
			try {
				if (currentRange == null) {
					currentRange = sequenceDao.nextRange(code);
				}
			} finally {
				lock.unlock();
			}
		}

		long value = currentRange.getAndIncrement();
		if (value == -1) {
			lock.lock();
			try {
				for (;;) {
					if (currentRange.isOver()) {
						currentRange = sequenceDao.nextRange(code);
					}

					value = currentRange.getAndIncrement();
					if (value == -1) {
						continue;
					}

					break;
				}
			} finally {
				lock.unlock();
			}
		}

		if (value < 0) {
			throw new SequenceException("Sequence value overflow, value = " + value);
		}

		return value;
	}

	public SequenceDao getSequenceDao() {
		return sequenceDao;
	}

	public void setSequenceDao(SequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
