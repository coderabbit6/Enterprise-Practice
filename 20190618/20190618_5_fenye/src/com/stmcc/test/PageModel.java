package com.stmcc.test;

import java.util.List;

/*
 * ��������ҳ�йص�����
 */
public class PageModel {
	// �����
	private List list;
	// ��ѯ�ܼ�¼��
	private int totalRecords;
	// ÿҳ��������¼��ҳ��������
	private int pageSize;

	// ҳ�루�ڼ�ҳ��
	private int pageNo;

	/*
	 * ��ҳ��
	 */
	public int getTotalPages() {
		return (totalRecords + pageSize - 1) / pageSize;
	}

	/*
	 * ��ȡ��ҳ
	 * 
	 */
	public int getTopPageNo() {
		return 1;
	}

	/*
	 * ��һҳ
	 * 
	 */
	public int getPreviousPageNo() {
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo - 1;
	}

	/*
	 * ��һҳ
	 * 
	 */
	public int getNextPageNo() {
		if (pageNo >= getBottomPageNo()) {
			return getBottomPageNo();
		}
		return pageNo + 1;
	}

	/*
	 * ĩҳ
	 */

	public int getBottomPageNo() {
		return getTotalPages();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
