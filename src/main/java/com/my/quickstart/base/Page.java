package com.my.quickstart.base;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 分页对象
 * @author admin
 *
 * @param <T>
 */
public class Page<T> {
	private static int DEFAULT_PAGESIZE=10;
	private static int DEFAULT_PAGENUM=1;
	private static int DEFAULT_NAVIGATEPAGES=10;
	private static int INIT_COUNT=0;
	//当前页
	private int pageNum = DEFAULT_PAGENUM;
	//每页数量
	private int pageSize = DEFAULT_PAGESIZE;
	//当前页的数量
	private int size;
	//当前页第一个元素在数据库中的行号
	private int startRow;
	//当前页最后一个元素在数据库中的行号
	private int endRow;
	//总记录数
	private int total;
	//总页数
	private int pages;
	//第一页
	private int firstPage;
	//前一页
	private int prePage;
	//下一页
	private int nextPage;
	//最后一也
	private int lastPage;
    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    //导航页码数
    private int navigatePages=DEFAULT_NAVIGATEPAGES;
    //所有导航页号
    private int[] navigatepageNums;
    //结果集
    private List<T> result=Lists.newArrayList();
    //排序
    private Sort sort = new Sort();
    /**
     * mysql 分页专用
     * 
     * @return
     */
    public int getPreEndNum() {
        return getPageSize() * (getPageNum() - 1);
    }
    
    public Page(){
    	this(DEFAULT_PAGENUM);
    }
    
    public Page(int pageNum){
        this(pageNum, DEFAULT_PAGESIZE);
    }
    
    public Page(int pageNum,int pageSize){
        this(pageNum, pageSize, INIT_COUNT);
    }

    public Page(int pageNum,int pageSize,int total){
    	if(pageNum<=0){
    		pageNum=DEFAULT_PAGENUM;
    	}
    	this.pageNum=pageNum;
    	this.pageSize=pageSize;
    	this.total=total;
    }

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum<=0?DEFAULT_PAGENUM:pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		calculate();
	}
	
	private void calculate(){
	    calculatePages();//计算页数
	    calcNavigatepageNums();//计算导航页
	    calcPageFirstAndLast();//计算前后页
	    judgePageBoudary();//判定边界
	    calculateStartAndEndRow();//计算起止行数
	}
	/**
	 * 计算页数
	 */
	private void calculatePages(){
		if(pageSize>0){
			pages=(int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
		}else{
			pages=0;
		}
		//处理分页不合理情况
		if(pageNum > pages){
			pageNum=pages;
		}
	}
	
    /**
     * 计算起止行号
     */
    private void calculateStartAndEndRow() {
    	this.size=this.result!=null?this.result.size():0;
    	if(this.total==0){
    		this.startRow=0;
    		this.endRow=0;
    	}else{
            this.startRow = this.pageNum > 0 ? ((this.pageNum - 1) * this.pageSize+1) : 0;
            this.endRow = this.startRow-1 + this.size;
    	}
    }	


    /**
     * 计算导航页
     */
    private void calcNavigatepageNums() {
        //当总页数小于或等于导航页码数时
        if (pages <= navigatePages) {
            navigatepageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                //最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
    }

    /**
     * 计算前后页，第一页，最后一页
     */
    private void calcPageFirstAndLast() {
        if (navigatepageNums != null && navigatepageNums.length > 0) {
            firstPage = navigatepageNums[0];
            lastPage = navigatepageNums[navigatepageNums.length - 1];
            if (pageNum > 1) {
                prePage = pageNum - 1;
            }
            if (pageNum < pages) {
                nextPage = pageNum + 1;
            }
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages && pageNum != 1;
        hasPreviousPage = pageNum > 1;
        hasNextPage = pageNum < pages;
    }

    
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getNavigatePages() {
		return navigatePages;
	}

	public void setNavigatePages(int navigatePages) {
		this.navigatePages = navigatePages;
	}

	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(int[] navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
		calculateStartAndEndRow();
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}
	
}
