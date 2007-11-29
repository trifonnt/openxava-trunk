package org.openxava.web.style;

import org.openxava.util.*;

/*
 * 					Classic		Brochure	Negria		Standalone	Lf41	Lf42	WPS6	
 * Formulario		x			x			x			x
 * Grupos			x			x			x			x
 * Secciones		x			x			x			x
 * Referencias		x			x			x			x
 * Colecciones
 * Galer�a Imag.
 * Ed. enmarcables
 * Botones			x			x			x			x
 * Botonera
 * V�nculos			x			x			x			x
 * Lista
 * 
 */


/**
 * 
 * @author Javier Paniza
 */ 

public class LiferayStyle extends Style {
	
	private static LiferayStyle instance = null;

	
	
	protected LiferayStyle() {
	}
	
	public static Style getInstance() {
		if (instance == null) {
			instance = new LiferayStyle();
		}
		return instance;
	}
		
	public String getModule() {
		return ""; // done		
	}
	
	public String getModuleSpacing() {
		return "border=0 cellpadding=0 cellspacing=2 width='100%'";
	}
		
	public String getButtonBar() {
		return "liferay-xava-frame-header"; 
	}
	
	public String getButtonBar2() {
		return "portlet-header-bar";
	}
	
	public String getButtonBarSpacing() {
		return "cellpadding=0 cellspacing=0";
	}	
	
	public String getButtonBarStart(boolean onBottom) {
		return "portlet-header-left";
	}
	
	public String getButtonBarMiddle(boolean onBottom) {
		return ""; 
	}
		
	public String getButtonBarEnd(boolean onBottom) {
		return "portlet-header-right";
	}
	
	public String getButtonBarStyle() {
		return "style='position: static'";
	}
	
	public String getButtonBarStartStyle() {
		return "style='position: static'";
	}
	
	public String getButtonBarMiddleStyle() {
		return "style='position: static'";
	}
	
	public String getButtonBarEndStyle() {
		return "style='position: static'";
	}

		
	public String getMode(boolean onButton) { 
		return "list-info";
	}
	
	public String getDetail() {
		return "liferay-table"; // done		
	}
			
	public String getList() { 
		return "";
	}
	
	public String getListCellSpacing() {
		return "border=0 cellspacing=0 cellpadding=0 style='border-collapse: collapse'";
	}
	
	
	public String getListHeader() { 
		return "portlet-section-header";		
	}
	
	
	
	public String getListHeaderCell() { 		
		return getListCell();
	}
	
	
	public String getListSubheader() {
		return "portlet-section-subheader";		
	}
	
	
	public String getListSubheaderCell() { 
		return getListCell();		
	}
	
	
	public String getListPair() { 
		return "portlet-section-body";		
	}
	
	public String getListPairCell() {
		return getListCell();
	}
	
	public String getListOdd() { 
		return "portlet-section-alternate";		
	}
	
	public String getListOddCell() { 
		return getListCell();		
	}
	
	public String getListPairSelected() { 
		return "portlet-section-selected";
	}
	
	public String getListOddSelected() { 
		return "portlet-section-selected";
	}
	
		
	public String getListInfo() {
		return "list-info";
	}
	
		
	public String getListTitle() {
		return "list-title";
	}
	
	private String getListCell() { 
		return "liferay-xava-cell-wrapper";		
	}
		
	public String getFrameStartDecoration(String label, String labelKey) { // tmp
		StringBuffer r = new StringBuffer();
		r.append("<table style='float:left; clear:none'><tr><td>\n");
		r.append("<div class='portlet'><div class='portlet-topper'><span class='portlet-title'>");
		if (labelKey != null) {
			r.append("<span id='");
			r.append(labelKey);
			r.append("'>");
		}
		r.append(label);
		if (labelKey != null) r.append("</span>");
		r.append("</span></div><div class='portlet-content'><div class='portlet-content-container'>\n");
		return r.toString();		
	}
	public String getFrameEndDecoration() { // tmp
		return "\n</div></div></div></td></tr></table>";

	}		
		
	public String getFrame() {
		return "portlet"; // tmp 
	}
	
	public String getFrameTitle() {
		return "portlet-topper"; // tmp
	}
	
	public String getFrameTitleLabel() {
		// tmp return "liferay-xava-frame-header";
		return "";
	}
	
	public String getFrameTitleStartDecoration(Align align) {
		return "<span class='portlet-title'>"; // tmp
		//return "";
	}
	
	public String getFrameTitleEndDecoration() {
		return "</span>"; // tmp
		//return "";
	}

	public String getFrameContent() {
		return "liferay-xava-frame-core"; 
	}
	
	public String getFrameSpacing() {
		return "cellpadding='0' cellspacing='0'";
	}
		
	public String getEditor() { 
		return "form-text";
	}
	
	public String getSmallLabel() {
		return "''";
	}
	
	public String getErrors() { 
		return "portlet-msg-error";
	}
		

	public String getMessages() { 
		return "portlet-msg-success";
	}

	/**
	 * For messages and errors
	 */
	public String getMessagesWrapper() { 
		return "";
	}
	
	
	public String getProcessing() { 
		return "processing";
	}
			
	public String getButton() {
		return ""; // done
	}
	
	public String getAscendingImage() {
		return "ascending.gif";
	}
	
	public String getDescendingImage() {
		return "descending.gif";
	}
	
	public String getSection() {
		return "";
	}
	
	public String getSectionTableAttributes() {		
		return "border='0' cellpadding='0' cellspacing='0' width='100%'";
	}
	
	public String getSectionActive() {
		return "";
	}	
	
	public String getSectionLink() {
		return "";
	}
	
	public String getSectionBarStartDecoration() {
		return "<td style='padding-top: 4px;'><ul class='tabs'>"; // tmp
	}
	public String getSectionBarEndDecoration() {	
		return "</ul></td>";
	}
		
	public String getActiveSectionTabStartDecoration() {
		return "<li class='current'><a href='javascript:void(0)'>"; // tmp
	}
	
	public String getActiveSectionTabEndDecoration() {
		return "</a></li>";	 // tmp 	
	}
	
	public String getSectionTabStartDecoration() {
		return "<li>";
	}
	
	public String getSectionTabEndDecoration() {
		return "</li>";		
	}	
		
	public String getCollectionListActions() {
		return "";
	}
	
	public String getRestoreImage() {
		return "/html/themes/brochure/images/portlet/minimize.gif";
	}
	
	public String getMaximizeImage() {
		return "/html/themes/brochure/images/portlet/maximize.gif";
	}
	
	public String getRemoveImage() {
		return "/html/themes/brochure/images/portlet/close.gif";
	}
	
	public boolean isApplySelectedStyleToCellInList() {
		return false;
	}
		
}
