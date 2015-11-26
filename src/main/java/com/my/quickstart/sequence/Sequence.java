/**
 * 
 */
package com.my.quickstart.sequence;

/**
 * @author Alan
 * 
 */
public interface Sequence {

	/**
	 * 取得序列下一个值
	 * 
	 * @return 返回序列下一个值
	 * @throws SequenceException
	 */
	long nextValue() throws SequenceException;
}
