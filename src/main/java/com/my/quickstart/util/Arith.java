package com.my.quickstart.util;

import java.math.BigDecimal;

public class Arith {
		
		/**
		 *@param DEF_DIV_SCALE
		 *定义默认除法运算精度,精度越高，运算结果越精确，但效率会有所降低 
		 */
		//private static final int DEF_DIV_SCALE =6000; 
		
		/** 
		 * 功能：BigDecimal类型的加法运算。 
		 * @param s1 被加数 
		 * @param s2 加数 
		 * @return 两个参数的和 
		 */ 
		public static double add(double s1, double s2) 
		{ 
			BigDecimal b1 = new BigDecimal(Double.toString(s1));	
			BigDecimal b2 = new BigDecimal(Double.toString(s2)); 	
			return b1.add(b2).doubleValue(); 
		} 
		
		/** 
		 * 功能：BigDecimal类型的减法运算。 
		 * @param s1 被减数 
		 * @param s2 减数 
		 * @return 两个参数的差 
		 */ 
		public static double sub(double s1, double s2) 
		{ 
			BigDecimal b1 = new BigDecimal(Double.toString(s1));	
			BigDecimal b2 = new BigDecimal(Double.toString(s2)); 	
			return b1.subtract(b2).doubleValue(); 
		} 
		
		/**
		 * 功能：BigDecimal类型的乘法运算。 
		 * @param s1 被乘数 
		 * @param s2 乘数 
		 * @return 两个参数的积 
		 */ 
		public static double mul(double s1, double s2)
		{ 
			BigDecimal b1 = new BigDecimal(Double.toString(s1));	
			BigDecimal b2 = new BigDecimal(Double.toString(s2)); 	
			return b1.multiply(b2).doubleValue(); 
		}
		
//		/**
//		 * 功能：计算x的y次方根。
//		 * @param s1
//		 * @param s2
//		 * @return
//		 */
//		public static double xsqrty(double s1, double s2 )
//		{
//			BigDecimal d1 = new BigDecimal(Double.toString(s1));	
//			BigDecimal d2 = new BigDecimal(Double.toString(s2));	
//			BigDecimal b1=new BigDecimal(Math.pow(d1.doubleValue(),1./d2.doubleValue()));	
//			return b1.doubleValue();
//		}
//		
//		/**
//		 * 功能：计算x的y次幂(x^y)。
//		 * @param s1　String型
//		 * @param s2　String型
//		 * @return
//		 */
//		public static double xpowy(String s1,String s2)
//		{ 	
//			BigDecimal d1=new BigDecimal(s1);
//			BigDecimal d2=new BigDecimal(s2);	
//			BigDecimal b1=new BigDecimal(Math.pow(d1.doubleValue(),d2.doubleValue()));		
//			return b1.doubleValue(); 
//		} 
		
//		/**
//		 * 功能：计算x的y次幂(x^y)。
//		 * @param s1 String型
//		 * @param scale　int型
//		 * @return
//		 */
//		public static double xpowy(String s1, int scale) 
//		{ 	
//			BigDecimal d1=new BigDecimal(s1);	
//			BigDecimal b1=d1.pow(scale);		
//			return b1.doubleValue(); 
//		} 
		
//		/**
//		 * 功能：计算x的平方。
//		 * @param x
//		 * @return
//		 */
//		public static double xpow2(String x) 
//		{ 	
//			BigDecimal d1=new BigDecimal(x);
//			BigDecimal d2=new BigDecimal("2");	
//			BigDecimal b1=d1.pow(d2.intValue());		
//			return b1.doubleValue(); 
//		} 
		
//		/**
//		 * 功能：计算x的3次方。
//		 * @param x
//		 * @return
//		 */
//		public static double xpow3(String x) 
//		{ 	
//			BigDecimal d1=new BigDecimal(x);
//			BigDecimal d2=new BigDecimal("3");	
//			BigDecimal b1=d1.pow(d2.intValue());		
//			return b1.doubleValue(); 
//		} 
		
//		/** 
//		 * 功能： 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
//		 * 小数点以后32位，以后的数字四舍五入。
//		 * @param s1 被除数 
//		 * @param s2 除数 
//		 * @return 两个参数的商 
//		 */ 
//		public static double div(String s1, String s2) 
//		{ 
//			return div(s1, s2, DEF_DIV_SCALE); 
//		} 
		
		/** 
		 * 功能：提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 
		 * 定精度，以后的数字四舍五入。 
		 * @param s1 被除数 
		 * @param s2 除数 
		 * @param scale 表示表示需要精确到小数点以后几位。 
		 * @return 两个参数的商 
		 */ 
		public static double div(double s1, double s2, int scale)
		{ 
			if (scale < 0) 
			{ 	
				throw new IllegalArgumentException("精确度不能小于0！"); 	
			} 
			
			BigDecimal b1 = new BigDecimal(Double.toString(s1));	
			BigDecimal b2 = new BigDecimal(Double.toString(s2));	
			return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		} 
		
		
		/** 向下取值
		 * 功能：提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 
		 * 定精度，以后的数字四舍五入。 
		 * @param s1 被除数 
		 * @param s2 除数 
		 * @param scale 表示表示需要精确到小数点以后几位。 
		 * @return 两个参数的商 
		 */ 
		public static double divDown(double s1, double s2, int scale)
		{ 
			if (scale < 0) 
			{ 	
				throw new IllegalArgumentException("精确度不能小于0！"); 	
			} 
			
			BigDecimal b1 = new BigDecimal(Double.toString(s1));	
			BigDecimal b2 = new BigDecimal(Double.toString(s2));	
			return b1.divide(b2, scale, BigDecimal.ROUND_DOWN).doubleValue(); 
		}
		
		/** 
		 * 功能：提供精确的小数位四舍五入处理。 
		 * @param v 需要四舍五入的数字 
		 * @param scale 小数点后保留几位 
		 * @return 四舍五入后的结果 
		 */ 
		public static double round(double v, int scale) { 
			if (scale < 0) { 	
				throw new IllegalArgumentException("精确度不能小于0！"); 
				
			} 
			
			BigDecimal b = new BigDecimal(Double.toString(v)); 
			
			return b.setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue(); 
		} 
		
//		/**
//		 * 功能：计算n的阶乘，以BigInteger返回。
//		 * @param n
//		 * @return
//		 */ 
//		public static BigInteger factorial(double n) 
//		{ 
//			Double d=new Double(n);
//			n=d.intValue();
//			BigInteger s=BigInteger.valueOf(1); 
//			BigInteger j=BigInteger.valueOf(0); 
//			BigInteger c=BigInteger.valueOf(1); 
//			for(int i=1;i<=n;i++) 
//			{ 
//				j=j.add(c); 
//				s=s.multiply(j); 
//			} 
//			
//			return s;
//		} 
		
		/**
		 * 按月还款
		 * excel 中rate()函数
		 * @param a 现值
		 * @param b 年金
		 * @param c 期数
		 * @param cnt 循环次数
		 * @param ina 精确到小数点后10位
		 * @return
		 */
		public static double excelRate(double a,double b,double c,int cnt,int ina){  
		    double rate = 1,x,jd = 0.1,side = 0.1,i = 1;  
		    do{  
		        x = a/b - (Math.pow(1+rate, c)-1)/(Math.pow(rate+1, c)*rate);  
		        if(x*side>0){side = -side;jd *=10;}  
		        rate += side/jd;  
		    }while(i++<cnt&&Math.abs(x)>=1/Math.pow(10, ina));  
		    if(i>cnt)return Double.NaN;  
		    return rate;  
		}  
		
		
		/**
		 * 每月付息，到期还本
		 * @param planTotal
		 * @param putIn
		 * @param time 月份
		 * 年平均收益率 = (预计到期本金收益和 / 计划投资金额) ^ (1 / 投资年限) - 1
		 * @return
		 */
		public static double rateTotal(double planTotal,double putIn,int time){  
			float year = time*1.0f / 12;//月份转换成年
		    
			double rate = Math.pow(planTotal/putIn, 1/year) - 1;
		    return rate;  
		}
		
		/**
		 * 转换成字符串，如果大于一万，则以万为单位
		 * @param amount
		 * @return
		 */
		public static String doubleToString(double d){
			if (d < 10000) {
				return String.format("%.2f", d);
			}
			
			return Math.round(d / 10000)+"万";
		}
}
