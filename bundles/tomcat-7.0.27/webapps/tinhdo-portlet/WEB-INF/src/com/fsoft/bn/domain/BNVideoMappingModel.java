/**
 * 
 */
package com.fsoft.bn.domain;

/**
 * @author VangND1
 *
 */
public class BNVideoMappingModel {
	/***/
	private String name;
	/***/
	private String path;
	/***/
	private String classPK;
	/***/
	private String className;
	/***/
	private String folder;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the classPK
	 */
	public String getClassPK() {
		return classPK;
	}
	/**
	 * @param classPK the classPK to set
	 */
	public void setClassPK(String classPK) {
		this.classPK = classPK;
	}
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}
	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}
}
