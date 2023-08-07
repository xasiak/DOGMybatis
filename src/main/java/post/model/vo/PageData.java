package post.model.vo;

import java.util.List;

public class PageData {
	private List<Post> pList;
	private String pageNavi;
	
	public PageData() {}

	public PageData(List<Post> pList, String pageNavi) {
		super();
		this.pList = pList;
		this.pageNavi = pageNavi;
	}

	public List<Post> getpList() {
		return pList;
	}

	public void setnList(List<Post> pList) {
		this.pList = pList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [pList=" + pList + ", pageNavi=" + pageNavi + "]";
	}

}
