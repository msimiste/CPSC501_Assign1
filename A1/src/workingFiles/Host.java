package workingFiles;

public class Host {
	
	private String hostName;
	private int port;
	private String path;
	private String fileName;
	private String concatPath;
	String url; 

	public Host(String url) {
		initializeLocals(url);
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String name) {
		this.hostName = name;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int prt) {
		this.port = prt;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String pth) {
		this.path = pth;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String file) {
		this.fileName = file;
	}

	public String getConcatPath() {
		return concatPath;
	}

	public void setConcatPath(String cPath) {
		this.concatPath = cPath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String urlToSet) {
		this.url = urlToSet;
	}

	private void initializeLocals(String url) {
		this.setHostName(parseUrl(url));
		this.setPort(this.initializePort(hostName));
		this.setHostName(removePortFromHostName(hostName));
		this.setPath(parsePath(url));
		this.setFileName(parseTail(url));
		this.setConcatPath(initializeConcatenatedPath());
		this.setUrl(initializeUrl());
	}

	private String initializeConcatenatedPath() {
		return this.path + "/" + this.fileName;
	}
	
	private String initializeUrl(){
		return this.hostName + this.concatPath;
	}

	/**
	 * @param in - URL to be parsed
	 * @return parsed URL which is a string
	 */
	private String parseUrl(String in) {
		String[] arr1 = in.split("//");
		String[] arr;
		if (arr1.length > 1) {
			arr = arr1[1].split("/");
		} else {
			arr = in.split("/");
		}
		String url = arr[0];
		return url;
	}

	/**
	 * 
	 * @param in
	 *            URL which may or may not contain a port number to be parsed
	 * @return the port number parsed from a URL or the default port 80
	 */
	private int initializePort(String in) {
		int port = 80;
		if (in.contains(":")) {
			int portIndex = in.indexOf(":") + 1;
			String stringPort = in.substring(portIndex);
			port = Integer.parseInt(stringPort);
		}
		return port;
	}

	/**
	 * 
	 * @param in: URL which contains a filepath
	 * @return a filepath string
	 */
	private String parsePath(String in) {
		String[] arr = in.split("/");

		String path = "";

		for (int i = 1; i < arr.length - 1; i++) {
			path = path + "/" + arr[i];
		}
		return path;
	}

	/**
	 * @param in: URL to be parsed
	 * @return returns the last component of a URL the file name including
	 *         extension
	 */
	private String parseTail(String in) {
		String[] arr = in.split("/");
		int tailIndex = arr.length;
		String tail = arr[tailIndex - 1];

		return tail;
	}

	/**
	 * 
	 * @param hostName : string hostname which may or may not contain a port
	 * @return hostname with the port removed if it exists
	 * 
	 */
	private String removePortFromHostName(String hostName) {

		if (hostName.contains(":")) {
			int portIndex = hostName.indexOf(":");
			hostName = hostName.substring(0, portIndex);
		}
		return hostName;
	}
}
