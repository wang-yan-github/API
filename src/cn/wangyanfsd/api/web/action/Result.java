package cn.wangyanfsd.api.web.action;

public class Result {
	private boolean redirect;
	private String path;
	public Result(String path) {
		this.path = path;
	}
	public Result(String path,boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	} 
}
