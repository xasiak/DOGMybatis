package post.model.vo;

import java.util.List;

public class PageData {
	private List<Post> nList;
	private String pageNavi;
	
	public PageData() {}
	
	

	public List<Post> getnList() {
		return nList;
	}

	public void setnList(List<Post> nList) {
		this.nList = nList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [nList=" + nList + ", pageNavi=" + pageNavi + "]";
	}

}
