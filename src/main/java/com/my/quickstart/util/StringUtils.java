/**
 * 
 */
package com.my.quickstart.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class StringUtils extends org.apache.commons.lang3.StringUtils {
    
    public static final String ALL_NUMBER_VALUE = "0123456789";
    public static final String ALL_LOWERCASE_VALUE = "abcdefghijklmnopqrstuvwxyz";
    public static final String ALL_UPPERCASE_VALUE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
	/**
	 * 全角转半角
	 * 
	 * @param input
	 * @return
	 */
	public static String toDBC(String input) {
		if (isEmpty(input)) {
			return "";
		}
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '\u3000') {
				c[i] = ' ';
			} else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
				c[i] = (char) (c[i] - 65248);
			}
		}
		String returnString = new String(c);
		return returnString;
	}

	/**
	 * 去除前后空格后，判断是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyWithTrim(String str) {
		return isEmpty(trim(str));
	}

	/**
	 * 按逗号进行split，返回字符串型的集合
	 * 
	 * @param str
	 * @return
	 */
	public static List<String> splitToStrList(String str) {
		return split(str, ',', new TypeConvertor<String>() {
			@Override
			public String convert(String str) {
				return str;
			}
		});
	}

	/**
	 * 按逗号进行split，返回长整型的集合
	 * 
	 * @param str
	 * @return
	 */
	public static List<Long> splitToLongList(String str) {
		return split(str, ',', new TypeConvertor<Long>() {
			@Override
			public Long convert(String str) {
				if (isEmpty(str)) {
					return null;
				}
				return Long.parseLong(str);
			}
		});
	}

	/**
	 * 按照默认的字符，进行对字符串做split，返回一个预知类型的List对象
	 * 
	 * @param str
	 * @param separatorChar
	 * @return str为empty时返回null
	 */
	public static <T> List<T> split(String str, char separatorChar,
			TypeConvertor<T> typeConvertor) {
		if (isEmptyWithTrim(str)) {
			return null;
		}

		String[] strs = split(str, separatorChar);
		if (strs == null || strs.length == 0) {
			return null;
		}
		List<T> list = new ArrayList<T>();
		for (String tmp : strs) {
			list.add(typeConvertor.convert(trim(tmp)));
		}
		return list;
	}

	public interface TypeConvertor<T> {
		public T convert(String str);
	}

	/**
	 * 除去字符串头尾部的指定字符，如果字符串是<code>null</code>，依然返回<code>null</code>。
	 * 
	 * <pre>
	 * StringUtil.trim(null, *)          = null
	 * StringUtil.trim("", *)            = ""
	 * StringUtil.trim("abc", null)      = "abc"
	 * StringUtil.trim("  abc", null)    = "abc"
	 * StringUtil.trim("abc  ", null)    = "abc"
	 * StringUtil.trim(" abc ", null)    = "abc"
	 * StringUtil.trim("  abcyx", "xyz") = "  abc"
	 * </pre>
	 * 
	 * @param str
	 *            要处理的字符串
	 * @param stripChars
	 *            要除去的字符，如果为<code>null</code>表示除去空白字符
	 * 
	 * @return 除去指定字符后的的字符串，如果原字串为<code>null</code>，则返回<code>null</code>
	 */
	public static String trim(String str, String stripChars) {
		return trim(str, stripChars, 0);
	}

	/**
	 * 除去字符串头尾部的指定字符，如果字符串是<code>null</code>，依然返回<code>null</code>。
	 * 
	 * <pre>
	 * StringUtil.trim(null, *)          = null
	 * StringUtil.trim("", *)            = ""
	 * StringUtil.trim("abc", null)      = "abc"
	 * StringUtil.trim("  abc", null)    = "abc"
	 * StringUtil.trim("abc  ", null)    = "abc"
	 * StringUtil.trim(" abc ", null)    = "abc"
	 * StringUtil.trim("  abcyx", "xyz") = "  abc"
	 * </pre>
	 * 
	 * @param str
	 *            要处理的字符串
	 * @param stripChars
	 *            要除去的字符，如果为<code>null</code>表示除去空白字符
	 * @param mode
	 *            <code>-1</code>表示trimStart，<code>0</code>表示trim全部，
	 *            <code>1</code>表示trimEnd
	 * 
	 * @return 除去指定字符后的的字符串，如果原字串为<code>null</code>，则返回<code>null</code>
	 */
	private static String trim(String str, String stripChars, int mode) {
		if (str == null) {
			return null;
		}

		int length = str.length();
		int start = 0;
		int end = length;

		// 扫描字符串头部
		if (mode <= 0) {
			if (stripChars == null) {
				while ((start < end)
						&& (Character.isWhitespace(str.charAt(start)))) {
					start++;
				}
			} else if (stripChars.length() == 0) {
				return str;
			} else {
				while ((start < end)
						&& (stripChars.indexOf(str.charAt(start)) != -1)) {
					start++;
				}
			}
		}

		// 扫描字符串尾部
		if (mode >= 0) {
			if (stripChars == null) {
				while ((start < end)
						&& (Character.isWhitespace(str.charAt(end - 1)))) {
					end--;
				}
			} else if (stripChars.length() == 0) {
				return str;
			} else {
				while ((start < end)
						&& (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
					end--;
				}
			}
		}

		if ((start > 0) || (end < length)) {
			return str.substring(start, end);
		}

		return str;
	}

	/**
	 * 除去字符串头尾部的空白，如果字符串是<code>null</code>，则返回空字符串<code>""</code>。
	 * 
	 * <p>
	 * 注意，和<code>String.trim</code>不同，此方法使用<code>Character.isWhitespace</code>
	 * 来判定空白， 因而可以除去英文字符集之外的其它空白，如中文空格。
	 * 
	 * <pre>
	 * StringUtil.trim(null, *)          = ""
	 * StringUtil.trim("", *)            = ""
	 * StringUtil.trim("abc", null)      = "abc"
	 * StringUtil.trim("  abc", null)    = "abc"
	 * StringUtil.trim("abc  ", null)    = "abc"
	 * StringUtil.trim(" abc ", null)    = "abc"
	 * StringUtil.trim("  abcyx", "xyz") = "  abc"
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param str
	 *            要处理的字符串
	 * 
	 * @return 除去空白的字符串，如果原字串为<code>null</code>或结果字符串为<code>""</code>，则返回
	 *         <code>null</code>
	 */
	public static String trimToEmpty(String str, String stripChars) {
		String result = trim(str, stripChars);

		if (result == null) {
			return "";
		}

		return result;
	}

	public static Boolean hasSpecialCharacter(String input) {
		String regEx = "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		return p.matcher(input).find();
	}

	public static String getNotNullString(Object o) {
		if (o == null) {
			return "";
		}
		return String.valueOf(o);
	}

	public static String getDefaultString(Object o, String def) {
		if (o == null) {
			return def;
		}
		return String.valueOf(o);
	}

	public static boolean isEmpty(String... strings) {
		for (String str : strings) {
			if (StringUtils.isEmpty(str)) {
				return true;
			}
		}
		return false;
	}
	
    public static String createNumberRandom(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length cannot be less than 1");
        }
        int vLen = ALL_NUMBER_VALUE.length();
        String result = "";
        for (int i = 1; i <= length; i++) {
            double dr = Math.random() * vLen;
            int ir = (int) Math.floor(dr);
            result += ALL_NUMBER_VALUE.charAt(ir);
        }
        return result;
    }

    public static String createUppercaseRandom(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length cannot be less than 1");
        }
        int vLen = ALL_UPPERCASE_VALUE.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            double dr = Math.random() * vLen;
            int ir = (int) Math.floor(dr);
            result += ALL_UPPERCASE_VALUE.charAt(ir);
        }
        return result;
    }

    public static String createLowercaseRandom(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length cannot be less than 1");
        }
        int vLen = ALL_LOWERCASE_VALUE.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            double dr = Math.random() * vLen;
            int ir = (int) Math.floor(dr);
            result += ALL_LOWERCASE_VALUE.charAt(ir);
        }
        return result;
    }

    public static String createMixRandom(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length cannot be less than 1");
        }
        String values = ALL_NUMBER_VALUE + ALL_UPPERCASE_VALUE + ALL_LOWERCASE_VALUE;
        int vLen = values.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            double dr = Math.random() * vLen;
            int ir = (int) Math.floor(dr);
            result += values.charAt(ir);
        }
        return result;
    }

	public static void main(String[] args) {
		String nick = "abc!def";
		System.out.println(toDBC(nick));
		System.out.println(hasSpecialCharacter(nick));
	}
}
