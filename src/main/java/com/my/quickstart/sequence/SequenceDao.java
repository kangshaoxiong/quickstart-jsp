/**
 * 
 */
package com.my.quickstart.sequence;

/**
 * @author Alan
 *
 */
public interface SequenceDao {
	/**
	 * 取得下一个可用的序列区间
	 *
	 * @param code 序列编码
	 * @return 返回下一个可用的序列区间
	 * @throws SequenceException
	 */
	SequenceRange nextRange(String code) throws SequenceException;
}
